abstract class Student {
    public String enroll() {
        return "Students must enroll in classes";
    }
}

class UndergradStudent extends Student {
    public String enroll() {
        return "Undergraduate student enrolled in standard courses";
    }
}

class GradStudent extends Student {
    public String enroll() {
        return "Graduate student enrolled in specialized research courses";
    }
}

public class poly2 {
    public static void main(String[] args) {
        Student[] students = new Student[5];

        students[0] = new UndergradStudent();
        students[1] = new GradStudent();
        students[2] = new UndergradStudent();
        students[3] = new GradStudent();
        students[4] = new UndergradStudent();

        for (Student student : students) {
            System.out.println(student.enroll());
        }
    }
}
