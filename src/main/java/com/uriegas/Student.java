package com.uriegas;
/**
 * Student POJO class
 * The ordering is as follows:
 * SELECT * FROM STUDENTS ORDER BY GRADE, 
 */
public class Student implements Comparable<Student> {
    private String student_name;
    private String student_first_last_name;
    private String student_second_last_name;
    private int student_id; //Matricula
    private double grade;
    private int failed_subjects;
    private int total_subjects;

    public Student(String student_name, double grade, int failed_subjects, int total_subjects) {
        this.student_name = student_name;
        this.grade = grade;
        this.failed_subjects = failed_subjects;
        this.total_subjects = total_subjects;
    }
    public Student(String student_name, String student_first_last_name, String student_second_last_name, int student_id, double grade, int failed_subjects, int total_subjects) {
        setStudent_name(student_name);
        setStudent_first_last_name(student_first_last_name);
        setStudent_second_last_name(student_second_last_name);
        setStudent_id(student_id);
        setGrade(grade);
        setFailed_subjects(failed_subjects);
        setTotal_subjects(total_subjects);
    }
    public String getStudent_name() {return student_name;}
    public String getStudent_first_last_name() {return student_first_last_name;}
    public String getStudent_second_last_name() {return student_second_last_name;}
    public int getStudent_id() {return student_id;}
    public double getGrade() {return grade;}
    public int getFailed_subjects() {return failed_subjects;}
    public int getTotal_subjects() {return total_subjects;}
    public void setStudent_name(String student_name) {this.student_name = student_name;}
    public void setStudent_first_last_name(String student_first_last_name) {this.student_first_last_name = student_first_last_name;}
    public void setStudent_second_last_name(String student_second_last_name) {this.student_second_last_name = student_second_last_name;}
    public void setStudent_id(int student_id) {this.student_id = student_id;}
    public void setGrade(double grade) {this.grade = grade;}
    public void setFailed_subjects(int failed_subjects) {this.failed_subjects = failed_subjects;}
    public void setTotal_subjects(int total_subjects) {this.total_subjects = total_subjects;}
    public String toString() { return "Student: " + student_name + " " + student_first_last_name + " " + student_second_last_name + " " + student_id + " " + grade + " " + failed_subjects + " " + total_subjects; }
    public String toCSV() { return student_name + "," + student_first_last_name + "," + student_second_last_name + "," + student_id + "," + grade + "," + failed_subjects; }
    /**
     * Comparison method to sort the students by given restrictions:<p>
     * <ul>
     * <li>grade</li>
     * <li>failed_subjects</li>
     * <li>total_subjects</li>
     * </ul>
     */
    public int compareTo(Student student) {
            int lastCmp = Double.valueOf(getGrade()).compareTo(Double.valueOf(student.getGrade()));
            if (lastCmp == 0){//If grade is the same in both students, compare the ids
                int idCmp = Integer.valueOf(getStudent_id()/1000).compareTo(Integer.valueOf(student.getStudent_id()/1000)); //Divide by 1000 to get the first 4 digits of the id = YYMM
                if (idCmp == 0)//If ids are the same, compare total taken subjects
                    return -Integer.valueOf(getTotal_subjects()).compareTo(Integer.valueOf(student.getTotal_subjects()));//The student with more taken subjects is first
                else
                    return idCmp;
            }
            else
                return -lastCmp;//Reverse the order greater to minor
    }
}
