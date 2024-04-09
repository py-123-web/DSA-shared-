package dao;

import adt.*;
import entity.Course;
import entity.Tutor;
import entity.TutorialGroup;
import java.util.Iterator;

/**
 *
 * @author User
 */
public class CourseTutorInitializer {

    private SortedArrayListInterface<Tutor> tutorList;
   
    private SortedArrayListInterface<Course> cList = new SortedArrayList<>();
    private SortedArrayListInterface<TutorialGroup> tGList = new SortedArrayList<>();
    private Tutor tutor;
    private Course course;

    public CourseTutorInitializer() {
        this.tutorList = new SortedArrayList<>();
        initializeTutor();
    }
    
    public SortedArrayListInterface<Tutor> initializeTutor() {
        
        tutorList.add(new Tutor("T0001", "Mr SHOONG WAI KIN", "p2023@tarc.edu.my", 'M', "Full Time"));
        tutorList.add(new Tutor("T0002", "Ms YEOH KAR PENG", "p2020@tarc.edu.my", 'F', "Part Time"));
        tutorList.add(new Tutor("T0003", "Ms Thamarai Subramaniam", "p2021@tarc.edu.my", 'F', "Full Time"));
        tutorList.add(new Tutor("T0004", "MR LAI JOO CHOI", "p2001@tarc.edu.my", 'F', "Full Time"));
        tutorList.add(new Tutor("T0005", "MR CHOONG YUN LOONG", "p2010@tarc.edu.my", 'F', "Part Time"));
        return tutorList;
    }

    public void initializeCourse() {
        cList.add(new Course("Problem Solving and Programming", "Practical", "REI", "Sem1", 3, "FOCS"));
        cList.add(new Course("Data Structure And Algorithm", "Lecture", "RIT", "Sem2", 3, "FOCS"));
        cList.add(new Course("Blockchain Application Development", "Tutorial", "RDS", "Sem3", 3, "FOCS"));
        cList.add(new Course("Mobile Application Development", "Tutorial", "RSD", "Sem1", 3, "FOCS"));
        cList.add(new Course("Vulnerability Assessment and Penetration Testing", "Practical", "RIS", "Sem2", 3, "FOCS"));
    }

    public void initializeTutorialGrp() {
        tGList.add(new TutorialGroup("BACS1014", "Problem Solving and Programming", "Group 1", 24, "Ali", "S0001", "ali-wm@tarc.edu.my"));
        tGList.add(new TutorialGroup("BACS2063", "Data Structure And Algorithm", "Group 2", 22, "Abu", "S0002", "abu-wm@tarc.edu.my"));
        tGList.add(new TutorialGroup("BMIS2003", "Blockchain Application Development", "Group 3", 23, "Yen", "S0003", "yen-wm@tarc.edu.my"));
        tGList.add(new TutorialGroup("BAIT2073", "Mobile Application Development", "Group 4", 22, "Hajimi", "S0004", "hajimi-wm@tarc.edu.my"));
        tGList.add(new TutorialGroup("BMIS3123", "Vulnerability Assessment and Penetration Testing", "Group 5", 26, "Ah Kau", "S0005", "ahkau-wm@tarc.edu.my"));
    }

    public void displayTutorInfo() {
        for (int i = 0; i < tutorList.getNumberOfEntries(); i++) {
            Tutor tutor = tutorList.getEntry(i);
            System.out.println(" " + tutor.getTutorId()
                    + " " + tutorList.getEntry(i)
                    + " " + tutorList.getEntry(i)
                    + " " + tutorList.getEntry(i)
                    + " " + tutorList.getEntry(i));
        }
    }
   
      public SortedArrayListInterface<Tutor> getTutorList() {
        return tutorList;
    }
     

}
