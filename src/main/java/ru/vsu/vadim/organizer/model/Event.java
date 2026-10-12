package ru.vsu.vadim.organizer.model;

import java.util.UUID;

public abstract class Event {
    private String id;
    private String date;
    private String description;

    public Event(String date, String description) {
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
