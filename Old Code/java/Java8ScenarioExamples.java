import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8ScenarioExamples {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(101, "Rahul", "IT", 80000),
                new Employee(102, "Amit", "HR", 50000),
                new Employee(103, "Priya", "IT", 90000),
                new Employee(104, "Neha", "Finance", 70000),
                new Employee(105, "Vikas", "HR", 60000),
                new Employee(106, "Ankit", "IT", 95000),
                new Employee(107, "Pooja", "Finance", 85000)
        );

        // 1. Highest Salary Employee
        System.out.println("=== Highest Salary Employee ===");
        employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);

        // 2. Second Highest Salary Employee
        System.out.println("\n=== Second Highest Salary Employee ===");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);

        // 3. Top 3 Highest Salaries
        System.out.println("\n=== Top 3 Highest Salaries ===");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .forEach(System.out::println);

        // 4. Group Employees By Department
        System.out.println("\n=== Employees Grouped By Department ===");
        Map<String, List<Employee>> deptMap =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));

        deptMap.forEach((dept, empList) -> {
            System.out.println(dept + " -> " + empList);
        });

        // 5. Count Employees By Department
        System.out.println("\n=== Employee Count By Department ===");
        Map<String, Long> countMap =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()));

        System.out.println(countMap);

        // 6. Average Salary By Department
        System.out.println("\n=== Average Salary By Department ===");
        Map<String, Double> avgSalary =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(avgSalary);

        // 7. Department With Highest Average Salary
        System.out.println("\n=== Department With Highest Average Salary ===");
        avgSalary.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // 8. Partition Employees By Salary > 80000
        System.out.println("\n=== Partition Employees ===");
        Map<Boolean, List<Employee>> partition =
                employees.stream()
                        .collect(Collectors.partitioningBy(
                                e -> e.getSalary() > 80000));

        System.out.println("Above 80000");
        partition.get(true).forEach(System.out::println);

        System.out.println("Below or Equal 80000");
        partition.get(false).forEach(System.out::println);

        // 9. Convert List To Map
        System.out.println("\n=== Employee Map ===");
        Map<Integer, Employee> employeeMap =
                employees.stream()
                        .collect(Collectors.toMap(
                                Employee::getId,
                                Function.identity()));

        employeeMap.forEach((id, emp) ->
                System.out.println(id + " -> " + emp));

        // 10. Sort By Name Then Salary
        System.out.println("\n=== Sorted By Name Then Salary ===");
        employees.stream()
                .sorted(
                        Comparator.comparing(Employee::getName)
                                .thenComparing(Employee::getSalary))
                .forEach(System.out::println);

        // 11. Duplicate Elements
        System.out.println("\n=== Duplicate Elements ===");
        List<Integer> numbers =
                Arrays.asList(1, 2, 3, 4, 2, 5, 6, 3, 7);

        Set<Integer> unique = new HashSet<>();

        Set<Integer> duplicates =
                numbers.stream()
                        .filter(n -> !unique.add(n))
                        .collect(Collectors.toSet());

        System.out.println(duplicates);

        // 12. First Non-Repeated Character
        System.out.println("\n=== First Non-Repeated Character ===");

        String input = "swiss";

        Character firstNonRepeated =
                input.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(entry -> entry.getValue() == 1)
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .orElse(null);

        System.out.println(firstNonRepeated);

        // 13. Character Frequency
        System.out.println("\n=== Character Frequency ===");

        String word = "programming";

        Map<Character, Long> frequency =
                word.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()));

        System.out.println(frequency);

        // 14. Common Elements Between Two Lists
        System.out.println("\n=== Common Elements ===");

        List<Integer> list1 =
                Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> list2 =
                Arrays.asList(3, 4, 5, 6, 7);

        List<Integer> common =
                list1.stream()
                        .filter(list2::contains)
                        .collect(Collectors.toList());

        System.out.println(common);

        // 15. Merge Lists Without Duplicates
        System.out.println("\n=== Merge Lists Without Duplicates ===");

        List<Integer> merged =
                Stream.concat(list1.stream(), list2.stream())
                        .distinct()
                        .collect(Collectors.toList());

        System.out.println(merged);

        // 16. Optional Example
        System.out.println("\n=== Optional Example ===");

        Optional<Employee> employee =
                employees.stream()
                        .filter(e -> e.getId() == 999)
                        .findFirst();

        String name =
                employee.map(Employee::getName)
                        .orElse("Employee Not Found");

        System.out.println(name);
    }
}

class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name,
                    String department, double salary) {
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
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
