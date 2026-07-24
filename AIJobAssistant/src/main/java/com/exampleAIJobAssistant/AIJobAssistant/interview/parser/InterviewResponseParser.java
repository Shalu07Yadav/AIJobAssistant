package com.exampleAIJobAssistant.AIJobAssistant.interview.parser;

import com.exampleAIJobAssistant.AIJobAssistant.interview.dto.InterviewResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InterviewResponseParser {
    private final ObjectMapper objectMapper;

    public InterviewResponse parse(String geminiResponse)
            throws Exception {

        JsonNode root =
                objectMapper.readTree(geminiResponse);

        String interviewJson =
                root.path("candidates")
                        .get(0)
                        .path("content")
                        .path("parts")
                        .get(0)
                        .path("text")
                        .asText();

        return objectMapper.readValue(
                interviewJson,
                InterviewResponse.class
        );
    }
}
