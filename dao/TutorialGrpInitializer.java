package dao;

import adt.SortedArrayList;
import adt.SortedListInterface;
import entity.TutorialGroup;
import static dao.ProgrammeInitializer.programmeList;

public class TutorialGrpInitializer {
    public static SortedListInterface<TutorialGroup> TutorialGrpList = new SortedArrayList<>();

    public void insertSampleData() {
        // Sample data for TutorialGrpList
        TutorialGrpList.add(new TutorialGroup("RSWG1", 1, 3, programmeList.getEntry(0)));
        TutorialGrpList.add(new TutorialGroup("RSWG2", 2, 2, programmeList.getEntry(2)));
        TutorialGrpList.add(new TutorialGroup("REIG2", 2, 4, programmeList.getEntry(1)));
        TutorialGrpList.add(new TutorialGroup("RMTG4", 1, 5, programmeList.getEntry(3)));
    }

    public SortedListInterface<TutorialGroup> getTutorialGrpList() {
        return TutorialGrpList;
    }

}

