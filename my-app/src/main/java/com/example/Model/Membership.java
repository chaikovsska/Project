package com.example.Model;

public class Membership {
    private int id;
    private String name;
    private String description;
    private double price;
    private int duration;

    public Membership() {
        // тут не потрібно нічого додавати, всі значення можна ініціалізувати через сеттери
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getType() {
        return this.name; // Тут можна змінити, якщо потрібно, на іншу змінну
    }
}