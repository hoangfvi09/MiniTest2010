package menu;

import model.Student;

import service.StudentManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static StudentManager studentManager = new StudentManager();

    public static void showMenu() {
        System.out.println("_______________________________________________________________");
        System.out.println("Enter your selection:");
        System.out.println("0.Exit menu.");
        System.out.println("1. Add a new student.");
        System.out.println("2. Show all students.");
        System.out.println("3. Search for a student's position in the list by his/her id.");
        System.out.println("4. Remove a student from the list by his/her id.");
        System.out.println("5. Sort the list by the average mark.");
        System.out.println("6. Calculate total average mark.");
        System.out.println("7. Edit student's information by id.");
        System.out.println("________________________________________________________________");
    }

    public static void manageMenuSelection() {
        int selection=-1;
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                selection = scanner.nextInt();
            } catch (InputMismatchException e) {
                selection=-1;

            }finally {
                switch (selection) {
                    case 1 -> input();
                    case 2 -> showAll();
                    case 3 -> searchPosition();
                    case 4 -> removeFromTheList();
                    case 5 -> sort();
                    case 6 -> total();
                    case 7 -> edit();
                    default -> System.out.println("Not a valid selection.");
                }
                showMenu();
            }
        } while (selection != 0);
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student's name: ");
        String name = scanner.nextLine();
        System.out.println("Enter student's age:");
        int age = scanner.nextInt();
        System.out.println("Enter student's average mark:");
        double average = scanner.nextDouble();
        Student student = new Student(name, age, average);
        studentManager.add(student);
        showAll();
    }

    public static void showAll() {
        System.out.println("Student list:");
        studentManager.print();
    }

    public static void searchPosition() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student's id:");
        int id = scanner.nextInt();
        int index = studentManager.findIndexById(id);
        System.out.println("Student's at index " + index);
    }

    public static void removeFromTheList() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student's id:");
        int id = scanner.nextInt();
        studentManager.removeById(id);
        showAll();
    }

    public static void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student's id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter student's new name: ");
        String name = scanner.nextLine();
        System.out.println("Enter student's new age:");
        int age = scanner.nextInt();
        System.out.println("Enter student's new average mark:");
        double average = scanner.nextDouble();
        studentManager.editById(id, name, age, average);
        showAll();
    }

    public static void sort() {
        studentManager.sortByAverageMark();
        showAll();
    }

    public static void total() {
        System.out.println("Total average mark: " + studentManager.calculateTotal());
    }




}
