package entity;

import adt.*;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Lee Weng Yan
 */
public class RegisterCourse implements Comparable<RegisterCourse> {

    private int registerId;
    private double amount;
    // private Date registerDate;
    private SortedListInterface<Course> courseList = new SortedArrayList<>();// one Register Course, many Courses

    public RegisterCourse() {
    }

    public RegisterCourse(int registerId, double amount) {
        this.registerId = registerId;
        this.amount = amount;
    }
//        public RegisterCourse(int registerId, double amount, Date registerDate) {
//        this.registerId = registerId;
//        this.amount = amount;
//        this.registerDate = registerDate;
//    }

    public int getRegisterId() {
        return registerId;
    }

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

//    public Date getRegisterDate() {
//        return registerDate;
//    }
//
//    public void setRegisterDate(Date registerDate) {
//        this.registerDate = registerDate;
//    }
    public SortedListInterface<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(SortedListInterface<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "%-15s %-10s\n"
                + registerId + amount;
    }
    //    @Override
//    public String toString() {
//        return "%-15s %-10s %-15s\n"
//                + registerId + amount + registerDate;
//    }

    @Override
    public int compareTo(RegisterCourse otherRegisterCourse) {
        // Compare based on registerId or any other attribute that defines the natural order
        return Integer.compare(this.registerId, otherRegisterCourse.registerId); // sort based on registerId
    }

    @Override
    public boolean equals(Object o) {
        //this method is specifically designed to check if two RegisterCourse objects are equal by comparing their register IDs(registerId)
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RegisterCourse registerCourse = (RegisterCourse) o;
        return Objects.equals(registerId, registerCourse.registerId);
    }
}
