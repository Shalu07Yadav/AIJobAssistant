package com.exampleAIJobAssistant.AIJobAssistant.ats.controller;

import com.exampleAIJobAssistant.AIJobAssistant.ats.dto.AtsRequest;
import com.exampleAIJobAssistant.AIJobAssistant.ats.dto.AtsResponse;
import com.exampleAIJobAssistant.AIJobAssistant.ats.service.AtsService;
import com.exampleAIJobAssistant.AIJobAssistant.ats.util.skillExtractor;
import com.exampleAIJobAssistant.AIJobAssistant.resume.entity.Resume;
import com.exampleAIJobAssistant.AIJobAssistant.resume.repository.resumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
//RequestMapping("/api/test")
@RequiredArgsConstructor

public class atsTestController {
private final resumeRepository resumeRepository;
private final skillExtractor skillExtractor;
private final AtsService atsService;

    @GetMapping("/skills/{resumeId}")
    public Set<String> extractSkills(@PathVariable Long resumeId) {

        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() ->
                        new RuntimeException("Resume not found"));

        return skillExtractor.extractSkills(
                resume.getResumeText()
        );
    }

    @PostMapping("/analyze")
    public AtsResponse analyze(
            @RequestBody AtsRequest request
    ) {
        return atsService.analyze(request);
    }

}
