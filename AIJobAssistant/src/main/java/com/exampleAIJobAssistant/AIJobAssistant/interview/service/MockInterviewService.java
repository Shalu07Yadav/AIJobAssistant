package com.exampleAIJobAssistant.AIJobAssistant.interview.service;

import com.exampleAIJobAssistant.AIJobAssistant.interview.dto.*;

public interface MockInterviewService {

    StartInterviewResponse startInterview(StartInterviewRequest request) throws Exception;

    ContinueInterviewResponse continueInterview(
            ContinueInterviewRequest request
    ) throws Exception;

    FinishInterviewResponse finishInterview(
            FinishInterviewRequest request
    ) throws Exception;
}