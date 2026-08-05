package com.exampleAIJobAssistant.AIJobAssistant.interview.controller;

import com.exampleAIJobAssistant.AIJobAssistant.interview.dto.*;
import com.exampleAIJobAssistant.AIJobAssistant.interview.service.MockInterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mock-interview")
public class MockInterviewController {

    private final MockInterviewService mockInterviewService;

    @PostMapping("/start")
    public StartInterviewResponse startInterview(
            @RequestBody StartInterviewRequest request)
            throws Exception {

        return mockInterviewService.startInterview(request);

    }

    @PostMapping("/next")
    public ContinueInterviewResponse continueInterview(

            @RequestBody ContinueInterviewRequest request

    ) throws Exception {

        return mockInterviewService.continueInterview(request);

    }

    @PostMapping("/finish")
    public FinishInterviewResponse finishInterview(

            @RequestBody FinishInterviewRequest request

    ) throws Exception {

        return mockInterviewService.finishInterview(request);

    }
}