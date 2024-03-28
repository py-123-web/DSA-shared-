package boundary;

import java.util.Scanner;
//import entity.Course;
//import adt.*;
//import java.util.Iterator;
import utility.*;

public class CourseUI {
    int coursechoice;
    
    //ListInterface<Course> courseList = new SortedArrayList<>();
    Scanner scanner = new Scanner(System.in);
    
    public int getMenuChoice() {
         
          int coursechoice = -1;
        
        System.out.println("\nCourse Management Subsystem\n");
        System.out.println("Main Menu");
        System.out.println("1. Add a new programme to courses");
        System.out.println("2. Add a new course to programmes");
        System.out.println("3. Remove a programme from a course ");
        System.out.println("4. Remove a course from a programme");
        System.out.println("5. Search courses offered in a semester");
        System.out.println("6. Amend course details for a programme");
        System.out.println("7. List courses taken by different faculties");
        System.out.println("8. List all courses for a programme");
        System.out.println("9. Generate summary reports");
        System.out.println("0. Quit");
        
          boolean loop = true;
        
          do {
        System.out.print("\nEnter choice:");
        
        try {
            coursechoice = scanner.nextInt(); // Read user's choice
            scanner.nextLine(); // Consume newline character
            loop = false; // Exit the loop if input is successful
        } catch (Exception ex) {
            System.out.println("[Error Message]: Only accept numeric input. Please try again.");
            scanner.nextLine(); // Clear the invalid input from the scanner
        }
    } while (loop);
    
    return coursechoice;
    }
    
//    public void printCourseDetails(Course programme) {
//    System.out.println("Course Details");
//    System.out.println("Programme Name:" + programme.getProgramme());
//    
//  }
    
//
//   public Course inputCourseDetails(){
//    String courseCode = inputCourseCode();
//    String courseName = inputCourseName();
//    String couseType = inputCourseType();
//    String programme = inputProgramme();
//    String semester = inputSemester();
//    int creditHour = inputCreditHour();
//    String faculty = inputFaculty();
//    
//    return new Course(courseCode,courseName,couseType,programme,semester,creditHour,faculty);
//   }
   
    public void getAddProgHeader() {
        System.out.println("-------------------------------------------------");
        System.out.println("        Add a new programme");
        System.out.println("-------------------------------------------------");
    }
    
      //for input the programme
    public String getProgrammeCode() {
        System.out.print("Enter new prorgamme code : ");
        String programmeCode = scanner.nextLine();
        return programmeCode.toUpperCase();
    }
    
      //for input the programme
    public String getProgrammeName() {
        System.out.print("Enter new full name of prorgamme : ");
        String programmeName = scanner.nextLine();
        return programmeName.toUpperCase();
    }
    
    public void getAddCourseHeader() {
        System.out.println("-------------------------------------------------");
        System.out.println("        Add a new course");
        System.out.println("-------------------------------------------------");
    }
    
  
  //for input the programme name to add the course
    public String getProgrammeForCourse(){
        System.out.print("Enter programme to add course : ");
        String stu_programmeCode = scanner.nextLine();
        return stu_programmeCode.toUpperCase();
    }
    
    //to get new course code
     public String getCourseCode(){
        System.out.print("Enter a new course code : ");
        String course_code = scanner.nextLine();
        return course_code.toUpperCase();
    }
     
     //to get new course name
     public String getCourseName(){
          System.out.print("Enter a new course name : ");
        String course_name = scanner.nextLine();
        return course_name.toUpperCase();
     }
     
      public String getClassType(){
        System.out.print("Please enter class type: ");
        String class_type = scanner.nextLine();
        return class_type.toUpperCase();
    }
     
      public String getSemester(){
        System.out.print("Please enter semester: ");
        String course_semester = scanner.nextLine();
        return course_semester.toUpperCase();
    }
     
      public int getCreditHour() {
        int course_creditHour = 0; // Declare course_creditHour outside the try block
        boolean loop = true;
        
        do {
            System.out.print("Please enter new programme credit hour: ");
            
            try {
                course_creditHour = scanner.nextInt(); // Read user's choice
                scanner.nextLine(); // Consume newline character
                loop = false; // Exit the loop if input is successful
                
            } catch (Exception ex) {
                System.out.println("[Error Message]: Only accept numeric input. Please try again.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        } while (loop);
        
        return course_creditHour; // Added for the case when the loop exits without returning a value
    }

     public String getFaculty(){
        System.out.print("Please enter faculty: ");
        String course_faculty = scanner.nextLine();
        return course_faculty.toUpperCase();
        
    }

     //-----------------display-----------------------------
     
     
    public void printProgramme(String programmeCode,String programmeName){
         System.out.println("List of programme :" + programmeCode + programmeName);
         DateTime.currentDateTime();
    }
    
    public void printCourse(String courseCode,String courseName){
         System.out.println("List of course :" + courseCode + ","+ courseName );
        DateTime.currentDateTime();
    }
    
  //list all courses for a programme
    public void printCoursesProgramme(String programmeCode,String programmeName, String courseCode, String courseName,String classType,String semester,Integer creditHour,String faculty){
        System.out.println("List of programme : " + programmeCode  + ","+ programmeName);
          System.out.println("-------------------------------------------------");
           System.out.println("List of course :" + courseCode + ","+ courseName + ","+ classType+","+ semester+","+ creditHour+","+ faculty);
        System.out.println();
           
    }
    
    public void printFacultyCourses(String faculty, String courseCode, String courseName,String classType,String semester,Integer creditHour){
        System.out.println("List of faculty : " + faculty);
          System.out.println("-------------------------------------------------");
           System.out.println("List of course :" + courseCode + ","+ courseName + ","+ classType+","+ semester+","+ creditHour);
        System.out.println();
           
    }
    
     public static void displayAddProgrammeExist(String programme){
        System.out.println("Programme "+ programme +" already existed");    
    }
    
      public void displayAddCourseExist(String course_code){
        System.out.println("Programme "+ course_code +" already existed");    
    }
    
     public static void printProgNotExisted(){
        System.out.println("\u001B[31mThe programme is not existed.\u001B[0m");
        System.out.println("\u001B[31mPlease enter programme in the programme function.\u001B[0m");
    }
    
//     public static void displayListProgNotFound(String Programme) {
//        System.out.println("Programme " + Programme + " not found.");
//    }
     
      public static void displayListCourseNotFound(String Course) {
        System.out.println( Course);
    }
      
      
     
     
     
    }
    
    
    
    
    
    

     

        
       
        
    

