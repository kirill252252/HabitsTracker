package services;

import core.Habit;

import java.util.ArrayList;
import java.util.List;

public class HabitNotifications {

    public static List<String> getMissedHabits(HabitManager manager) {

        List<String> missed = new ArrayList<>();

        for (Habit habit : manager.getHabits()) {
            if (habit.getCompletedDates().isEmpty()) {
                missed.add("Привычка не выполнялась: " + habit.getName());
            }
        }

        return missed;
    }
}