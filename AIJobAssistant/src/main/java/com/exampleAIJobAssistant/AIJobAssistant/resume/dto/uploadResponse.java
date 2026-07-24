package com.exampleAIJobAssistant.AIJobAssistant.resume.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class uploadResponse {

    private Long resumeId;
    private String message;
}
