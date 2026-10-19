package ru.vsu.vadim.organizer.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.vsu.vadim.organizer.model.Birthday;
import ru.vsu.vadim.organizer.model.Event;
import ru.vsu.vadim.organizer.model.Meeting;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class EventRepositoryTest {

    private EventRepository repository;

    @BeforeEach
    void setUp() {
        repository = new EventRepositoryInMemoryImpl();
    }

    @Test
    void testSaveAndFindAll() {
        Event birthday = new Birthday("2026-10-15", "ДР", "Алексей", "18:00", "Книга");
        Event meeting = new Meeting("2026-09-20", "Встреча", "Андрей", "10:00");

        repository.save(birthday);
        repository.save(meeting);

        List<Event> all = repository.findAll();

        assertEquals(2, all.size());
        assertTrue(all.contains(birthday));
        assertTrue(all.contains(meeting));
    }

    @Test
    void testFindById() {
        Event birthday = new Birthday("2026-08-01", "Праздник", "Мама", "12:00", "Цветы");
        repository.save(birthday);

        Event found = repository.findById(birthday.getId());

        assertNotNull(found);
        assertEquals(birthday.getId(), found.getId());
    }

    @Test
    void testFindByIdNotFound() {
        Event found = repository.findById(UUID.randomUUID());
        assertNull(found);
    }

    @Test
    void testDeleteById() {
        Event meeting = new Meeting("2026-07-10", "БК", "Роман", "14:00");
        repository.save(meeting);

        boolean deleted = repository.deleteById(meeting.getId());

        assertTrue(deleted);
        assertNull(repository.findById(meeting.getId()));
        assertEquals(0, repository.findAll().size());
    }

    @Test
    void testDeleteByIdNotFound() {
        boolean deleted = repository.deleteById(UUID.randomUUID());
        assertFalse(deleted);
    }
}