import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8AdditionalScenarios {

    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5, 6);

        List<String> names =
                Arrays.asList("Java", "Spring", "AWS", "Docker");

        List<Employee> employees = Arrays.asList(
                new Employee(101, "Rahul", "IT", 80000),
                new Employee(102, "Amit", "HR", 50000),
                new Employee(103, "Priya", "IT", 90000),
                new Employee(104, "Neha", "Finance", 70000),
                new Employee(105, "Vikas", "HR", 60000)
        );

        // 31 Sum using reduce
        System.out.println("31. Sum");
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);

        // 32 Maximum using reduce
        System.out.println("32. Maximum");
        Integer max = numbers.stream()
                .reduce(Integer::max)
                .orElse(0);
        System.out.println(max);

        // 33 Minimum using reduce
        System.out.println("33. Minimum");
        Integer min = numbers.stream()
                .reduce(Integer::min)
                .orElse(0);
        System.out.println(min);

        // 34 Concatenate strings
        System.out.println("34. Concatenate Strings");
        String result = names.stream()
                .reduce("", (a, b) -> a + " " + b);
        System.out.println(result);

        // 35 Number frequency
        System.out.println("35. Number Frequency");
        Map<Integer, Long> frequency =
                numbers.stream()
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()));
        System.out.println(frequency);

        // 36 Distinct numbers
        System.out.println("36. Distinct Numbers");
        System.out.println(
                numbers.stream()
                        .distinct()
                        .collect(Collectors.toList())
        );

        // 37 Elements appearing once
        System.out.println("37. Elements Appearing Once");
        numbers.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .forEach(System.out::println);

        // 38 Comma separated string
        System.out.println("38. Comma Separated");
        System.out.println(
                names.stream()
                        .collect(Collectors.joining(", "))
        );

        // 39 Sort Map By Key
        System.out.println("39. Sort Map By Key");
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "C");
        map.put(1, "A");
        map.put(2, "B");

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

        // 40 Sort Map By Value
        System.out.println("40. Sort Map By Value");
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

        // 41 First Element
        System.out.println("41. First Element");
        numbers.stream()
                .findFirst()
                .ifPresent(System.out::println);

        // 42 Skip First 2
        System.out.println("42. Skip First Two");
        numbers.stream()
                .skip(2)
                .forEach(System.out::println);

        // 43 Limit 3
        System.out.println("43. Limit Three");
        numbers.stream()
                .limit(3)
                .forEach(System.out::println);

        // 44 Check List Empty
        System.out.println("44. Check List Empty");
        boolean present =
                numbers.stream()
                        .findAny()
                        .isPresent();
        System.out.println(present);

        // 45 String Length List
        System.out.println("45. String Length List");
        List<Integer> lengths =
                names.stream()
                        .map(String::length)
                        .collect(Collectors.toList());
        System.out.println(lengths);

        // 46 Total Length
        System.out.println("46. Total Length");
        int totalLength =
                names.stream()
                        .mapToInt(String::length)
                        .sum();
        System.out.println(totalLength);

        // 47 Longest Employee Name
        System.out.println("47. Longest Employee Name");
        employees.stream()
                .max(Comparator.comparingInt(
                        e -> e.getName().length()))
                .ifPresent(System.out::println);

        // 48 Employee Names Uppercase
        System.out.println("48. Employee Names Uppercase");
        employees.stream()
                .map(Employee::getName)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // 49 Department Employee Count
        System.out.println("49. Department Count");
        Map<String, Long> deptCount =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()));

        System.out.println(deptCount);

        // 50 Department With Least Employees
        System.out.println("50. Department Least Employees");
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);
    }
}

class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name,
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
        return "Employee{id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary + '}';
    }
}
