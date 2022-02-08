package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GradeLevel {
    private long id;
    private String name;

    /**
     * Create a new Grade Level.
     * @param id The id.
     * @param name The name of the grade.
     */
    public GradeLevel(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * Provide a list of names for use in form display.
     * @return A list of level names in sorted order.
     */
    public static List<String> getNameList() {
        String[] nameArray = {"Script Writer", "Director", "Cinematographer", "Producer", "Other"};
        return Arrays.asList(nameArray);
    }


    public static GradeLevel findLevel(String levelName) {
        for (GradeLevel level : allLevels) {
            if (levelName.equals(level.getName())) {
                return level;
            }
        }
        return null;
    }

    /**
     * Provide a default grade level for use in form display.
     * @return The default grade level.
     */
    public static GradeLevel getDefaultLevel() {
        return findLevel("Director");
    }

    @Override
    public String toString() {
        return String.format("[GradeLevel %s]", this.name);
    }

    /** Fake a database of Grade Levels. */
    private static List<GradeLevel> allLevels = new ArrayList<>();

    /** Instantiate the fake database. */
    static {
        allLevels.add(new GradeLevel(1L, "Script Writer"));
        allLevels.add(new GradeLevel(2L, "Director"));
        allLevels.add(new GradeLevel(3L, "Cinematographer"));
        allLevels.add(new GradeLevel(4L,  "Producer"));
        allLevels.add(new GradeLevel(5L, "Other"));
    }


}
