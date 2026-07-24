package com.exampleAIJobAssistant.AIJobAssistant.optimizer.service.Impl;

import com.exampleAIJobAssistant.AIJobAssistant.ai.service.AIService;
import com.exampleAIJobAssistant.AIJobAssistant.optimizer.dto.ResumeOptimizerRequest;
import com.exampleAIJobAssistant.AIJobAssistant.optimizer.dto.ResumeOptimizerResponse;
import com.exampleAIJobAssistant.AIJobAssistant.optimizer.parser.ResumeOptimizerParser;
import com.exampleAIJobAssistant.AIJobAssistant.optimizer.prompt.ResumeOptimizerPromptBuilder;
import com.exampleAIJobAssistant.AIJobAssistant.optimizer.service.ResumeOptimizerService;
import com.exampleAIJobAssistant.AIJobAssistant.resume.entity.Resume;
import com.exampleAIJobAssistant.AIJobAssistant.resume.repository.resumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ResumeOptimizerServiceImpl implements ResumeOptimizerService {

    private final resumeRepository resumeRepository;

    private final ResumeOptimizerPromptBuilder promptBuilder;

    private final AIService aiService;

    private final ResumeOptimizerParser parser;


    @Override
    public ResumeOptimizerResponse optimizeResume(ResumeOptimizerRequest request) throws Exception {
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
                        resume.getResumeText(),
                        request.getJobDescription()
                );

        String aiResponse =
                aiService.generateResponse(prompt);

        return parser.parse(aiResponse);
    }
}
