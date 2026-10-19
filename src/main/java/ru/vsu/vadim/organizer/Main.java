package ru.vsu.vadim.organizer;

import ru.vsu.vadim.organizer.controller.CmdController;
import ru.vsu.vadim.organizer.repository.EventRepository;
import ru.vsu.vadim.organizer.repository.EventRepositoryInMemoryImpl;
import ru.vsu.vadim.organizer.service.EventService;
import ru.vsu.vadim.organizer.service.EventServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventRepository repository = new EventRepositoryInMemoryImpl();
        EventService service = new EventServiceImpl(repository);
        CmdController controller = new CmdController(service, scanner);
        controller.run();
    }
}