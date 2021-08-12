package com.uriegas;

import java.io.*;
import java.util.*;

/**
 * Command line interface for the sorting inscriptions program.
 */
public class App {

    public static String ERROR ="\033[91m[ERROR]\033[0m ";
    public static String WARNING ="\033[93m[WARNING]\033[0m ";
    public static String INFO ="\033[94m[INFO]\033[0m ";
    public static String DEBUG ="\033[95m[DEBUG]\033[0m ";
    public static String SUCCESS ="\033[92m[SUCCESS]\033[0m ";
    public static void main( String[] args ){
        // if( args.length == 1 ){
        //     System.out.println( WARNING + "Considering output file as output.csv" );
        //     run(args[0], "output.csv");
        //     // args[1] = "output.csv";
        // }else if( args.length == 2 ){
        //     run(args[0], args[1]);
        // }else{
        //     System.out.println( ERROR + "Usage: java -jar gradeording-1.0-SNAPSHOT.jar <input_file> <output_file>");
        //     System.out.println( INFO + "1. input_file: absolute or relative path to the excel/csv file with the inscriptions.");
        //     System.out.println( INFO + "2. output_file: csv or txt file to append the ordered list.");
        //     System.out.println( INFO + "Example: java -jar gradeording-1.0-SNAPSHOT.jar ejemplo1.xlsx output.csv");
        // }
        // ==> Menu loop
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<Student> students = new ArrayList<Student>();
            System.out.println("Welcome to the sorting inscriptions program.");
            System.out.println(INFO + "Type 'exit' to exit this program");
            while(true){
                try{
                    System.out.println(INFO + "Type 'view' to view sorted list");
                    System.out.print("Input file please (XLSX or CSV)> ");
                    line = in.readLine();
                    if(line.equals("exit"))
                        break;
                    else if(line.equals("view")){
                        if(!students.isEmpty() || students == null){
                            System.out.println(INFO + "Sorted list:");
                            System.out.println("Name,First last name,Second last name,Student ID,Grade,No Failed Subjects");
                            students.forEach(s -> System.out.println( s.toCSV()));
                        }else
                            System.out.println(ERROR + "List is empty");
                    }else{
                        System.out.println(INFO + "Reading: " + line + "...");
                        students = run(line, "output.csv");
                        System.out.println(SUCCESS + "Done.");
                    }
                }catch( IOException e ){
                    System.err.println( "Error: " + e.getMessage() );
                }catch( NullPointerException e ){
                    System.err.println(ERROR + "List is empty");
                }
            }
        // <== Menu loop
    }
    public static List<Student> run(String inputFile, String outputFile){
        System.out.println( INFO + "Executing sorting inscriptions program.");
        System.out.println( DEBUG + "Input file: " + inputFile);
        System.out.println( DEBUG + "Output file: " + outputFile);
        try{
            List<Inscription> inscriptions = Reader.read(new File(inputFile));
            List<Student> students = Sorting.getStudents(inscriptions);
            students = Sorting.sort(students);
            Reader.write(new File(outputFile), students);
            return students;
        }catch( Exception e ){
            System.err.println( ERROR + "Error: " + e.getMessage() );
            return null;
        }
    }
}
