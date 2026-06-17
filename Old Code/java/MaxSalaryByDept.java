import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    String dept;
    int salary;

    Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String getDept() { return dept; }
    public int getSalary() { return salary; }
    public String getName() { return name; }
}

public class MaxSalaryByDept {
    public static void main(String[] args) {

        List<Employee> list = Arrays.asList(
                new Employee("A", "IT", 50000),
                new Employee("B", "IT", 80000),
                new Employee("C", "HR", 40000),
                new Employee("D", "HR", 60000)
        );

        Map<String, Employee> result =
                list.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDept,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                                        Optional::get
                                )
                        ));

        result.forEach((k, v) ->
                System.out.println(k + " -> " + v.getName()));
    }
}
