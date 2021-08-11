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
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try{
            line = in.readLine();
            System.out.println(INFO + "Wrote: " + line);
        }catch( IOException e ){
            System.err.println( "Error: " + e.getMessage() );
        }

        // while( (line = in.readLine()) != null ){
        //     String[] tokens = line.split(" ");
    }
}
