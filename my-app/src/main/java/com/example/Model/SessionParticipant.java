package com.example.Model;

public class SessionParticipant {
    private int sessionId;      // Ідентифікатор сесії
    private int participantId;  // Ідентифікатор учасника

    // Конструктор за замовчуванням (потрібний для DAO)
    public SessionParticipant() {
    }

    // Конструктор з параметрами sessionId та participantId
    public SessionParticipant(int sessionId, int participantId) {
        this.sessionId = sessionId;
        this.participantId = participantId;
    }

    // Гетери та сетери для sessionId та participantId
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }
}