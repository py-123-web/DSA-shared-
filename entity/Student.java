package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author LWY, Low Jia Yu
 */

public class Student implements Comparable<Student> {
    private String studId;
    private String studName;
    private String ic;
    private String gender;
    private String contactNo;
    private String email;
    private String address;

    public Student() {
    }

    public Student(String studId, String studName, String ic, String gender, String contactNo, String email, String address) {
        this.studId = studId;
        this.studName = studName;
        this.ic = ic;
        this.gender = gender;
        this.contactNo = contactNo;
        this.email = email;
        this.address = address;
    }
    
    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    @Override
//    public String toString() {
//        return  "Student ID = " + studId + 
//                ", Student Name = " + studName + 
//                ", IC = " + ic + 
//                ", Gender = " + gender + 
//                ", ContactNo = " + contactNo + 
//                ", Email = " + email + 
//                ", Address = " + address;
//    }
    
    @Override
    public String toString() {
        return String.format("%-10s %-20s %-15s %10s %-15s %-30s %-50s",
                studId, studName, ic, gender, contactNo, email, address);
    }
    
     @Override
    public int compareTo(Student otherStudent) {
        // Compare based on studId or any other attribute that defines the natural order
        return this.studId.compareTo(otherStudent.studId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studId, student.studId);
    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(studId);
//    }
    
}
//public class Student implements Serializable{
//
//    private String studId;
//    private String studName;
//    private int ic;
//    private String gender;
//    private int contactNo;
//    private String email;
//    private String address;
//
//    public Student() {
//    }
//
//    public Student(String studId, String studName, int ic, String gender, int contactNo, String email, String address) {
//        this.studId = studId;
//        this.studName = studName;
//        this.ic = ic;
//        this.gender = gender;
//        this.contactNo = contactNo;
//        this.email = email;
//        this.address = address;
//    }
//
//    public String getStudId() {
//        return studId;
//    }
//
//    public void setStudId(String studId) {
//        this.studId = studId;
//    }
//
//    public String getStudName() {
//        return studName;
//    }
//
//    public void setStudName(String studName) {
//        this.studName = studName;
//    }
//
//    public int getIc() {
//        return ic;
//    }
//
//    public void setIc(int ic) {
//        this.ic = ic;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public int getContactNo() {
//        return contactNo;
//    }
//
//    public void setContactNo(int contactNo) {
//        this.contactNo = contactNo;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

    //override havent complete
    /*
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.number, other.number)) {
            return false;
        }
        return true;
    }
    
     @Override
    public String toString() {
        return String.format("%-10s %-40s %10d", number, name, quantity);
    }
     */
//}
