package app;

import core.*;
import services.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HabitManager manager = new HabitManager();

        HabitCategory sport = new HabitCategory("Спорт");
        HabitCategory study = new HabitCategory("Учёба");
        HabitCategory health = new HabitCategory("Здоровье");

        boolean running = true;

        while (running) {
            System.out.println("\n МЕНЮ ПРИВЫЧЕК");
            System.out.println("1. Добавить привычку");
            System.out.println("2. Пометить привычку как выполненную");
            System.out.println("3. Показать все привычки");
            System.out.println("4. Показать отчёт");
            System.out.println("5. Показать непройденные сегодня");
            System.out.println("6. Выход");
            System.out.print("Выберите опцию: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Название привычки: ");
                    String name = scanner.nextLine();

                    System.out.println("Категории: 1-Спорт, 2-Учёба, 3-Здоровье");
                    System.out.print("Выберите категорию (1-3): ");
                    String catChoice = scanner.nextLine();
                    HabitCategory selectedCat = switch (catChoice) {
                        case "1" -> sport;
                        case "2" -> study;
                        case "3" -> health;
                        default -> sport;
                    };

                    manager.addHabit(name, selectedCat);
                    System.out.println("Привычка добавлена!");
                    break;

                case "2":
                    System.out.println("Введите ID привычки для выполнения:");
                    int id = Integer.parseInt(scanner.nextLine());
                    manager.markCompleted(id);
                    System.out.println("Привычка помечена как выполненная!");
                    break;

                case "3":
                    System.out.println("\nВсе привычки:");
                    for (Habit h : manager.getHabits()) {
                        System.out.println(h.getId() + ". " + h.getName() + " (" + h.getCategory().getName() + ")");
                    }
                    break;

                case "4":
                    System.out.println("\n=== ОТЧЁТ ===");
                    ReportGenerator.generate(manager);
                    break;

                case "5":
                    List<Habit> uncompleted = HabitReminder.getUncompletedToday(manager);
                    System.out.println("\nНепройденные сегодня:");
                    if (uncompleted.isEmpty()) {
                        System.out.println("Все привычки выполнены!");
                    } else {
                        for (Habit h : uncompleted) {
                            System.out.println(h.getId() + ". " + h.getName());
                        }
                    }
                    break;

                case "6":
                    running = false;
                    System.out.println("Выход из программы...");
                    break;

                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }
}