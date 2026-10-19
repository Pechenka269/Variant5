package ru.vsu.vadim.organizer.repository;

import ru.vsu.vadim.organizer.model.Event;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventRepositoryInMemoryImpl implements EventRepository {
    private final List<Event> events = new ArrayList<>();


    public void save(Event event) {
        events.add(event);
    }


    public List<Event> findAll() {
        return events;
    }


    public Event findById(UUID id) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                return event;
            }
        }
        return null;
    }


    public boolean deleteById(UUID id) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getId().equals(id)) {
                events.remove(i);
                return true;
            }
        }
        return false;
    }
}