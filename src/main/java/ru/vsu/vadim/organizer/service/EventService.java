package ru.vsu.vadim.organizer.service;

import ru.vsu.vadim.organizer.exception.EventNotFoundException;
import ru.vsu.vadim.organizer.model.Event;
import java.util.List;

public interface EventService {
    void addEvent(Event event);
    List<Event> getAllEvents();
    List<Event> getEventsByDatePrefix(String prefix);
    Event getById(String id) throws EventNotFoundException;
    void deleteById(String id) throws EventNotFoundException;
}