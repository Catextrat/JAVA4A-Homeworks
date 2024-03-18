import java.util.ArrayList;
import java.util.List;
public class Student {
    private int studentId;
    private String studentName;
    private String email;
    private List<Course> enrolledCourses;
    private List<Progress> progress;

    public Student (int studentId, String studentName, String email) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.enrolledCourses = new ArrayList<>();
        this.progress = new ArrayList<>();
    }

    public void enrollToCourses(Course course) {
        enrolledCourses.add(course);
        Progress newProgress = new Progress(course,0, false);
        progress.add(newProgress);
        System.out.println(studentName + "enrolled in course: " + course.getCourseName());
    }

    public void displayEnrolledCourses() {
        System.out.println("Courses enrolled by " + studentName + ":");
        for (Course course : enrolledCourses) {
            System.out.println("- " + course.getCourseName());
        }
    }

    public void getCourseInfo(Course course) {
        course.displayCourseInfo();
    }

    public List<Progress> getProgress() {
        return progress;
    }

    public void setProgress(List<Progress> progress) {
        this.progress = progress;
    }
}
