import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8InterviewScenarios {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(101, "Rahul", "IT", 80000, LocalDate.of(2024, 1, 10)),
                new Employee(102, "Amit", "HR", 50000, LocalDate.of(2025, 3, 15)),
                new Employee(103, "Priya", "IT", 90000, LocalDate.of(2023, 7, 20)),
                new Employee(104, "Neha", "Finance", 70000, LocalDate.of(2025, 2, 5)),
                new Employee(105, "Vikas", "HR", 60000, LocalDate.of(2022, 10, 12)),
                new Employee(106, "Ankit", "IT", 95000, LocalDate.of(2025, 4, 25)),
                new Employee(107, "Pooja", "Finance", 85000, LocalDate.of(2021, 6, 8)),
                new Employee(108, "Rakesh", "IT", 90000, LocalDate.of(2025, 1, 1))
        );

        List<Integer> numbers =
                Arrays.asList(1,2,3,4,5,6,2,3,4,7,8,9);

        System.out.println("===== 1. Highest Salary =====");
        employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);

        System.out.println("\n===== 2. Second Highest Salary =====");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("\n===== 3. Top 3 Salaries =====");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\n===== 4. Group By Department =====");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((k,v)->System.out.println(k+"="+v));

        System.out.println("\n===== 5. Employee Count By Department =====");
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()))
        );

        System.out.println("\n===== 6. Average Salary By Department =====");
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)))
        );

        System.out.println("\n===== 7. Department With Highest Average Salary =====");
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        System.out.println("\n===== 8. Partition Employees Salary > 80000 =====");
        System.out.println(
                employees.stream()
                        .collect(Collectors.partitioningBy(
                                e -> e.getSalary() > 80000))
        );

        System.out.println("\n===== 9. List To Map =====");
        Map<Integer, Employee> empMap =
                employees.stream()
                        .collect(Collectors.toMap(
                                Employee::getId,
                                Function.identity()));
        System.out.println(empMap);

        System.out.println("\n===== 10. Sort By Name Then Salary =====");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName)
                        .thenComparing(Employee::getSalary))
                .forEach(System.out::println);

        System.out.println("\n===== 11. Duplicate Numbers =====");
        Set<Integer> unique = new HashSet<>();
        numbers.stream()
                .filter(n -> !unique.add(n))
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("\n===== 12. First Non-Repeated Character =====");
        String input = "swiss";

        Character first =
                input.chars()
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

        System.out.println(first);

        System.out.println("\n===== 13. Character Frequency =====");
        System.out.println(
                "programming".chars()
                        .mapToObj(c -> (char)c)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()))
        );

        System.out.println("\n===== 14. Common Elements =====");
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(3,4,5,6,7);

        System.out.println(
                list1.stream()
                        .filter(list2::contains)
                        .collect(Collectors.toList())
        );

        System.out.println("\n===== 15. Merge Lists Without Duplicates =====");
        System.out.println(
                Stream.concat(list1.stream(), list2.stream())
                        .distinct()
                        .collect(Collectors.toList())
        );

        System.out.println("\n===== 16. Optional Example =====");
        String name =
                employees.stream()
                        .filter(e -> e.getId() == 999)
                        .findFirst()
                        .map(Employee::getName)
                        .orElse("Employee Not Found");

        System.out.println(name);

        System.out.println("\n===== 17. 3rd Highest Salary =====");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(2)
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("\n===== 18. Salary Greater Than Average =====");
        double avg =
                employees.stream()
                        .mapToDouble(Employee::getSalary)
                        .average()
                        .orElse(0);

        employees.stream()
                .filter(e -> e.getSalary() > avg)
                .forEach(System.out::println);

        System.out.println("\n===== 19. Department Wise Highest Salary =====");
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.maxBy(
                                        Comparator.comparing(Employee::getSalary))))
        );

        System.out.println("\n===== 20. Department Wise Lowest Salary =====");
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.minBy(
                                        Comparator.comparing(Employee::getSalary))))
        );

        System.out.println("\n===== 21. Joined Current Year =====");
        employees.stream()
                .filter(e -> e.getJoiningDate().getYear()
                        == LocalDate.now().getYear())
                .forEach(System.out::println);

        System.out.println("\n===== 22. Missing Number =====");
        int[] arr = {1,2,3,4,6,7};
        int expected = IntStream.rangeClosed(1,7).sum();
        int actual = Arrays.stream(arr).sum();
        System.out.println(expected - actual);

        System.out.println("\n===== 23. Odd Even Partition =====");
        System.out.println(
                numbers.stream()
                        .collect(Collectors.partitioningBy(
                                n -> n % 2 == 0))
        );

        System.out.println("\n===== 24. Longest String =====");
        List<String> namesList =
                Arrays.asList("Java","SpringBoot","Microservices","AWS");

        System.out.println(
                namesList.stream()
                        .max(Comparator.comparing(String::length))
                        .orElse("")
        );

        System.out.println("\n===== 25. Duplicate Characters =====");
        Set<Character> chars = new HashSet<>();

        "programming".chars()
                .mapToObj(c -> (char)c)
                .filter(c -> !chars.add(c))
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n===== 26. Reverse Each Word =====");
        String sentence = "Java Stream API";

        String reversed =
                Arrays.stream(sentence.split(" "))
                        .map(w -> new StringBuilder(w).reverse().toString())
                        .collect(Collectors.joining(" "));

        System.out.println(reversed);

        System.out.println("\n===== 27. Names Starting With A =====");
        employees.stream()
                .map(Employee::getName)
                .filter(n -> n.startsWith("A"))
                .forEach(System.out::println);

        System.out.println("\n===== 28. Uppercase Strings =====");
        System.out.println(
                namesList.stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.toList())
        );

        System.out.println("\n===== 29. Salary Sum By Department =====");
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.summingDouble(Employee::getSalary)))
        );

        System.out.println("\n===== 30. Salary Range Count =====");
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(e -> {
                            if (e.getSalary() < 60000)
                                return "LOW";
                            else if (e.getSalary() <= 85000)
                                return "MEDIUM";
                            return "HIGH";
                        }, Collectors.counting()))
        );

        System.out.println("\n===== 31. Remove Null Values =====");
        List<String> data =
                Arrays.asList("Java", null, "Spring", null, "AWS");

        System.out.println(
                data.stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList())
        );

        System.out.println("\n===== 32. Flatten Nested List =====");
        List<List<Integer>> nested =
                Arrays.asList(
                        Arrays.asList(1,2),
                        Arrays.asList(3,4),
                        Arrays.asList(5,6));

        System.out.println(
                nested.stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList())
        );

        System.out.println("\n===== 33. Most Frequent Number =====");
        System.out.println(
                numbers.stream()
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .get()
                        .getKey()
        );

        System.out.println("\n===== 34. Palindrome =====");
        String str = "madam";
        System.out.println(
                str.equals(
                        new StringBuilder(str)
                                .reverse()
                                .toString())
        );

        System.out.println("\n===== 35. Group Anagrams =====");
        List<String> words =
                Arrays.asList("eat","tea","ate","tan","nat","bat");

        System.out.println(
                words.stream()
                        .collect(Collectors.groupingBy(word -> {
                            char[] c = word.toCharArray();
                            Arrays.sort(c);
                            return new String(c);
                        }))
        );

        System.out.println("\n===== 36. Employees Having Same Salary =====");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .forEach(System.out::println);

        System.out.println("\n===== 37. Last Element =====");
        System.out.println(
                numbers.stream()
                        .skip(numbers.size()-1)
                        .findFirst()
                        .orElse(null)
        );

        System.out.println("\n===== 38. Second Largest Number =====");
        System.out.println(
                numbers.stream()
                        .distinct()
                        .sorted(Comparator.reverseOrder())
                        .skip(1)
                        .findFirst()
                        .orElse(null)
        );

        System.out.println("\n===== 39. Total Characters =====");
        System.out.println(
                namesList.stream()
                        .mapToInt(String::length)
                        .sum()
        );

        System.out.println("\n===== 40. Department -> Employee Names =====");
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toList())))
        );
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
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
