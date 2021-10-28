package service;

import model.Student;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWriter {
    public static void write(ArrayList <Student> students, String filePath){

        try {
            java.io.FileWriter writer = new java.io.FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String str="";
            for(Student student: students){
                str+=student+"\n";
            }
            bufferedWriter.write(str);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
