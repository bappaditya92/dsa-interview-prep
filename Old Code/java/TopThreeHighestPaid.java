import java.util.*;
import java.util.stream.Collectors;

class Employee {

    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    double getSalary() {
        return salary;
    }

    String getName() {
        return name;
    }
}

public class TopThreeHighestPaid {

    public static void main(String[] args) {

        List<Employee> list = Arrays.asList(
                new Employee(1, "Rahul", 50000),
                new Employee(2, "Amit", 90000),
                new Employee(3, "Neha", 70000),
                new Employee(4, "Priya", 120000),
                new Employee(5, "Vikash", 110000)
        );

        List<Employee> top3 = list.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());

        for (Employee e : top3) {
            System.out.println(e.getName() + " : " + e.getSalary());
        }
    }
}
