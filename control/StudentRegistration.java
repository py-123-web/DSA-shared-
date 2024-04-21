package control;

import adt.*;
import boundary.StudentRegistrationUI;
import dao.StudentInitializer;
import entity.*;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;
import utility.MessageUI;

/**
 *
 * @author Lee Weng Yan
 */
public class StudentRegistration {

    private SortedListInterface<Student> studentList = new SortedArrayList<>();
    private SortedListInterface<RegisterCourse> registerCourseList = new SortedArrayList<>();
    private SortedListInterface<Course> courseList = new SortedArrayList<>();

    StudentRegistrationUI studentUI = new StudentRegistrationUI();       //go to UI page
    StudentInitializer getStudentInitializer = new StudentInitializer(); //go to initializer page
    CourseInitializer initializer = new CourseInitializer();             //add PY part

    public void runStudentRegistration() {
        int choice = 0;
        getStudentInitializer.initializeStudent();          //student list
        //getStudentInitializer.CourseInfo();                 //course list
        getStudentInitializer.initializeRegisteredCourse(); //registered course list
        initializer.CourseInfo();	                        //add PY part

        do {
            choice = studentUI.getMenuChoice();
            switch (choice) {
                case 0:
                    MessageUI.displayExitMessage();
                    break;
                case 1:
                    displayStudent();
                    break;
                case 2:
                    addNewStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    amendStudentDetails();
                    break;
                case 5:
                    searchStudentsRegisterCourse();
                    break;
                case 6:
                    addStudentToCourses();
                    break;
                case 7:
                    removeStudentFromCourse();
                    break;
                case 8:
                    filterStudentForCourse();
                    break;
                case 9:
                    generateSummaryReport1();
                case 10:
                    generateSummaryReport2();
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    //-----------------------(1)list student-----------------------------   
    private void displayStudent() {
        studentUI.printStudentDetailsHeader();
        Iterator<Student> studentIterator = getStudentInitializer.studentList.iterator();
        boolean foundData = false;
        int count = 0; // Initialize total student count

        if (!getStudentInitializer.studentList.isEmpty()) {
            count = getStudentInitializer.studentList.getNumberOfEntries(); // Get the total number of students
            while (studentIterator.hasNext()) {
                Student student = studentIterator.next();
                studentUI.printStudentDetails(student.getStudId(), student.getStudName(), student.getIc(), student.getGender(), student.getContactNo(), student.getEmail(), student.getAddress());
                foundData = true;
            }
        }

        if (!foundData && getStudentInitializer.studentList.isEmpty()) {
            System.out.println("No student found.");
        }

        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Total Student: " + count);
    }

    //---------------------(2)add Student---------------------
    public void addNewStudent() {
        studentUI.printAddStudentHeader();
        String studId = "";
        boolean studIdExists = false;

        do {
            studId = getValidatedStudId("Enter Student ID [eg. 21WMR12345]: ");
            Student existingStudent = findStudentByID(studId);
            if (existingStudent != null) {
                System.out.println("\nStudent ID " + studId + " already exists. Please enter another Student ID.\n");
                studIdExists = true;
            } else {
                studIdExists = false;
            }
        } while (studIdExists);

        String studName = getValidatedEmpty("Enter Student Name: ");
        String ic = getValidatedIc("Enter IC [eg. 123456-12-1234]: ");
        String gender = getValidatedGender("Enter Gender [eg. male/female]: ");
        String contactNo = getValidatedContactNo("Enter Contact No [eg. 012-3456789]: ");
        String email = getValidatedEmail("Enter Email [eg. lisa@tarc.edu.my]: ");
        String address = getValidatedEmpty("Enter Address: [eg. 2 Jalan Bunga]: ");

        Student newStudent = new Student(studId, studName, ic, gender, contactNo, email, address);
        getStudentInitializer.studentList.add(newStudent); // ADT - add the new student
        MessageUI.displayStudAdded();
        System.out.println(newStudent); // print the added student
    }

    //-------------------(3)remove Student-------------------------
    public void removeStudent() {
        studentUI.printRemoveStudentHeader();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        String studentToRemove = scanner.nextLine().trim().toUpperCase();

        Student student = findStudentByID(studentToRemove);
        if (student != null) {
            getStudentInitializer.studentList.remove(student); // ADT - Remove the found student
            System.out.println("\nStudent with ID " + studentToRemove + " removed.");
        } else {
            System.out.println("\nStudent with ID " + studentToRemove + " not found.");
        }
    }

    //------------(4)amend Student Details-----------------
    public void amendStudentDetails() {
        studentUI.printAmendStudentHeader();
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter the student ID to amend details: ");
        String studentID = scanner.nextLine().trim().toUpperCase();

        Student oldStudent = findStudentByID(studentID);

        if (oldStudent != null) {
            Student newStudent = new Student(); // Create a new Student object to store updated data
            newStudent.setStudId(oldStudent.getStudId()); // Set student ID to match the old student, if change one item, others remain original data
            newStudent.setStudName(oldStudent.getStudName());
            newStudent.setIc(oldStudent.getIc());
            newStudent.setGender(oldStudent.getGender());
            newStudent.setContactNo(oldStudent.getContactNo());
            newStudent.setEmail(oldStudent.getEmail());
            newStudent.setAddress(oldStudent.getAddress());

            System.out.println("\nCurrent details:");
            studentUI.printStudentDetailsHeader();
            System.out.println(oldStudent); // Assuming you have overridden toString() in Student class
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");

            System.out.println("\n1. Student Name");
            System.out.println("2. IC");
            System.out.println("3. Gender");
            System.out.println("4. Contact No");
            System.out.println("5. Email");
            System.out.println("6. Address");
            System.out.println("0. Exit");

            int choice;
            do {
                System.out.printf("\nSelect the detail to amend: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        String newStudName = getValidatedEmpty("Enter New Student Name: ");
                        newStudent.setStudName(newStudName);
                        break;
                    case 2:
                        String newIc = getValidatedIc("Enter New IC [eg. 123456-12-1234]: ");
                        newStudent.setIc(newIc);
                        break;
                    case 3:
                        String newGender = getValidatedGender("Enter New Gender [eg. male/female]: ");
                        newStudent.setGender(newGender);
                        break;
                    case 4:
                        String newContact = getValidatedContactNo("Enter New Contact No [eg. 012-3456789]: ");
                        newStudent.setContactNo(newContact);
                        break;
                    case 5:
                        String newEmail = getValidatedEmail("Enter New Email [eg. lisa@tarc.edu.my]: ");
                        newStudent.setEmail(newEmail);
                        break;
                    case 6:
                        String newAddress = getValidatedEmpty("Enter New address: ");
                        newStudent.setAddress(newAddress);
                        break;
                    case 0:
                        //System.out.println("Exiting...");
                        return; // Exit the method
                    default:
                        MessageUI.displayInvalidChoiceMessage();
                }
            } while (choice < 0 || choice > 6);
            // Replace the old student with the updated one in the studentList        
            getStudentInitializer.studentList.replace(oldStudent, newStudent); //ADT
            System.out.println("\nStudent details updated successfully.");
        } else {
            System.out.println("\nStudent not found.");
        }
    }

    //------------(5)search Student for Register Courses-----------------
    public void searchStudentsRegisterCourse() {
        studentUI.printSearchStudentHeader();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine().trim().toUpperCase();

        Student searchedStudent = findStudentByID(studentID);

        if (searchedStudent == null) {
            System.out.println("\nStudent with ID " + studentID + " not found.");
            return;
        }

        boolean foundCourses = false;
        System.out.println("\n=== REGISTERED COURSES ===");
        System.out.printf("\nStudent ID: %s\nStudent Name: %s\n\n", searchedStudent.getStudId(), searchedStudent.getStudName());
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s | %-50s | %-15s | %-15s%n", "Course Code", "Course Name", "Course Fees (RM)", "Status");
        System.out.println("------------------------------------------------------------------------------------------------");

        Iterator<RegisterCourse> registerCourseIterator = searchedStudent.getRegisterCourseList().iterator();

        while (registerCourseIterator.hasNext()) {
            RegisterCourse registerCourse = registerCourseIterator.next();
            Course courseR = registerCourse.getCourseList().getEntry(0); // Assuming only one course per RegisterCourse
            System.out.printf("%-15s | %-50s | %-15.2f | %s%n",
                    courseR.getCourseCode(),
                    courseR.getCourseName(),
                    registerCourse.getFeesPaid(),
                    courseR.getStatus()
            );
            foundCourses = true;
        }

        System.out.println("------------------------------------------------------------------------------------------------");

        if (!foundCourses) {
            System.out.println("No registered courses found for the student.");
        }
    }

    //------------(6)add Student To Courses-----------------
    public void addStudentToCourses() {
        Scanner scanner = new Scanner(System.in);

        // -----student part-----
        studentUI.printAddStudentToCoursesHeader();
        displayStudent();

        System.out.print("\nEnter Student ID: ");
        String studId = scanner.nextLine().trim().toUpperCase();

        Student studentToAdd = findStudentByID(studId);

        if (studentToAdd == null) {
            System.out.println("Student with ID " + studId + " not found.");
            return;
        }

        // Clear the previous bill
        registerCourseList.clear();

        // -----course part-----
        double totalFees = 0.00;
        char addMoreCourses = 0; // assign empty value for addMoreCourses == 'Y'

        // Print course details
        studentUI.printCourseDeatilsHeader();
        //Iterator<Course> courseIterator = getStudentInitializer.courseList.iterator();
        Iterator<Course> courseIterator = initializer.courseList.iterator();	//add PY part

        while (courseIterator.hasNext()) {
            System.out.println(courseIterator.next());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

        do {
            System.out.printf("\nEnter Course Code: ");
            String courseCode = scanner.nextLine().trim().toUpperCase();

            Course selectedCourse = findCourseByCode(courseCode);

            if (selectedCourse == null) {
                System.out.println("Course with code " + courseCode + " not found.");
                continue;
            }

            double courseFees = selectedCourse.getFees();
            totalFees += courseFees;

            // Create a new RegisterCourse object for each course added by the student
            RegisterCourse registerCourse = new RegisterCourse(courseFees);
            registerCourse.getCourseList().add(selectedCourse); // Add the selected course to the registerCourse
            registerCourseList.add(registerCourse); // Add the registerCourse to the registerCourseList for the student

            // Add the registerCourse to the student's registerCourseList
            studentToAdd.getRegisterCourseList().add(registerCourse);

            System.out.print("\nAdd another course? (Y/N): ");
            addMoreCourses = scanner.nextLine().toUpperCase().charAt(0);
        } while (addMoreCourses == 'Y');

        // Generate Bill
        System.out.println("\n=== STUDENT BILL ===");
        System.out.println("\nStudent ID: " + studId);
        System.out.println("Student Name: " + studentToAdd.getStudName());

        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s | %-50s | %-15s | %-15s%n", "Course Code", "Course Name", "Course Fees (RM)", "Status");
        System.out.println("------------------------------------------------------------------------------------------------");

        for (RegisterCourse registerCourse : registerCourseList) {
            Course courseReg = registerCourse.getCourseList().getEntry(0); // ADT - Assuming only one course per RegisterCourse
            double fees = registerCourse.getFeesPaid();
            System.out.printf("%-15s | %-50s | %-15.2f | %s%n",
                    courseReg.getCourseCode(),
                    courseReg.getCourseName(),
                    fees,
                    courseReg.getStatus()
            );
        }

        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("Total Amount: RM %.2f%n", totalFees);
    }

    //------------(7)remove Student from Courses-----------------
    public void removeStudentFromCourse() {
        studentUI.printRemoveStudentFromCourseHeader();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        String studId = scanner.nextLine().trim().toUpperCase();

        Student studentToRemove = findStudentByID(studId);

        if (studentToRemove == null) {
            System.out.println("Student with ID " + studId + " not found.");
            return;
        }

        //print the registered courses
        boolean foundCourses = false;
        System.out.println("\n=== REGISTERED COURSES ===");
        System.out.printf("\nStudent ID: %s\nStudent Name: %s\n\n", studentToRemove.getStudId(), studentToRemove.getStudName());
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s | %-50s | %-15s | %-15s%n", "Course Code", "Course Name", "Course Fees (RM)", "Status");
        System.out.println("------------------------------------------------------------------------------------------------");

        Iterator<RegisterCourse> registerCourseIterator = studentToRemove.getRegisterCourseList().iterator();

        while (registerCourseIterator.hasNext()) {
            RegisterCourse registerCourse = registerCourseIterator.next();
            Course courseR = registerCourse.getCourseList().getEntry(0); // Assuming only one course per RegisterCourse
            System.out.printf("%-15s | %-50s | %-15.2f | %s%n",
                    courseR.getCourseCode(),
                    courseR.getCourseName(),
                    registerCourse.getFeesPaid(),
                    courseR.getStatus()
            );
            foundCourses = true;
        }
        System.out.println("------------------------------------------------------------------------------------------------");

        if (!foundCourses) {
            System.out.println("No registered courses found for the student.");
            return; // Jump out of the method if no registered courses are found
        }

        System.out.print("\nEnter Course Code to remove from the student: ");
        String courseCodeToRemove = scanner.nextLine().trim().toUpperCase();

        Course courseToRemove = findCourseByCode(courseCodeToRemove);

        if (courseToRemove == null) {
            System.out.println("\nCourse with code " + courseCodeToRemove + " not found.");
            return;
        }

        // Remove the course from the student's registerCourseList
        for (RegisterCourse registerCourse : studentToRemove.getRegisterCourseList()) {
            Course courseInRegisterCourse = registerCourse.getCourseList().getEntry(0); // Assuming one course per RegisterCourse
            if (courseInRegisterCourse.getCourseCode().contains(courseToRemove.getCourseCode())) {
                studentToRemove.getRegisterCourseList().remove(registerCourse);
                System.out.println("\nCourse " + courseToRemove.getCourseCode() + " removed from student " + studentToRemove.getStudId());
                return;
            }
        }

        System.out.println("\nStudent " + studentToRemove.getStudId() + " is not enrolled in course " + courseToRemove.getCourseCode());
    }

    //--------------(8)filter student for courses based on citeria--------------------------
    public void filterStudentForCourse() {
        studentUI.printFiltersStudentsForCourseCiteriaHeader();
        Scanner scanner = new Scanner(System.in);

        // Print course details
        studentUI.printCourseDeatilsHeader();
        //Iterator<Course> courseIterator = getStudentInitializer.courseList.iterator();
        Iterator<Course> courseIterator = initializer.courseList.iterator();	//add PY part

        while (courseIterator.hasNext()) {
            System.out.println(courseIterator.next());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

        System.out.print("\nEnter the Course Code to filter students: ");
        String courseCode = scanner.nextLine().trim().toUpperCase();

        // Find the course using the findCourseByCode method
        Course selectedCourse = findCourseByCode(courseCode);

        if (selectedCourse == null) {
            System.out.println("Course with code " + courseCode + " not found.");
            return;
        }

        // Print filtered students for the selected course
        boolean foundStudents = false;
        System.out.println("\nStudents enrolled in " + selectedCourse.getCourseCode() + " - " + selectedCourse.getCourseName());
        studentUI.printFilterStudentHeader();

        for (Student student : getStudentInitializer.studentList) {
            for (RegisterCourse registerCourse : student.getRegisterCourseList()) {
                for (Course courseInRegisterCourse : registerCourse.getCourseList()) {
                    if (courseInRegisterCourse.getCourseCode().contains(courseCode)) {

                        //System.out.println(student.getStudId() + " - " + student.getStudName());
                        System.out.printf("%-15s %s%n",
                                student.getStudId(),
                                student.getStudName()
                        );

                        foundStudents = true;
                        break; // Move to the next student
                    }
                }
            }
        }
        System.out.println("------------------------------------------");//print footer

        if (!foundStudents) {
            System.out.println("No students found for the selected course.");
        }
    }

    //--------------(9A)generate Summary Report--------------------------
    public void generateSummaryReport1() {
        studentUI.printReportHeader1();
        displayStudent();

        int maleCount = 0;
        int femaleCount = 0;
        int elderMaleAge = Integer.MIN_VALUE;
        int youngerMaleAge = Integer.MAX_VALUE;
        int elderFemaleAge = Integer.MIN_VALUE;
        int youngerFemaleAge = Integer.MAX_VALUE;

        // Initialize total students with specific age counters
        int totalElderMaleAge = 0;
        int totalYoungerMaleAge = 0;
        int totalElderFemaleAge = 0;
        int totalYoungerFemaleAge = 0;

        for (Student student : getStudentInitializer.studentList) {
            String gender = student.getGender();
            int age = calculateAgeFromIC(student.getIc());

            // Find age extremes for males and females
            if (gender.equalsIgnoreCase("MALE")) {
                maleCount++;
                if (age > elderMaleAge) {
                    elderMaleAge = age;
                    totalElderMaleAge = 1; // Reset count for older males
                } else if (age == elderMaleAge) {
                    totalElderMaleAge++; // Increment count for older males with the same age
                }
                if (age < youngerMaleAge) {
                    youngerMaleAge = age;
                    totalYoungerMaleAge = 1; // Reset count for younger males
                } else if (age == youngerMaleAge) {
                    totalYoungerMaleAge++; // Increment count for younger males with the same age
                }
            } else if (gender.equalsIgnoreCase("FEMALE")) {
                femaleCount++;
                if (age > elderFemaleAge) {
                    elderFemaleAge = age;
                    totalElderFemaleAge = 1; // Reset count for older females
                } else if (age == elderFemaleAge) {
                    totalElderFemaleAge++; // Increment count for older females with the same age
                }
                if (age < youngerFemaleAge) {
                    youngerFemaleAge = age;
                    totalYoungerFemaleAge = 1; // Reset count for younger females
                } else if (age == youngerFemaleAge) {
                    totalYoungerFemaleAge++; // Increment count for younger females with the same age
                }
            }
        }

        System.out.println("\nTotal Male Students: " + maleCount);
        System.out.println("Total Female Students: " + femaleCount);
        System.out.println("\n***********************************\n");
        System.out.println("Elder Male Age: " + elderMaleAge);
        System.out.println("Number of Elder Male Students: " + totalElderMaleAge);
        System.out.println("\nYounger Male Age: " + youngerMaleAge);
        System.out.println("Number of Younger Male Students: " + totalYoungerMaleAge);
        System.out.println("\n***********************************\n");
        System.out.println("Elder Female Age: " + elderFemaleAge);
        System.out.println("Number of Elder Female Students: " + totalElderFemaleAge);
        System.out.println("\nYounger Female Age: " + youngerFemaleAge);
        System.out.println("Number of Younger Female Students: " + totalYoungerFemaleAge);

        studentUI.printReportFooter();
        pressEnterToContinue();
    }

    private int calculateAgeFromIC(String icNumber) {
        // Assuming IC number format is YYMMDD
        String yearString = icNumber.substring(0, 2); // Extracting the first two digits as year
        int year = Integer.parseInt(yearString);

        // Adjust the year based on the first digit of IC
        if (year >= 0 && year <= 24) {  //2000 to 2024
            year += 2000;               // Birth year in the 2000s
        } else {                       //1925 to 1999
            year += 1900;               // Birth year in the 1900s
        }

        int currentYear = LocalDate.now().getYear();
        int age = currentYear - year;

        return age;
    }

    //--------------(9A)generate Summary Report--------------------------
    public void generateSummaryReport2() {
        studentUI.printReportHeader2();

        //code here
        studentUI.printReportFooter();
        pressEnterToContinue();
    }

    //------------------------find Student-----------------
    public Student findStudentByID(String studentID) { //search student
        Iterator<Student> studentIterator = getStudentInitializer.studentList.iterator();

        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            if (student.getStudId().contains(studentID)) {
                return student; // Found the student with the matching ID
            }
        }
        return null; // Student not found
    }

    //-----------------------find course----------------------------- 
    public Course findCourseByCode(String courseCode) { //search course
        //Iterator<Course> courseIterator = getStudentInitializer.courseList.iterator();
        Iterator<Course> courseIterator = initializer.courseList.iterator();	//add PY part

        while (courseIterator.hasNext()) {
            Course course = courseIterator.next();
            if (course.getCourseCode().contains(courseCode)) {
                return course; // Found the course with the matching code
            }
        }
        return null; // course not found
    }

    //--------------------VALIDATION----------------------
    //=== validation for empty field ===
    public static String getValidatedEmpty(String prompt) {
        Scanner scan = new Scanner(System.in);
        String input;

        do {
            System.out.print(prompt);
            input = scan.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("\nField cannot be empty. Please enter again.\n");
            }
        } while (input.trim().isEmpty());
        return input;
    }

//    //=== validation for StudId ===
//    public static String getValidatedStudId(String prompt) {
//        Scanner scan = new Scanner(System.in);
//        String input;
//
//        do {
//            System.out.print(prompt);
//            input = scan.nextLine();
//
//            if (!input.trim().isEmpty()) {
//                if (input.trim().length() != 10) {
//                    System.out.println("\nIt should be 10 characters. Please enter again.\n");
//                }
//            } else {
//                System.out.println("\nField cannot be empty. Please enter again.\n");
//            }
//
//        } while (input.trim().isEmpty() || (input.trim().length() != 10));
//        return input;
//    }
    public static String getValidatedStudId(String prompt) { //have problem in last few also can run
        Scanner scan = new Scanner(System.in);
        String input;

        do {
            System.out.print(prompt);
            input = scan.nextLine().toUpperCase(); // Convert input to uppercase

            if (!input.trim().isEmpty()) {
                if (input.trim().length() != 10) {
                    System.out.println("\nIt should be 10 characters. Please enter again.\n");
                    continue; // Restart the loop if length is not 10
                }
                // Check if characters 1, 2 are digits
                char firstChar = input.charAt(0);
                char secondChar = input.charAt(1);
                if (!Character.isDigit(firstChar) || !Character.isDigit(secondChar)) {
                    System.out.println("\nCharacters 1 and 2 must be digits. Please enter again.\n");
                    continue; // Restart the loop if format is incorrect
                }
                // Check if characters 3, 4, 5 are alphabetic and convert to uppercase
                char thirdChar = input.charAt(2);
                char fourthChar = input.charAt(3);
                char fifthChar = input.charAt(4);
                if (!Character.isLetter(thirdChar) || !Character.isLetter(fourthChar) || !Character.isLetter(fifthChar)) {
                    System.out.println("\nCharacters 3, 4, 5 must be alphabetic. Please enter again.\n");
                    continue; // Restart the loop if format is incorrect
                }
                // Check if characters 6, 7, 8, 9, 10 are digits
                String digits = input.substring(5);
                if (!digits.matches("\\d{5}")) {
                    System.out.println("\nCharacters 6 to 10 must be digits. Please enter again.\n");
                    continue; // Restart the loop if format is incorrect
                }
            } else {
                System.out.println("\nField cannot be empty. Please enter again.\n");
            }
        } while (input.trim().isEmpty() || (input.trim().length() != 10));

        return input;
    }

    //=== validation for ContactNo ===
    public static String getValidatedContactNo(String prompt) {
        Scanner scan = new Scanner(System.in);
        String input;

        do {
            System.out.print(prompt);
            input = scan.nextLine();

            if (!input.trim().isEmpty()) {
                if (input.trim().length() != 11) {
                    System.out.println("\nIt should be 11 characters. Please enter again.\n");
                }
            } else {
                System.out.println("\nField cannot be empty. Please enter again.\n");
            }

        } while (input.trim().isEmpty() || (input.trim().length() != 11));
        return input;
    }

    //=== validation for gender ===
    public static String getValidatedGender(String prompt) {
        Scanner scan = new Scanner(System.in);
        String input;
        do {
            System.out.print(prompt);
            input = scan.nextLine().toUpperCase(); // Convert to uppercase

            // Check if the studGender is valid
            if (input.contains("MALE") || input.contains("FEMALE")) {
                break; // Valid input, break the loop
            } else {
                MessageUI.displayAddStudInvalidGender();
            }
        } while (true);
        return input;
    }

    //=== validation for IC ===
    public static String getValidatedIc(String prompt) { //have problem when put '-' in last few also can run
        Scanner scan = new Scanner(System.in);
        String input;

        boolean isValid = false; // Flag to track if input is valid

        do {
            System.out.print(prompt);
            input = scan.nextLine();

            if (!input.trim().isEmpty()) {
                if (input.trim().length() != 14) {
                    System.out.println("\nIt should be 14 characters. Please enter again.\n");
                    continue; // Restart the loop if length is not 14
                }

                // Check if characters 1,2,3,4,5,6,8,9,11,12,13,14 are digits
                String digits = input.replaceAll("-", "").replaceAll("\\d", "");
                if (!digits.isEmpty()) {
                    System.out.println("\nCharacters 1,2,3,4,5,6,8,9,11,12,13,14 must be digits. Please enter again.\n");
                    continue; // Restart the loop if format is incorrect
                }

                // Check if characters 7 and 10 are dashes '-'
                if (input.charAt(6) != '-' || input.charAt(9) != '-') {
                    System.out.println("\nCharacters 7 and 10 must be dashes '-'. Please enter again.\n");
                    continue; // Restart the loop if format is incorrect
                }
                isValid = true; // Set isValid to true if input passes all checks
            } else {
                System.out.println("\nField cannot be empty. Please enter again.\n");
            }

        } while (!isValid);

        return input;
    }

    //=== validation for Email ===
    public static String getValidatedEmail(String prompt) {
        Scanner scan = new Scanner(System.in);
        String input;

        do {
            System.out.print(prompt);
            input = scan.nextLine();

            if (!input.trim().isEmpty()) {
                boolean containsAtSymbol = false;
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) == '@') {
                        containsAtSymbol = true;
                        break; // No need to continue checking if '@' is found
                    }
                }
                if (!containsAtSymbol) {
                    System.out.println("\nPlease include '@' in the email. Please enter again.");
                }
            } else {
                System.out.println("\nField cannot be empty. Please enter again.\n");
            }
        } while (input.trim().isEmpty() || !input.contains("@"));
        return input;
    }

    //--------------------press Enter To Continue----------------------
    public static void pressEnterToContinue() {
        System.out.println("\nPress Enter to continue...");
        try {
            System.in.read(); // Wait for the user to press Enter
        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions that might occur
        }
    }

    //---------------------start program----------------------
    public static void main(String[] args) {
        StudentRegistration studentRegistration = new StudentRegistration();
        studentRegistration.runStudentRegistration();
    }
}
