package com.exampleAIJobAssistant.AIJobAssistant.ai.controller;

import com.exampleAIJobAssistant.AIJobAssistant.ai.service.AIService;
import com.exampleAIJobAssistant.AIJobAssistant.interview.prompt.InterviewPromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor

public class AIController {

    private final AIService aiService;
    private final InterviewPromptBuilder promptBuilder;

//    @GetMapping("/test")
//    public String test(){
//
//        return aiService.generateResponse(
//                "Describe about gemini in one sentance"
//        );
//    }

    @GetMapping("/test")
    public String test() {

        String resume = """
                Java
                Spring Boot
                AWS
                Docker
                PostgreSQL
                """;

        String prompt = promptBuilder.buildPrompt(resume);

        return aiService.generateResponse(prompt);
    }
}
