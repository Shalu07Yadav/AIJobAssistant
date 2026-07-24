package com.exampleAIJobAssistant.AIJobAssistant.ai.service.impl;

import com.exampleAIJobAssistant.AIJobAssistant.ai.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor

public class OpenAIServiceImpl implements AIService {
    private final RestClient restClient;

    @Value("${gemini.api.key}")
    private String apiKey;

    @Override
    public String generateResponse(String prompt) {
        Map<String, Object> requestBody = Map.of(
                "contents",
                List.of(
                        Map.of(
                                "parts",
                                List.of(
                                        Map.of(
                                                "text", prompt
                                        )
                                )
                        )
                )
        );

        String response = restClient.post()
                .uri("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + apiKey)
                .body(requestBody)
                .retrieve()
                .body(String.class);

        return response;
    }
}
