package mypackage;

public class Program {
    public static void main(String[] args) {
        Undergrad s1 = new Undergrad("Sean", 8.0f, "IT");
        Undergrad s2 = new Undergrad("Tony", 9.0f, "CS");

        System.out.println("S1: " + s1.getName() + "\tGPA: " + s1.getGPA() + "\tMajor: " + s1.getMajor());
        System.out.println("S2: " + s2.getName() + "\tGPA: " + s2.getGPA() + "\tMajor: " + s2.getMajor());
    }
}
