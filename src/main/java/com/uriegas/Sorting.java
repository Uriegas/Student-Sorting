package com.uriegas;

import java.util.*;
import java.util.stream.*;
/**
 * Class to get the sorted list of students.
 */
public class Sorting {
    /**
     * Sort a list of students by grades and more.
     */
    public static List<Student> sort(List<Student> nStudents){
        Map<Object, List<Student>> groups = nStudents.stream().collect(Collectors.groupingBy(s -> s.getFailed_subjects() ));
        List<Student> sorted = new ArrayList<Student>();
        for (Object key : groups.keySet()) {
            List<Student> list = groups.get(key);
            Collections.sort(list);
            sorted.addAll(list);
        }
        return sorted;
    }
    /**
     * Get the students totals by the list of inscrptions to subjects
     */
    public static List<Student> getStudents(List<Inscription> students){
        Map<Object, List<Inscription>> map = students.stream().collect(Collectors.groupingBy(s -> s.getStudent_id() ));//Group inscriptions by student_id's
        List<Student> result = new ArrayList<Student>();
        for (Object key : map.keySet()) {
            // ==> Get information about the student from his inscriptions
            List<Inscription> list = map.get(key);//Get the list of inscriptions for the student_id
            int total_subjects = list.size();
            int failed_subjects = (int)(list.stream().filter(s -> s.getGrade() < 70.0).count());//Count the subjects with grade < 70
            double grade = (double)(list.stream().mapToDouble(s -> s.getGrade()).sum());//Sum the grades
            grade /= total_subjects;//Calculate the average
            // <== Get information about the student from his inscriptions

            result.add(new Student(list.get(1).getStudent_name(), list.get(1).getStudent_first_last_name(), list.get(1).getStudent_second_last_name(), list.get(1).getStudent_id(), grade, failed_subjects, total_subjects));//Add the student to the list
        }
        return result;
    }
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Guillermo", "Gonzalez", "Perez", 1930526, 87.0, 2, 6),
            new Student("Juan", "Perez", "Lopez", 2030526, 90.0, 0, 6),
            new Student("Raul", "Alarez", "Quinta", 1830526, 80.0, 1, 6),
            new Student("Raul", "Alarez", "Quinta", 1930526, 80.0, 2, 7),
            new Student("Jorge", "Garcia", "Sanchez", 2030526, 90.0, 2, 6),
            new Student("Jorge", "Garcia", "Sanchez", 2030556, 90.0, 0, 6),
            new Student("Jorge", "Garcia", "Sanchez", 2030526, 70.0, 0, 6)
        );
        //Group by failed subjects
        Map<Object, List<Student>> groups = students.stream().collect(Collectors.groupingBy(s -> s.getFailed_subjects() ));

        System.out.println("Sorted is:");
        groups.forEach((key, value) ->{
            // System.out.println(key + ": " + value);
            Collections.sort(value);
            value.forEach(System.out::println);
        });

        List<Student> sorted = sort(students);
        System.out.println("Sorted is:");
        sorted.forEach(System.out::println);

        // System.out.println("Not sorted");
        // for (Student student : students)
        //     System.out.println(student);

        // Collections.sort(students);

        // System.out.println("\nSorted");
        // for (Student student : students)
        //     System.out.println(student);
    }
}
