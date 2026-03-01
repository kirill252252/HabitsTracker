package core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Habit {

    private int id;
    private String name;
    private HabitCategory category;
    private HabitGoals goal;
    private List<String> notes;
    private List<LocalDate> completedDates;

    public Habit(int id, String name, HabitCategory category) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.notes = new ArrayList<>();
        this.completedDates = new ArrayList<>();
    }

    public void markCompleted() {
        LocalDate today = LocalDate.now();
        if (!completedDates.contains(today)) {
            completedDates.add(today);
        }
    }

    public void addNote(String note) {
        notes.add(note);
    }

    public void setGoal(HabitGoals goal) {
        this.goal = goal;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public HabitCategory getCategory() { return category; }
    public HabitGoals getGoal() { return goal; }
    public List<String> getNotes() { return notes; }
    public List<LocalDate> getCompletedDates() { return completedDates; }
}
