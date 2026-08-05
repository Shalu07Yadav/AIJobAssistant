package com.exampleAIJobAssistant.AIJobAssistant.interview.service;

import com.exampleAIJobAssistant.AIJobAssistant.interview.model.InterviewSession;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InterviewSessionStore {

    private final Map<String, InterviewSession> sessions = new HashMap<>();

    public void save(InterviewSession session) {
        sessions.put(session.getSessionId(), session);
    }

    public InterviewSession get(String sessionId) {
        return sessions.get(sessionId);
    }

    public void remove(String sessionId) {
        sessions.remove(sessionId);
    }
}