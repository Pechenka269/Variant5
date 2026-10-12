package ru.vsu.vadim.organizer.exception;

public class EventNotFoundException extends BusinessException {
    public EventNotFoundException(String id) {
        super("Событие с ID = " + id + " не найдено");
    }
}