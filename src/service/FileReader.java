package service;

import model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class FileReader {
    public static void addFromFile(ArrayList <Student> studentList, String filePath){
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new java.io.FileReader(filePath));
            br.readLine();

            while (( line=br.readLine()) != null) {
                printStudent(parseCsvLine(line));
                studentList.add(createStudentObject(parseCsvLine(line)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Student list added by creating objects and adding to arraylist: ");
        for(Student student:studentList){
            System.out.println(student);
        }
    }

    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(",");
            Collections.addAll(result, splitData);
        }
        return result;
    }

    private static void printStudent(List<String> student) {
        System.out.println(
                "Student [id= "
                        + student.get(0)
                        + ", name= " + student.get(1)
                        + " , age=" + student.get(2)
                        + " , average mark=" + student.get(3)
                        + "]");
    }

    private static Student createStudentObject(List<String> student){
        return new Student(parseInt(student.get(0)),student.get(1),parseInt(student.get(2)),parseDouble(student.get(3)));


    }


}
