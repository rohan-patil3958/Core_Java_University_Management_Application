import java.io.IOException;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        University un = new University("Rohan Patil Education Society");

        // Setup initial data
        Department cse = new Department(1, "CSE");
        Department mesa = new Department(2, "MESA");
        un.addDept(cse);
        un.addDept(mesa);

        Course math = new Course(1, "Math");
        Course digital = new Course(2, "Digital Course");
        // mesa.addCourse(math);
        // cse.addCourse(digital);

        Faculty f = new Faculty(1, "ABC", mesa);
        Faculty f1 = new Faculty(2, "PQR", cse);
        un.addFaculty(f);
        un.addFaculty(f1);

        Student s = new Student(1, "Rohan");
        s.addCourse(digital);
        s.assignGrade(digital, "A");
        s.setAttendence(digital, 75);
        un.addStudent(s);

        // Variables
        int selection = 0;
        boolean loop = true;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.println("Welcome to Nexon University");
                System.out.println("1. Create Account");
                System.out.println("2. Login into Existing Account");
                selection = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Input Mismatch! Enter Only Numbers: " + e);
                sc.nextLine(); // Clear the invalid input
                continue;
            }

            sc.nextLine(); // Consume newline character
            String cid, cpass;

            switch (selection) {
                case 1: // Account Creation
                    System.out.println("1. Create Account for Administrator");
                    System.out.println("2. Create Account for Faculty");
                    int select2 = sc.nextInt();
                    sc.nextLine();

                    switch (select2) {
                        case 1:
                            try {
                                System.out.println("Enter College ID as Username:");
                                cid = sc.nextLine();

                                System.out.println("Enter Password:");
                                cpass = sc.nextLine();

                                Authentication ac = new Authentication();
                                ac.createAc(cid, cpass);
                                System.out.println("Account Created Successfully!");
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        case 2:
                            try {
                                System.out.println("Enter College ID as Username:");
                                cid = sc.nextLine();

                                System.out.println("Enter Password:");
                                cpass = sc.nextLine();

                                FacAuthentication ac = new FacAuthentication();
                                ac.createAc(cid, cpass);
                                System.out.println("Account Created Successfully!");
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        default:
                            break;
                    }
                    break;

                case 2: // Login
                    System.out.println("1.Login Administration");
                    System.out.println("2.Login Faculty");
                    select2 = sc.nextInt();
                    sc.nextLine();

                    switch (select2) {
                        case 1:

                            System.out.println("Enter Username:");
                            cid = sc.nextLine();

                            System.out.println("Enter Password:");
                            cpass = sc.nextLine();

                            Authentication auth = new Authentication();
                            String res = auth.login(cid, cpass);

                            if (res.equals("Administration")) {
                                boolean isAuthenticated = true;

                                while (isAuthenticated) {
                                    try {
                                        System.out.println("Welcome!!");
                                        System.out.println("Enter choice to perform a task:");
                                        System.out.println("1. Add Department");
                                        System.out.println("2. Add Student");
                                        System.out.println("3. Add Faculty");
                                        System.out.println("4. View Students");
                                        System.out.println("5. View Departments");
                                        System.out.println("6. View Faculty");
                                        System.out.println("7. Exit to Login Menu");
                                        selection = sc.nextInt();
                                    } catch (Exception e) {
                                        System.out.println("Input Mismatch! Enter Numbers Only: " + e);
                                        sc.nextLine(); // Clear the invalid input
                                        continue;
                                    }

                                    switch (selection) {
                                        case 1: // Add Department
                                            System.out.println("You are in the Department Add Tab\n");
                                            System.out.println("Enter Department ID:");
                                            int did = sc.nextInt();
                                            sc.nextLine();

                                            System.out.println("Enter Department Name:");
                                            String dname = sc.nextLine();

                                            Department d = new Department(did, dname);
                                            boolean res1 = un.addDept(d);
                                            if (res1) {
                                                System.out.println("Department Added Successfully");
                                            } else {
                                                System.out.println("Department Already Exists");
                                            }
                                            break;

                                        case 2: // Add Student
                                            sc.nextLine();
                                            System.out.println("Enter Student ID:");
                                            int sid = sc.nextInt();
                                            sc.nextLine();

                                            System.out.println("Enter Student Name:");
                                            String sname = sc.nextLine();

                                            Student std = new Student(sid, sname);

                                            System.out.println("Enroll Courses to the Student");
                                            System.out.println("How many courses do you want to add?");
                                            int cno = sc.nextInt();
                                            sc.nextLine();

                                            for (int i = 1; i <= cno; i++) {
                                                System.out.println("Enter Course ID:");
                                                int coid = sc.nextInt();
                                                sc.nextLine();

                                                System.out.println("Enter Course Name:");
                                                String courseName = sc.nextLine();

                                                Course course = new Course(coid, courseName);
                                                std.addCourse(course);
                                            }

                                            List<Department> departments = un.getDept();
                                            System.out.println("Enter Department:");
                                            for (int i = 0; i < departments.size(); i++) {
                                                System.out.println(i + " " + departments.get(i).getDeptName());
                                            }
                                            int deptIndex = sc.nextInt();
                                            sc.nextLine();

                                            if (deptIndex < 0 || deptIndex >= departments.size()) {
                                                System.out.println("Invalid Selection");
                                            } else {
                                                Department selectedDept = departments.get(deptIndex);
                                                un.addStudentToDepartment(std, selectedDept);
                                                std.setDepartment(selectedDept);
                                            }

                                            un.addStudent(std);
                                            break;

                                        case 3: // Add Faculty
                                            System.out.println("You are in the Faculty Add Tab\n");
                                            System.out.println("Enter Faculty ID:");
                                            int fid = sc.nextInt();
                                            sc.nextLine();

                                            System.out.println("Enter Faculty Name:");
                                            String fname = sc.nextLine();

                                            departments = un.getDept();
                                            System.out.println("Select Department:");
                                            for (int i = 0; i < departments.size(); i++) {
                                                System.out.println(i + " " + departments.get(i).getDeptName());
                                            }
                                            deptIndex = sc.nextInt();
                                            sc.nextLine();

                                            if (deptIndex < 0 || deptIndex >= departments.size()) {
                                                System.out.println("Invalid Selection");
                                            } else {
                                                Department selectedDept = departments.get(deptIndex);
                                                Faculty faculty = new Faculty(fid, fname, selectedDept);
                                                un.addFaculty(faculty);
                                                System.out.println("Faculty Added Successfully");
                                            }
                                            break;

                                        case 4: // View Students
                                            un.getStudent();
                                            break;

                                        case 5: // View Departments
                                            un.ShowDept();
                                            break;

                                        case 6: // View Faculty
                                            un.getFaculty();
                                            break;

                                        case 7: // Exit to Login Menu
                                            isAuthenticated = false;
                                            break;

                                        default:
                                            System.out.println("Invalid Option! Please Try Again.");
                                            break;
                                    }
                                }
                            } else {
                                System.out.println("Credentials Mismatch!");
                            }
                            break;
                        case 2:
                            List<Department> departments = un.getDept();
                            System.out.println("Select Department:");
                            for (int i = 0; i < departments.size(); i++) {
                                System.out.println((i + 1) + ". " + departments.get(i).getDeptName());
                            }

                            int deptIndex = sc.nextInt() - 1; // Assume user enters valid input
                            sc.nextLine(); // Consume newline character

                            if (deptIndex >= 0 && deptIndex < departments.size()) {
                                Department selectedDept = departments.get(deptIndex);
                                System.out.println("Enter Username:");
                                cid = sc.nextLine();

                                System.out.println("Enter Password:");
                                cpass = sc.nextLine();

                                FacAuthentication auth2 = new FacAuthentication();
                                res = auth2.login(cid, cpass);

                                if (res.equals("fac")) {
                                    Faculty loggedInFaculty = new Faculty();
                                    loggedInFaculty.setDepartment(selectedDept); // Set the selected department for this
                                                                                 // faculty

                                    System.out
                                            .println("Welcome to " + selectedDept.getDeptName() + " Faculty Module\n");
                                    System.out.println("1. To View Students\t2. Set Attendance\t3.Assign");
                                    selection = sc.nextInt();

                                    switch (selection) {
                                        case 1:
                                            loggedInFaculty.MeStudents();
                                            break;
                                        case 2:// To Assign attendance

                                            sc.nextLine();
                                            System.out.println("Enter Student id to update attendance");
                                            int studid = sc.nextInt();
                                            sc.nextLine();
                                            System.out.println("Enter Course Name");
                                            String coname = sc.nextLine();
                                            System.out.println("Enter Attendence");
                                            int atten = sc.nextInt();
                                            break;

                                        case 3: // Assign Grade
                                            sc.nextLine(); // Consume newline character
                                            System.out.println("Enter Student ID to assign grade:");
                                            int studentId = sc.nextInt();
                                            sc.nextLine(); // Consume newline character

                                            // Now get the course name
                                            System.out.println("Enter Course Name:");
                                            String courseName = sc.nextLine();

                                            // Now get the grade
                                            System.out.println("Enter grade (A to D):");
                                            String grade = sc.nextLine();

                                            // Now call the Faculty method to assign the grade
                                            if (selectedDept != null) {
                                                loggedInFaculty = new Faculty(); // Assuming faculty is already logged
                                                                                 // in and selectedDept is set
                                                loggedInFaculty.assignGradeToStudent(studentId, courseName, grade,
                                                        selectedDept);
                                            } else {
                                                System.out.println("No department selected.");
                                            }
                                            break;

                                        case 4:
                                            selectedDept.show(1);

                                            break;
                                      
                                        // Implement other cases
                                        default:
                                            System.out.println("Invalid selection!");
                                    }
                                } else {
                                    System.out.println("Credentials Mismatch!");
                                }
                            } else {
                                System.out.println("Invalid department selection!");
                            }

                        default:
                            break;
                    }
                    break;

                default:
                    System.out.println("Invalid Option! Please Try Again.");
                    break;
            }
        } while (loop);
    }
}
