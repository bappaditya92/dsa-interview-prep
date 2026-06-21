import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Interview30Scenarios {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(101, "Rahul", "IT", 80000, LocalDate.of(2023, 1, 10)),
                new Employee(102, "Amit", "HR", 50000, LocalDate.of(2024, 3, 15)),
                new Employee(103, "Priya", "IT", 90000, LocalDate.of(2022, 7, 20)),
                new Employee(104, "Neha", "Finance", 70000, LocalDate.of(2024, 2, 5)),
                new Employee(105, "Vikas", "HR", 60000, LocalDate.of(2021, 10, 12)),
                new Employee(106, "Ankit", "IT", 95000, LocalDate.of(2024, 4, 25)),
                new Employee(107, "Pooja", "Finance", 85000, LocalDate.of(2020, 6, 8)),
                new Employee(108, "Rakesh", "IT", 90000, LocalDate.of(2024, 1, 1))
        );

        List<Integer> numbers =
                Arrays.asList(1,2,3,4,5,6,2,3,4,7,8,9);

        // 1 Highest Salary
        employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);

        // 2 Second Highest Salary
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);

        // 3 Top 3 Salaries
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .forEach(System.out::println);

        // 4 Group By Department
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment)));

        // 5 Count By Department
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting())));

        // 6 Average Salary By Department
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(
                                        Employee::getSalary))));

        // 7 Department With Highest Avg Salary
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(
                                Employee::getSalary)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // 8 Partition Employees
        System.out.println(
                employees.stream()
                        .collect(Collectors.partitioningBy(
                                e -> e.getSalary() > 80000)));

        // 9 List To Map
        System.out.println(
                employees.stream()
                        .collect(Collectors.toMap(
                                Employee::getId,
                                Function.identity())));

        // 10 Sort By Name
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);

        // 11 Duplicate Numbers
        Set<Integer> unique = new HashSet<>();

        System.out.println(
                numbers.stream()
                        .filter(n -> !unique.add(n))
                        .collect(Collectors.toSet()));

        // 12 First Non Repeated Character
        String str = "swiss";

        Character ch =
                str.chars()
                        .mapToObj(c -> (char)c)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue() == 1)
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .orElse(null);

        System.out.println(ch);

        // 13 Character Frequency
        System.out.println(
                "programming".chars()
                        .mapToObj(c -> (char)c)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting())));

        // 14 Common Elements
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(3,4,5,6,7);

        System.out.println(
                list1.stream()
                        .filter(list2::contains)
                        .collect(Collectors.toList()));

        // 15 Merge Without Duplicates
        System.out.println(
                Stream.concat(list1.stream(), list2.stream())
                        .distinct()
                        .collect(Collectors.toList()));

        // 16 Optional Example
        String name =
                employees.stream()
                        .filter(e -> e.getId() == 999)
                        .findFirst()
                        .map(Employee::getName)
                        .orElse("Employee Not Found");

        System.out.println(name);

        // 17 Salary Greater Than Average
        double avg =
                employees.stream()
                        .mapToDouble(Employee::getSalary)
                        .average()
                        .orElse(0);

        employees.stream()
                .filter(e -> e.getSalary() > avg)
                .forEach(System.out::println);

        // 18 Department Wise Highest Salary
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.maxBy(
                                        Comparator.comparing(
                                                Employee::getSalary)))));

        // 19 Joined Current Year
        employees.stream()
                .filter(e ->
                        e.getJoiningDate().getYear() ==
                                LocalDate.now().getYear())
                .forEach(System.out::println);

        // 20 Missing Number
        int[] arr = {1,2,3,4,6,7};

        int missing =
                IntStream.rangeClosed(1,7).sum()
                        - Arrays.stream(arr).sum();

        System.out.println(missing);

        // 21 Odd Even Partition
        System.out.println(
                numbers.stream()
                        .collect(Collectors.partitioningBy(
                                n -> n % 2 == 0)));

        // 22 Longest String
        List<String> words =
                Arrays.asList(
                        "Java",
                        "SpringBoot",
                        "Microservices",
                        "AWS");

        System.out.println(
                words.stream()
                        .max(Comparator.comparingInt(
                                String::length))
                        .orElse(""));

        // 23 Duplicate Characters
        Set<Character> chars = new HashSet<>();

        "programming".chars()
                .mapToObj(c -> (char)c)
                .filter(c -> !chars.add(c))
                .distinct()
                .forEach(System.out::println);

        // 24 Reverse Each Word
        String sentence = "Java Stream API";

        System.out.println(
                Arrays.stream(sentence.split(" "))
                        .map(w ->
                                new StringBuilder(w)
                                        .reverse()
                                        .toString())
                        .collect(Collectors.joining(" ")));

        // 25 Names Starting With A
        employees.stream()
                .map(Employee::getName)
                .filter(n -> n.startsWith("A"))
                .forEach(System.out::println);

        // 26 Uppercase Strings
        System.out.println(
                words.stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.toList()));

        // 27 Remove Null Values
        List<String> data =
                Arrays.asList(
                        "Java",
                        null,
                        "Spring",
                        null,
                        "AWS");

        System.out.println(
                data.stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList()));

        // 28 Flatten Nested List
        List<List<Integer>> nested =
                Arrays.asList(
                        Arrays.asList(1,2),
                        Arrays.asList(3,4),
                        Arrays.asList(5,6));

        System.out.println(
                nested.stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList()));

        // 29 Palindrome Check
        String palindrome = "madam";

        System.out.println(
                palindrome.equals(
                        new StringBuilder(palindrome)
                                .reverse()
                                .toString()));

        // 30 Word Frequency
        String text =
                "java spring java aws spring java";

        System.out.println(
                Arrays.stream(text.split(" "))
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting())));
    }
}

class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;
    private LocalDate joiningDate;

    public Employee(int id, String name,
                    String department,
                    double salary,
                    LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.joiningDate = joiningDate;
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

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    @Override
    public String toString() {
        return id + " " + name + " " +
                department + " " + salary;
    }
}
