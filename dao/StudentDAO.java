package dao;

import adt.*;
import entity.Student;

/**
 *
 * @author LWY
 */
public class StudentDAO {
  
    //  Method to return a collection of with hard-coded entity values
    // sorted by stdent ID
    public SortedListInterface<Student> initializeStudents() {
        SortedListInterface<Student> studentList = new SortedArrayList<>();
        studentList.add(new Student("21WMR01237", "Zen", "000912-09-1234", "M", "012-2587101", "alice@tarc.edu.my", "33, Jalan Bunga 2"));
        studentList.add(new Student("21WMR01239", "Alice", "000912-09-1234", "F", "012-2587101", "alice@tarc.edu.my", "33, Jalan Bunga 2"));
        studentList.add(new Student("21WMR01231", "Glenn", "000912-09-1234", "M", "012-2587101", "alice@tarc.edu.my", "33, Jalan Bunga 2"));
        return studentList;
    }

    
    //=== only run this hardcode ===
//       public static void main(String[] args) {
//    // To illustrate how to use the initializeProducts() method
//    StudentDAO s = new StudentDAO();
//    SortedListInterface<Student> studentList = s.initializeStudents();
//    System.out.println("\nStudents:\n" + studentList);
//  }
}




//
//import adt.SortedArrayList;
//import entity.Student;
///**
// *
// * @author USER LJY
// */
//public class StudentDAO {
//    public static SortedArrayList<Student> studentList = new SortedArrayList<>();
//    public static SortedArrayList<Student> idleStudentList = new SortedArrayList<>();   // store students with no programme
//
//    static {
//        // Test data goes here
//         studentList.add(new Student("21WMR01237", "Zen", "000912-09-1234", "M", "012-2587101", "alice@tarc.edu.my", "33, Jalan Bunga 2"));
//        studentList.add(new Student("21WMR01239", "Alice", "000912-09-1234", "F", "012-2587101", "alice@tarc.edu.my", "33, Jalan Bunga 2"));
//        studentList.add(new Student("21WMR01231", "Glenn", "000912-09-1234", "M", "012-2587101", "alice@tarc.edu.my", "33, Jalan Bunga 2"));
////        studentList.add(new Student("22WMR23056", "Abel Tan Jun Han", "930430-07-0084", "M", "011-2010202", "abel@gmail.com"));
////        studentList.add(new Student("22WMR23000", "Abraham Chan Wai Ming", "930430-07-0084", "M", "012-2000202", "abraham@gmail.com"));
////        studentList.add(new Student("22WMR23001", "Abigail Lee Hui En", "930430-07-0084", "F", "013-2000202", "huien@gmail.com"));
////        studentList.add(new Student("20WMR23002", "Alissa Lim Chee Wen", "930430-07-0084", "F", "014-2000202", "alissa@gmail.com"));
////        studentList.add(new Student("20WMR23003","Audrey Soh Pei Li","930430-07-0084","F", "015-2000202",  "audrey@gmail.com"));
////        studentList.add(new Student("21WMR23004","Benjamin Chew Kar Wen", "930430-07-0084","016-2000202", "M", "benjamin@gmail.com"));
////        studentList.add(new Student("22WMR23005","Bella Yeow Kai Li","930430-07-0084", "017-2000202", "M", "bella@gmail.com"));
////        studentList.add(new Student("23WMR23006","Brandon Low Kai Hua","930430-07-0084", "018-2000202","M", "brandon@gmail.com"));
////        studentList.add(new Student("22WMR23007","Bryan Liew Wei Kai",  "930430-07-0084","019-2000202", "M","bryan@gmail.com"));
////        studentList.add(new Student("22WMR23005","Brenda Chuah Mei Li", "930430-07-0084","011-2000202","M", "brenda@gmail.com"));
////        studentList.add(new Student("22WMR23005","Cody Chee Li Min", "930430-07-0084","012-2000202", "M", "cody@gmail.com"));
////        studentList.add(new Student("22WMR23005","Christina Lau Pei Han", "930430-07-0084", "013-2000202","M", "christina@gmail.com"));
////        studentList.add(new Student("22WMR23005","Crystal Lim See Yan", "930430-07-0084", "014-2000202","F", "crystal@gmail.com"));
////        studentList.add(new Student("20WMR23004","Charissa Wong Wei Ho", "930430-07-0084","015-2000202","F",  "charisan@gmail.com"));
////        studentList.add(new Student("20WMR23004","Clement Chen Chow Yan", "930430-07-0084", "011-2000202","F", "clement@gmail.com"));
////        studentList.add(new Student("20WMR23004","Dexter Tan Seng Kit", "930430-07-0084","011-2000202", "F", "dexter@gmail.com"));
////        studentList.add(new Student("20WMR23004","Danial See Han Wai","930430-07-0084", "011-2000202", "F", "danial@gmail.com"));
////        studentList.add(new Student("20WMR23004","Derrick Wong Yow Heng", "930430-07-0084", "011-2000202","F", "derrick@gmail.com"));
////        studentList.add(new Student("20WMR23004","Denise Lai Wen Pei", "930430-07-0084","011-2000202",  "F","denise@gmail.com"));
////        studentList.add(new Student("20WMR23004","Darrell Hao Chin Peng", "930430-07-0084","011-2000202", "F", "darrell@gmail.com"));
////        studentList.add(new Student("20WMR23004","Esther Zhang Yu Wen","930430-07-0084", "011-2000202", "F", "esther@gmail.com"));
////        studentList.add(new Student("20WMR23004","Elise Poh Yi Mei","930430-07-0084", "011-2000202", "F", "elise@gmail.com"));
////        studentList.add(new Student("20WMR23004","Emma Cho Xin Yi","930430-07-0084", "011-2000202", "F", "emma@gmail.com"));
////        studentList.add(new Student("20WMR23004","Emeleen Koh Chin Wei", "930430-07-0084","011-2000202", "F", "emeleen@gmail.com"));
////        studentList.add(new Student("20WMR23004","Eileen Leeng Wai Hong","930430-07-0084", "011-2000202", "F", "eileen@gmail.com"));
////        studentList.add(new Student("20WMR23004","Felix Chee Khai Xian","930430-07-0084", "011-2000202", "F", "felix@gmail.com"));
////        studentList.add(new Student("20WMR23004","Francis Lem Ho Teng","930430-07-0084", "011-2000202","F", "francis@gmail.com"));
////        studentList.add(new Student("20WMR23004","Florence Lee Hui En","930430-07-0084", "011-2000202", "F", "abc@gmail.com"));
////        studentList.add(new Student("20WMR23004","Felicia Tan Yan Kit","930430-07-0084", "011-2000202", "F", "abc@gmail.com"));
////        studentList.add(new Student("20WMR23004","Fiona Wee Teng Kai","930430-07-0084", "011-2000202","F", "abc@gmail.com"));
////        studentList.add(new Student("20WMR23004","Gary Goh Jing Teng", "930430-07-0084","011-2000202", "F", "abc@gmail.com"));
//    }
//}
