import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + salary;
    }
}

public class CollectionDemo {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Rahul", 60000));
        employees.add(new Employee(102, "Amit", 45000));
        employees.add(new Employee(103, "Sneha", 75000));

        employees.sort(Comparator.comparingDouble(e -> e.salary));

        System.out.println("Sorted by Salary:");
        employees.forEach(System.out::println);

        System.out.println("\nSalary > 50000:");
        employees.stream()
                 .filter(e -> e.salary > 50000)
                 .forEach(System.out::println);

        Map<Integer, String> empMap = new HashMap<>();
        for (Employee e : employees) {
            empMap.put(e.id, e.name);
        }

        System.out.println("\nEmployee Map:");
        empMap.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
