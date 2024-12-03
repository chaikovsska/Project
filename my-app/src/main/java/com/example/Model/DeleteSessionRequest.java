package com.example.Model;

public class DeleteSessionRequest {
    private String email;       // Електронна пошта користувача
    private int trainerId;      // ID тренера
    private String date;        // Дата сесії у вигляді String (формат YYYY-MM-DD)
    private String time;        // Час сесії у вигляді String (формат HH:mm)

    // Getter та Setter для кожного поля
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}