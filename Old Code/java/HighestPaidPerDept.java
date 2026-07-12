import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return name + "(" + salary + ")";
    }
}

public class HighestPaidPerDept {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Alice", "Engineering", 95000),
            new Employee("Bob", "Engineering", 105000),
            new Employee("Carol", "Sales", 60000),
            new Employee("Dave", "Sales", 72000),
            new Employee("Eve", "HR", 55000)
        );

        Map<String, Optional<Employee>> result = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::department == null ? null : e -> e.department, // placeholder
                Collectors.maxBy(Comparator.comparingDouble(e -> e.salary))
            ));

        result.forEach((dept, emp) ->
            System.out.println(dept + " -> " + emp.get()));
    }
}
