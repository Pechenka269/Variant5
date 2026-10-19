package ru.vsu.vadim.organizer.controller;

import ru.vsu.vadim.organizer.exception.BusinessException;
import ru.vsu.vadim.organizer.model.Birthday;
import ru.vsu.vadim.organizer.model.Event;
import ru.vsu.vadim.organizer.model.Meeting;
import ru.vsu.vadim.organizer.service.EventService;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CmdController {

    private final EventService eventService;
    private final Scanner scanner;

    public CmdController(EventService eventService, Scanner scanner) {
        this.eventService = eventService;
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            System.out.println("\n=== ОРГАНАЙЗЕР ===");
            System.out.println("1. Добавить день рождения");
            System.out.println("2. Добавить встречу");
            System.out.println("3. Показать все события");
            System.out.println("4. Просмотр по годам/месяцам/дням");
            System.out.println("5. Удалить событие по ID");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        createBirthday();
                        break;

                    case "2":
                        createMeeting();
                        break;

                    case "3":
                        if (checkIfEmpty()) break;
                        getAll();
                        break;

                    case "4":
                        if (checkIfEmpty()) break;
                        filterByDate();
                        break;

                    case "5":
                        if (checkIfEmpty()) break;
                        deleteEvent();
                        break;

                    case "0":
                        System.out.println("Выход из программы. Пока!");
                        return;

                    default:
                        System.out.println("Неверный ввод. Попробуйте еще раз.");
                }
            } catch (BusinessException e) {
                System.out.println("Ошибка бизнес-логики: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Возникла непредвиденная ошибка: " + e.getMessage());
            }
        }
    }


    private boolean checkIfEmpty() {
        if (eventService.getAllEvents().isEmpty()) {
            System.out.println("В органайзере пока нет записей! Сначала добавьте событие.");
            return true;
        }
        return false;
    }

    private UUID readUuid() {
        UUID uuid;
        while (true) {
            System.out.print("Введите идентификатор (UUID): ");
            String rawId = scanner.nextLine();
            try {
                uuid = UUID.fromString(rawId);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Неверный формат идентификатора. Попробуйте снова (пример: 50b66077-2437-404b-aa34-a7103bfdd581)");
            }
        }
        return uuid;
    }

    private void createBirthday() {
        System.out.print("Введите дату (например, 2006-04-04): ");
        String date = scanner.nextLine();
        System.out.print("Имя именинника: ");
        String name = scanner.nextLine();
        System.out.print("Час рождения: ");
        String hour = scanner.nextLine();
        System.out.print("Подарок: ");
        String gift = scanner.nextLine();
        System.out.print("Описание: ");
        String desc = scanner.nextLine();

        Birthday birthday = new Birthday(date, desc, name, hour, gift);
        eventService.addEvent(birthday);
        System.out.println("День рождения добавлен! " + birthday);
    }

    private void createMeeting() {
        System.out.print("Введите дату (например, 2006-04-04): ");
        String date = scanner.nextLine();
        System.out.print("Собеседник: ");
        String person = scanner.nextLine();
        System.out.print("Время начала: ");
        String time = scanner.nextLine();
        System.out.print("Описание: ");
        String desc = scanner.nextLine();

        Meeting meeting = new Meeting(date, desc, person, time);
        eventService.addEvent(meeting);
        System.out.println("Встреча добавлена! " + meeting);
    }

    private void getAll() {
        List<Event> all = eventService.getAllEvents();
        System.out.println("\n--- Все события ---");
        for (Event event : all) {
            System.out.println(event);
        }
    }

    private void filterByDate() {
        System.out.print("Введите год, месяц или день (например, 2006, 2006-04 или 2006-04-04): ");
        String prefix = scanner.nextLine();

        List<Event> filtered = eventService.getEventsByDatePrefix(prefix);
        if (filtered.isEmpty()) {
            System.out.println("Событий по заданному критерию не найдено.");
            return;
        }

        System.out.println("\n--- Найдено ---");
        for (Event event : filtered) {
            System.out.println(event);
        }
    }

    private void deleteEvent() throws BusinessException {

        UUID id = readUuid();
        eventService.deleteById(id);
        System.out.println("Событие с ID " + id + " успешно удалено!");
    }
}