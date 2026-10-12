package ru.vsu.vadim.organizer.repository;

import ru.vsu.vadim.organizer.model.Event;
import java.util.ArrayList;
import java.util.List;

public class EventRepositoryInMemoryImpl implements EventRepository {
    private final List<Event> events = new ArrayList<>();

    @Override
    public void save(Event event) {
        events.add(event);
    }

    @Override
    public List<Event> findAll() {
        return events;
    }

    @Override
    public Event findById(String id) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                return event;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getId().equals(id)) {
                events.remove(i);
                return true;
            }
        }
        return false;
    }
}