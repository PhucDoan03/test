public class Student {
    protected String name;
    protected int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    //Setters and getters for name and age
    void setName(String name) {
        this.name = name;
    }
    String getName() {
        return name;
    }

    void setAge(int age) {
        this.age = age;
    }
    int getAge() {
        return age;
    }
}