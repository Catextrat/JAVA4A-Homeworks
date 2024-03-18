import java.util.ArrayList;
import java.util.List;
import java.util.Date;
public class Course {
    private int courseId;
    private String courseName;
    private String instructor;
    private String description;
    private String category;
    private double price;
    private double rating;
    private ArrayList<String> content;
    private int numberOfStudents;
    private ArrayList<String> comments;
    private ArrayList<String> reviews;
    private String difficultyLevel;
    private String targetAudience;
    private Date startDate;
    private Date endDate;
    private boolean certificateAvailable;
    private List<String> videos;
    private List<String> documents;
    private List<String> exams;
    private List<String> assignments;

    public Course(int courseId, String courseName, String description, String category, String instructor, double price,
                  ArrayList<String> content, int numberOfStudents, ArrayList<String> comments, ArrayList<String> reviews,
                  String difficultyLevel, String targetAudience, Date startDate, Date endDate, boolean certificateAvailable, double rating) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.description = description;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.content = content;
        this.numberOfStudents = numberOfStudents;
        this.comments = comments;
        this.reviews = reviews;
        this.difficultyLevel = difficultyLevel;
        this.targetAudience = targetAudience;
        this.startDate = startDate;
        this.endDate = endDate;
        this.certificateAvailable = certificateAvailable;
        this.videos = new ArrayList<>();
        this.documents = new ArrayList<>();
        this.exams = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    // Getter ve setter metotları
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<String> getContent() {
        return content;
    }

    public void setContent(ArrayList<String> content) {
        this.content = content;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isCertificateAvailable() {
        return certificateAvailable;
    }

    public void setCertificateAvailable(boolean certificateAvailable) {
        this.certificateAvailable = certificateAvailable;
    }

    // Video koleksiyonu
    public List<String> getVideos() {
        return videos;
    }

    public void setVideos(List<String> videos) {
        this.videos = videos;
    }

    // Döküman koleksiyonu
    public List<String> getDocuments() {
        return documents;
    }

    public void setDocuments(List<String> documents) {
        this.documents = documents;
    }

    // Sınav koleksiyonu
    public List<String> getExams() {
        return exams;
    }

    public void setExams(List<String> exams) {
        this.exams = exams;
    }

    // Ödev koleksiyonu
    public List<String> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<String> assignments) {
        this.assignments = assignments;
    }

public void displayCourseInfo() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor: " + instructor);
        System.out.println("Description: " + description);
        System.out.println("Category: " + category);
        System.out.println("Price: $ " + price);
        System.out.println("Rating: " + rating);
    }

    public void enrollToCourse() {
        System.out.println("Enrolled in course: " + courseName);
    }
}
