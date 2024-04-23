package entity;
/**
 *
 * @author USER Low Jia Yu & Hor Pei Yu
 */
import adt.*; 
import java.util.Objects;

public class Programme implements Comparable<Programme>{
    private String programmeCode;
    private String programmeName;
    private SortedArrayList<TutorialGroup> tutorialGroups; // Changed to SortedArrayList

    public Programme(String programmeCode, String programmeName) {
        this.programmeCode = programmeCode;
        this.programmeName = programmeName;
        this.tutorialGroups = new SortedArrayList<>(); // Initialize the SortedArrayList
    }
    public String getProgrammeCode() {
        return programmeCode;
    }

    public void setProgrammeCode(String progCode) {
        this.programmeCode = progCode;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String progName) {
        this.programmeName = progName;
    }

    public SortedListInterface<TutorialGroup> getTutorialGroups() {
        return tutorialGroups;
    }

    // Getters and setters
    public void setTutorialGroups(SortedArrayList<TutorialGroup> tutorialGroups) {    
        this.tutorialGroups = tutorialGroups;
    }

    // Method to add a TutorialGrp to the programme
    public void addTutorialGroup(TutorialGroup tutorialGrp) {
        tutorialGroups.add(tutorialGrp);
    }

    public void removeTutorialGroup(TutorialGroup tutorialGrp) {
        tutorialGroups.remove(tutorialGrp);
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-15s",
                programmeCode, programmeName, tutorialGroups);
    }

    @Override
    public int compareTo(Programme otherProg) {
        // Compare based on studId or any other attribute that defines the natural order
        return this.programmeCode.compareTo(otherProg.programmeCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Programme prog = (Programme) o;
        return Objects.equals(programmeCode, prog.programmeCode);
    }

}

