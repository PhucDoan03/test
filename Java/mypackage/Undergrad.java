package mypackage;

public class Undergrad extends Student1 {
    private String major;

    Undergrad() {}

    Undergrad(String name, float gpa, String major) {
        super(name, gpa);
        this.major = major;
    }

    // Setter and getter for major
    void setMajor(String major) {
        this.major = major;
    }

    String getMajor() {
        return major;
    }
}