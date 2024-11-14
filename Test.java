import java.io.IOException;
import java.util.*;
public class Test
{
    public static void main(String x[]) throws IOException
    {
        // Course c = new Course(1, "Math");
        // Course c1 = new Course(2, "Math");

        // Student s = new Student(1, "Rohan");

        // s.addCourse(c);
        // s.addCourse(c1);

        // s.assignGrade(c, "A");
        // s.assignGrade(c1,"B");
        // s.setAttendence(c, 75);
        // s.setAttendence(c1, 85);

        // s.displayStudentInfo();
        // s.removeCourse(c1);
        // List<Course> en = s.getCoList();
        // System.out.println("List of Subjects");
        // for(Course co :en)
        // {
        //     System.out.println(co.getCourseName());
        // }


        University un = new University("Rohan Patil Education Soceity");

        Department cse= new Department(1, "Cse");
        Department mesa=new Department(2, "Mesa");

        un.addDept(cse);
        un.addDept(mesa);

        Course math = new Course(1, "math");
        Course Digital = new Course(2, "Digital Course");

        mesa.addCourse(math);
        cse.addCourse(Digital);

        Faculty f = new Faculty(1, "ABC", mesa);
        Faculty f1 = new Faculty(2,"PQR",cse);

        un.addFaculty(f);
        un.addFaculty(f1);

        Student s = new Student(1,"Rohan");
        s.addCourse(Digital);
        s.assignGrade(Digital, "A");
        s.setAttendence(Digital, 75);

        un.addStudent(s);

        un.generateStudentReportForCourse(Digital);







        int selection=0;
        Scanner sc = new Scanner(System.in);
        try
        {
           
        System.out.println("Welcome to Nexon University");
        System.out.println("1.Create Account");
        System.out.println("2.Login into Existing Account");
            
        
        selection=sc.nextInt();
  
        }
        catch(Exception e)
        {
            System.out.println("Input Miss Match Enter Only Numbers " + e);
        }
      

        sc.nextLine();

        switch (selection) 
        {
            case 1:
                    String cid,cpass;
                 try
                 {
                    System.out.println("Enter Colleger Id as as Username");
                    cid=sc.nextLine();

                    System.out.println("Enter Password");
                    cpass=sc.nextLine();

                    Authentication ac = new Authentication();
                    ac.createAc(cid, cpass);

            }
            catch(Exception e)
            {
                System.out.println(e);
            }
                break;
            
                case 2:
                    System.out.println("Enter username");
                    cid=sc.nextLine();

                    System.out.println("Enter Password");
                    cpass=sc.nextLine();

                    Authentication auth = new Authentication();
                    boolean res=auth.login(cid,cpass);

                    if(res)
                    {   do
                        {
                        try
                        {
                        System.out.println("Welcome!!");
                        System.out.println("Enter choice to Perfrom Task");
                        System.out.println("1.To Add Student\t2.To Add Department\t3.To Add Faculty");
                        System.out.println("4.To View Students\t5.To View Departments\t6.To View Faculty");

                        selection=sc.nextInt();
                        }catch(Exception e)
                        {
                            System.out.println("Input Mismatch Enter Number Only "+e);
                        }

                        switch (selection) {
                            case 1:     
                                        sc.nextLine();
                                        System.out.println("Enter Student ID");
                                        int icol=sc.nextInt();
                                        
                                        System.out.println("Enter Student Name");
                                        String scol=sc.nextLine();

                                        sc.nextLine();

                                        Student std = new Student(icol, scol);

                                        System.out.println("Enroll Courses to The Student");
                                        System.out.println("How many course you want to add student");
                                        int cno=sc.nextInt();
                                        sc.nextLine();
                                     for(int i=1;i<=cno;i++)
                                     {
                                        System.out.println("Enter Course Id");
                                        int coid=sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("Enter Course Name");
                                        String coursename=sc.nextLine();

                                        Course course = new Course(coid, coursename);
                                        std.addCourse(course);
                                     }
                                     un.addStudent(std);
                                        
                                break;
                        case 2:
                                    System.out.println("You are in Department Add Tab\n\n");
                                    System.out.println("Enter Department Id");
                                    int did=sc.nextInt();
                                    sc.nextLine();

                                    System.out.println("Enter Department Name");
                                    String dname=sc.nextLine();

                                    
                                     Department d = new Department(did,dname);
                                     boolean res1=un.addDept(d);
                                    if(res1)
                                    {
                                        System.out.println("Deparment Added Successfully");
                                    }
                                    else
                                    {
                                        System.out.println("DepartMent Already Exist");
                                    }
                                    break;
                            
                            case 3:
                                    System.out.println("You Are in Faculty Add Tab\n");
                                    System.out.println("Enter Id Of Faculty");
                                    int fid = sc.nextInt();
                                    sc.nextLine();

                                    System.out.println("Enter Name of Faculty");
                                   String dpname= sc.nextLine();
                                    List<Department> departments = un.getDept();
                                    System.out.println("Select Department");
                                    for(int i=0;i<departments.size();i++)
                                    {
                                        System.out.println(i+" "+departments.get(i).getDeptName());
                                    }
                                    int deptIndex=sc.nextInt();
                                    sc.nextLine();

                                    if(deptIndex<0 || deptIndex>departments.size())
                                    {
                                        System.out.println("Invalid Selection");
                                    }
                                    else
                                    {
                                        Department selectedDept = departments.get(deptIndex);

                                        Faculty fu = new Faculty(fid, dpname, selectedDept);

                                        un.addFaculty(fu);
            
                                        System.out.println("Faculty Added SuccessFully");

                                    }
                                    break;
                            case 4:
                                    un.getStudent();
                                break;
                            default:
                                break;
                        }
                    }while(true);
                    }
                    else
                    {
                        System.out.println("Credentials Mismatch!!");
                    }
                        break;
        
            default:
                break;
        }
    
   
    }
}
