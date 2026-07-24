package com.exampleAIJobAssistant.AIJobAssistant.optimizer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResumeOptimizerResponse {
    private String overallFeedback;

    private List<String> summarySuggestions;

    private List<String> experienceSuggestions;

    private List<String> projectSuggestions;

    private List<String> technicalSkillSuggestions;

    private List<String> missingKeywords;

    private List<OptimizedBulletPoint> optimizedBulletPoints;
}
