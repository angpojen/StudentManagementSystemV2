
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    // Store students and courses
    static ArrayList<Student> students = new ArrayList<Student>();
    static ArrayList<Course> courses = new ArrayList<Course>();

    static Scanner scanner = new Scanner(System.in);

    // Main method
    public static void main(String[] args) {

        int choice = 0;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. View All Students");
            System.out.println("5. View All Courses");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
                continue;
            }

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    addCourse();
                    break;

                case 3:
                    enrollStudent();
                    break;

                case 4:
                    viewStudents();
                    break;

                case 5:
                    viewCourses();
                    break;

                case 6:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        scanner.close();
    }

    // Add student
    public static void addStudent() {

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        for (Student s : students) {
            if (s.getStudentID().equalsIgnoreCase(id)) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        int age;

        try {
            age = Integer.parseInt(scanner.nextLine());

            if (age <= 0) {
                System.out.println("Invalid age!");
                return;
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid age!");
            return;
        }

        Student student = new Student(id, name, age);
        students.add(student);

        System.out.println("Student added successfully!");
    }

    // Add course
    public static void addCourse() {

        System.out.print("Enter Course Code: ");
        String code = scanner.nextLine();

        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(code)) {
                System.out.println("Course already exists!");
                return;
            }
        }

        System.out.print("Enter Course Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Credit Hours: ");
        int credit;

        try {
            credit = Integer.parseInt(scanner.nextLine());

            if (credit <= 0) {
                System.out.println("Invalid credit hours!");
                return;
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
            return;
        }

        Course course = new Course(code, name, credit);
        courses.add(course);

        System.out.println("Course added successfully!");
    }

    // Enroll student in course
    public static void enrollStudent() {

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        Student selectedStudent = null;

        for (Student s : students) {
            if (s.getStudentID().equalsIgnoreCase(id)) {
                selectedStudent = s;
                break;
            }
        }

        if (selectedStudent == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter Course Code: ");
        String code = scanner.nextLine();

        Course selectedCourse = null;

        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(code)) {
                selectedCourse = c;
                break;
            }
        }

        if (selectedCourse == null) {
            System.out.println("Course not found!");
            return;
        }

        selectedStudent.enrollCourse(selectedCourse);
    }

    // View all students
    public static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");

        for (Person p : students) {
            p.displayDetails();
        }
    }

    // View all courses
    public static void viewCourses() {

        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        System.out.println("\n===== COURSE LIST =====");

        for (Course c : courses) {
            c.displayCourse();
            System.out.println("----------------------");
        }
    }
}
