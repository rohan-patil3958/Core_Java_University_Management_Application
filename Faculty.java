public class Faculty 
{
        private int FacultyId;
        private String FacultyName;
        private Department department;
            public Faculty(int FacultyId,String FacultyName, Department department)
            {
                    this.FacultyId=FacultyId;
                    this.FacultyName=FacultyName;
                    this.department=department;
            }

            public int getFId()
            {
                return FacultyId;

            }
            public String getFName()
            {
                return FacultyName;
            }
            public Department getDept()
            {
                return department;
            }
}
