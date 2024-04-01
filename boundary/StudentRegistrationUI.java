package boundary;

import entity.Student;
import java.util.Scanner;

/**
 *
 * @author LWY
 */
public class StudentRegistrationUI {

    Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
        System.out.println("\nSTUDENT REGISTRARION MANAGEMENT SUBSYSTEM");
        System.out.println(  "=========================================");
        System.out.println("1. List all students");
        System.out.println("2. Add new students");
        System.out.println("3. Remove a student");
        System.out.println("4. Amend student details");
        System.out.println("5. Search students for registered courses");
        System.out.println("6. Add students to a few courses (main,elective,resit,repeat)");
        System.out.println("7. Remove a student from a course (main,elective) registration");
        System.out.println("8. Calculate fee paid for registered courses");
        System.out.println("9. Filters students for courses based on citeria");
        System.out.println("10. Generate summary reports x2");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }

    


//    public void listAllStudents(String outputStr) {
//        System.out.println("\nList of Students:\n" + outputStr);
//    }
//
//    public void printStudentDetails(Student student) {
//        System.out.println("\nStudent Details");
//        System.out.println(  "===============");
//        System.out.println("Student ID:" + student.getStudId());
//        System.out.println("Student Name: " + student.getStudName());
//        System.out.println("IC: " + student.getIc());
//        System.out.println("Gender: " + student.getGender());
//        System.out.println("Contact No: " + student.getContactNo());
//        System.out.println("Email: " + student.getEmail());
//        System.out.println("Address: " + student.getAddress());
//    }

    
    //=== List All Students ===
    public void printStudentDetails() {
        System.out.println("\n=== STUDENT DETAILS ===");
        System.out.println("\nStudent ID    Student Name    IC  Gender  Contact No  Email   Address");
        System.out.println(  "=====================================================================");
       // System.out.println(student.getStudId(),student.getStudName(),student.getIc(), student.getGender(), student.getContactNo(), student.getEmail(), )student.getAddress());
//        return String.format("%-10s %-30s %-15s %10 %-15s %-30s %-50s",
//                studId, studName, ic, gender, contactNo, email, address);
    }
    
    //=== Add Student ===
    public Student inputStudentDetails() {
        System.out.println("\nAdd New Student");
        System.out.println(  "===============");
        String studentID = inputStudentID();
        String studentName = inputStudentName();
        String ic = inputIc();
        String gender = inputGender();
        String contactNo = inputContactNo();
        String email = inputEmail();
        String address = inputAddress();

       // movieList.add("Inception");
        
        
        System.out.println();
        //return new Student();
        return new Student(studentID, studentName, ic, gender, contactNo, email, address);
    }  
    public String inputStudentID() {
        System.out.print("Enter Student ID [eg. 21WMR12345]: ");
        String studID = scanner.nextLine();
        return studID;
    }

    public String inputStudentName() {
        System.out.print("Enter Student Name: ");
        String studName = scanner.nextLine();
        return studName;
    }

    public String inputIc() {
        System.out.print("Enter IC [eg. 123456-12-1234]: ");
        String ic = scanner.nextLine();
        return ic;
    }

    public String inputGender() {
        System.out.print("Enter Gender [eg. Y/N]: ");
        String gender = scanner.nextLine();
        return gender;
    }

    public String inputContactNo() {
        System.out.print("Enter Contact No [eg. 012-3456789]: ");
         String contactNo = scanner.nextLine();
        return contactNo;
    }

    public String inputEmail() {
        System.out.print("Enter Email [eg. lisa@gmail.com]: ");
        String email = scanner.nextLine();
        return email;
    }

    public String inputAddress() {
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        return address;
    }
}
