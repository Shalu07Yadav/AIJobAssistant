package com.exampleAIJobAssistant.AIJobAssistant.interview.service.impl;

import com.exampleAIJobAssistant.AIJobAssistant.ai.service.AIService;
import com.exampleAIJobAssistant.AIJobAssistant.interview.dto.*;
import com.exampleAIJobAssistant.AIJobAssistant.interview.model.ChatMessage;
import com.exampleAIJobAssistant.AIJobAssistant.interview.model.InterviewSession;
import com.exampleAIJobAssistant.AIJobAssistant.interview.model.InterviewStatus;
import com.exampleAIJobAssistant.AIJobAssistant.interview.parser.MockInterviewEvaluationParser;
import com.exampleAIJobAssistant.AIJobAssistant.interview.parser.MockInterviewParser;
import com.exampleAIJobAssistant.AIJobAssistant.interview.parser.MockInterviewResponseParser;
import com.exampleAIJobAssistant.AIJobAssistant.interview.prompt.MockInterviewPromptBuilder;
import com.exampleAIJobAssistant.AIJobAssistant.interview.service.InterviewSessionStore;
import com.exampleAIJobAssistant.AIJobAssistant.interview.service.MockInterviewService;
import com.exampleAIJobAssistant.AIJobAssistant.resume.entity.Resume;
import com.exampleAIJobAssistant.AIJobAssistant.resume.repository.resumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MockInterviewServiceImpl implements MockInterviewService {

    private final resumeRepository resumeRepository;

    private final AIService aiService;

    private final MockInterviewPromptBuilder promptBuilder;

    private final InterviewSessionStore sessionStore;

    private final MockInterviewParser parser;

    private final MockInterviewResponseParser responseParser;

    private final MockInterviewEvaluationParser evaluationParser;
    @Override
    public StartInterviewResponse startInterview(StartInterviewRequest request)
            throws Exception {

        // 1. Fetch Resume
        Resume resume = resumeRepository.findById(Long.valueOf(request.getResumeId()))
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        // 2. Build Prompt
        String prompt = promptBuilder.buildFirstQuestionPrompt(
                resume.getResumeText(),
                request.getJobDescription()
        );

        // 3. Ask Gemini
        String aiResponse = aiService.generateResponse(prompt);

        // 4. Extract Question
        String firstQuestion = parser.parseQuestion(aiResponse);

        // 5. Generate Session Id
        String sessionId = UUID.randomUUID().toString();

        // 6. Create Interview Session
        InterviewSession session = new InterviewSession();

        session.setSessionId(sessionId);
        session.setResumeId(request.getResumeId());

        session.setResumeText(
                resume.getResumeText()
        );
        session.setJobDescription(request.getJobDescription());

        session.setStatus(InterviewStatus.ONGOING);



        // 7. Store First AI Question
        session.getConversation().add(
                new ChatMessage(
                        "AI",
                        firstQuestion
                )
        );

        // 8. Save Session
        sessionStore.save(session);

        System.out.println("================================");
        System.out.println("Saved Session");
        System.out.println(session.getSessionId());
        System.out.println("================================");

        // 9. Return Response
        return new StartInterviewResponse(
                sessionId,
                firstQuestion
        );
    }

    @Override
    public ContinueInterviewResponse continueInterview(
            ContinueInterviewRequest request
    ) throws Exception {

        System.out.println("================================");
        System.out.println("Requested Session");
        System.out.println(request.getSessionId());
        System.out.println("================================");

        InterviewSession session =
                sessionStore.get(request.getSessionId());

        System.out.println(session);

        if (session == null) {
            throw new RuntimeException("Interview session not found");
        }

        session.getConversation().add(

                new ChatMessage(
                        "USER",
                        request.getAnswer()
                )

        );

        String prompt =
                promptBuilder.buildNextQuestionPrompt(session);

        String aiResponse =
                aiService.generateResponse(prompt);

        String nextQuestion =
                parser.parseQuestion(aiResponse);

        session.getConversation().add(

                new ChatMessage(
                        "AI",
                        nextQuestion
                )

        );

        return new ContinueInterviewResponse(
                nextQuestion
        );
    }

    @Override
    public FinishInterviewResponse finishInterview(
            FinishInterviewRequest request
    ) throws Exception {

        // 1. Get interview session
        InterviewSession session =
                sessionStore.get(request.getSessionId());

        if (session == null) {
            throw new RuntimeException("Interview session not found");
        }

        // 2. Mark interview completed
        session.setStatus(InterviewStatus.COMPLETED);

        // 3. Build evaluation prompt
        String prompt =
                promptBuilder.buildEvaluationPrompt(session);

        // 4. Ask Gemini
        String aiResponse =
                aiService.generateResponse(prompt);

        // 5. Parse evaluation
        FinishInterviewResponse response =
                evaluationParser.parse(aiResponse);

        // 6. Remove completed session
        sessionStore.remove(request.getSessionId());

        // 7. Return report
        return response;
    }
}