public class Course 
{
    private String courseName;
    private int courseId;
        Course(int courseId,String courseName)
        {
           this.courseId=courseId;
            this.courseName=courseName;
        }
        public String getCourseName()
        {
            return courseName;
        }

        public boolean equals(Object obj)
        {
            if(this==obj) return true;
            if(obj==null || getClass()!=obj.getClass()) return false;

            Course course=(Course) obj;

            return courseId==course.courseId;
        }

        public String toString() {
            return "Course ID: " + courseId + ", Course Name: " + courseName;
        }

}
