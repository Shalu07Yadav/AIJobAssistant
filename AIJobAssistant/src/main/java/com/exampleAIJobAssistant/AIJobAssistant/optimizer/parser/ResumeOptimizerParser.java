package com.exampleAIJobAssistant.AIJobAssistant.optimizer.parser;

import com.exampleAIJobAssistant.AIJobAssistant.optimizer.dto.ResumeOptimizerResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class ResumeOptimizerParser {
    private final ObjectMapper objectMapper;

    public ResumeOptimizerResponse parse(String geminiResponse)
            throws Exception {

        JsonNode root =
                objectMapper.readTree(geminiResponse);

        String optimizerJson =
                root.path("candidates")
                        .get(0)
                        .path("content")
                        .path("parts")
                        .get(0)
                        .path("text")
                        .asText();

        System.out.println(optimizerJson);

        return objectMapper.readValue(
                optimizerJson,
                ResumeOptimizerResponse.class
        );
    }
}
