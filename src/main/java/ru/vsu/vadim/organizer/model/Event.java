package ru.vsu.vadim.organizer.model;

import java.util.UUID;

public abstract class Event {
    private UUID id;
    private String date;
    private String description;

    public Event(String date, String description) {
        this.id = UUID.randomUUID();
        this.date = date;
        this.description = description;
    }

    public UUID getId() {
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
