package com.exampleAIJobAssistant.AIJobAssistant.interview.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StartInterviewResponse {

    private String sessionId;

    private String firstQuestion;

}