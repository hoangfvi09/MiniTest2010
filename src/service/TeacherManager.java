package service;

import model.Teacher;

import java.util.ArrayList;

public class TeacherManager extends PersonManager {
    public ArrayList<Teacher> findBySubjectName(String subject) {
        ArrayList<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < super.getPeople().size(); i++) {
            Teacher teacher = (Teacher) super.getPeople().get(i);
            if (teacher.getSubject().equals(subject)) {
                teachers.add(teacher);
            }
        }
        return teachers;
    }
}
