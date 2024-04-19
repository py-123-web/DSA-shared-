package control;

import adt.SortedListInterface;
import adt.SortedArrayList;
import entity.Course;
import entity.Programme;
import boundary.CourseUI;
import java.util.Iterator;
import utility.*;
import dao.CourseInitializer;
import java.util.Scanner;

/**
 *
 * @author Hor Pei Yu
 */
public class CourseManagement {

    private SortedListInterface<Programme> progList = new SortedArrayList<>();
    private SortedListInterface<Course> courseList = new SortedArrayList<>();

    CourseInitializer initializer = new CourseInitializer();

    private CourseUI courseUI = new CourseUI();

    boolean foundData = false;

    public void runCourseSubsystem() {
        int choice;

        initializer.CourseInfo();
        initializer.ProgrammeInfo();

        do {
            choice = courseUI.getMenuChoice();

            switch (choice) {

                case 0:
                    MessageUI.displayExitMessage();
                    break;

                case 1:
                    addNewProgramme();
                    break;
                case 2:
                    addNewCourse();
                    break;

                case 3:
//                    removeProg();
                    break;

                case 4:
                    removeCourse();
                    break;

                case 5:
                    search();
                    break;

                case 6:
                    amendCourse();
                    break;

                case 7:
                    listFacultyCourse();
                    break;

                case 8:
                    listProgCourse();
                    break;

                case 9:
                    courseReport();
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
                    break;
            }
            // MessageUI.displayInvalidChoiceMessage();
        } while (choice != 0);
    }

    //--------------------------------- add fucntion --------------------------
    //----------------------------- add course-----------------------------
    private void addNewCourse() {
        courseUI.getAddCourseHeader();

        // Display the list of programs
        for (Programme programme : initializer.progList) {
            courseUI.programmeList(programme.getProgrammeCode(), programme.getProgrammeName());
        }

        System.out.println("\nPlease select one programme to add course\n");

        String programmeCode;
        int progIndex;

        do {
            programmeCode = courseUI.getProgrammeForCourse();
            Programme inputProgramme = new Programme(programmeCode);
            progIndex = initializer.progList.contains(inputProgramme);

            if (progIndex == -1) {
                courseUI.printProgNotExisted();
                continue; // Prompt the user to select a program again
            }

            boolean courseAdded = false;
            boolean exists;

            do {
                exists = false;

                // Collect course information
                String courseCode = courseUI.getCourseCode();

                // Check if the course already exists
                for (Course course : initializer.courseList) {
                    if (course.getCourseCode().equals(courseCode)) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    courseUI.displayAddProgrammeExist(courseCode);
                } else {
                    String courseName = courseUI.getCourseName();
                    String classType = courseUI.getClassType();
                    String semester = courseUI.getSemester();
                    int creditHour = courseUI.getCreditHour();
                    String faculty = courseUI.getFaculty();
                    double fees = courseUI.getFees();
                    String status = courseUI.getStatus();

                    // Create a new course object
                    Course newCourse = new Course(courseCode, courseName, classType, semester, creditHour, faculty, fees, programmeCode, status);

                    // Add the new course to the course list
                    initializer.courseList.add(newCourse);
                    MessageUI.displayRecordSuccessful();
                    courseAdded = true;

                }
            } while (!courseAdded);
            break;
        } while (true); // Continue until a new course is added
    }

    private void addNewProgramme() {
        // Display header
        courseUI.getAddProgHeader();

        boolean progAdded = false;

        do {
            // Collect programme information
            String programmeCode = courseUI.getProgrammeCode();
            String programmeName = courseUI.getProgrammeName();

            // Validate input
            if (programmeCode.isEmpty()) {
                System.out.println("[Error Message]: Code cannot be empty. Please try again.");
                continue;
            }

            if (programmeName.isEmpty()) {
                System.out.println("[Error Message]: Name cannot be empty. Please try again.");
                continue;
            }

// Check if the programme is match with the hardcode or also can add new programme that not exist in hardcode
            boolean exists = false;
            for (Programme prog : initializer.progList) {
                if (prog.getProgrammeCode().contains(programmeCode)) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                courseUI.displayAddProgrammeExist(programmeCode);
            } else {
                // Display list of courses
                courseUI.courseListUI();
                for (Course course : initializer.courseList) {
                    courseUI.courseList(course.getCourseCode(), course.getCourseName());
                }

                System.out.println("\nPlease select one course to add a programme\n");
                String courseCode = courseUI.getCourseForProgramme();
                Course selectedCourse = null;

                // Find the selected course in the course list
                for (Course course : initializer.courseList) {
                    if (course.getCourseCode().equals(courseCode)) {
                        selectedCourse = course;
                        break;
                    }
                }

                if (selectedCourse != null) {
                    // Add programme code to the selected course
                    selectedCourse.setProgrammeCode(programmeCode);

                    // Create new programme and add it to the list
                    Programme newProg = new Programme(programmeCode, programmeName);
                    initializer.progList.add(newProg);

                    // Display success message
                    MessageUI.displayRecordSuccessful();
                    progAdded = true;
                } else {
                    courseUI.printCourseNotExisted();
                }
            }

        } while (!progAdded); // Continue looping until a programme is added successfully
    }

