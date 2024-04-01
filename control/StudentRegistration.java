package control;

import adt.*;
import boundary.StudentRegistrationUI;
import dao.StudentDAO;
import entity.*;
import java.util.Iterator;
import utility.MessageUI;

/**
 *
 * @author LWY
 */
public class StudentRegistration {

    SortedListInterface<Student> studentList = new SortedArrayList<>();
   // StudentDAO studentDAO = new StudentDAO();
    StudentRegistrationUI studentUI = new StudentRegistrationUI();
 
    //private SortedListInterface<Student> studentList = new SortedArrayList<>();
//    private StudentDAO studentDAO = new StudentDAO();
//    private StudentRegistrationUI studentUI = new StudentRegistrationUI();
//
    public void runStudentRegistration() {
        int choice = 0;
        do {
            choice = studentUI.getMenuChoice();
            switch (choice) {
                case 0:
                    MessageUI.displayExitMessage();
                    break;
                case 1:
                    studentUI.printStudentDetails();
                    getAllStudents();
                    // To illustrate how to use the initializeProducts() method
//    StudentDAO s = new StudentDAO();
//    SortedListInterface<Student> studentList = s.initializeStudents();
//    System.out.println("\nStudents:\n" + studentList);
                    //   studentUI.listAllStudents(getAllStudents());            
                    break;
                case 2:
                    addNewStudent();
//                   studentUI.listAllStudents(getAllStudents());
                    
                    break;
                case 3:
//removeStudent();
                    break;
                case 4:
//amendStudentDetails():
                    break;
                case 5:
//searchStudents();
                    break;
                case 6:
//addStudenttoCourses();
                    break;
                case 7:
//removeStudentFromCourse();
                    break;
                case 8:
//calFeePaid();
                    break;
                case 9:
//filterStudent();
                    break;
                case 10:
//generateSummaryReport();
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    //=== List All Students ===
    public void getAllStudents() {
        StudentDAO s = new StudentDAO();
        SortedListInterface<Student> studentList = s.initializeStudents();
        System.out.println(studentList);
    }
    
//    public String getAllStudents() {
//        String outputStr = "";
//        for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
//            outputStr += studentList.getNumberOfEntries() + "\n";
//        }
//        return outputStr;
//     //To illustrate how to use the initializeProducts() method
//
//       }
//    public String getAllStudents() {
//        // Return a formatted string of all students in the list
//        String outputStr = "";
//        for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
//            outputStr += studentList.getEntry(i) + "\n";
//        }
//        return outputStr;
//        
//    }
//
//    public void displayStudents() {
//        studentUI.listAllStudents(getAllStudents());
//    }
//
//        //=== List Student ===
//    public void listAllStudents() {
//        // Print header and separator
//        System.out.println("Student Details");
//        System.out.println("===============");
//        System.out.printf("%-10s %-30s %-15s %10s %-15s %-30s %-50s\n", "Id", "Name", "IC", "Gender", "Contact No", "Email", "Address");
//        
//        // Assuming ctI.getTutorList() returns an up-to-date and initialized list of tutors
//        //Iterator<Student> iterator = ctI.getStudentList().getIterator();
//         Iterator<Student> iterator = ctI.getStudentList().getIterator();
//        if (!iterator.hasNext()) {
//            System.out.println("No students available.");
//            return; // Early exit if there are no tutors to display
//        }
//        while (iterator.hasNext()) {
//            Student student = iterator.next();
//            System.out.printf(" %-10s %-30s %-15s %10s %-15s %-30s %-50s\n",
//                    student.getStudId(),
//                    student.getStudName(),
//                    student.getIc(),
//                    student.getGender(),
//                    student.getContactNo(),
//                    student.getEmail(),
//                    student.getAddress());
//        }
//    }
    public void addNewStudent() {
        Student newStudent = studentUI.inputStudentDetails();
        studentList.add(newStudent);
        //  studentDAO.saveToArray(studentList);
        
//        studentList.add(new Student("21WMR01231", "Glenn", "000912-09-1234", "M", "012-2587101", "alice@tarc.edu.my", "33, Jalan Bunga 2"));
//        return studentList;
    }
    

    // public static void main(String[] args) {
//        SortedListInterface<String> studentList = new SortedArrayList<String>();
//        studentList.add("21WMR01234", "Alice", "000912-09-1234", "F", "012-2587101","alice@tarc.edu.my","33, Jalan Bunga 2");
//        studentList.add("21WMR01234");
//
//        System.out.println("Movie List: \n" + studentList);
//        SortedListInterface<String> studentList = new SortedArrayList<String>();
//        studentList.add("21WMR01234");
//        studentList.add("The Expendables");
    // }
    public static void main(String[] args) {
        StudentRegistration studentRegistration = new StudentRegistration();
        studentRegistration.runStudentRegistration();

    }

}
