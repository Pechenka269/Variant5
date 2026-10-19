package ru.vsu.vadim.organizer.repository;

import ru.vsu.vadim.organizer.model.Event;
import java.util.List;
import java.util.UUID;

public interface EventRepository {
    void save(Event event);
    List<Event> findAll();
    Event findById(UUID id);
    boolean deleteById(UUID id);
}