/*
Author: WONG YEN JUN
ASSIGNMENT TEAM MANAGEMENT SUBSYSTEM
 */
package entity;

import adt.SortedArrayList;
import adt.SortedListInterface;


public class AssignmentTeam implements Comparable <AssignmentTeam>{
    
    private String tutorialGrp;//(G1)
    public String getTutorialGrp() {
        return tutorialGrp;
    }
    public void setTutorialGrp(String tutorialGrp) {
        this.tutorialGrp = tutorialGrp;
    }
    
    
    
    private SortedListInterface<Course> courseList;//courseCode=(DSA)
    private SortedListInterface<Programme> programmeList;//programmeCode=REI
    private SortedListInterface<TutorialGrp> tutorialGroupList;//(G1), Programme=(REI)
    private Course course;
    private Programme programme;
    //private TutorialGrp tutorialGrp;
    
    private String teamId;
    private int maxNumOfStud;
    private int maxNumOfTeam;
    private int numOfTeamToCreate;
    //private Course course;
    //private TutorialGroup;
    //private Programme programme;
    
    //TeamMember
    //private Student student;
    private String teamLeader;
    private String studId; //  - get studId, studName, email

    public SortedListInterface<Course> getCourseList() {
        return courseList;
    }
    public SortedListInterface<TutorialGrp> getTutorialGroupList() {
        return tutorialGroupList;
    }
    public SortedListInterface<Programme> getProgrammeList() {
        return programmeList;
    }
    
    public Course getCourse() {
        return course;
    }
    public Programme getProgramme() {
        return programme;
    }
    

    
    
    

    public String getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(String teamLeader) {
        this.teamLeader = teamLeader;
    }

    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }

    
    
    
    
   

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public int getMaxNumOfStud() {
        return maxNumOfStud;
    }

    public void setMaxNumOfStud(int maxNumOfStud) {
        this.maxNumOfStud = maxNumOfStud;
    }

    public int getMaxNumOfTeam() {
        return maxNumOfTeam;
    }

    public void setMaxNumOfTeam(int maxNumOfTeam) {
        this.maxNumOfTeam = maxNumOfTeam;
    }

    public int getNumOfTeamToCreate() {
        return numOfTeamToCreate;
    }

    public void setNumOfTeamToCreate(int numOfTeamToCreate) {
        this.numOfTeamToCreate = numOfTeamToCreate;
    }
    
    
    
    
    
    
    
    
    
    
    public AssignmentTeam(){
        
    }
    
    //create
    public AssignmentTeam(String teamId, int maxNumOfStud, Course course, Programme programme, String tutorialGrp) {
        this.tutorialGrp = tutorialGrp;
        this.course = course;
        this.programme = programme;
        this.teamId = teamId;
        this.maxNumOfStud = maxNumOfStud;
    }
    
    

    
    //input detail
    public AssignmentTeam(Course course, Programme programme, String tutorialGrp,  int maxNumOfStud, int numOfTeamToCreate) {
        this.tutorialGrp = tutorialGrp;
        this.course = course;
        this.programme = programme;
        this.maxNumOfStud = maxNumOfStud;
        this.numOfTeamToCreate = numOfTeamToCreate;
    }
    
    
    
    @Override
    public int compareTo(AssignmentTeam o) {
    return teamId.compareTo(o.teamId);
  }
    

    
   

    
    
    
}
