package ru.vsu.vadim.organizer.exception;

import java.util.UUID;

public class EventNotFoundException extends BusinessException {
    public EventNotFoundException(UUID id) {
        super("Событие с ID = " + id + " не найдено");
    }
}