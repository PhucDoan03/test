package mypackage;

public class Student1 {
    protected String name;
    protected float gpa;

    Student1() {} // Student's default constructor

    Student1(String name, float gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    // Setter and getter for name
    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    // Setter and getter for GPA
    void setGPA(float gpa) {
        this.gpa = gpa;
    }

    float getGPA() {
        return gpa;
    }
}