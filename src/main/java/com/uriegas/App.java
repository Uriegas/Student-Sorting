package com.uriegas;

import java.io.*;

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
        if( args.length == 1 ){
            System.out.println( WARNING + "Considering output file as output.csv" );
            run(args[0], "output.csv");
            // args[1] = "output.csv";
        }else if( args.length == 2 ){
            run(args[0], args[1]);
        }else{
            System.out.println( ERROR + "Usage: java -jar gradeording-1.0-SNAPSHOT.jar <input_file> <output_file>");
            System.out.println( INFO + "1. input_file: absolute or relative path to the excel/csv file with the inscriptions.");
            System.out.println( INFO + "2. output_file: csv or txt file to append the ordered list.");
            System.out.println( INFO + "Example: java -jar gradeording-1.0-SNAPSHOT.jar ejemplo1.xlsx output.csv");
        }
        // ==> Menu loop
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // String line;
        // try{
        //     System.out.println("Welcome to the sorting inscriptions program.");
        //     System.out.println("MENU:");
        //     System.out.println("1. Sort inscriptions");
        //     line = in.readLine();
        //     System.out.println(INFO + "Wrote: " + line);
        // }catch( IOException e ){
        //     System.err.println( "Error: " + e.getMessage() );
        // }

        // while( (line = in.readLine()) != null )
        //     String[] tokens = line.split(" ");
        // <== Menu loop
    }
    public static void run(String inputFile, String outputFile){
        System.out.println( INFO + "Executing sorting inscriptions program.");
        System.out.println( DEBUG + "Input file: " + inputFile);
        System.out.println( DEBUG + "Output file: " + outputFile);
    }
}
