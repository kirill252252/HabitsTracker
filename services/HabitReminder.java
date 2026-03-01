package services;

import core.Habit;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class HabitReminder {

    public static List<Habit> getUncompletedToday(HabitManager manager) {

        LocalDate today = LocalDate.now();

        return manager.getHabits()
                .stream()
                .filter(h -> !h.getCompletedDates().contains(today))
                .collect(Collectors.toList());
    }
}