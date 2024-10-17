public class UndergradStudent extends Student {
    private String major;

    UndergradStudent(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    //Setter and getter for major
    void setMajor(String major) {
        this.major = major;
    }
    String getMajor() {
        return major;
    }
}
