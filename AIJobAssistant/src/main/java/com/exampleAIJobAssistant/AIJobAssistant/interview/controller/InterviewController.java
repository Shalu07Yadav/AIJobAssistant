package com.exampleAIJobAssistant.AIJobAssistant.interview.controller;

import com.exampleAIJobAssistant.AIJobAssistant.interview.dto.InterviewRequest;
import com.exampleAIJobAssistant.AIJobAssistant.interview.dto.InterviewResponse;
import com.exampleAIJobAssistant.AIJobAssistant.interview.service.InterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class InterviewController {
    private final InterviewService interviewService;

    @PostMapping("/api/interview/generate")
    public InterviewResponse generateInterviewQuestions(
            @RequestBody InterviewRequest request)
            throws Exception {

        return interviewService.generateInterviewQuestions(request);

    }
}
