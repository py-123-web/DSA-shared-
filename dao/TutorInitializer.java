
package dao;

import adt.*;
import static dao.ProgrammeInitializer.programmeList;
import static dao.TutorialGrpInitializer.TutorialGrpList;
import entity.Course;
import entity.Tutor;
import entity.TutorialGroup;
import java.util.Iterator;

/**
 *
 * @author User
 */
public class TutorInitializer {

    private SortedListInterface<Tutor> tutorList;
    private SortedListInterface<Course> cList = new SortedArrayList<>();
    private SortedListInterface<Course> cList1 = new SortedArrayList<>();
    private SortedListInterface<Course> cList2 = new SortedArrayList<>();
    private SortedListInterface<Course> cList3 = new SortedArrayList<>();
    private SortedListInterface<Course> cList4 = new SortedArrayList<>();
    
    private SortedListInterface<TutorialGroup> tGroupList = new SortedArrayList<>();
    private SortedListInterface<TutorialGroup> tGroupList1 = new SortedArrayList<>();
    private SortedListInterface<TutorialGroup> tGroupList2 = new SortedArrayList<>();
    private SortedListInterface<TutorialGroup> tGroupList3 = new SortedArrayList<>();
    private SortedListInterface<TutorialGroup> tGroupList4 = new SortedArrayList<>();
    private SortedListInterface<TutorialGroup> pList = new SortedArrayList<>();
    private Tutor tutor;
    private Course course;
    private boolean initialized = false;
    

    public TutorInitializer() {
        if (!initialized) {
            this.tutorList = new SortedArrayList<>();
            this.cList = new SortedArrayList<>();
            this.pList = new SortedArrayList<>();
            this.tGroupList = new SortedArrayList<>();
            initializeTutor();
            initialized = true;
        }
    }

    public TutorInitializer(SortedListInterface<Tutor> tutorList,
            SortedListInterface<Course> cList,
            SortedListInterface<TutorialGroup> tGroupList) {
        this.tutorList = tutorList;
        this.cList = cList;
        this.tGroupList = tGroupList;

    }

    public SortedListInterface<Tutor> initializeTutor() {
        
        cList.add(new Course("BACS2063", "DATA STRUCTURE AND ALGORITHM", "LECTURE", "YEAR 3 SEM 3", 3, "FOCS", 777.00, "REI", "Main"));
        cList1.add(new Course("BAIT1093", "STATISTIC", "TUTORIAL", "YEAR 3 SEM 3", 3, "FOCS", 777.00, "REI", "Main"));
        cList2.add(new Course("BAIT1083", "VISUAL PROGRAMMING", "PRACTICAL", "YEAR 3 SEM 2", 3, "FOCS", 777.00, "REI", "Repeat"));
        cList3.add(new Course("BACS2003", "ARTIFICIAL INTELLIGENCE", "LECTURE", "YEAR 3 SEM 3", 3, "FOCS", 777.00, "RSW", "Main"));
        cList4.add(new Course("BACS2033", "DATA WAREHOUSE", "PRACTICAL", "YEAR 3 SEM 3", 3, "FOCS", 777.00, "RSD", "Main"));
        
        tGroupList.add(new TutorialGroup("RSWG1", 1, 13, programmeList.getEntry(0)));
        tGroupList1.add(new TutorialGroup("RE1G1", 2, 17, programmeList.getEntry(0)));
        tGroupList2.add(new TutorialGroup("RSDG1", 3, 18, programmeList.getEntry(0)));
        tGroupList3.add(new TutorialGroup("RSDG2", 4, 12, programmeList.getEntry(0)));
        tGroupList4.add(new TutorialGroup("REIG2", 5, 19, programmeList.getEntry(0)));
        
        tutorList.add(new Tutor("T0001", "SHOONG WAI KIN", "p2023@tarc.edu.my", 'M', "Full Time", "Assigned", cList, tGroupList));
        tutorList.add(new Tutor("T0002", "YEOH KAR PENG", "p2020@tarc.edu.my", 'F', "Part Time", "Assigned", cList1, tGroupList1));
        tutorList.add(new Tutor("T0003", "Thamarai Subramaniam", "p2021@tarc.edu.my", 'F', "Full Time", "Assigned", cList2,tGroupList2 ));
        tutorList.add(new Tutor("T0004", "LAI JOO CHOI", "p2001@tarc.edu.my", 'F', "Full Time", "Assigned", cList3, tGroupList3));
        tutorList.add(new Tutor("T0005", "CHOONG YUN LOONG", "p2010@tarc.edu.my", 'F', "Part Time", "Assigned", cList4, tGroupList4));
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
//    }
    public void displayTutorInfo() {
        for (int i = 0; i < tGroupList.getNumberOfEntries(); i++) {
            TutorialGroup tutorialGrp = tGroupList.getEntry(i);
            System.out.println(" " + tutorialGrp.getTutorialGroupName()
                    + " " + tGroupList.getEntry(i)
                    + " " + tGroupList.getEntry(i));
        }
    }

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

