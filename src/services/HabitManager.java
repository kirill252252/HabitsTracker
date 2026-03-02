package services;

import core.Habit;
import core.HabitCategory;

import java.util.ArrayList;
import java.util.List;

public class HabitManager {

    private List<Habit> habits = new ArrayList<>();
    private int nextId = 1;

    public Habit addHabit(String name, HabitCategory category) {
        Habit habit = new Habit(nextId++, name, category);
        habits.add(habit);
        return habit;
    }

    public void removeHabit(int id) {
        habits.removeIf(h -> h.getId() == id);
    }

    public Habit getHabit(int id) {
        return habits.stream()
                .filter(h -> h.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void markCompleted(int id) {
        Habit habit = getHabit(id);
        if (habit != null) {
            habit.markCompleted();
        }
    }

    public List<Habit> getHabits() {
        return habits;
    }
}