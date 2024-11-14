import java.util.ArrayList;
import java.util.List;
public class Department 
{
         private int DeptId;
         private String DeptName;
         List<Course> courses;

        public Department (int DeptId,String DeptName)
        {
            this.DeptId=DeptId;
            this.DeptName=DeptName;
            this.courses=new ArrayList<>();
        }

        public int getDeptId()
        {
            return DeptId;
        }
        public String getDeptName()
        {
            return DeptName;
        }
        public void addCourse(Course course)
        {
            courses.add(course);
        }
        public List<Course> getCourses()
        {
            return courses;
        }

}
