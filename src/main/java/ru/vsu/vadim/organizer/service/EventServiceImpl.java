package ru.vsu.vadim.organizer.service;

import ru.vsu.vadim.organizer.exception.EventNotFoundException;
import ru.vsu.vadim.organizer.model.Event;
import ru.vsu.vadim.organizer.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventServiceImpl implements EventService {
    private final EventRepository repository;

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addEvent(Event event) {
        repository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    @Override
    public List<Event> getEventsByDatePrefix(String prefix) {
        List<Event> result = new ArrayList<>();
        for (Event event : repository.findAll()) {
            if (event.getDate().startsWith(prefix)) {
                result.add(event);
            }
        }
        return result;
    }

    @Override
    public Event getById(UUID id) throws EventNotFoundException {
        Event event = repository.findById(id);
        if (event == null) {
            throw new EventNotFoundException(id);
        }
        return event;
    }

    @Override
    public void deleteById(UUID id) throws EventNotFoundException {
        boolean deleted = repository.deleteById(id);
        if (!deleted) {
            throw new EventNotFoundException(id);
        }
    }
}