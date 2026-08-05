package com.exampleAIJobAssistant.AIJobAssistant.interview.dto;

import lombok.Data;

@Data
public class ContinueInterviewRequest {

    private String sessionId;

    private String answer;

}