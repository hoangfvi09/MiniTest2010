import model.Person;
import model.Student;
import model.Teacher;
import service.PersonManager;
import service.TeacherManager;

public class Main {
    public static void main(String[] args) {
        PersonManager personManager = new PersonManager();
        personManager.add(new Student("Hu", 21, 0));
        personManager.add(new Teacher("Hu", 21, "English"));
        personManager.print();
        TeacherManager teacherManager = (TeacherManager) personManager;
    }
}
