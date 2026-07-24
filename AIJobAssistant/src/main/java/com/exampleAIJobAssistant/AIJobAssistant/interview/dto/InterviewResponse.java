package com.exampleAIJobAssistant.AIJobAssistant.interview.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class InterviewResponse {
    private List<QuestionDto> projectQuestions;

    private List<QuestionDto> experienceQuestions;

    private List<QuestionDto> technicalQuestions;

    private List<QuestionDto> behavioralQuestions;
}
