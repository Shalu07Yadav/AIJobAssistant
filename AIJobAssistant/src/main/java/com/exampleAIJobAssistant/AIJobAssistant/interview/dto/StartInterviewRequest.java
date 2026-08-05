package com.exampleAIJobAssistant.AIJobAssistant.interview.dto;

import lombok.Data;

@Data
public class StartInterviewRequest {

    private Integer resumeId;

    private String jobDescription;

}