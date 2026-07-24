package com.exampleAIJobAssistant.AIJobAssistant.interview.service.impl;

import com.exampleAIJobAssistant.AIJobAssistant.ai.service.AIService;
import com.exampleAIJobAssistant.AIJobAssistant.interview.dto.InterviewRequest;
import com.exampleAIJobAssistant.AIJobAssistant.interview.dto.InterviewResponse;
import com.exampleAIJobAssistant.AIJobAssistant.interview.parser.InterviewResponseParser;
import com.exampleAIJobAssistant.AIJobAssistant.interview.prompt.InterviewPromptBuilder;
import com.exampleAIJobAssistant.AIJobAssistant.interview.service.InterviewService;
import com.exampleAIJobAssistant.AIJobAssistant.resume.entity.Resume;
import com.exampleAIJobAssistant.AIJobAssistant.resume.repository.resumeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class InterviewServiceImpl implements InterviewService {

    private final resumeRepository resumeRepository;

    private final InterviewPromptBuilder promptBuilder;

    private final AIService aiService;

    private final InterviewResponseParser parser;

    @Override
    public InterviewResponse generateInterviewQuestions(InterviewRequest request) throws Exception {
        Resume resume =
                resumeRepository.findById(
                        request.getResumeId()
                ).orElseThrow(
                        () -> new RuntimeException(
                                "Resume not found"
                        )
                );

        String prompt =
                promptBuilder.buildPrompt(
                        resume.getResumeText()
                );

        String aiResponse =
                aiService.generateResponse(prompt);

        return parser.parse(aiResponse);
    }
}
