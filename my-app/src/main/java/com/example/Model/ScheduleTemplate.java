package com.example.Model;

import java.time.LocalTime;

public class ScheduleTemplate {

    private int id;              // Унікальний ідентифікатор шаблону
    private int trainerId;       // Ідентифікатор тренера
    private String dayOfWeek;    // День тижня (наприклад, "Monday")
    private LocalTime time;      // Час проведення сесії

    // Конструктор без параметрів (потрібний для JAX-RS)
    public ScheduleTemplate() {}

    // Конструктор з усіма параметрами
    public ScheduleTemplate(int id, int trainerId, String dayOfWeek, LocalTime time) {
        this.id = id;
        this.trainerId = trainerId;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
    }

    // Гетери та сетери для всіх полів
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ScheduleTemplate{" +
                "id=" + id +
                ", trainerId=" + trainerId +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", time=" + time +
                '}';
    }
}