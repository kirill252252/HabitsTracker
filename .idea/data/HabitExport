package data;

import services.HabitManager;
import core.Habit;

import java.io.FileWriter;
import java.io.IOException;

public class HabitExport {

    public static void exportToFile(HabitManager manager, String filename) throws IOException {

        FileWriter writer = new FileWriter(filename);

        for (Habit habit : manager.getHabits()) {
            writer.write(
                    habit.getId() + ";" +
                    habit.getName() + ";" +
                    habit.getCategory().getName() + "\n"
            );
        }

        writer.close();
    }
}