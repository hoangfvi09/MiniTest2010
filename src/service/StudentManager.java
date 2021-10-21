package service;

import model.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class StudentManager implements Manageable<Student> {
    private ArrayList<Student> studentList = new ArrayList<>(10);

    public StudentManager() {
    }

    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    @Override
    public void print() {
        for (Student student : studentList) {
            System.out.println(student);
        }

    }

    @Override
    public Student findById(int id) {
        int index = findIndexById(id);
        return studentList.get(index);
    }

    @Override
    public void editById(int id, String name, int age, double average) {
        int index = findIndexById(id);
        studentList.get(index).setAverageMark(average);
        studentList.get(index).setName(name);
        studentList.get(index).setAge(age);


    }

    @Override
    public void removeById(int id) {
        int index = findIndexById(id);
        studentList.remove(index);

    }


    public void sortByAverageMark() {
        studentList.sort(Comparator.comparingDouble(Student::getAverageMark));

    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }


    public double calculateTotal() {
        double total = 0;
        for (Student student : studentList) {
            total += student.getAverageMark();
        }
        return total;
    }
}
