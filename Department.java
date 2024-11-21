import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Department {
    private int DeptId; // Unique ID for the department
    private String DeptName; // Name of the department
    private List<Course> courses; // List of courses in the department
    private List<Student> studadd; // List of students in the department

    // Default constructor
    public Department() {
    }

    // Constructor to initialize department details
    public Department(int DeptId, String DeptName) {
        this.DeptId = DeptId;
        this.DeptName = DeptName;
        this.courses = new ArrayList<>(); // Initialize list of courses
        this.studadd = new ArrayList<>(); // Initialize list of students
    }

    // Getter for department ID
    public int getDeptId() {
        return DeptId;
    }

    // Getter for department name
    public String getDeptName() {
        return DeptName;
    }

    // Getter for list of courses in the department
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Adds a student to the department.
     * 
     * @param student The student to be added.
     */
    public void addStudent(Student student) {
        if (!studadd.contains(student)) { // Check if the student is not already in the list
            studadd.add(student); // Add the student to the department
            student.setDepartment(this); // Link the student back to this department
        }
    }

    // Getter for list of students in the department
    public List<Student> getStud() {
        return studadd;
    }

    /**
     * Finds a student in the department by their ID.
     * 
     * @param studentid The ID of the student to find.
     * @return The student object if found, otherwise null.
     */
    public Student findstudById(int studentid) {
       //Stream Api for code enhancement 
        return studadd.stream()
                        .filter(student->student.getSId()==studentid)
                        .findFirst()
                        .orElse(null);
    //     for (Student std : studadd) { // Loop through all students in the department
    //         if (std.getSId() == studentid) { // Check if the ID matches
    //             return std; // Return the matching student
    //         }
    //     }
    //     return null; // Return null if no matching student is found
     }
    

    
}
