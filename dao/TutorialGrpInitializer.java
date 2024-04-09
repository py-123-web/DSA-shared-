package dao;
import adt.*;
import entity.TutorialGrp;
/**
 *
 * @author USER Low Jia Yu
 */
public class TutorialGrpInitializer {
    public static SortedArrayList<TutorialGrp> TutorialGrpList = new SortedArrayList<>(); 
    
    public void insertSampleData() { // Specify type arguments
        // Specify type arguments
        TutorialGrpList.add(new TutorialGrp("G1", 25));
        TutorialGrpList.add(new TutorialGrp("G2", 20));
        TutorialGrpList.add(new TutorialGrp("G3", 35));
        TutorialGrpList.add(new TutorialGrp("G4", 21));
        // Specify type arguments

    }

    public SortedArrayList<TutorialGrp> getTutorialGrpList() {
        return TutorialGrpList;
    }

    //
}
