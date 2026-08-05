package com.exampleAIJobAssistant.AIJobAssistant.interview.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinishInterviewResponse {
    private double overallScore;

    private String overallFeedback;

    private List<String> strengths;

    private List<String> improvements;

    private List<String> recommendations;
}
