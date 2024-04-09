/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import adt.SortedArrayList;
import adt.ListInterface;

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
   

    private ListInterface<Course> courseList;
    private ListInterface<TutorialGroup> tutorialGroupList;

    public Tutor() {
    }

    public Tutor(String tutorId, String tutorName, String tutorEmail, Character tutorGender, String tutorCategory) {
        this.tutorId = tutorId;
        this.tutorName = tutorName;
        this.tutorEmail = tutorEmail;
        this.tutorGender = tutorGender;
        this.tutorCategory = tutorCategory;
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

    public ListInterface<Course> getCourseList() {
        return courseList;
    }

    public ListInterface<TutorialGroup> getTutorialGroupList() {
        return tutorialGroupList;
    }


    @Override
    public String toString() {
        // Directly use tutorGender.toString() if not null, otherwise, show "-"
        String genderStr = (tutorGender != null) ? tutorGender.toString() : "-";
        return String.format("%-7s %-30s %-7s %-15s %-30s %-30s %-30s",
                tutorId, tutorName, genderStr, tutorCategory, tutorEmail, courseList, tutorialGroupList);
    
    //return "Tutor{" + "id=" + id + ", gender=" + gender + ", name=" + name + ", phoneNumber=" + phoneNumber + ", gmail=" + gmail + ", registerDate=" + registerDate + ", courseList=" + courseList + ", tutorialGroupList=" + tutorialGroupList + '}';
    

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
