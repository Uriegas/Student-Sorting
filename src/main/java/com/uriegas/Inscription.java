package com.uriegas;

// import java.util.*;

/**
 * An inscription of a student to a course.
 */
public class Inscription implements Sortable<Double> {
    private String student_name;
    private String student_first_last_name;
    private String student_second_last_name;
    private int student_id; //Matricula
    private String class_name;
    private String class_id;
    private int student_attendace;
    private double grade;

    public Inscription(){
    }
    public Inscription(String student_name, String student_first_last_name, String student_second_last_name, int student_id, String class_name, String class_id, int student_attendace, double grade) {
        this.student_name = student_name;
        this.student_first_last_name = student_first_last_name;
        this.student_second_last_name = student_second_last_name;
        this.student_id = student_id;
        this.class_name = class_name;
        this.class_id = class_id;
        this.student_attendace = student_attendace;
        this.grade = grade;
    }

    public String getStudent_name() {
        return student_name;
    }
    public String getStudent_first_last_name() {
        return student_first_last_name;
    }
    public String getStudent_second_last_name() {
        return student_second_last_name;
    }
    public int getStudent_id() {
        return student_id;
    }
    public String getClass_name() {
        return class_name;
    }
    public String getClass_id() {
        return class_id;
    }
    public int getStudent_attendace() {
        return student_attendace;
    }
    public double getGrade() {
        return grade;
    }
    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
    public void setStudent_first_last_name(String student_first_last_name) {
        this.student_first_last_name = student_first_last_name;
    }
    public void setStudent_second_last_name(String student_second_last_name) {
        this.student_second_last_name = student_second_last_name;
    }
    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }
    public void setStudent_attendace(int student_attendace) {
        this.student_attendace = student_attendace;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
    public String toString() {
        return this.student_name + " " + this.student_id + " " + this.class_name + " " + this.class_id + " " + this.student_attendace + " " + this.grade;
    }
    public int compareTo(Object o) {
        Inscription ins = (Inscription) o;
        return this.student_id - ins.getStudent_id();
    }
    public Double get(int index) {
        return Double.valueOf(getGrade());
    }
    public int size() {
        return 1;
    }
}
