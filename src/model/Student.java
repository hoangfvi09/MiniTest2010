package model;

public class Student extends Person {
    private double averageMark;

    public Student() {
    }

    public Student(String name, int age, double averageMark) {
        super(name, age);
        this.averageMark = averageMark;
    }

    public Student(int id, String name, int age, double averageMark) {
        super(id, name, age);
        this.averageMark = averageMark;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public String toString() {
        return "Student: " +
                "id = " + super.getId() +
                ", name = " + super.getName() +
                ", age = " + super.getAge() +
                ", averageMark = " + averageMark;
    }
}
