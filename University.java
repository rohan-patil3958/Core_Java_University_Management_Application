import java.util.*;

public class University {
    // Fields to store the university name, students, departments, and faculties
    private String UniversityName;
    private List<Student> students;
    private List<Department> departments;
    private List<Faculty> facultys;

    // Default constructor
    public University() {
    }

    // Constructor to initialize the university with a name and empty lists
    public University(String UniversityName) {
        this.UniversityName = UniversityName;
        this.students = new ArrayList<>();
        this.departments = new ArrayList<>();
        this.facultys = new ArrayList<>();
    }

    // Add a student to the university's student list
    public void addStudent(Student student) {
        students.add(student);
    }

    // Add a department to the university
    // Returns false if a department with the same ID already exists
    public boolean addDept(Department department) {
        for (Department existingdept : departments) {
            if (department.getDeptId() == existingdept.getDeptId()) {
                return false; // Department ID already exists
            }
        }
        return departments.add(department); // Add the department if it's new
    }

    // Add a faculty member to the university's faculty list
    public void addFaculty(Faculty faculty) {
        facultys.add(faculty);
    }

    // Display the list of students with their details and courses
    public void getStudent() {
        System.out.println("\nDisplaying Student Details:");
        System.out.printf("%-10s %-20s %-15s%n", "Student Id\t", "Student Name\t", "Department");
        System.out.println("------------------------------------------------------");

        for (Student student : students) {
            // Get the student's department name or "No Department" if not assigned
            String departmentName = (student.getDepartment() != null) ? student.getDepartment().getDeptName()
                    : "No Department";

            // Print student details
            System.out.printf("%-10s %-20s %-15s%n", "     " + student.getSId(), "      " + student.getName(),
                    "      " + departmentName);

            // Print student's courses
            if (student.getCoList().isEmpty()) {
                System.out.println("   No courses registered.");
            } else {
                System.out.println("  \n Courses:");
                for (Course course : student.getCoList()) {
                    System.out.println("      - " + course); // Assuming Course.toString() provides course details
                }
            }
            System.out.println("------------------------------------------------------");
            System.out.println();
        }
    }

    // Get the list of all students
    public List<Student> getStInfo() {
        return students;
    }

    // Get the list of all departments
    public List<Department> getDept() {
        return departments;
    }

    // Display all departments with their IDs and names
    public void ShowDept() {
        System.out.println("------------------------------------------------------");
        System.out.println("Department ID\tDepartment Name");
        System.out.println("------------------------------------------------------");
        for (Department deptInfo : departments) {
            System.out.println("   " + deptInfo.getDeptId() + "\t\t    " + deptInfo.getDeptName());
        }
        System.out.println("------------------------------------------------------");
        System.out.println();
    }

    // Display the list of all faculties with their details
    public void getFaculty() {
        System.out.println("------------------------------------------------------");
        System.out.println("Faculty Id\tFaculty Name\tFaculty Department");
        System.out.println("------------------------------------------------------");
        for (Faculty finfo : facultys) {
            System.out.println("     " + finfo.getFId() + " \t\t    " + finfo.getFName() + "\t\t      "
                    + finfo.getDepartment().getDeptName());
        }
        System.out.println("------------------------------------------------------");
        System.out.println();
    }

    // Get the university name
    public String getUnName() {
        return UniversityName;
    }

    // Add a student to a department and to the central university record
    public void addStudentToDepartment(Student student, Department department) {
        if (!departments.contains(department)) {
            System.out.println("DEBUG: Department not found in university.");
            return; // Exit if the department doesn't exist in the university
        }
        department.addStudent(student); // Add the student to the department
        students.add(student); // Add the student to the university's central list
        System.out.println("Student added to department and university.");
    }
}
