package ru.vsu.vadim.organizer.model;

public class Birthday extends Event {
    private String name;
    private String birthHour;
    private String gift;

    public Birthday(String date, String description, String name, String birthHour, String gift) {
        super(date, description);
        this.name = name;
        this.birthHour = birthHour;
        this.gift = gift;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthHour() {
        return birthHour;
    }

    public void setBirthHour(String birthHour) {
        this.birthHour = birthHour;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }


    public String toString() {
        return "ДЕНЬ РОЖДЕНИЯ ID: " + getId() +
                " | Дата: " + getDate() +
                " | Имя: " + name +
                " | Время: " + birthHour +
                " | Подарок: " + gift +
                " | Описание: " + getDescription();
    }
}
