package com.exampleAIJobAssistant.AIJobAssistant.resume.repository;

import com.exampleAIJobAssistant.AIJobAssistant.resume.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface resumeRepository
        extends JpaRepository<Resume, Long> {

}