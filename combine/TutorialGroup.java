package entity;

import adt.*;
import dao.StudentInitializer;

/**
 *
 * @author Low Jia Yu, Wong Yen Jun
 */
public class TutorialGroup implements Comparable<TutorialGroup> {
    private String tutorialGroupName;
    private int groupNo;
    private int noOfStudent;
    private SortedListInterface<Student> enrolledStudents;
    private SortedListInterface<Programme> programmes;
     private Student student;
    

    public TutorialGroup(String tutorialGroupName) {
        this.tutorialGroupName = tutorialGroupName;
    }

    public TutorialGroup(String tutorialGroupName, int groupNo) {
        this.tutorialGroupName = tutorialGroupName;
        this.groupNo = groupNo;
        this.enrolledStudents = new SortedArrayList<>();
        this.programmes = new SortedArrayList<>();
    }
    
    public TutorialGroup(String tutorialGroupName, int noOfStudents) {
        this.tutorialGroupName = tutorialGroupName;
    }

    public TutorialGroup(String tutorialGroupName, int groupNo, int noOfStudent) {
        this(tutorialGroupName, groupNo, noOfStudent, null);
    }

    public TutorialGroup(String tutorialGroupName, int groupNo,int noOfStudent) {
        this.tutorialGroupName = tutorialGroupName;
        this.groupNo = groupNo;
        this.enrolledStudents = new SortedArrayList<>();
        this.programmes = new SortedArrayList<>();
    }
      
     public TutorialGroup(int noOfStudent) {
        this.noOfStudent = noOfStudent;
        this.enrolledStudents = new SortedArrayList<>();
        this.programmes = new SortedArrayList<>();
        
        for(int i = 0; i < noOfStudent; i++) {
            enrolledStudents.add(StudentInitializer.studentList.getEntry(i));
        }
    }

    public TutorialGroup(String tutorialGroupName, int groupNo, int noOfStudent, Programme programme) {
        this.tutorialGroupName = tutorialGroupName;
        this.groupNo = groupNo;
        this.noOfStudent = noOfStudent;
        this.enrolledStudents = new SortedArrayList<>();
        this.programme = programme;

        for(int i = 0; i < noOfStudent; i++) {
            enrolledStudents.add(StudentInitializer.studentList.getEntry(i));
        }
    }
    
    
     public TutorialGroup(Student student, String tutorialGroupName, int groupNo, int noOfStudent, Programme programme) {
        this.tutorialGroupName = tutorialGroupName;
        this.groupNo = groupNo;
        this.noOfStudent = noOfStudent;
        this.enrolledStudents = new SortedArrayList<>();
        this.programmes = new SortedArrayList<>();
     }
    
    //+++++++++++++++++
    private Student student;
    private Programme programme;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programmeCode) {
        this.programme = programme;
    }
    public TutorialGroup(Student student, String tutorialGroupName, int groupNo, int noOfStudent, Programme programme) {
        this.student = student;
        this.tutorialGroupName = tutorialGroupName;
        this.groupNo = groupNo;
        this.noOfStudent = noOfStudent;
        this.programme = programme;
    }
    //+++++++++++++++++++++++++++++++++
    

    public String getTutorialGroupName() {
        return tutorialGroupName;
    }

    public void setTutorialGroupName(String tutorialGroupName) {
        this.tutorialGroupName = tutorialGroupName;
    }

    public int getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(int groupNo) {
        this.groupNo = groupNo;
    }

    public int getNoOfStudent() {
        return noOfStudent;
    }

    public void setNoOfStudent(int noOfStudent) {
       int original = this.noOfStudent;
        this.noOfStudent = noOfStudent;
        
        if(original > noOfStudent) {
            for(int i = 0; i < (original - noOfStudent);i++) {
                this.enrolledStudents.remove(this.enrolledStudents.getEntry(i));
            }
        } else if(original < noOfStudent) {
            for(int i = 0; i < (noOfStudent - original); i++) {
                enrolledStudents.add(StudentInitializer.studentList.getEntry(i));
            }
        }
    }

     public SortedListInterface<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(SortedArrayList<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public SortedListInterface<Programme> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(SortedArrayList<Programme> programmes) {
        this.programmes = programmes;
    }

     public void addStudent(Student student) {
        enrolledStudents.add(student);
        noOfStudent++;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TutorialGroup)) {
            return false;
        }
        TutorialGroup other = (TutorialGroup) object;
        if ((this.tutorialGroupName == null && other.tutorialGroupName != null) || (this.tutorialGroupName != null && !this.tutorialGroupName.equals(other.tutorialGroupName))) {
            return false;
        }
        return true;
    }
    
    public int compareTo(TutorialGroup tutorialGroup) {
       if (tutorialGroupName.compareTo(tutorialGroup.getTutorialGroupName()) > 0) {
            return 1;
        } else if (tutorialGroupName.compareTo(tutorialGroup.getTutorialGroupName()) == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return String.format("%-25s %-15d", tutorialGroupName, noOfStudent);
    }

  
}
 
