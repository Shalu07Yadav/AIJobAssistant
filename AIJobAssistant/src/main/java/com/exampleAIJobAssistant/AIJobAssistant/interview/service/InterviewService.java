package com.exampleAIJobAssistant.AIJobAssistant.interview.service;

import com.exampleAIJobAssistant.AIJobAssistant.interview.dto.InterviewRequest;
import com.exampleAIJobAssistant.AIJobAssistant.interview.dto.InterviewResponse;

public interface InterviewService {
    InterviewResponse generateInterviewQuestions(InterviewRequest request)
            throws Exception;
}
