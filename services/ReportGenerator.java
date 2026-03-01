package services;

import core.Habit;

public class ReportGenerator {

    public static void generate(HabitManager manager) {
        for (Habit habit : manager.getHabits()) {
            System.out.println(
                    habit.getName() +
                    " | Выполнено: " +
                    habit.getCompletedDates().size()
            );
        }
    }
}
