public class TimeLimit {
    private int hours;
    private int minutes;

    // Constructor
    public TimeLimit(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    // Getter and setter methods
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
