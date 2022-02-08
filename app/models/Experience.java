package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * Represent a Experience.
 * This class includes:
 * <ul>
 * <li> The model structure (fields, plus getters and setters).
 * <li> Some methods to facilitate form display and manipulation (makeGPAMap, etc.).
 * <li> Some fields and methods to "fake" a database of GPAs.
 * </ul>
 */
public class Experience {
    private long id;
    private String name;

    public Experience(long id, String name) {
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
     * Create a map of GPA name -> boolean where the boolean is true if the GPA corresponds to the student.
     * @param student A student with a GPA.
     * @return A map of GPA to boolean indicating which one is the student's GPA.
     */
    public static Map<String, Boolean> makeGPAMap(YourMovie student) {
        Map<String, Boolean> gpaMap = new TreeMap<String, Boolean>();
        for (Experience gpa : allGPAs) {
            gpaMap.put(gpa.getName(),  (student == null) ? false : (student.gpa != null && student.gpa.equals(gpa.getName())));
        }
        return gpaMap;
    }

    /**
     * @return A list of GPA ranges in sorted order.
     */
    public static List<String> getGPAList() {
        String[] nameArray = {"Fresher", "1-2 Movies", "3-5 Movies", "More Than 5 Movies "};
        return Arrays.asList(nameArray);
    }

    /**
     * Return the GPA instance in the database with name 'gpa' or null if not found.
     * @param gpa The gpa
     * @return The GradePointAverage instance, or null.
     */
    public static Experience findGPA(String gpaName) {
        for (Experience gpa : allGPAs) {
            if (gpaName.equals(gpa.getName())) {
                return gpa;
            }
        }
        return null;
    }

    /**
     * Define a default GPA, used for form display.
     * @return The default GPA.
     */
    public static Experience getDefaultGPA() {
        return findGPA("Fresher");
    }

    @Override
    public String toString() {
        return String.format("[GPA %s]", this.name);
    }

    /** Fake a database of GPAs. */
    private static List<Experience> allGPAs = new ArrayList<>();

    /** Instantiate the fake database of GPAs. */
    static {
        allGPAs.add(new Experience(1L, "Fresher"));
        allGPAs.add(new Experience(2L, "1-2 Movies"));
        allGPAs.add(new Experience(3L, "3-5 Movies"));
        allGPAs.add(new Experience(4L, "More Than 5 Movies "));

    }


}