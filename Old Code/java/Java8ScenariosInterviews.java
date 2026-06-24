import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8ScenariosInterviews {

    public static void main(String[] args) {

        List<String> words = Arrays.asList(
                "java", "spring", "boot",
                "java", "aws", "docker", "aws"
        );

        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        // 71 Flatten Nested List
        System.out.println("71");
        nestedList.stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        // 72 Sum Nested List
        System.out.println("72");
        int sum = nestedList.stream()
                .flatMap(Collection::stream)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);

        // 73 Distinct Words
        System.out.println("73");
        words.stream()
                .distinct()
                .forEach(System.out::println);

        // 74 Count Distinct Words
        System.out.println("74");
        long count =
                words.stream()
                        .distinct()
                        .count();

        System.out.println(count);

        // 75 Duplicate Words
        System.out.println("75");
        Set<String> unique = new HashSet<>();

        words.stream()
                .filter(w -> !unique.add(w))
                .forEach(System.out::println);

        // 76 Word Frequency
        System.out.println("76");
        Map<String, Long> frequency =
                words.stream()
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()));

        System.out.println(frequency);

        // 77 Most Frequent Word
        System.out.println("77");
        frequency.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // 78 Least Frequent Word
        System.out.println("78");
        frequency.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // 79 Partition Numbers
        System.out.println("79");

        List<Integer> nums =
                Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        System.out.println(
                nums.stream()
                        .collect(Collectors.partitioningBy(
                                n -> n % 2 == 0))
        );

        // 80 Group Strings By Length
        System.out.println("80");

        System.out.println(
                words.stream()
                        .collect(Collectors.groupingBy(
                                String::length))
        );

        // 81 Joining Strings
        System.out.println("81");

        String joined =
                words.stream()
                        .distinct()
                        .collect(Collectors.joining(","));

        System.out.println(joined);

        // 82 Convert To Uppercase
        System.out.println("82");

        words.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // 83 Convert To Lowercase
        System.out.println("83");

        Arrays.asList("JAVA","SPRING","AWS")
                .stream()
                .map(String::toLowerCase)
                .forEach(System.out::println);

        // 84 Filter Strings > 4 Length
        System.out.println("84");

        words.stream()
                .filter(w -> w.length() > 4)
                .forEach(System.out::println);

        // 85 Count Characters
        System.out.println("85");

        int totalChars =
                words.stream()
                        .mapToInt(String::length)
                        .sum();

        System.out.println(totalChars);

        // 86 Optional Example
        System.out.println("86");

        Optional<String> name =
                Optional.ofNullable("Rahul");

        System.out.println(
                name.orElse("Unknown")
        );

        // 87 Optional Empty
        System.out.println("87");

        Optional<String> empty =
                Optional.empty();

        System.out.println(
                empty.orElse("Default Value")
        );

        // 88 Calculate Age
        System.out.println("88");

        LocalDate dob =
                LocalDate.of(1998, 5, 20);

        int age =
                Period.between(
                        dob,
                        LocalDate.now())
                        .getYears();

        System.out.println(age);

        // 89 Days Between Dates
        System.out.println("89");

        LocalDate start =
                LocalDate.of(2024,1,1);

        LocalDate end =
                LocalDate.of(2024,12,31);

        System.out.println(
                end.toEpochDay()
                        - start.toEpochDay()
        );

        // 90 Current Date Info
        System.out.println("90");

        LocalDate today =
                LocalDate.now();

        System.out.println(today);
        System.out.println(today.getDayOfWeek());
        System.out.println(today.getMonth());
    }
}
