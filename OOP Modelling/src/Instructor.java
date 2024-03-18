import java.util.ArrayList;
import java.util.List;

public class Instructor {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String expertise;
    private List<Course> taughtCourses;
    private double earnings;
    private List<String> evaluations;
    private String resume;
    private String experience;
    private String education;
    private String contactInfo;
    private List<String> socialMediaProfiles;

    public Instructor(String username, String email, String password, String firstName, String lastName, String expertise) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.expertise = expertise;
        this.taughtCourses = new ArrayList<>();
        this.earnings = 0.0;
        this.evaluations = new ArrayList<>();
        this.resume = "";
        this.experience = "";
        this.education = "";
        this.contactInfo = "";
        this.socialMediaProfiles = new ArrayList<>();
    }

    // Getter ve setter metotları
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public List<Course> getTaughtCourses() {
        return taughtCourses;
    }

    public void setTaughtCourses(List<Course> taughtCourses) {
        this.taughtCourses = taughtCourses;
    }

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    public List<String> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<String> evaluations) {
        this.evaluations = evaluations;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<String> getSocialMediaProfiles() {
        return socialMediaProfiles;
    }

    public void setSocialMediaProfiles(List<String> socialMediaProfiles) {
        this.socialMediaProfiles = socialMediaProfiles;
    }
}

