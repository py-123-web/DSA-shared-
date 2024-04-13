package dao;

import adt.*;
import entity.Course;
import entity.Student;
import java.util.Iterator;

/**
 *
 * @author Lee Weng Yan, Low Jia Yu
 */
public class StudentInitializer {

    private SortedListInterface<Course> courseList = new SortedArrayList<>();
    private Course course;

   // private SortedListInterface<Student> studentList;

//    public StudentInitializer() {
//        this.studentList = new SortedArrayList<>();
//        //initializeStudent();
//    }

    public SortedListInterface<Student> initializeStudent() {
        SortedListInterface<Student> studentList = new SortedArrayList<>(); // Assuming SortedArrayList is your implementation of SortedListInterface
        studentList.add(new Student("22WMR23056", "Abel Tan Jun Han", "030430-07-0084", "Male", "011-2010202", "abel@tarc.edu.my", "34 Jalan Emas"));
        studentList.add(new Student("21WMR01237", "Zen Tan Wei Hao", "000912-09-1234", "Male", "012-2587101", "zen@tarc.edu.my", "33 Jalan Bunga"));
        studentList.add(new Student("22WMR23000", "Abraham Chan Wai Ming", "019314-07-6716", "Male", "012-4032218", "abraham@tarc.edu.my", "71 Jalan Perak"));
        studentList.add(new Student("21WMR01231", "Glenn Yong Qi Hang", "001010-10-1090", "Male", "012-2762101", "glenn@tarc.edu.my", "30 Jalan Permai"));
        studentList.add(new Student("21WMR01239", "Alice Wong Mei Qi", "020112-14-1884", "Female", "012-2456101", "alice@tarc.edu.my", "12 Jalan Maju"));

//        studentList.add(new Student("22WMR23001", "Abigail Lee Hui En", "966683-23-9394", "Female", "013-1073784", "huien@tarc.edu.my", "1 Jalan Ampang"));
//        studentList.add(new Student("20WMR23002", "Alissa Lim Chee Wen", "012049-30-7261", "Female", "014-5409235", "alissa@tarc.edu.my", "5 Jalan Langkawi"));
//        studentList.add(new Student("20WMR23003", "Audrey Soh Pei Li", "035054-07-3095", "Female", "015-2085536", "audrey@tarc.edu.my", "7 Jalan Sultan Ismail"));
//        studentList.add(new Student("21WMR23004", "Benjamin Chew Kar Wen", "020430-07-1417", "016-2000202", "Female", "benjamin@tarc.edu.my", "93 Jalan Istana"));
//        studentList.add(new Student("22WMR23005", "Bella Yeow Kai Li", "040912-41-3352", "017-7301346", "Male", "bella@tarc.edu.my", "10 Jalan Hang Tuah"));

//        studentList.add(new Student("23WMR23006", "Brandon Low Kai Hua", "035884-14-7657", "018-4850327", "Male", "brandon@tarc.edu.my", "67 Jalan Bangsa Selatan"));
//        studentList.add(new Student("22WMR23007", "Bryan Liew Wei Kai", "039030-14-8097", "019-2025297", "Male", "bryan@tarc.edu.my", "9 Jalan Bukit Bintang"));
//        studentList.add(new Student("22WMR23008", "Brenda Chuah Mei Li", "994862-07-2396", "011-3029610", "Female", "brenda@tarc.edu.my", "8 Jalan Chow Kit"));
//        studentList.add(new Student("22WMR23009", "Cody Chee Li Min", "037629-08-5629", "012-9044068", "Male", "cody@tarc.edu.my", "95 Jalan Imbi"));
//        studentList.add(new Student("22WMR23010", "Christina Lau Pei Han", "031869-14-3445", "013-3552042", "Female", "christina@tarc.edu.my", "41 Jalan Cochrane"));
//        studentList.add(new Student("22WMR23011", "Crystal Lim See Yan", "022070-02-7288", "014-3364172", "Female", "crystal@tarc.edu.my", "1 Jalan Dewan Bahasa"));
//        studentList.add(new Student("20WMR23012", "Charissa Wong Wei Ho", "022070-08-7516", "015-3449800", "Female", "charisan@tarc.edu.my", "86 Jalan Bukit Tinggi"));
//        studentList.add(new Student("20WMR23015", "Clement Chen Chow Yan", "023815-14-7409", "011-8529891", "Female", "clement@tarc.edu.my", "32 Jalan Dang Wangi"));
//        studentList.add(new Student("20WMR23056", "Dexter Tan Seng Kit", "023887-03-4147", "011-9318631", "Male", "dexter@tarc.edu.my", "3 Jalan Aman"));
//        studentList.add(new Student("20WMR23033", "Danial See Han Wai", "021636-07-2938", "011-2286956", "Male", "danial@tarc.edu.my", "5 Jalan Bunga"));
//        
//        studentList.add(new Student("20WMR23076", "Derrick Wong Yow Heng", "017843-09-4037", "011-7107600", "Male", "derrick@tarc.edu.my", "89 Jalan Kuching"));
//        studentList.add(new Student("20WMR23098", "Denise Lai Wen Pei", "016032-14-3068", "011-1178901", "Female", "denise@tarc.edu.my", "3 Jalan Ipoh"));
//        studentList.add(new Student("20WMR23045", "Darrell Hao Chin Peng", "019596-14-6212", "011-2435012", "Male", "darrell@tarc.edu.my", "94 Jalan Shelley"));
//        studentList.add(new Student("20WMR23066", "Esther Zhang Yu Wen", "010685-14-1684", "011-5507215", "Female", "esther@tarc.edu.my", "25 Jalan Sultan Hishamuddin"));
//        studentList.add(new Student("20WMR23023", "Elise Poh Yi Mei", "010027-14-1549", "011-2200797", "Female", "elise@tarc.edu.my", "92 Jalan Kampar"));
//        studentList.add(new Student("20WMR23090", "Emma Cho Xin Yi", "038939-28-4683", "011-6115211", "Female", "emma@tarc.edu.my", "42 Jalan Persatuan"));
//        studentList.add(new Student("20WMR23014", "Felix Chee Khai Xian", "030419-05-2401", "011-8418411", "Male", "felix@tarc.edu.my", "9 Jalan Klang"));
//        studentList.add(new Student("20WMR23033", "Francis Lem Ho Teng", "991395-03-5683", "011-4070675", "Male", "francis@tarc.edu.my", "8 Jalan Temenggung"));
//        studentList.add(new Student("20WMR23099", "Florence Lee Hui En", "048586-01-9201", "011-6505378", "Female", "florence@tarc.edu.my", "84 Jalan Jati"));
//        studentList.add(new Student("20WMR23100", "Fiona Wee Teng Kai", "045625-07-7156", "011-1021807", "Male", "fiona@tarc.edu.my", "79 Jalan Pantai"));
        return studentList;
    }

    public void initializeCourse() {
        courseList.add(new Course("Problem Solving and Programming", "Practical", "REI", "Sem1", 3, "FOCS"));
        courseList.add(new Course("Data Structure And Algorithm", "Lecture", "RIT", "Sem2", 3, "FOCS"));
        courseList.add(new Course("Blockchain Application Development", "Tutorial", "RDS", "Sem3", 3, "FOCS"));
        courseList.add(new Course("Mobile Application Development", "Tutorial", "RSD", "Sem1", 3, "FOCS"));
        courseList.add(new Course("Vulnerability Assessment and Penetration Testing", "Practical", "RIS", "Sem2", 3, "FOCS"));
    }

    // === Refer SY ===
//    public void displayStudentInfo() {
//        for (int i = 0; i < studentList.getNumberOfEntries(); i++) {
//            Student student = studentList.getEntry(i);
////            System.out.println(" " + student.getStudId()
////                    + " " + studentList.getEntry(i));
////        }
//        System.out.println(studentList.getEntry(i));
//        }
//    }
//    
//    public SortedListInterface<Student> getStudentList() {
//        return studentList;
//    }
}
