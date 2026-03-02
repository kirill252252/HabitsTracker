package services;

import core.*;
import java.util.*;
import java.util.stream.Collectors;


public class HabitLeaderboard {

    // 1. Основной рейтинг (простая сортировка)
    public static List<Habit> getLeaderboard(HabitManager manager) {
        return manager.getHabits().stream()
                .sorted((h1, h2) -> h2.getCompletedDates().size() - h1.getCompletedDates().size())
                .collect(Collectors.toList());
    }

    // 2. Топ-N привычек
    public static List<Habit> getTopHabits(HabitManager manager, int limit) {
        return getLeaderboard(manager).stream().limit(limit).collect(Collectors.toList());
    }

    // 3. Детальный рейтинг с позициями
    public static List<String> getDetailedLeaderboard(HabitManager manager) {
        List<String> result = new ArrayList<>();
        List<Habit> sorted = getLeaderboard(manager);

        for (int i = 0; i < sorted.size(); i++) {
            Habit h = sorted.get(i);
            result.add(String.format("%d. %s - %d вып. (серия: %d)",
                    i + 1, h.getName(), h.getCompletedDates().size(),
                    HabitStreak.calculate(h)));
        }
        return result;
    }

    // 4. Рейтинг по категориям
    public static Map<String, List<Habit>> getLeaderboardByCategory(HabitManager manager) {
        return manager.getHabits().stream()
                .sorted((h1, h2) -> h2.getCompletedDates().size() - h1.getCompletedDates().size())
                .collect(Collectors.groupingBy(h -> h.getCategory().getName(),
                        LinkedHashMap::new, Collectors.toList()));
    }

    // 5. Самая популярная привычка
    public static Habit getMostPopularHabit(HabitManager manager) {
        return manager.getHabits().stream()
                .max(Comparator.comparingInt(h -> h.getCompletedDates().size()))
                .orElse(null);
    }

    // 6. Вывод в консоль
    public static void printLeaderboard(HabitManager manager) {
        System.out.println("\n=== РЕЙТИНГ ПРИВЫЧЕК ===");
        getDetailedLeaderboard(manager).forEach(System.out::println);

        Habit top = getMostPopularHabit(manager);
        if (top != null) {
            System.out.println(" Лидер: " + top.getName() +
                    " (" + top.getCompletedDates().size() + ")");
        }
    }

    // 7. Процент выполнения (кратко)
    public static List<String> getCompletionPercentages(HabitManager manager) {
        return manager.getHabits().stream()
                .map(h -> String.format("%s: %.0f%%", h.getName(),
                        HabitStatistics.progress(h)))
                .collect(Collectors.toList());
    }
}