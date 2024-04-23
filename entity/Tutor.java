package entity;

import java.io.Serializable;
import adt.SortedArrayList;
import adt.SortedListInterface;
//import adt.SortedListInterface;

/**
 *
 * @author User
 */
public class Tutor implements Comparable<Tutor>, Serializable {

    private String tutorId;
    private String tutorName;
    private String tutorEmail;
    private Character tutorGender;
    private String tutorCategory;
    private String status;
    private int maxTutor;
    private String classType;
    private SortedArrayList<Course> courses = new SortedArrayList<>();

    private SortedArrayList<Course> courseCode;
    private SortedArrayList<TutorialGroup> tutorialGroups;

    private SortedListInterface<Course> courseList = new SortedArrayList<>();
    private SortedListInterface<TutorialGroup> tutorialGroupList = new SortedArrayList<>();

    public Tutor() {
        this.tutorialGroups = new SortedArrayList<>();
        this.status = "unassign";
    }

    public Tutor(TutorialGroup tutorialGroup, String tutorId, int maxTutor) {
        this.tutorialGroups=new SortedArrayList<>();
        this.tutorId=tutorId;
        this.maxTutor=maxTutor;
    }
     public Tutor(Course course, String classType) {
        this.courses = new SortedArrayList<>();
        this.classType = classType;
    }
     

    public String getStatus() {
        return status;
    }

    public int getNumberOfCourses() {
        return courses.getNumberOfEntries();
    }

    public int getNumberOfTutorialGroups() {
        return tutorialGroups.getNumberOfEntries();
    }

    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    public Tutor(String tutorId) {
        this.tutorId = tutorId;
    }

    public Tutor(String tutorId, String courseCode) {
        this.courses = new SortedArrayList<>();
        this.tutorId = tutorId != null ? tutorId : "";
    }

    public SortedArrayList<TutorialGroup> getTutorialGroups() {
        return tutorialGroups;
    }

    public void addTutorialGroup(TutorialGroup tutorialGroup) {
        if (this.tutorialGroups == null) {
            this.tutorialGroups = new SortedArrayList<TutorialGroup>(); // Ensures initialization
        }
        this.tutorialGroups.add(tutorialGroup);
    }

    public void removeTutorialGroup(TutorialGroup tutorialGroup) {
        tutorialGroups.remove(tutorialGroup);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public void setTutorialGroups(SortedArrayList<TutorialGroup> tutorialGroups) {
        this.tutorialGroups = tutorialGroups;
    }

    public SortedArrayList<Course> getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(SortedArrayList<Course> courses) {
        this.courses = courses;
    }

    public Tutor(String tutorId, String tutorName, String tutorEmail, Character tutorGender, String tutorCategory) {
        this.tutorId = tutorId;
        this.tutorName = tutorName;
        this.tutorEmail = tutorEmail;
        this.tutorGender = tutorGender;
        this.tutorCategory = tutorCategory;
        this.courseList = new SortedArrayList<>();
        this.courses = new SortedArrayList<>();
    }

    public Tutor(String tutorId, String tutorName, String tutorEmail, Character tutorGender, String tutorCategory, String status, SortedListInterface<Course> clist, SortedListInterface<TutorialGroup> glist) {
        this.tutorId = tutorId;
        this.tutorName = tutorName;
        this.tutorEmail = tutorEmail;
        this.tutorGender = tutorGender;
        this.tutorCategory = tutorCategory;
        this.status = status;
        this.courseList = clist;
        this.tutorialGroupList = glist;
//        this.courseCode = courseCode;
//        this.tutorialGroups = tutorialGroups;
//        this.courseList = courseList;
//        this.tutorialGroupList = tutorialGroupList;
    }

    public SortedArrayList<Course> getCourse() {
        return courses;
    }
    
   

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getTutorEmail() {
        return tutorEmail;
    }

    public void setTutorEmail(String tutorEmail) {
        this.tutorEmail = tutorEmail;
    }

    public Character getTutorGender() {
        return tutorGender;
    }

    public void setTutorGender(Character tutorGender) {
        this.tutorGender = tutorGender;
    }

    public String getTutorCategory() {
        return tutorCategory;
    }

    public void setTutorCategory(String tutorCategory) {
        this.tutorCategory = tutorCategory;
    }

    public SortedListInterface<Course> getCourseList() {
        return courseList;
    }

    public SortedListInterface<TutorialGroup> getTutorialGroupList() {
        return tutorialGroupList;
    }

    public void setCourse(SortedArrayList<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        if (courses.contains(course) == -1) {
            courses.add(course);
        }
    }

    @Override
    public String toString() {
        // Directly use tutorGender.toString() if not null, otherwise, show "-"
        String genderStr = (tutorGender != null) ? tutorGender.toString() : "-";
        return String.format("%-7s %-30s %-7s %-15s %-30s",
                tutorId, tutorName, genderStr, tutorCategory, tutorEmail);
    }

    @Override
    public int compareTo(Tutor otherTutor) {
        return this.tutorName.compareTo(otherTutor.tutorName);
    }

//    @Override
//    public int compareTo(Tutor otherTutor) {
//        return this.tutorId.compareTo(otherTutor.tutorId);
//    }
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

}
