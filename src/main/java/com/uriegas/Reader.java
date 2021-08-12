package com.uriegas;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

/**
 * Class to read and write to excel and csv files
 */
public class Reader {
    /**
     * Reads a csv or excel file and converts it to a list
     * 
     */
    public static List<Inscription> read(File file) throws Exception {
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
        FileInputStream f = new FileInputStream(file);
        XSSFWorkbook worksheet = new XSSFWorkbook(f);
        XSSFSheet sheet = worksheet.getSheetAt(0);
        Iterator<Row> rowIt = sheet.rowIterator();//Iterator over rows
        rowIt.next();//Skip first row
        while(rowIt.hasNext()){
            Row row = rowIt.next();//Current row
            if(isRowEmpty(row))//If row is empty, skip it
                 continue;
            Iterator<Cell> cellIt = row.cellIterator();
            // values.add(new ArrayList<String>());
            String name = cellIt.next().getStringCellValue();
            String first_last_name = cellIt.next().getStringCellValue();
            String second_last_name = cellIt.next().getStringCellValue();
            int student_id = (int)cellIt.next().getNumericCellValue();
            String class_name = cellIt.next().getStringCellValue();
            String class_id = cellIt.next().getStringCellValue();
            int student_attendance = (int)cellIt.next().getNumericCellValue();
            double grade = 0.0;
            int grades_count = 0;
            //Get grade
            double unit_grade = 0;
            while(cellIt.hasNext()){
                Cell cell = cellIt.next();
                if( cell.getCellType() != CellType.BLANK )
                    unit_grade = cell.getNumericCellValue();
                else
                    break;
                if( unit_grade < 70.0){ // INFO: Any grade lower than 70 is reprobatory
                    grade = 60.0;
                    break;
                }
                grade += unit_grade;
                grades_count++;
            }
            if(grades_count > 8) System.out.println("WARNING: More than 8 grades for student " + name + " " + first_last_name + " " + second_last_name);
            if(grade > 60.0) grade /= grades_count;
            inscriptions.add(new Inscription(name, first_last_name, second_last_name, student_id, class_name, class_id, student_attendance, grade));
            
        }
        //<--Get values of Excel file
        worksheet.close();
        f.close();
        return inscriptions;
    }
    public static List<Inscription> readCsv(File file) throws IOException {
        List<Inscription> inscriptions = new ArrayList<Inscription>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine(); //Read and ignore the first line
            // HashMap<String, List<String>> map = new HashMap<String, List<String>>();
            // for(String s : line.split(","))
            //     map.put(s, new ArrayList<String>());
            while((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                // ==> Get units grades
                List<Double> values = new ArrayList<Double>();
                for(int i = 7; i < fields.length; i++)
                    values.add(Double.parseDouble(fields[i]));
                if(values.size() > 8) System.out.println("WARNING: More than 8 grades for student " + fields[0] + " " + fields[1] + " " + fields[2] + " " + fields[3]);
                // <== Get units grades
                inscriptions.add(new Inscription(fields[0], fields[1], fields[2], Integer.valueOf(fields[3]), fields[4], fields[5], Integer.valueOf(fields[6]), avg(values)));
            }
        }catch(NullPointerException e){
            System.out.println("Error: " + e.getMessage());
            throw new IllegalArgumentException("Error: File has not the expected columns");
        }catch(NumberFormatException e){
            System.out.println("Error: " + e.getMessage());
            throw new IllegalArgumentException("Error: Expected a number in this column");
        }



        return inscriptions;
    }
    public static void write(File file, List<Student> students) throws Exception {
        String fileName = file.getName();
        if(fileName.endsWith(".xlsx"))
            writeExcel(file, students);
        else if(fileName.endsWith(".csv"))
            writeCsv(file, students);
        else
            throw new IllegalArgumentException("File format not supported");
    }
    public static void writeExcel(File file, List<Student> students) throws IOException {
        FileOutputStream f = new FileOutputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Students");
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("Name");
        cell = row.createCell(1);
        cell.setCellValue("First name");
        cell = row.createCell(2);
        cell.setCellValue("Second name");
        cell = row.createCell(3);
        cell.setCellValue("Student ID");
        cell = row.createCell(4);
        cell.setCellValue("Grade");
        cell = row.createCell(5);
        cell.setCellValue("Failed Subjects");
        for(Student student : students) {
            row = sheet.createRow(sheet.getPhysicalNumberOfRows());
            cell = row.createCell(0);
            cell.setCellValue(student.getStudent_name());
            cell = row.createCell(1);
            cell.setCellValue(student.getStudent_first_last_name());
            cell = row.createCell(2);
            cell.setCellValue(student.getStudent_second_last_name());
            cell = row.createCell(3);
            cell.setCellValue(student.getStudent_id());
            cell = row.createCell(4);
            cell.setCellValue(student.getGrade());
            cell = row.createCell(5);
            cell.setCellValue(student.getFailed_subjects());
        }
        workbook.write(f);
        workbook.close();
        f.close();
    }
    public static void writeCsv(File file, List<Student> students) throws IOException {
        FileOutputStream f = new FileOutputStream(file);
        PrintWriter writer = new PrintWriter(f);
        writer.println("Name,First last name,Second last name,Student ID,Grade,No Failed Subjects");
        for(Student student : students)
            writer.println(student.toCSV());
        writer.close();
        f.close();
    }
    private static double avg(List<Double> s){
        double sum = 0;
        for(Double d : s){
            if(d < 70.0)
                return 60.0;
            sum += d;
        }
        return sum / s.size();
    }
    private static boolean isRowEmpty(Row row){
        boolean isEmpty = true;
		DataFormatter dataFormatter = new DataFormatter();
		if (row != null) {
			for (Cell cell : row) {
				if (dataFormatter.formatCellValue(cell).trim().length() > 0) {
					isEmpty = false;
					break;
				}
			}
		}
		return isEmpty;
    }
    // private static boolean hasNotEmptyCells(Row row, int n_columns){
    //     boolean isEmpty = true;
    //     DataFormatter dataFormatter = new DataFormatter();
    //     if (row != null) {
    //         for (Cell cell : row) {
    //             if (dataFormatter.formatCellValue(cell).trim().length() > 0) {
    //                 isEmpty = false;
    //                 break;
    //             }
    //         }
    //     }
    //     return isEmpty;
    // }
}