public class MainStudent {
    public static void main(String[] args) {
        UndergradStudent s1 = new UndergradStudent("Tom", 20, "CS");

        System.out.println("S1 - " + "Name: " + s1.getName() + "\tAge: " + s1.getAge() + "\tMajor: " + s1.getMajor());
    }
}