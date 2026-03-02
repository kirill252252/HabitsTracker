package data;

import core.HabitCategory;
import services.HabitManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HabitImport {

    public static void importFromFile(HabitManager manager, String filename) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";");
            HabitCategory category = new HabitCategory(parts[2]);
            manager.addHabit(parts[1], category);
        }

        reader.close();
    }
}