/*
Author: WONG YEN JUN
ASSIGNMENT TEAM MANAGEMENT SUBSYSTEM
 */
package boundary;
import entity.AssignmentTeam;
import utility.MessageUI;
import java.util.Scanner;


public class AssignmentTeamUI {
    Scanner scan = new Scanner(System.in);
    
    public static void displayMenu(){
         System.out.println("""
                           \n\n
                           \t\t,--------------------------------------------.
                           \t\t|    Assignment Team Management Subsystem    |
                           \t\t`--------------------------------------------'
                           \t\t 1. Create assignment teams for a tutorial group
                           \t\t 2. Remove assignment team
                           \t\t 3. Amend assignment team details
                           \t\t 4. Add students to assignment teams
                           \t\t 5. Remove students from assignment teams
                           \t\t 6. Merge assignment teams based on criteria
                           \t\t 7. List assignment teams for a tutorial group
                           \t\t 8. List students under an assignment team
                           \t\t 9. Reports(at least 2)
                           \t\t 0. Back to Menu
                               """);
    }
    
    public void displayCreateAssignmentTeamTitle(){
        System.out.println("""
                           \n\n
                           \t\t,----------------------------------------------------.
                           \t\t|    Create assignment teams for a tutorial group    |
                           \t\t`----------------------------------------------------'
                           """);
    }
    
    public int getMenuChoice(){
        displayMenu();
        do{
            System.out.printf("Select an option: ");
            try{
                int choice = scan.nextInt();
                return choice;
            }catch(Exception e){
                MessageUI.enterNumericNumber();
                scan.nextLine();
            }
        }while(true);
        
    }
            
//    public AssignmentTeam inputAssignmentTeamDetails(){
//        int maxNumOfStud = getMaxNumOfStud();
//        System.out.print(maxNumOfStud);
//        
//        //        System.out.printf("Enter Course ID or Name: ");
//        //        System.out.printf("Enter Programme Name: ");
//        //        System.out.printf("Enter Year: ");
//        //        System.out.printf("Enter Semester: ");
//        //        
//        //        System.out.printf("Enter Tutorial Group: ");
//        //        System.out.printf("Enter Tutor Id: ");
//        //        //search from arraylist display tutor detail to confirm
//        //        System.out.printf("Enter the maximum number of student for each team: ");
//        return new AssignmentTeam();
//    }
    
    public String getCourseID(){
        System.out.printf("Enter Course ID or Name: ");
        String courseId = scan.nextLine();
        return courseId;
    }
    public String getProgramme(){
        System.out.printf("Enter Programme Name: ");
        String programme = scan.nextLine();
        return programme;
    }
//    public int getYear(){
//        System.out.printf("Enter Year: ");
//        int year = scan.nextInt();
//        return year;
//    }
//    public int getSemester(){
//        System.out.printf("Enter Semester: ");
//        int semester = scan.nextInt();
//        return semester;
//    }
    public String getTutorialGroupID(){ //not sure string or integer
        System.out.printf("Enter Tutorial Group: ");
        String tutorialGroupID = scan.nextLine();
        return tutorialGroupID;
    }
    public String getTutorId(){
        System.out.printf("Enter Tutor Id: ");
        String tutorId = scan.nextLine();
        return tutorId;
    }
    public int getMaxNumOfStud(){
        do{
            System.out.printf("Enter the maximum number of student for each team: ");
            try{
                int maxNumOfStud = scan.nextInt();
                return maxNumOfStud;
            }catch(Exception e){
                MessageUI.enterNumericNumber();
                scan.nextLine();
            }
        }while(true);
//        System.out.printf("Enter the maximum number of student for each team: ");
//        int maxNumOfStud = scan.nextInt();
//        return maxNumOfStud;
//        
        
    }
}
