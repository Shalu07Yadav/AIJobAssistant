package com.exampleAIJobAssistant.AIJobAssistant.optimizer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeOptimizerRequest {
    private Long resumeId;
    private String jobDescription;
}
