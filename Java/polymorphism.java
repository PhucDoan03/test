class Student {
    private String name;
    private float gpa;

    Student(String name, float gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String enroll() {
        return "Name: " + name + "\tGPA: " + gpa;
    }
}

class Undergrad extends Student{
    private int age;

    Undergrad(String name, float gpa, int age) {
        super(name, gpa);
        this.age = age;
    }

    public String enroll() {
        return super.enroll() + "\tAge: " + age;
    }
}

class Grad extends Student{
    private String major;

    Grad(String name, float gpa, String major) {
        super(name, gpa);
        this.major = major;
    }

    public String enroll() {
        return super.enroll() + "\tMajor: " + major;
    }
}

public class polymorphism {
    public static void main(String[] args) {
        Student s1 = new Student("Tony", 3.0f);
        Student s2 = new Undergrad("John", 3.5f, 20);
        Student s3 = new Grad("Jane", 4.0f, "CS");

        System.out.println(s1.enroll());
        System.out.println(s2.enroll());
        System.out.println(s3.enroll());
    }
}