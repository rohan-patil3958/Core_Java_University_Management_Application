import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Student {
    // Private fields for student details
    private int SId; // Student ID
    private String name; // Student name
    private List<Course> courseList; // List of courses the student is enrolled in
    private Map<Course, Integer> attendence; // Attendance percentage for each course
    private Map<Course, String> grades; // Grades for each course
    private Department department; // Department assigned to the student

    // Default constructor
    public Student() {
    }

    // Constructor to initialize student with ID and name
    public Student(int SId, String name) {
        this.SId = SId;
        this.name = name;
        this.courseList = new ArrayList<>(); // Initialize course list
        this.attendence = new HashMap<>(); // Initialize attendance map
        this.grades = new HashMap<>(); // Initialize grades map
    }

    // Add a course to the student's course list
    public void addCourse(Course course) {
        if (!courseList.contains(course)) {
            courseList.add(course); // Add course to the list
            attendence.put(course, 0); // Initialize attendance to 0
            grades.put(course, "not define"); // Initialize grade as "not define"
        } else {
            System.out.println("Student is already enrolled in this course.");
        }
    }

    // Get the student's grades for all courses
    public Map<Course, String> getGrades() {
        return grades;
    }

    // Get the student's attendance for all courses
    public Map<Course, Integer> getAttendence() {
        return attendence;
    }

    // Set attendance for a specific course
    public void setAttendence(Course course, int Presenty) {
        if (courseList.contains(course)) {
            this.attendence.put(course, Presenty); // Update attendance
        } else {
            System.out.println("Student is not enrolled in this course.");
        }
    }

    // Assign a grade to the student for a specific course
    public void assignGrade(Course course, String grade) {
        if (courseList.contains(course)) {
            this.grades.put(course, grade); // Update grade
        } else {
            System.out.println("Student is not enrolled in this course.");
        }
    }

    // Display student information, including courses, attendance, and grades
    public void displayStudentInfo() {
        System.out.println("ID of student: " + SId);
        System.out.println("Name of student: " + name);

        // Display the list of enrolled courses
        System.out.println("Enrolled Courses:");
        for (Course course : courseList) {
            System.out.println(course.getCourseName());
        }

        // Display attendance for each course
        System.out.print("Attendance: ");
        for (Course course : courseList) {
            System.out.print(course.getCourseName() + " : " + attendence.get(course) + " ");
        }
        System.out.println();

        // Display grades for each course
        System.out.print("Grades: ");
        for (Course course : courseList) {
            System.out.print(course.getCourseName() + " : " + grades.get(course) + " ");
        }
        System.out.println();

        // Display the department, if assigned
        if (department != null) {
            System.out.println("Department: " + department.getDeptName());
        } else {
            System.out.println("Department not assigned.");
        }
        System.out.println();
    }

    // Getter for student ID
    public int getSId() {
        return SId;
    }

    // Getter for student name
    public String getName() {
        return name;
    }

    // Getter for course list
    public List<Course> getCoList() {
        return courseList;
    }

    // Setter to assign a department to the student
    public void setDepartment(Department department) {
        this.department = department;
    }

    // Getter to retrieve the department of the student
    public Department getDepartment() {
        return department;
    }
}
