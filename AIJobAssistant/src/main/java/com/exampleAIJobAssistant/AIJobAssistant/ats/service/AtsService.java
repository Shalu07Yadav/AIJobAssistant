package com.exampleAIJobAssistant.AIJobAssistant.ats.service;

import com.exampleAIJobAssistant.AIJobAssistant.ats.dto.AtsRequest;
import com.exampleAIJobAssistant.AIJobAssistant.ats.dto.AtsResponse;

public interface AtsService {
    AtsResponse analyze(AtsRequest request);
}
