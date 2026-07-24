package com.exampleAIJobAssistant.AIJobAssistant.optimizer.prompt;

import org.springframework.stereotype.Component;

@Component

public class ResumeOptimizerPromptBuilder {

    public String buildPrompt(String resumeText,
                              String jobDescription) {

        return """
                You are an experienced Technical Recruiter, ATS Expert, and Senior Software Engineer.

                Analyze the candidate's resume against the provided Job Description.

                Your tasks are:

                1. Give overall feedback about the resume.
                2. Suggest improvements for the professional summary.
                3. Suggest improvements for the experience section.
                4. Suggest improvements for the projects section.
                5. Suggest improvements for the technical skills section.
                6. Identify important keywords present in the Job Description but missing from the resume.
                7. Rewrite weak resume bullet points into stronger, ATS-friendly bullet points.
                8. Do NOT invent fake experience.
                9. Do NOT add skills unless they are genuinely relevant.
                10. Return ONLY valid JSON.
                11. Do not wrap the response in markdown.

                Return JSON in exactly this format:

                {
                  "overallFeedback":"",
                  "summarySuggestions":[],
                  "experienceSuggestions":[],
                  "projectSuggestions":[],
                  "technicalSkillSuggestions":[],
                  "missingKeywords":[],
                  "optimizedBulletPoints":[]
                }

                ==========================
                RESUME
                ==========================

                """ + resumeText +

                """

                ==========================
                JOB DESCRIPTION
                ==========================

                """ + jobDescription;

    }

}
