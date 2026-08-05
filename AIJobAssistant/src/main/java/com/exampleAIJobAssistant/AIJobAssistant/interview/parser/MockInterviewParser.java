package com.exampleAIJobAssistant.AIJobAssistant.interview.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class MockInterviewParser {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String parseQuestion(String aiResponse) throws Exception {

        JsonNode root = objectMapper.readTree(aiResponse);

        return root.path("candidates")
                .get(0)
                .path("content")
                .path("parts")
                .get(0)
                .path("text")
                .asText();
    }
}