package control;

import adt.SortedListInterface;
import adt.SortedArrayList;
import entity.Course;
import entity.Programme;
import boundary.CourseUI;
import java.util.Iterator;
import utility.DateTime;
import utility.MessageUI;
import dao.CourseInitializer;
import dao.ProgrammeInitializer;

/**
 *
 * @author pyhor
 */

//add
//delete
//amend
//search


public class CourseManagement {

    private SortedListInterface<Programme> progList = new SortedArrayList<>();
    private SortedListInterface<Course> courseList = new SortedArrayList<>();
    
//    SortedListInterface<Programme> progInit = ProgrammeInitializer.programmeInitializer();
//    SortedListInterface<Course> courseInit = CourseInitializer.courseInitializer();
    
    
    private CourseUI courseUI = new CourseUI();
    
     //for add programme
    
    
      String programme_code;
      String programme_name;

      //for add course
       String stu_programmeCode;
       String course_code;
       String course_name;
       String class_type;
       String course_semester;
       Integer course_creditHour;
       String course_faculty;
      
    public CourseManagement(){

        courseUI = new CourseUI();
    }

    public void runCourseSubsystem(){
        int choice;

        do{
            choice = courseUI.getMenuChoice();

            switch(choice) {

            case 0:
                MessageUI.displayExitMessage();
            break;

            case 1 :
           addNewProgramme();

                break;

            case 3:
                 addNewCourse();

                break;

                 case 7 :
                listProgCourse();
                    //productUI.listAllProducts(getAllProducts());
                break;

                case 8 :
                    listFacultyCourse();
                   break;

                case 6 :
                
                break;

            default :
                 MessageUI.displayInvalidChoiceMessage();
                break;
     }
            // MessageUI.displayInvalidChoiceMessage();
                } while (choice != 0);
  }
    
    //-----------------------------course-----------------------------
   public void addNewCourse() {
      Iterator<Course> courseIterator = courseList.getIterator();
    courseUI.getAddCourseHeader();

    do {
        stu_programmeCode = courseUI.getProgrammeForCourse();

        if (!programmeExistsForCourse(stu_programmeCode)) {
            courseUI.printProgNotExisted();
            break;
        }

        course_code = courseUI.getCourseCode();
        course_name = courseUI.getCourseName();
        class_type=courseUI.getClassType();
        course_semester = courseUI.getSemester();
        course_creditHour=courseUI.getCreditHour();
        course_faculty=courseUI.getFaculty();

        if (courseCodeExists(course_code)) {
            courseUI.displayAddCourseExist(course_code);
            break;
        }

        createCourse(course_code, course_name,class_type,course_semester,course_creditHour,course_faculty);
        MessageUI.displayRecordSuccessful();

    } while (false);
}

         public boolean programmeExistsForCourse(String stu_programmeCode) {
    Iterator<Programme> progIterator = progList.getIterator();

    while (progIterator.hasNext()) {
        Programme programme = progIterator.next();
        if (programme.getProgrammeCode().equals(stu_programmeCode)) {
          
            return true;
        }
    }
    return false;
}

           public boolean courseCodeExists(String course_code) {
    Iterator<Course> courseIterator = courseList.getIterator();

    while (courseIterator.hasNext()) {
        Course course = courseIterator.next();
        if (course.getCourseCode().equals(course_code)) {
            // If a course with the same program already exists, return true
            return true;
        }
    }
    // If no course with the same program is found, return false
    return false;
}

         public Course createCourse(String course_code, String course_name,String class_type,String course_semester, Integer course_creditHour,String course_faculty) {
        Iterator<Course> courseIterator = courseList.getIterator();
        

        while (courseIterator.hasNext()) {
            Course group = courseIterator.next();
            if (group.getCourseCode().equals(course_code)) {
                return group;
            }
        }
        // If not found, create a new course
        Course newCourse = new Course(course_code, course_name,class_type,course_semester,course_creditHour,course_faculty);
        courseList.add(newCourse);
        return newCourse;
      }

    //-----------------------list function-----------------------------
public void listProgCourse() {
    
     Iterator<Programme> progIterator = progList.getIterator();
    Iterator<Course> courseIterator = courseList.getIterator();
    
    SortedListInterface<Programme> progInit = ProgrammeInitializer.programmeInitializer();
    SortedListInterface<Course> courseInit = CourseInitializer.courseInitializer();
   
    boolean foundData = false;

    // Display all courses and programmes
    while (courseIterator.hasNext() && progIterator.hasNext()) {
        Programme programme = progIterator.next();
        Course course = courseIterator.next();
        courseUI.printCoursesProgramme(programme.getProgrammeCode(), programme.getProgrammeName(), course.getCourseCode(), course.getCourseName(),course.getClassType(),course.getSemester(),course.getCreditHour(),course.getFaculty());
        foundData = true;
    }

    // Check if no data is found
    if (!foundData) {
        courseUI.displayListCourseNotFound("No courses found.");
    }

    // Print date and time
    DateTime.currentDateTime();
}

public void listFacultyCourse() {
    
     //Iterator<Programme> progIterator = progList.getIterator();
    Iterator<Course> courseIterator = courseList.getIterator();
    
    //SortedListInterface<Programme> progInit = ProgrammeInitializer.programmeInitializer();
    SortedListInterface<Course> courseInit = CourseInitializer.courseInitializer();
   
    boolean foundData = false;

    // Display all courses and programmes
    while (courseIterator.hasNext()) {
        //Programme programme = progIterator.next();
        Course course = courseIterator.next();
        courseUI.printFacultyCourses(course.getFaculty(), course.getCourseCode(), course.getCourseName(),course.getClassType(),course.getSemester(),course.getCreditHour());
        foundData = true;
    }

    // Check if no data is found
    if (!foundData) {
        courseUI.displayListCourseNotFound("No courses found.");
    }

    // Print date and time
    DateTime.currentDateTime();
}




//-----------------programme-----------------------------
 public void addNewProgramme() {
          //Iterator<Programme> progIterator = progList.getIterator();   
    courseUI.getAddProgHeader();

    // Get the input for the programme
    do {
       programme_code = courseUI.getProgrammeCode();
       programme_name = courseUI.getProgrammeName();

        // Check if the programme already exists
        if (programmeExists(programme_code)) {
            courseUI.displayAddProgrammeExist(programme_code);
        } else {
            // If the programme doesn't exist, create a new programme
            createProg(programme_code,programme_name); 
             MessageUI.displayRecordSuccessful();
             
            break;
            
        }
    } while (true);
}
          
          //verify
        public boolean programmeExists(String programme_code) {
    Iterator<Programme> progIterator = progList.getIterator();

    while (progIterator.hasNext()) {
        Programme programme = progIterator.next();
        if (programme.getProgrammeCode().equals(programme_code)) {
            // If a course with the same program already exists, return true
            return true;
        }
    }
    // If no course with the same program is found, return false
    return false;
}
             public Programme createProg(String programme_code,String programme_name) {
        Iterator<Programme> progIterator = progList.getIterator();
   while (progIterator.hasNext()) {
            Programme group = progIterator.next();
            if (group.getProgrammeCode().equals(programme_code)) {
                return group;
            }
        }
        // If not found, create a new programme
        Programme newProg = new Programme(programme_code,programme_name);
        progList.add(newProg);
        return newProg;
        
        
    }


}
