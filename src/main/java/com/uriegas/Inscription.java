package com.uriegas;

import java.util.*;

/**
 * A inscription of a student to a course.
 */
public class Inscription implements Sortable<Inscription> {
    private String student_name;
    private int student_id; //Matricula
    private String class_name;
    private String class_id;
    private int student_attendace;
    private List<Float> student_grades;

    public Inscription(String student_name, int student_id, String class_name, String class_id, int student_attendace, List<Float> student_grades) {
        this.student_name = student_name;
        this.student_id = student_id;
        this.class_name = class_name;
        this.class_id = class_id;
        this.student_attendace = student_attendace;
        this.student_grades = student_grades;
    }

    public String getStudent_name() {
        return student_name;
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
    public List<Float> getStudent_grades() {
        return student_grades;
    }
    public void setStudent_name(String student_name) {
        this.student_name = student_name;
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
    public void setStudent_grades(List<Float> student_grades) {
        this.student_grades = student_grades;
    }
    public String toString() {
        return this.student_name + " " + this.student_id + " " + this.class_name + " " + this.class_id + " " + this.student_attendace + " " + this.student_grades;
    }
    public int compareTo(Object o) {
        Inscription ins = (Inscription) o;
        return this.student_id - ins.getStudent_id();
    }
    public Inscription get(int index) {
        return new Inscription(this.student_name, this.student_id, this.class_name, this.class_id, this.student_attendace, this.student_grades);
    }
    public int size() {
        return this.student_grades.size();
    }
}
