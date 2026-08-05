package com.exampleAIJobAssistant.AIJobAssistant.interview.parser;

import com.exampleAIJobAssistant.AIJobAssistant.interview.dto.FinishInterviewResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class MockInterviewEvaluationParser {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public FinishInterviewResponse parse(String aiResponse) throws Exception {

        // Parse the complete Gemini response
        String json = objectMapper.readTree(aiResponse)
                .path("candidates")
                .get(0)
                .path("content")
                .path("parts")
                .get(0)
                .path("text")
                .asText();

        // Remove markdown if Gemini wraps JSON
        json = json.replace("```json", "")
                .replace("```", "")
                .trim();

        return objectMapper.readValue(
                json,
                FinishInterviewResponse.class
        );
    }
}