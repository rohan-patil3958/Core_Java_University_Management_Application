import java.util.*;
public class University
{   
    private String UniversityName;
    private List<Student> students;
    private List<Department> departments;
    private List<Faculty> facultys;
    public University(){}
    public University(String UniversityName)
    {
        this.UniversityName = UniversityName;
        this.students=new ArrayList<>();
        this.departments=new ArrayList<>();
        this.facultys=new ArrayList<>();
    }

    public void addStudent(Student student)
    {
        students.add(student);
    }
    
    public boolean addDept(Department department)
    {   
        for(Department existingdept:departments)
        {
            if(department.getDeptId()==existingdept.getDeptId())
            {
                return false;
            }
           
        }
        return  departments.add(department);
    }

    public void addFaculty(Faculty faculty)
    {   
       
        facultys.add(faculty);
    }

    public void getStudent() {
        System.out.println("\nDisplaying Student Details:");
        System.out.printf("%-10s %-20s %-15s%n", "Student Id\t", "Student Name\t", "Department");
        System.out.println("------------------------------------------------------");
    
        for (Student student : students) {
            String departmentName = (student.getDepartment() != null) ? student.getDepartment().getDeptName() : "No Department";
            System.out.printf("%-10s %-20s %-15s%n","     " +student.getSId(),"      "+ student.getName(),"      "+ departmentName);
    
            if (student.getCoList().isEmpty()) {
                System.out.println("   No courses registered.");
            } else {
                System.out.println("  \n Courses:");
                for (Course course : student.getCoList()) {
                    System.out.println("      - " + course); // Assuming Course.toString() gives course details.
                }
            }
            System.out.println("------------------------------------------------------");
            System.out.println();
        }
    }
    public List<Student> getStInfo()
    {
        return students;
    }
    
    

    public List<Department> getDept()
    {
        return departments;
    }
    public void ShowDept()
    {   
        System.out.println("------------------------------------------------------");
        System.out.println("Department ID\tDepartment Name");
        System.out.println("------------------------------------------------------");
        for(Department deptInfo:departments)
        {
            System.out.println("   "+deptInfo.getDeptId()+"\t\t    "+deptInfo.getDeptName());
        }
        System.out.println("------------------------------------------------------");
        System.out.println();
    }
    public void getFaculty()
    {
        System.out.println("------------------------------------------------------");
        System.out.println("Faculty Id\tFaculty Name\tFaculty Department");
        System.out.println("------------------------------------------------------");
       for(Faculty finfo :facultys)
       {
            System.out.println("     "+finfo.getFId()+" \t\t    "+finfo.getFName()+"\t\t      "+finfo.getDepartment().getDeptName());
       }
       System.out.println("------------------------------------------------------");
       System.out.println();
    }
    public String getUnName()
    {
        return UniversityName;
    }

    public void generateStudentReportForCourse(Course course) {
        for (Student student : students) {
            if (student.getCoList().contains(course)) {
                System.out.println("Student: " + student.getName() + ", Grade: " + student.getGrades().get(course));
            }
        }
    }
    public void addStudentToDepartment(Student student, Department department) {
        if (!departments.contains(department)) {
            System.out.println("DEBUG: Department not found in university.");
            return;
        }
        department.addStudent(student); // Add student to department
        students.add(student);          // Keep a central record of students
        System.out.println("Student added to department and university.");
    }
    
    
    public void show()
    { 
        
    }
    
}
