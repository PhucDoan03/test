import java.util.Scanner;

class Student {
    // Static variables
    private static int studentCount = 0;
    private static double totalGPA = 0.0;

    // Instance variables
    private int studentID;
    private String name;
    private double gpa;

    Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
        studentCount++;
        this.studentID = studentCount;
        totalGPA += gpa;
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public static double getAverageGPA() {
        if (studentCount == 0) {
            return 0.0;
        }
        return totalGPA / studentCount;
    }

    public void displayStudentInfo() {
        System.out.println("StudentID: " + studentID);
        System.out.println("StudentName: " + name);
        System.out.println("StudentGPA: " + gpa);
    }
}

public class static1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name of the 1st student: ");
        String name1 = sc.nextLine();
        System.out.println("Enter the GPA of the 1st student: ");
        double gpa1 = sc.nextDouble();
        sc.nextLine();
        Student stu1 = new Student(name1, gpa1);

        System.out.println("Enter the name of the 2nd student: ");
        String name2 = sc.nextLine();
        System.out.println("Enter the GPA of the 2nd student: ");
        double gpa2 = sc.nextDouble();
        sc.nextLine();
        Student stu2 = new Student(name2, gpa2);

        System.out.println("\nStudent 1 Info: ");
        stu1.displayStudentInfo();

        System.out.println("\nStudent 2 Info: ");
        stu2.displayStudentInfo();

        System.out.println("\nTotal number of students: " + Student.getStudentCount());
        System.out.println("Average GPA: " + Student.getAverageGPA());

        sc.close();
    }
}
