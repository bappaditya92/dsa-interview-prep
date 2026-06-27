import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Scenarios211To230 {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1,"Rahul","IT",80000),
                new Employee(2,"Amit","IT",90000),
                new Employee(3,"Neha","HR",60000),
                new Employee(4,"Priya","HR",70000),
                new Employee(5,"Ankit","Finance",95000),
                new Employee(6,"Pooja","Finance",85000)
        );

        // 211 Department Wise Salary Sum
        Map<String, Double> deptSalary =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.summingDouble(
                                        Employee::getSalary)));

        System.out.println(deptSalary);

        // 212 Department Wise Average Salary
        Map<String, Double> avgSalary =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(
                                        Employee::getSalary)));

        System.out.println(avgSalary);

        // 213 Department Wise Highest Salary
        Map<String, Optional<Employee>> highest =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.maxBy(
                                        Comparator.comparing(
                                                Employee::getSalary))));

        System.out.println(highest);

        // 214 Department Wise Lowest Salary
        Map<String, Optional<Employee>> lowest =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.minBy(
                                        Comparator.comparing(
                                                Employee::getSalary))));

        System.out.println(lowest);

        // 215 Employee Count Per Department
        Map<String, Long> count =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()));

        System.out.println(count);

        // 216 Department Having Max Employees
        count.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // 217 Department Having Min Employees
        count.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // 218 Employee Names By Department
        Map<String,List<String>> empNames =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toList()
                                )));

        System.out.println(empNames);

        // 219 Top 2 Highest Salaries
        employees.stream()
                .sorted(
                        Comparator.comparing(
                                Employee::getSalary)
                                .reversed())
                .limit(2)
                .forEach(System.out::println);

        // 220 Bottom 2 Salaries
        employees.stream()
                .sorted(
                        Comparator.comparing(
                                Employee::getSalary))
                .limit(2)
                .forEach(System.out::println);

        // 221 Employees Salary > Average
        double avg =
                employees.stream()
                        .mapToDouble(Employee::getSalary)
                        .average()
                        .orElse(0);

        employees.stream()
                .filter(e -> e.getSalary() > avg)
                .forEach(System.out::println);

        // 222 Employees Salary < Average
        employees.stream()
                .filter(e -> e.getSalary() < avg)
                .forEach(System.out::println);

        // 223 Sort By Department Then Salary
        employees.stream()
                .sorted(
                        Comparator.comparing(
                                Employee::getDepartment)
                                .thenComparing(
                                        Employee::getSalary))
                .forEach(System.out::println);

        // 224 Department -> Total Salary
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summingDouble(
                                Employee::getSalary)))
                .forEach((k,v) ->
                        System.out.println(k+"="+v));

        // 225 Employee Name Length Map
        Map<String,Integer> map =
                employees.stream()
                        .collect(Collectors.toMap(
                                Employee::getName,
                                e -> e.getName().length()));

        System.out.println(map);

        // 226 Highest Paid Employee
        employees.stream()
                .max(Comparator.comparing(
                        Employee::getSalary))
                .ifPresent(System.out::println);

        // 227 Lowest Paid Employee
        employees.stream()
                .min(Comparator.comparing(
                        Employee::getSalary))
                .ifPresent(System.out::println);

        // 228 Group Employees By Salary Range
        Map<String,List<Employee>> salaryRange =
                employees.stream()
                        .collect(Collectors.groupingBy(e -> {

                            if(e.getSalary() < 70000)
                                return "LOW";

                            if(e.getSalary() < 90000)
                                return "MEDIUM";

                            return "HIGH";
                        }));

        System.out.println(salaryRange);

        // 229 Find Duplicate Employee Names
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getName,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .forEach(System.out::println);

        // 230 Create Department -> Employee Count Map
        Map<String,Integer> deptCount =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.counting(),
                                        Long::intValue)));

        System.out.println(deptCount);
    }
}

class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id,
                    String name,
                    String department,
                    double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " " + department + " " + salary;
    }
}
