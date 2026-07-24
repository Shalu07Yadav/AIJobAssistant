package com.exampleAIJobAssistant.AIJobAssistant.optimizer.service;

import com.exampleAIJobAssistant.AIJobAssistant.optimizer.dto.ResumeOptimizerRequest;
import com.exampleAIJobAssistant.AIJobAssistant.optimizer.dto.ResumeOptimizerResponse;

public interface ResumeOptimizerService {
    ResumeOptimizerResponse optimizeResume(ResumeOptimizerRequest request) throws Exception;
}
