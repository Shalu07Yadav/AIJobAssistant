package com.exampleAIJobAssistant.AIJobAssistant.interview.prompt;

import com.exampleAIJobAssistant.AIJobAssistant.interview.model.ChatMessage;
import com.exampleAIJobAssistant.AIJobAssistant.interview.model.InterviewSession;
import org.springframework.stereotype.Component;

@Component
public class MockInterviewPromptBuilder {

    public String buildFirstQuestionPrompt(String resumeText,
                                           String jobDescription) {

        return """
                You are an experienced technical interviewer.

                Candidate Resume:
                %s

                Job Description:
                %s

                Your task:

                Rules:
                
                1. Ask ONLY ONE interview question.
                2. Do NOT answer your own question.
                 3. Do NOT give feedback.
                 4. Do NOT explain anything.
                5. Behave exactly like a human interviewer.

                Return ONLY the question.
                """.formatted(resumeText, jobDescription);

    }

    // ADD THIS METHOD HERE
    public String buildNextQuestionPrompt(
            InterviewSession session
    ) {

        StringBuilder prompt = new StringBuilder();

        prompt.append("""
You are an experienced Senior Software Engineer interviewer.

Continue this interview naturally.

The interview is based on BOTH the candidate's resume and the job description.

Candidate Resume:

""");

        prompt.append(session.getResumeText());

        prompt.append("""

Job Description:

""");

        prompt.append(session.getJobDescription());

        prompt.append("""

Conversation so far:

""");

        for (ChatMessage message : session.getConversation()) {

            prompt.append(message.getRole())
                    .append(": ")
                    .append(message.getMessage())
                    .append("\n");

        }

        prompt.append("""

Rules:

1. Ask ONLY ONE next interview question.

2. The next question should naturally follow the candidate's previous answer whenever possible.

3. If the candidate answered well, increase the difficulty gradually.

4. If the candidate struggled, ask another question on the same topic before changing topics.

5. Focus on technologies mentioned in BOTH the resume and the job description.

6. Occasionally ask behavioural questions.

7. Do NOT provide feedback.

8. Do NOT explain the answer.

9. Never repeat an interview question already asked.

10. If a topic has already been covered, move naturally to another relevant topic.

Return ONLY the next interview question.

""");

        return prompt.toString();
    }

    public String buildEvaluationPrompt(
            InterviewSession session
    ) {

        StringBuilder prompt = new StringBuilder();

        prompt.append("""
You are a Senior Software Engineering Interviewer.

The interview has now finished.

Below is the complete interview conversation.

Evaluate the candidate honestly and professionally.

Return ONLY valid JSON.

Use the following format:

{
  "overallScore": 8.5,
  "overallFeedback": "...",
  "strengths": [
    "...",
    "..."
  ],
  "improvements": [
    "...",
    "..."
  ],
  "recommendations": [
    "...",
    "..."
  ]
}

Conversation:

""");

        for (ChatMessage message : session.getConversation()) {

            prompt.append(message.getRole())
                    .append(": ")
                    .append(message.getMessage())
                    .append("\n");

        }

        return prompt.toString();
    }

}