    //--------------------------------- remove function -------------------------------   
    //==========edit interface!!*****========
    public void removeCourse() {
        Scanner scanner = new Scanner(System.in);
        listCourseProg();
        String courseCode = courseUI.getCode_course(); // Get the course code
        Course oldCourse = findCourseByCode(courseCode);

        if (oldCourse != null) {
            // Create a new course object and initialize it with the values of the old course
            Course newCourse = new Course(oldCourse.getCourseCode(), oldCourse.getCourseName(), oldCourse.getClassType(),
                    oldCourse.getSemester(), oldCourse.getCreditHour(), oldCourse.getFaculty(),
                    oldCourse.getFees(), oldCourse.getProgrammeCode(), oldCourse.getStatus());

            // Replace the old course with the updated one in the courseList (assuming initializer is defined elsewhere)
            initializer.courseList.remove(oldCourse);

            System.out.println("Course details updated successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

//    public void removeProg() {
//        String courseRemoveProg;
//        String remove_progInput;
//        boolean removeProgCode = false;
//        listProgCourse(); // Assuming this is commented out because it's not provided
//
//        courseUI.removeProgHeader();
//
//        do {
//            courseRemoveProg = courseUI.removeProg_Course();
//
//            if (courseRemoveProg.isEmpty()) {
//                System.out.println("[Error Message]: Code cannot be empty. Please try again.");
//            } else {
//                if (courseRemoveProg.equalsIgnoreCase("X")) {
//                    runCourseSubsystem();
//                    return;
//                }
//
//                Course inputCourseCode = new Course(courseRemoveProg);
//                int courseIndex = initializer.courseList.contains(inputCourseCode);
//
//                if (courseIndex == -1) {
//                    System.out.println("[Error Message]: Course with code containing " + courseRemoveProg + " not found.");
//                } else {
//                    remove_progInput = courseUI.removeProg_Course();
//
//                    if (remove_progInput.isEmpty()) {
//                        System.out.println("[Error Message]: Code cannot be empty. Please try again.");
//                    } else {
//                        if (remove_progInput.equalsIgnoreCase("X")) {
//                            runCourseSubsystem();
//                            return;
//                        }
//
//                        Course inputProgCode = new Course(remove_progInput);
//                        int courseProgIndex = initializer.courseList.contains(inputProgCode);
//
//                        if (courseProgIndex == -1) {
//                            System.out.println("[Error Message]: Course with code containing " + courseRemoveProg + " not found.");
//                        } else {
//                            // Retrieve the course and update its program code
//                            Course courseToUpdate = initializer.courseList.getEntry(courseIndex);
//                            courseToUpdate.setProgrammeCode(""); // Assuming setProgrammeCode("") sets the program code to an empty string
//                            initializer.courseList.remove(programmeCode); // Remove the old course object
//                            initializer.courseList.add(courseToUpdate); // Add the updated course object back to the list
//
//                            System.out.println("Program code removed from course with code: " + courseRemoveProg);
//                            removeProgCode = true; // Set to true to exit the loop
//                        }
//                    }
//                }
//            }
//        } while (!removeProgCode);
//    }
//
//    //remove course
//    public void removeCourse() {
//        String remove_courseInput;
//        boolean courseFound = false;
//
//        do {
//            remove_courseInput = courseUI.removeCourse_Prog();
//
////        // Check if the user wants to cancel
////        if (remove_courseInput.equals("0")) {
////            courseUI.displayExitMessage();
////            return; // Exit the method
////        }
//            Iterator<Course> courseIterator = courseList.getIterator();
//
//            while (courseIterator.hasNext()) {
//                Course course = courseIterator.next();
//                if (course.getCourseCode().equals(remove_courseInput)) {
//                    courseIterator.remove(); // Remove using iterator
//                    MessageUI.displayRecordSuccessful();
//                    courseFound = true;
//                    break; // Exit the loop if found and removed
//                }
//            }
//
//            if (!courseFound) {
//                courseUI.displayListCourseNotFound("Course not found.");
//            }
//
//        } while (!courseFound); // Repeat until a course is found and removed
//    }
    //-----------------------list function-----------------------------
    private void listProgCourse() {
        // Display UI related to programme courses
        courseUI.programme_courseUI();

        boolean foundData = false;

        Iterator<Programme> inputIteratorProg = initializer.progList.iterator();

        while (inputIteratorProg.hasNext()) {
            Programme programme = inputIteratorProg.next();
            // Reset the iterator for programs for each course
            Iterator<Course> inputIterator = initializer.courseList.iterator();
            // Search for course's programme in progList
            while (inputIterator.hasNext()) {
                Course course = inputIterator.next();
                if (course.getProgrammeCode().contains(programme.getProgrammeCode())) {
                    courseUI.printProgrammeCourse(programme.getProgrammeCode(), programme.getProgrammeName(), course.getCourseCode(), course.getCourseName());
                    foundData = true;
                }
            }
        }

        // Check if no data is found
        if (!foundData) {
            courseUI.displayListCourseNotFound("No courses found.");
        }
    }

    private void listFacultyCourse() {
        System.out.println("The list of the courses that taken by different faculties");
        // Display UI related to faculty courses
        courseUI.faculty_courseUI();

        Iterator<Course> inputIterator = initializer.courseList.iterator();

        boolean foundData = false; // Initialize foundData flag to track if any data is found

        while (inputIterator.hasNext()) {
            // if (inputIterator.hasNext()) {
            Course course = inputIterator.next();
            System.out.println("");
            courseUI.printFacultyCourse(course.getFaculty(), course.getCourseCode(), course.getCourseName(), course.getClassType(), course.getSemester(), course.getCreditHour(), course.getFees(), course.getProgrammeCode(), course.getStatus());
           
            
            foundData = true;
            //}
        }
        System.out.println();

        // Check if no data is found
        if (!foundData && initializer.courseList.isEmpty()) {
            courseUI.displayListCourseNotFound("No courses found.");
        }

    }
//----------------- search function -------------
//binary search // Iterator implementation

    private void search() {
        // Display UI related to faculty courses
        courseUI.search_header();

        String search_courseCode;
        boolean courseFound = false;

        do {
            search_courseCode = courseUI.courseCodeSearch();
            if (search_courseCode.isEmpty()) {
                System.out.println("[Error Message]: Code cannot be empty. Please try again.");
            } else {
                if (search_courseCode.equalsIgnoreCase("X")) {
                    runCourseSubsystem();
                    return; // Exit the search method after running the course subsystem
                }

                courseUI.searchOutputUI();
                Iterator<Course> inputIterator = initializer.courseList.iterator();

                while (inputIterator.hasNext()) {
                    Course course = inputIterator.next();
                    if (course.getCourseCode().contains(search_courseCode)) { // Changed .equals to .equalsIgnoreCase for case-insensitive comparison
                        courseUI.searchOutput(course.getCourseCode(), course.getCourseName(), course.getSemester());
                        courseFound = true;
                    }
                }

                if (!courseFound) {
                    System.out.println("[Error Message]: Course with code " + search_courseCode + " not found.");
                }
            }
        } while (!courseFound);
    }

    //#################--------------------Amend--------------------------------
    //!!!! modify the interface!!!!!###
    // Modify the amendCourse() method to use the selected option
    public void amendCourse() {
        Scanner scanner = new Scanner(System.in);
        listCourseProg();
        String courseCode = courseUI.getCode_course(); // Get the course code
        Course oldCourse = findCourseByCode(courseCode);

        if (oldCourse != null) {
            // Create a new course object and initialize it with the values of the old course
            Course newCourse = new Course(oldCourse.getCourseCode(), oldCourse.getCourseName(), oldCourse.getClassType(),
                    oldCourse.getSemester(), oldCourse.getCreditHour(), oldCourse.getFaculty(),
                    oldCourse.getFees(), oldCourse.getProgrammeCode(), oldCourse.getStatus());

            // Call selectToAmend after finding the course
            int selection = courseUI.selectToAmend();

            // Ensure courseUI is defined
            switch (selection) {
                case 1:
                    System.out.printf("Enter New Course Name: ");
                    String newCourseName = scanner.nextLine();
                    newCourse.setCourseName(newCourseName);
                    break;
                case 2:
                    System.out.println("Enter New Class Type: ");
                    String newClassType = scanner.nextLine();
                    newCourse.setClassType(newClassType);
                    break;
                case 3:
                    System.out.println("Enter New Semester: ");
                    String newSemester = scanner.nextLine();
                    newCourse.setSemester(newSemester);
                    break;
                case 4:
                    System.out.println("Enter New Credit Hour: ");
                    int newCreditHour = 0;
                    boolean loop = true;

                    do {
                        System.out.print("Please enter new programme credit hour: ");
                        try {
                            newCreditHour = scanner.nextInt();
                            scanner.nextLine();
                            loop = false;
                        } catch (Exception ex) {
                            System.out.println("[Error Message]: Only accept numeric input. Please try again.");
                            scanner.nextLine();
                        }
                    } while (loop);
                    newCourse.setCreditHour(newCreditHour);
                    break;
                case 5:
                    System.out.println("Enter New Faculty: ");
                    String newFaculty = scanner.nextLine();
                    newCourse.setFaculty(newFaculty);
                    break;
                case 6:
                    System.out.println("Enter New Programme Code: ");
                    String newProgrammeCode = scanner.nextLine();
                    newCourse.setProgrammeCode(newProgrammeCode);
                    break;
                case 7:
                    System.out.println("Enter New Fees: ");
                    double newFees = 0.00;
                    loop = true;

                    do {
                        System.out.print("Please enter new programme fees: ");
                        try {
                            newFees = scanner.nextDouble();
                            scanner.nextLine();
                            loop = false;
                        } catch (Exception ex) {
                            System.out.println("[Error Message]: Only accept numeric input. Please try again.");
                            scanner.nextLine();
                        }
                    } while (loop);
                    newCourse.setFees(newFees);
                    break;
                case 8:
                    System.out.println("Enter New Status: ");
                    String newStatus = scanner.nextLine();
                    newCourse.setStatus(newStatus);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            // Replace the old course with the updated one in the courseList (assuming initializer is defined elsewhere)
            initializer.courseList.replace(oldCourse, newCourse);

            System.out.println("Course details updated successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    public void listCourseProg() {

        listProgCourse();
        String getProgCode_course = courseUI.getProgCode_course();

        Iterator<Course> inputIterator = initializer.courseList.iterator();
        if (getProgCode_course.isEmpty()) {
            System.out.println("[Error Message]: Code cannot be empty. Please try again.");
            return; // Removed return null;
        } else if (getProgCode_course.equalsIgnoreCase("X")) {
            runCourseSubsystem();
            return; // Removed return null;
        }

        boolean foundData = false; // Initialize foundData flag to track if any data is found

        System.out.println("\nThe list of the courses that taken by different faculties");
        courseUI.faculty_courseUI();

        while (inputIterator.hasNext()) {
            Course course = inputIterator.next();
            if (course.getProgrammeCode().contains(getProgCode_course)) {
                // Found the course with the matching code

                // Display UI related to faculty courses
                System.out.println();
                courseUI.printCourse(
                        course.getCourseCode(),
                        course.getCourseName(),
                        course.getClassType(),
                        course.getSemester(),
                        course.getCreditHour(),
                        course.getFees(),
                        course.getProgrammeCode(),
                        course.getFaculty()
                );

                foundData = true;
            }
        }

        // Check if no data is found
        if (!foundData) {
            courseUI.displayListCourseNotFound("\nNo courses found.");
        }
    }

    public Course findCourseByCode(String courseCode) {
        if (courseCode.isEmpty()) {
            System.out.println("[Error Message]: Code cannot be empty. Please try again.");
            return null;
        } else if (courseCode.equalsIgnoreCase("X")) {
            runCourseSubsystem();
            return null; // Exit the search method after running the course subsystem
        }

        Iterator<Course> courseIterator = initializer.courseList.iterator();
        while (courseIterator.hasNext()) {
            Course course = courseIterator.next();
            if (course.getCourseCode().contains(courseCode)) {
                return course; // Found the course with the matching code
            }
        }

        System.out.println("[Error Message]: Course with code " + courseCode + " not found.");
        return null; // Course not found
    }
    
    private void courseReport(){
   
    
    courseUI.courseReportUI();
   
}
    
    

}

//   // Course not found
//}
//    //------------------------Report---------------------------------------
//    //do a report refer ms sent




//    //
//}

