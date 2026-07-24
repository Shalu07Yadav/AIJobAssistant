package com.exampleAIJobAssistant.AIJobAssistant.optimizer.controller;

import com.exampleAIJobAssistant.AIJobAssistant.optimizer.dto.ResumeOptimizerRequest;
import com.exampleAIJobAssistant.AIJobAssistant.optimizer.dto.ResumeOptimizerResponse;
import com.exampleAIJobAssistant.AIJobAssistant.optimizer.service.ResumeOptimizerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/optimizer")
@RequiredArgsConstructor

public class ResumeOptimizerController {
    private final ResumeOptimizerService optimizerService;

    @PostMapping("/optimize")
    public ResumeOptimizerResponse optimize(
            @RequestBody ResumeOptimizerRequest request)
            throws Exception {

        return optimizerService.optimizeResume(request);
    }
}
