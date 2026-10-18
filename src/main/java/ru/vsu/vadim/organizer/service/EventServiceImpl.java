package ru.vsu.vadim.organizer.service;

import ru.vsu.vadim.organizer.exception.EventNotFoundException;
import ru.vsu.vadim.organizer.model.Event;
import ru.vsu.vadim.organizer.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;

public class EventServiceImpl implements EventService {
    private final EventRepository repository;

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    public void addEvent(Event event) {
        repository.save(event);
    }

    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    public List<Event> getEventsByDatePrefix(String prefix) {
        List<Event> result = new ArrayList<>();
        for (Event event : repository.findAll()) {
            if (event.getDate().startsWith(prefix)) {
                result.add(event);
            }
        }
        return result;
    }

    public Event getById(String id) throws EventNotFoundException {
        Event event = repository.findById(id);
        if (event == null) {
            throw new EventNotFoundException(id);
        }
        return event;
    }

    public void deleteById(String id) throws EventNotFoundException {
        boolean deleted = repository.deleteById(id);
        if (!deleted) {
            throw new EventNotFoundException(id);
        }
    }
}