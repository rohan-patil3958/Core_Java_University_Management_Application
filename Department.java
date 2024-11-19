import java.util.ArrayList;
import java.util.List;
public class Department 
{
         private int DeptId;
         private String DeptName;
         List<Course> courses;
         List<Student> studadd;
        public Department(){
        
        }
        public Department (int DeptId,String DeptName)
        {
            this.DeptId=DeptId;
            this.DeptName=DeptName;
            this.courses=new ArrayList<>();
            this.studadd=new ArrayList();
        }

        public int getDeptId()
        {
            return DeptId;
        }
        public String getDeptName()
        {
            return DeptName;
        }

        public List<Course> getCourses()
        {
            return courses;
        }
        public void addStudent(Student student) {
            if (!studadd.contains(student)) {
                studadd.add(student);
                student.setDepartment(this); // Link the student back to the department
            }
        }
        
        public List<Student> getStud()
        {
            return studadd;
        }

        public Student findstudById(int studentid)
        {
            for(Student std:studadd)
            {
                if(std.getSId()==studentid)
                {
                    return std;
                }
            }
            return null;
        }
        public void show(int stuentid)
        {
                for(Student std:studadd)
                {
                    System.out.println(std.getSId()+""+std.getName());
                }
        }
        

}
