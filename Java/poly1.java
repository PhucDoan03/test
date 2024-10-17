import java.util.ArrayList;
import java.util.List;

class Animal {
    public String makeSound() {
        return "Some generic animal sound: ";
    }
}

class Dog extends Animal {
    @Override
    public String makeSound() {
        return "Bark";
    }
}

class Cat extends Animal {
    @Override
    public String makeSound() {
        return "Meow";
    }
}

class Cow extends Animal {
    @Override
    public String makeSound() {
        return "Moo";
    }
}

public class poly1 {
    public static void main(String[] args) {
        // Tạo danh sách chứa các đối tượng Animal, nhưng thực tế là Dog, Cat, Cow
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Cow());
        
        // Sử dụng vòng lặp để gọi phương thức makeSound() cho từng đối tượng
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
        }
    }
}
