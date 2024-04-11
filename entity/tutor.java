/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import adt.SortedArrayList;
import adt.SortedArrayListInterface;

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

    private SortedArrayListInterface<Course> courseList;
    private SortedArrayListInterface<TutorialGroup> tutorialGroupList;

    public Tutor() {
    }

    public Tutor(String id, String name, String email, Character gender, String category) {
        this.tutorId = id;
        this.tutorName = name;
        this.tutorEmail = email;
        this.tutorGender = gender;
        this.tutorCategory = category;
        this.courseList = new SortedArrayList<>();
        this.tutorialGroupList = new SortedArrayList<>();
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

    public SortedArrayListInterface<Course> getCourseList() {
        return courseList;
    }

    public SortedArrayListInterface<TutorialGroup> getTutorialGroupList() {
        return tutorialGroupList;
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

}
