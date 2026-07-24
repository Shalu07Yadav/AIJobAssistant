package com.exampleAIJobAssistant.AIJobAssistant.interview.prompt;

import org.springframework.stereotype.Component;

@Component
public class InterviewPromptBuilder {

    public String buildPrompt(String resumeText) {

        return """
                You are an experienced Senior Software Engineer conducting a technical interview.

                Analyze the candidate's resume carefully.

                Generate personalized interview questions based ONLY on the resume.

                Rules:

                1. Generate questions only from the resume.
                2. Categorize them into:
                   - projectQuestions
                   - experienceQuestions
                   - technicalQuestions
                   - behavioralQuestions
                3. Decide dynamically how many questions each category should have.
                4. Each question must include:
                   - question
                   - difficulty (Easy, Medium, Hard)
                   - relatedSkill
                5. Return ONLY valid JSON.
                6. Do not add explanations.
                7. Do not wrap the response in markdown.
                8. The JSON must exactly match this structure:

                {
                  "projectQuestions":[
                    {
                      "question":"",
                      "difficulty":"",
                      "relatedSkill":""
                    }
                  ],
                  "experienceQuestions":[],
                  "technicalQuestions":[],
                  "behavioralQuestions":[]
                }

                Resume:

                """ + resumeText;

    }
}
