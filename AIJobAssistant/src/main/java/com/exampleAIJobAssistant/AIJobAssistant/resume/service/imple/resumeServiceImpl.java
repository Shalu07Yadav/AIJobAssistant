package com.exampleAIJobAssistant.AIJobAssistant.resume.service.imple;

import com.exampleAIJobAssistant.AIJobAssistant.resume.dto.uploadResponse;
import com.exampleAIJobAssistant.AIJobAssistant.resume.entity.Resume;
import com.exampleAIJobAssistant.AIJobAssistant.resume.repository.resumeRepository;
import com.exampleAIJobAssistant.AIJobAssistant.resume.service.resumeService;
import com.exampleAIJobAssistant.AIJobAssistant.resume.util.pdfExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class resumeServiceImpl implements resumeService {
    private final resumeRepository resumeRepository;
    private final pdfExtractor pdfExtractor;

    @Override
    public uploadResponse uploadResume(MultipartFile file)
            throws Exception {

        String uploadDir = "uploads/";

        Files.createDirectories(Paths.get(uploadDir));

        String fileName = System.currentTimeMillis()
                + "_" + file.getOriginalFilename();

        Path filePath = Paths.get(uploadDir, fileName);

        Files.copy(
                file.getInputStream(),
                filePath,
                StandardCopyOption.REPLACE_EXISTING
        );

        //extract pdf ko
        String extractedText = "";

        if(file.getContentType().equals("application/pdf")) {
            extractedText = pdfExtractor.extractText(filePath.toFile());
        }

//        System.out.println("========== START ==========");
//        System.out.println(extractedText);
//        System.out.println("Length = " + extractedText.length());
//        System.out.println("========== END ==========");


        Resume resume = Resume.builder()
                .fileName(file.getOriginalFilename())
                .fileType(file.getContentType())
                .filePath(filePath.toString())
                .resumeText(extractedText)
                .uploadedAt(LocalDateTime.now())
                .build();

        System.out.println("Before Save:");
        System.out.println(resume.getResumeText().substring(0,100));
        System.out.println("Length = " + resume.getResumeText().length());



        Resume savedResume = resumeRepository.save(resume);

        System.out.println("After Save:");
        System.out.println(savedResume.getResumeText().substring(0,100));
        System.out.println("Length = " + savedResume.getResumeText().length());

        return uploadResponse.builder()
                .resumeId(savedResume.getId())
                .message("Resume uploaded successfully")
                .build();
    }
}