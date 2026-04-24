interface Workable {
    void work();
}

abstract class Employee implements Workable {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    // Abstract Method
    public abstract double calculateSalary();

    // Concrete Method
    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

// Child Class 1
class Developer extends Employee {
    private double baseSalary;
    private double bonus;

    public Developer(String name, int id, double baseSalary, double bonus) {
        super(name, id);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    // Method Overriding
    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }

    @Override
    public void work() {
        System.out.println(getName() + " is writing code.");
    }
}

// Child Class 2
class Manager extends Employee {
    private double salary;

    public Manager(String name, int id, double salary) {
        super(name, id);
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public void work() {
        System.out.println(getName() + " is managing the team.");
    }

    // Method Overloading
    public void work(String project) {
        System.out.println(getName() + " is managing project: " + project);
    }
}

// Main Class
public class OOPSExample {
    public static void main(String[] args) {

        // Runtime Polymorphism (Upcasting)
        Employee emp1 = new Developer("Alice", 101, 50000, 10000);
        Employee emp2 = new Manager("Bob", 102, 80000);

        emp1.displayInfo();
        emp1.work();
        System.out.println("Salary: " + emp1.calculateSalary());

        System.out.println("------------------");

        emp2.displayInfo();
        emp2.work();
        System.out.println("Salary: " + emp2.calculateSalary());

        System.out.println("------------------");

        // Downcasting for overloaded method
        Manager mgr = (Manager) emp2;
        mgr.work("AI Project");
    }
}
