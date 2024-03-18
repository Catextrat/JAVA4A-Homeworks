import java.util.ArrayList;
import java.util.Date;
public class User {
    private int userId;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private java.util.Date registrationDate;
    private String role;
    private ArrayList<Course> takenCourses;
    private ArrayList<Course> givenCourses;
    private ArrayList<String> comments;
    private ArrayList<String> reviews;
    private String phoneNumber;
    private String address;
    private String socialMediaProfiles;
    private String preferredlanguage;
    private String paymentInfo;

    public User(int userId, String username, String email, String password, String firstName, String lastName,
                Date registrationDate, String role, String phoneNumber, String address, String socialMediaProfiles,
                String preferredLanguage, String paymentInfo) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.socialMediaProfiles = socialMediaProfiles;
        this.preferredlanguage = preferredLanguage;
        this.paymentInfo = paymentInfo;
        this.takenCourses = new ArrayList<>();
        this.givenCourses = new ArrayList<>();
        this. comments = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

}
