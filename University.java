import java.util.*;
public class University
{   
    private String UniversityName;
    private List<Student> students;
    private List<Department> departments;
    private List<Faculty> facultys;

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

    public void getStudent()
    {   System.out.println("Displaying Student Details");
        for(Student stshow:students)
        {
            System.out.println(stshow.getName());
        }
    }

    public List<Department> getDept()
    {
        return departments;
    }
    
    public List<Faculty> getFaculty()
    {
        return facultys;
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
    
}
