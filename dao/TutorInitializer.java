package dao;

import adt.*;
import static dao.CourseInitializer.courseList;
import static dao.TutorialGrpInitializer.TutorialGrpList;
import entity.Course;
import entity.Tutor;
import entity.TutorialGroup;
import java.util.Iterator;

/**
 *
 * @author Khong Shu Yen
 */
public class TutorInitializer {

    public static SortedArrayList<Tutor> tutorList = new SortedArrayList<>();

    public SortedListInterface<Tutor> initializeTutor() {

        tutorList.add(new Tutor("T0001", "SHOONG WAI KIN", "p2023@tarc.edu.my", 'M', "Full Time", "Assigned", courseList.getEntry(0), TutorialGrpList.getEntry(0)));
        tutorList.add(new Tutor("T0002", "YEOH KAR PENG", "p2020@tarc.edu.my", 'F', "Part Time", "Assigned", courseList.getEntry(1), TutorialGrpList.getEntry(1)));
        tutorList.add(new Tutor("T0003", "Thamarai Subramaniam", "p2021@tarc.edu.my", 'F', "Full Time", "Assigned", courseList.getEntry(2), TutorialGrpList.getEntry(2)));
        tutorList.add(new Tutor("T0004", "LAI JOO CHOI", "p2001@tarc.edu.my", 'M', "Full Time", "Assigned", courseList.getEntry(3), TutorialGrpList.getEntry(3)));
        tutorList.add(new Tutor("T0005", "CHOONG YUN LOONG", "p2010@tarc.edu.my", 'M', "Part Time", "Assigned", courseList.getEntry(4), TutorialGrpList.getEntry(4)));
        return tutorList;
    }

//    public SortedListInterface<Course> initializeCourse() {
//        cList.add(new Course("BACS2003", "DSA", "LECTURE", "Sem1", 3, "FOCS"));
//        cList.add(new Course("BACS2104", "DWH", "TUTORIAL", "Sem2", 3, "FOCS"));
//        cList.add(new Course("BACS2094", "ICS", "LECTURE", "Sem3", 3, "FOCS"));
//        cList.add(new Course("BACS2088", "BPM", "PRACTICAL", "Sem1", 3, "FOCS"));
//        cList.add(new Course("BACS2102", "ECP", "PRACTICAL", "Sem2", 3, "FOCS"));
//        return cList;
//    }
//    public void initializeTutorial() {
//        this.pList = new SortedArrayList<>();
//
//        // Create Tutor objects
//        Tutor tutor1 = new Tutor("T0006", "BCSA2033");
//        Tutor tutor2 = new Tutor("T0007", "BACS3043");
//
//        // Create TutorialGroup objects and add tutors to them
//        TutorialGroup group1 = new TutorialGroup("G1", 0);
//        group1.addTutor(tutor1);
//        group1.addTutor(tutor2);
//
//        this.pList.add(group1);
//
//        this.pList.add(new TutorialGroup("T0006", "G6", "BACS@033"));
//        this.pList.add(new TutorialGroup("T0007", "G7", "BACS@033"));
//    }
//    public void initializeTutorialGrp() {
//        tGroupList.add(new TutorialGroup("G1", 25));
//        tGroupList.add(new TutorialGroup("G2", 20));
//        tGroupList.add(new TutorialGroup("G3", 35));
//        tGroupList.add(new TutorialGroup("G4", 21));
////    }
//    public void displayTutorInfo() {
//        for (int i = 0; i < tGroupList.getNumberOfEntries(); i++) {
//            TutorialGroup tutorialGrp = tGroupList.getEntry(i);
//            System.out.println(" " + tutorialGrp.getTutorialGroupName()
//                    + " " + tGroupList.getEntry(i)
//                    + " " + tGroupList.getEntry(i));
//        }
//    }

//    public void displayCourseInfo() {
//        for (int i = 0; i < cList.getNumberOfEntries(); i++) {
//            Course course = cList.getEntry(i);
//            System.out.println(" " + course.getCourseCode()
//                    + " " + cList.getEntry(i)
//                    + " " + cList.getEntry(i)
//                    + " " + cList.getEntry(i)
//                    + " " + cList.getEntry(i)
//                    + " " + cList.getEntry(i));
//        }
//    }
//
//    public void displayTutorialGrp() {
//        for (int i = 0; i < cList.getNumberOfEntries(); i++) {
//            Course course = cList.getEntry(i);
//            System.out.println(" " + course.getCourseCode()
//                    + " " + cList.getEntry(i)
//                    + " " + cList.getEntry(i)
//                    + " " + cList.getEntry(i)
//                    + " " + cList.getEntry(i)
//                    + " " + cList.getEntry(i));
//        }
//    }
    public SortedListInterface<Tutor> getTutorList() {
        return tutorList;
    }

//    public SortedListInterface<TutorialGroup> getTGList() {
//        return tGroupList;
//    }
//
//    public SortedListInterface<Course> getcList() {
//        return cList;
//    }
//
//    public SortedListInterface<TutorialGroup> getpList() {
//        return pList;
//    }
}


