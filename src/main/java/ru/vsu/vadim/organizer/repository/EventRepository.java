package ru.vsu.vadim.organizer.repository;

import ru.vsu.vadim.organizer.model.Event;
import java.util.List;

public interface EventRepository {
    void save(Event event);
    List<Event> findAll();
    Event findById(String id);
    boolean deleteById(String id);
}