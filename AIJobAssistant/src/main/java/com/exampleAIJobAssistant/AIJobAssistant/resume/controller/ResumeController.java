package com.exampleAIJobAssistant.AIJobAssistant.resume.controller;


import com.exampleAIJobAssistant.AIJobAssistant.resume.dto.uploadResponse;
import com.exampleAIJobAssistant.AIJobAssistant.resume.service.resumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/resumes")
@RequiredArgsConstructor

public class ResumeController {
    private final resumeService resumeService;

    @PostMapping("/upload")
    public ResponseEntity<uploadResponse> uploadResume(
            @RequestParam("file") MultipartFile file) throws Exception {

        uploadResponse response = resumeService.uploadResume(file);

        return ResponseEntity.ok(response);
    }
}
