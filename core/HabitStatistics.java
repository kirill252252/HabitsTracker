package core;

public class HabitStatistics {

    public static int totalCompleted(Habit habit) {
        return habit.getCompletedDates().size();
    }

    public static double progress(Habit habit) {

        if (habit.getGoal() == null) return 0;

        double done = habit.getCompletedDates().size();
        double total = habit.getGoal().getTargetCount();

        return Math.min(100, (done / total) * 100);
    }
}