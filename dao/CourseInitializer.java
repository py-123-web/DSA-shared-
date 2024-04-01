package dao;

import adt.SortedArrayList;
import adt.SortedListInterface;
import boundary.CourseUI;
import entity.Course;
import entity.Programme;
import java.util.Iterator;

/**
 *
 * @author Hor Pei Yu
 */

/**
 * Initializes the course list and map.
 */
public class CourseInitializer {

    private CourseUI courseUI = new CourseUI();
    private final SortedListInterface<Programme> progList = new SortedArrayList<>();
    private final SortedListInterface<Course> courseList = new SortedArrayList<>();

    public CourseInitializer() {
        initializeCourse();
        initializeProgramme();
    }

    public SortedListInterface<Course> initializeCourse() {
        // Adding courses
        courseList.add(new Course("BACS2003", "DSA", "Lecture", "YEAR 3 SEM 3", 3, "FOCS", 777.00, "REI"));
        // Add other courses similarly

        return courseList; // Return the initialized course list
    }

    public void displayCourseInfo() {
        for (int i = 0; i < courseList.getNumberOfEntries(); i++) {
            Course course = courseList.getEntry(i);
            System.out.println(" " + course.getCourseCode()
                    + " " + course.getCourseName()
                    + " " + course.getClassType()
                    + " " + course.getSemester()
                    + " " + course.getCreditHour());
        }
    }

    public SortedListInterface<Course> getTutorList() {
        return courseList;
    }

    public SortedListInterface<Programme> initializeProgramme() {
        // Adding programmes
        progList.add(new Programme("BACS2003", "DSA"));
        // Add other programmes similarly

        return progList; // Return the initialized programme list
    }

//    public void displayProgInfo() {
//        for (int i = 0; i < progList.getNumberOfEntries(); i++) {
//            Programme programme = progList.getEntry(i);
//            System.out.println(" " + programme.getProgrammeCode() + " " + programme.getProgrammeName());
//        }
//    }

    public SortedListInterface<Programme> getcList() {
        return progList;
    }

    // List courses by programme
//public void listProgCourse() {
//    courseUI.programme_courseUI();
//
//    // Get iterators for courses and programmes
//    Iterator<Course> courseIterator = courseList.getIterator();
//    Iterator<Programme> progIterator = progList.getIterator();
//
//    boolean foundData = true;
//
//    // Display all courses and programmes
//    while (courseIterator.hasNext()) {
//        Course course = courseIterator.next();
//        // Reset program iterator for each course
//        progIterator = progList.getIterator();
//        while (progIterator.hasNext()) {
//            Programme programme = progIterator.next();
//            if (course.getProgrammeCode().equals(programme.getProgrammeCode())) {
//                // Collect course and programme details into arrays
//                String[] programmeDetails = {programme.getProgrammeCode(), programme.getProgrammeName()};
//                String[] courseDetails = {course.getCourseCode(), course.getCourseName(), course.getClassType(), course.getSemester(), String.valueOf(course.getCreditHour()), String.valueOf(course.getFees()), course.getFaculty()};
//                // Pass course and programme details arrays to printProgrammeCourse method
//                courseUI.printProgrammeCourse(programmeDetails, courseDetails);
//                foundData = true;
//                break; // Stop searching for programmes once a match is found
//            }
//        }
//    }
//
//    // Check if no data is found
//    if (!foundData) {
//        courseUI.displayListCourseNotFound("No courses found.");
//    }
//}


}
