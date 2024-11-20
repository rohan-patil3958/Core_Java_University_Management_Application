public class Course {
    private String courseName; // Name of the course
    private int courseId; // Unique ID for the course

    // Constructor to initialize the course ID and name
    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    // Getter for the course name
    public String getCourseName() {
        return courseName;
    }

    // Getter for the course ID
    public int getCourseId() {
        return courseId;
    }

    /**
     * Overrides the equals method to compare courses based on their IDs.
     * 
     * @param obj The object to compare with.
     * @return true if the course IDs are the same, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check if the objects are the same instance
        if (obj == null || getClass() != obj.getClass()) return false; // Check if the object is null or of a different class

        Course course = (Course) obj; // Cast the object to a Course
        return courseId == course.courseId; // Compare the course IDs
    }

    /**
     * Overrides the toString method to provide a string representation of the course.
     * 
     * @return A string containing the course ID and name.
     */
    @Override
    public String toString() {
        return "Course ID: " + courseId + ", Course Name: " + courseName;// this added for only testing purpose
    }
}
