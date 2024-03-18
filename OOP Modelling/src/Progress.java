public class Progress {
    private Course course;
    private int completedPercentage; //Kurs tamamlama yüzdesi
    private boolean isCompleted; // Kurs tamamlandı mı?

    public Progress(Course course, int completedPercentage, boolean isCompleted) {
        this.course = course;
        this.completedPercentage = completedPercentage;
        this.isCompleted = isCompleted;
    }

    //Kursun tamamlanma yüzdesini artırma
    public void incrementCompletedPercentage(int incrementAmount) {
        this.completedPercentage += incrementAmount;
        if (this.completedPercentage >= 100) {
            this.completedPercentage =100;
            this.isCompleted = true;
        }
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getCompletedPercentage() {
        return completedPercentage;
    }

    public void setCompletedPercentage(int completedPercentage) {
        this.completedPercentage = completedPercentage;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
