import java.util.*;

public class Faculty {
    private int FacultyId; // Unique ID for the faculty member
    private String FacultyName; // Name of the faculty member
    private Department department; // The department to which the faculty belongs

    // Default constructor
    public Faculty() {
    }

    // Parameterized constructor to initialize faculty details
    public Faculty(int FacultyId, String FacultyName, Department department) {
        this.FacultyId = FacultyId;
        this.FacultyName = FacultyName;
        this.department = department;
    }

    // Getter for Faculty ID
    public int getFId() {
        return FacultyId;
    }

    // Getter for Faculty Name
    public String getFName() {
        return FacultyName;
    }

    // Getter for Department
    public Department getDepartment() {
        return department;
    }

    // Setter for Department
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Display details of students belonging to the faculty's department.
     * Shows their ID, name, department, and course-wise grades.
     */
    public void MeStudents() {
        // Get the list of students in the department
        List<Student> std = department.getStud();

        // Print the header for student details
        System.out.println("\nDisplaying Student Details:");
        System.out.printf("%-10s %-20s %-15s%n", "Student Id", "Student Name", "Department");
        System.out.println("------------------------------------------------------");

        // Iterate through each student and display details
        for (Student student : std) {
            String departmentName = (student.getDepartment() != null) ? student.getDepartment().getDeptName() : "No Department";

            // Print basic details of the student
            System.out.printf("%-10s %-20s %-15s%n", student.getSId(), student.getName(), departmentName);

            // Fetch and display the student's courses and grades
            Map<Course, String> gradeMap = student.getGrades();
            if (!student.getCoList().isEmpty()) {
                System.out.println("\n  Courses and Grades:");
                for (Course course : student.getCoList()) {
                    String grade = gradeMap.get(course); // Get grade for the course
                    System.out.printf("      - %-20s %-30s Grade: %s%n",
                            course.getCourseId(),
                            course.getCourseName(),
                            (grade != null ? grade : "No grade"));
                }
            } else {
                System.out.println("   No courses registered.");
            }

            System.out.println("------------------------------------------------------");
        }
    }

    /**
     * Update attendance for a student in a specific course.
     * @param studentid - ID of the student
     * @param course - Course object
     * @param attendence - Attendance value to be set
     */
    public void setAttendence(int studentid, Course course, int attendence) {
        // Find the student by ID within the department
        Student student = department.findstudById(studentid);

        if (student != null) {
            // Check if the student is enrolled in the given course
            if (student.getCoList().contains(course)) {
                student.setAttendence(course, attendence); // Update attendance
                System.out.println("Attendance updated successfully for " + student.getSId());
            } else {
                System.out.println("Student not enrolled in the specified course");
            }
        } else {
            System.out.println("Student not found in department");
        }
    }

    /**
     * Assign a grade to a student for a specific course.
     * @param studentId - ID of the student
     * @param courseName - Name of the course
     * @param grade - Grade to assign
     * @param department - The department to search in
     */
    public void assignGradeToStudent(int studentId, String courseName, String grade, Department department) {
        // Find the student by ID within the department
        Student student = department.findstudById(studentId);

        if (student != null) {
            // Find the course the student is enrolled in
            Course course = null;
            for (Course c : student.getCoList()) {
                if (c.getCourseName().equals(courseName)) {
                    course = c;
                    break;
                }
            }

            // If course is found, assign the grade
            if (course != null) {
                student.assignGrade(course, grade); // Assign grade to the student
                System.out.println("Grade " + grade + " assigned to " + student.getName() + " for " + course.getCourseName());
            } else {
                System.out.println("Course not found for student: " + student.getName());
            }
        } else {
            System.out.println("Student not found with ID: " + studentId);
        }
    }
}
