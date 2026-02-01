import java.util.*;
import java.util.stream.*;

class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " : " + salary;
    }
}

public class StreamEmployeeExample {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Rahul", 60000),
                new Employee("Amit", 40000),
                new Employee("Neha", 80000),
                new Employee("Sara", 50000)
        );

        // 1. Filter salary > 50k
        List<Employee> highSalary = employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .collect(Collectors.toList());

        System.out.println("High salary employees: " + highSalary);

        // 2. Average salary
        double avgSalary = employees.stream()
                .collect(Collectors.averagingInt(Employee::getSalary));

        System.out.println("Average salary: " + avgSalary);

        // 3. Highest salary employee
        Employee highest = employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);

        System.out.println("Highest salary: " + highest);
    }
}
