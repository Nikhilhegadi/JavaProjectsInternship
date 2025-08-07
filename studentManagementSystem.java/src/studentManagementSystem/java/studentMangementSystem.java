package studentManagementSystem.java;

import java.util.HashMap;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private String course;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setCourse(String course) { this.course = course; }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }

    public void display() {
        System.out.println("ID     : " + id);
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Course : " + course);
    }
}

public class studentMangementSystem {
    private static HashMap<Integer, Student> students = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Remove Student");
            System.out.println("4. View Student Details");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1: addStudent(); break;
                case 2: updateStudent(); break;
                case 3: removeStudent(); break;
                case 4: viewStudent(); break;
                case 5: viewAllStudents(); break;
                case 6: System.out.println("Exiting system. Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);
    }

    private static void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = readInt();

        System.out.print("Enter course: ");
        String course = scanner.nextLine();

        Student student = new Student(nextId, name, age, course);
        students.put(nextId, student);
        System.out.println("Student added with ID: " + nextId);
        nextId++;
    }

    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = readInt();

        Student student = students.get(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new name (leave blank to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) student.setName(name);

        System.out.print("Enter new age (0 to keep current): ");
        int age = readInt();
        if (age > 0) student.setAge(age);

        System.out.print("Enter new course (leave blank to keep current): ");
        String course = scanner.nextLine();
        if (!course.isEmpty()) student.setCourse(course);

        System.out.println("Student updated successfully.");
    }

    private static void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        int id = readInt();

        if (students.remove(id) != null) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void viewStudent() {
        System.out.print("Enter student ID to view: ");
        int id = readInt();

        Student student = students.get(id);
        if (student != null) {
            System.out.println("\n--- Student Details ---");
            student.display();
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- All Students ---");
        for (Student student : students.values()) {
            System.out.println("----------------------------");
            student.display();
        }
    }

    private static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return val;
    }
}
