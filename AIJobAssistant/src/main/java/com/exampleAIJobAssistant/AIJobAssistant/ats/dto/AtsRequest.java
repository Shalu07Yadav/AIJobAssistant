package com.exampleAIJobAssistant.AIJobAssistant.ats.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtsRequest {
    private Long resumeId;
    private String jobDescription;
}
