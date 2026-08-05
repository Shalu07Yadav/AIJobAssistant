package com.exampleAIJobAssistant.AIJobAssistant.interview.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class InterviewSession {

    private String sessionId;

    private Integer resumeId;

    private String resumeText;

    private String jobDescription;

    private InterviewStatus status = InterviewStatus.ONGOING;

    private List<ChatMessage> conversation = new ArrayList<>();
}