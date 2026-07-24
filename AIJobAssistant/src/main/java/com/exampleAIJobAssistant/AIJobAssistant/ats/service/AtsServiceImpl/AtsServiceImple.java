package com.exampleAIJobAssistant.AIJobAssistant.ats.service.AtsServiceImpl;

import com.exampleAIJobAssistant.AIJobAssistant.ats.dto.AtsRequest;
import com.exampleAIJobAssistant.AIJobAssistant.ats.dto.AtsResponse;
import com.exampleAIJobAssistant.AIJobAssistant.ats.service.AtsService;
import com.exampleAIJobAssistant.AIJobAssistant.ats.util.ResumeInsightGenerator;
import com.exampleAIJobAssistant.AIJobAssistant.ats.util.skillExtractor;
import com.exampleAIJobAssistant.AIJobAssistant.resume.entity.Resume;
import com.exampleAIJobAssistant.AIJobAssistant.resume.repository.resumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor

public class AtsServiceImple implements AtsService {
    private final resumeRepository resumeRepository;
    private final skillExtractor skillExtractor;
    private final ResumeInsightGenerator resumeInsightGenerator;

    @Override
    public AtsResponse analyze(AtsRequest request) {

        // 1. Fetch Resume
        Resume resume = resumeRepository.findById(
                        request.getResumeId()
                )
                .orElseThrow(
                        () -> new RuntimeException(
                                "Resume not found"
                        )
                );

        // 2. Extract Resume Skills
        Set<String> resumeSkills =
                skillExtractor.extractSkills(
                        resume.getResumeText()
                );

        // 3. Extract JD Skills
        Set<String> jdSkills =
                skillExtractor.extractSkills(
                        request.getJobDescription()
                );

        // 4. Validate JD
        if (jdSkills.isEmpty()) {
            throw new RuntimeException(
                    "No supported skills found in Job Description"
            );
        }

        // 5. Find Matched Skills
        Set<String> matchedSkills =
                new HashSet<>(resumeSkills);

        matchedSkills.retainAll(jdSkills);

        // 6. Find Missing Skills
        Set<String> missingSkills =
                new HashSet<>(jdSkills);

        missingSkills.removeAll(matchedSkills);

        // 7. Calculate ATS Score
        double score =
                ((double) matchedSkills.size()
                        / jdSkills.size())
                        * 100;

        score = Math.round(score * 100.0) / 100.0;


        List<String> strongPoints =
                resumeInsightGenerator.generateStrongPoints(
                        matchedSkills
                );

        List<String> recommendations =
                resumeInsightGenerator.generateRecommendations(
                        missingSkills
                );

        // 8. Return Response
        return AtsResponse.builder()
                .score(score)
                .matchedSkills(matchedSkills)
                .missingSkills(missingSkills)
                .strongPoints(strongPoints)
                .recommendations(recommendations)
                .build();
    }
}
