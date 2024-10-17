class Employees {
    protected String fullname;
    protected int age;
    protected double salary;

    Employees() {} //default constructor

    Employees(String fullname, int age, double salary) {
        this.fullname = fullname;
        this.age = age;
        this.salary = salary;
    }

    void setFullName(String fullname) {
        this.fullname = fullname;
    }
    String getFullName() {
        return fullname;
    }

    void setAge(int age) {
        this.age = age;
    }
    int getAge() {
        return age;
    }

    void setSalary(double salary) {
        this.salary = salary;
    }
    double getSalary() {
        return salary;
    }

    public void displayInfo() {
        System.out.println("Full name: " + fullname); 
        System.out.println("Age: " + age); 
        System.out.println("Salary: " + salary); 
    }
}

class Managers extends Employees {
    protected String department;

    Managers() {} //default constructor

    Managers(String fullname, int age, double salary, String department) {
        super(fullname, age, salary);
        this.department = department;
    }

    void setDepartment(String department) {
        this.department = department;
    }
    String getDepartment() {
        return department;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + department);
    }
}

class Developers extends Employees {
    protected String prolang;

    Developers() {} //default constructor

    Developers(String fullname, int age, double salary, String prolang) {
        super(fullname, age, salary);
        this.prolang = prolang;
    }

    void setProLang (String prolang) {
        this.prolang = prolang;
    }
    String getProLang() {
        return prolang;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Programming Languages: " + prolang);
    }
}

public class MainSystem {
    public static void main(String[] args) {
        Managers m = new Managers("John Doe", 40, 8000, "IT");
        System.out.println("Manager Information: ");
        m.displayInfo();

        Developers d = new Developers("Jane Smith", 30, 5000, "Java");
        System.out.println("\nDeveloper Information: ");
        d.displayInfo();
    }
}