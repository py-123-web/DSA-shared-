/*
Author: WONG YEN JUN
ASSIGNMENT TEAM MANAGEMENT SUBSYSTEM
 */
package entity;

import java.io.Serializable;
import java.util.Date;

public class AssignmentTeam implements Serializable{
    private static int tID = 0;
    private String teamId;
    private String teamLeader;
    
    
    //private Course course
    //   -get courseId(DSA),  programme(REI(no fullname)
    //  - xuyao tambah year
    private String courseId; 
    private String programme;
    private int year;
    private int Semester;
    //private TutorialGroup
    //  - get tutorialGroupID
    private String tutorialGroupID;
    //private Tutor tutor;    
    //  - get tutorId
    private String tutorId;
    //private Student student;
    //  - get studId, studName, email
    private String studId;
    //need to calculate the year, semester
    
    
    public AssignmentTeam(){
        
    }

    public static int gettID() {
        return tID;
    }

    public static void settID(int tID) {
        AssignmentTeam.tID = tID;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(String teamLeader) {
        this.teamLeader = teamLeader;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return Semester;
    }

    public void setSemester(int Semester) {
        this.Semester = Semester;
    }

    public String getTutorialGroupID() {
        return tutorialGroupID;
    }

    public void setTutorialGroupID(String tutorialGroupID) {
        this.tutorialGroupID = tutorialGroupID;
    }

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }
    
    
   

    
    
    
}
