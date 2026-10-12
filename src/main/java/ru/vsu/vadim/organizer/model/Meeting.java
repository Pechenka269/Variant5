package ru.vsu.vadim.organizer.model;

public class Meeting extends Event {
    private String person;
    private String startTime;

    public Meeting(String date, String description, String person, String startTime) {
        super(date, description);
        this.person = person;
        this.startTime = startTime;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    public String toString() {
        return "ВСТРЕЧА ID: " + getId() +
                " | Дата: " + getDate() +
                " | Собеседник: " + person +
                " | Начало: " + startTime +
                " | Описание: " + getDescription();
    }
}