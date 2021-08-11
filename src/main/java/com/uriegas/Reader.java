package com.uriegas;

import java.io.*;
import java.util.*;

/**
 * Class to read and write to excel and csv files
 */
public class Reader {
    /**
     * Reads a csv or excel file and converts it to a list
     * 
     */
    public static List<Inscription> readFile(File file) throws Exception {
        String fileName = file.getName();
        if(fileName.endsWith(".xlsx"))
            return readExcel(file);
        else if(fileName.endsWith(".csv"))
            return readCsv(file);
        else
            throw new IllegalArgumentException("File format not supported");
    }
    public static List<Inscription> readExcel(File file) throws IOException {
        List<Inscription> inscriptions = new ArrayList<Inscription>();
        //TODO: read excel file
        return inscriptions;
    }
    public static List<Inscription> readCsv(File file) throws IOException {
        List<Inscription> inscriptions = new ArrayList<Inscription>();
        //TODO: read csv file
        return inscriptions;
    }
    public static void writeFile(File file, List<Inscription> inscriptions) throws Exception {
        String fileName = file.getName();
        if(fileName.endsWith(".xlsx"))
            writeExcel(file, inscriptions);
        else if(fileName.endsWith(".csv"))
            writeCsv(file, inscriptions);
        else
            throw new IllegalArgumentException("File format not supported");
    }
    public static void writeExcel(File file, List<Inscription> inscriptions) throws IOException {
        //TODO: write excel file
    }
    public static void writeCsv(File file, List<Inscription> inscriptions) throws IOException {
        //TODO: write csv file
    }
}