package com.exampleAIJobAssistant.AIJobAssistant.optimizer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptimizedBulletPoint {
    private String original;

    private String optimized;
}
