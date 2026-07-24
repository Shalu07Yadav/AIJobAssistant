package com.exampleAIJobAssistant.AIJobAssistant.ats.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

@Component
public class ResumeInsightGenerator {

    private static final Map<String, String> STRONG_POINTS =
            new HashMap<>();

    private static final Map<String, String> RECOMMENDATIONS =
            new HashMap<>();

    static {

        STRONG_POINTS.put(
                "java",
                "Strong Java programming skills."
        );

        STRONG_POINTS.put(
                "spring boot",
                "Hands-on experience building backend applications using Spring Boot."
        );

        STRONG_POINTS.put(
                "react",
                "Experience building modern frontend applications using React."
        );

        STRONG_POINTS.put(
                "postgresql",
                "Good knowledge of relational databases using PostgreSQL."
        );

        STRONG_POINTS.put(
                "docker",
                "Experience with containerization using Docker."
        );

        STRONG_POINTS.put(
                "aws",
                "Hands-on exposure to AWS cloud services."
        );


        RECOMMENDATIONS.put(
                "redis",
                "Learn Redis and integrate caching into one of your Spring Boot projects."
        );

        RECOMMENDATIONS.put(
                "kafka",
                "Build an event-driven application using Kafka."
        );

        RECOMMENDATIONS.put(
                "langchain",
                "Build an AI application using LangChain and OpenAI."
        );

        RECOMMENDATIONS.put(
                "docker",
                "Containerize one of your existing Spring Boot projects using Docker."
        );

        RECOMMENDATIONS.put(
                "aws",
                "Deploy one of your projects on AWS and mention it on your resume."
        );

    }

    public List<String> generateStrongPoints(
            Set<String> matchedSkills) {

        List<String> result = new ArrayList<>();

        for(String skill : matchedSkills){

            if(STRONG_POINTS.containsKey(skill)){

                result.add(
                        STRONG_POINTS.get(skill)
                );

            }

        }

        return result;
    }


    public List<String> generateRecommendations(
            Set<String> missingSkills){

        List<String> result = new ArrayList<>();

        for(String skill : missingSkills){

            if(RECOMMENDATIONS.containsKey(skill)){

                result.add(
                        RECOMMENDATIONS.get(skill)
                );

            }

        }

        return result;
    }

}