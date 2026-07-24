package com.exampleAIJobAssistant.AIJobAssistant.ats.util;

import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;


@Component
public class skillExtractor {
    private static final Set<String> SKILLS = Set.of(
            // Languages
            "java",
            "python",
            "c",
            "c++",
            "c#",
            "javascript",
            "typescript",
            "go",
            "rust",

            // Backend
            "spring",
            "spring boot",
            "hibernate",
            "jpa",
            "node.js",
            "express",

            // Frontend
            "react",
            "angular",
            "vue",
            "html",
            "css",

            // Database
            "sql",
            "mysql",
            "postgres",
            "postgresql",
            "mongodb",
            "redis",

            // Cloud
            "aws",
            "azure",
            "gcp",

            // DevOps
            "docker",
            "kubernetes",
            "jenkins",
            "git",
            "github",

            // AI
            "openai",
            "langchain",
            "langgraph",
            "rag",
            "vector database",
            "pinecone",
            "chroma",
            "ollama",
            "huggingface",

            // CS
            "operating system",
            "computer networks",
            "dbms",
            "system design",
            "data structures",
            "algorithms"
    );

    public Set<String> extractSkills(String text) {

        Set<String> foundSkills = new HashSet<>();

        text = text.toLowerCase();

        for(String skill : SKILLS) {

            if(text.contains(skill)) {
                foundSkills.add(skill);
            }

        }

        return foundSkills;
    }
}
