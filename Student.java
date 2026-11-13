
import java.util.ArrayList;

public class Student extends Person {

    // Attributes
    private String studentID;
    private ArrayList<Course> enrolledCourses;

    // Constructor
    public Student(String studentID, String name, int age) {
        super(name, age);
        this.studentID = studentID;
        enrolledCourses = new ArrayList<Course>();
    }

    // Getter
    public String getStudentID() {
        return studentID;
    }

    // Setter
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    // Enroll a course
    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        System.out.println("Course enrolled successfully!");
    }

    // Display student details
    @Override
    public void displayDetails() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Student Name: " + getName());
        System.out.println("Student Age: " + getAge());

        System.out.println("Enrolled Courses:");

        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            for (Course course : enrolledCourses) {
                System.out.println(
                    course.getCourseCode() + " - "
                    + course.getCourseName()
                );
            }
        }
    }
}
