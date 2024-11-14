import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
class Student
{
    private int SId;
    private String name;
    private List<Course>courseList;
    private Map<Course,Integer> attendence;
    private Map<Course,String> grades;

    public Student(int SId,String name)
    {
        this.SId=SId;
        this.name=name;
        this.courseList=new ArrayList();
        this.attendence=new HashMap();
        this.grades=new HashMap();
    }

    public void addCourse(Course course)
    {
            if(!courseList.contains(course))
            {
                courseList.add(course);
                attendence.put(course,0);
                grades.put(course,"not define");
            }
            else
            {
                    System.out.println("Student is already present");
            }
    }

    public void removeCourse(Course course)
    {
        if(courseList.contains(course))
        {
            courseList.remove(course);
            attendence.remove(course);
            grades.remove(course);
        }
        else
        {
            System.out.println("Student is not present");
        }
    }

    public Map<Course , String> getGrades()
    {
        return grades;
    }

    public void setAttendence(Course course,int Presenty)
    {
        if(courseList.contains(course))
        {
            this.attendence.put(course,Presenty);
        }
        else
        {
            System.out.println("Student is not present in course");
        }
    }

    public void assignGrade(Course course,String grade)
    {
        if(courseList.contains(course))
        {
            this.grades.put(course,grade);
        }
        else
        {
            System.out.println("Student is not present in course");
        }
    }

    public void displayStudentInfo()
    {
        System.out.println("ID of student:- "+SId);
        System.out.println("Name of student:- "+name);
        System.out.println("Enrolled Courses:- ");
        for(Course course:courseList)
        {
            System.out.println(course.getCourseName());
        }
        System.out.print("Attendence:-");
        for(Course course:courseList)
        {
            System.out.print(course.getCourseName()+" : "+attendence.get(course)+" ");
        }
        System.out.println("");
        System.out.print("Grades:-");
        for(Course course:courseList)
        {
            System.out.print(course.getCourseName()+" : "+grades.get(course)+" ");
        }
        System.out.println();
    }
        
    public int getSId()
    {
        return SId;
    }
    public String getName()
    {
        return name;
    }
    public List<Course> getCoList()
    {
        return courseList;
    }

}