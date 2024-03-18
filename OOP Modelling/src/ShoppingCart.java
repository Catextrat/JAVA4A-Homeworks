import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Course> courses;

    public ShoppingCart() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course \"" + course.getCourseName() + "\" added to the shopping cart.");
    }

    public void removeCourse(Course course) {
        if (courses.remove(course)) {
            System.out.println("Course \"" + course.getCourseName() + "\" removed from the shopping cart.");
        } else {
            System.out.println("Course \"" + course.getCourseName() + "\" not found in the shopping cart.");
        }
    }

    public void displayCourses() {
        if (courses.isEmpty()) {
            System.out.println("Shopping cart is empty.");
        } else {
            System.out.println("Courses in the shopping cart:");
            for (Course course : courses) {
                System.out.println("- " + course.getCourseName() + ": $" + course.getPrice());
            }
        }
    }

    public void checkout() {
        double totalPrice = calculateTotalPrice();
        System.out.println("Total price: $" + totalPrice);
    }

    private double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Course course : courses) {
            totalPrice += course.getPrice();
        }
        return totalPrice;
    }
}
