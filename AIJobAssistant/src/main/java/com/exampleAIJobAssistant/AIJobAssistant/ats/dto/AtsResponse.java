package com.exampleAIJobAssistant.AIJobAssistant.ats.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
public class AtsResponse {
    private double score;

    private Set<String> matchedSkills;

    private Set<String> missingSkills;

    private List<String> strongPoints;

    private List<String> recommendations;
}
