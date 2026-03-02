package core;

public class HabitGoals {

    private int targetCount;

    public HabitGoals(int targetCount) {
        this.targetCount = targetCount;
    }

    public int getTargetCount() {
        return targetCount;
    }

    public boolean isReached(Habit habit) {
        return habit.getCompletedDates().size() >= targetCount;
    }
}