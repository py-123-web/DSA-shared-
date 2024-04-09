package entity;

import adt.SortedArrayList; // Import SortedArrayList
/**
 *
 * @author USER Low Jia Yu
 */
public class TutorialGrp implements Comparable<TutorialGrp> {
    private String tutorialGroupName;
    private int noOfStudent;
    private SortedArrayList<Student> enrolledStudents;
    private SortedArrayList<Programme> programmes; // Changed to SortedArrayList

    public TutorialGrp(String tutorialGroupName, int noOfStudent) {
        this.tutorialGroupName = tutorialGroupName;
        this.noOfStudent = noOfStudent;
        this.enrolledStudents = new SortedArrayList<>();
        this.programmes = new SortedArrayList<>(); // Initialize as SortedArrayList
    }

    // Getters and setters
    public String getTutorialGroupName() {
        return tutorialGroupName;
    }

    public void setTutorialGroupName(String tutorialGroupName) {
        this.tutorialGroupName = tutorialGroupName;
    }

    public int getNoOfStudent() {
        return noOfStudent;
    }

    public void setNoOfStudent(int noOfStudent) {
        this.noOfStudent = noOfStudent;
    }

    public SortedArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(SortedArrayList<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public SortedArrayList<Programme> getProgramme() {
        return programmes;
    }

    public void setProgramme(SortedArrayList<Programme> programmes) {
        this.programmes = programmes;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        noOfStudent++;
    }

    public void addProgramme(Programme programme) {
        programmes.add(programme);
    }

    @Override
    public int compareTo(TutorialGrp o) {
        return tutorialGroupName.compareTo(o.tutorialGroupName);
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-15s %10s",
                tutorialGroupName,noOfStudent,enrolledStudents,programmes);
    }
//    @Override
//    public String toString() {
//        return String.format("%-10s %-20s %-15s %10s %-15s %-30s %-50s",
//                studId, studName, ic, gender, contactNo, email, address);
//    }
}
