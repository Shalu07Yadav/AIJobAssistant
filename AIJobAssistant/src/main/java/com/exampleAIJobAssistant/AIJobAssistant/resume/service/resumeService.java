package com.exampleAIJobAssistant.AIJobAssistant.resume.service;

import com.exampleAIJobAssistant.AIJobAssistant.resume.dto.uploadResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface resumeService {
    uploadResponse uploadResume(MultipartFile file)
            throws IOException, Exception;
}
