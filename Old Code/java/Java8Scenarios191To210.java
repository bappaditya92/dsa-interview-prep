import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Scenarios191To210 {

    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10, 20, 30, 40, 50, 60);

        List<String> names =
                Arrays.asList(
                        "Rahul",
                        "Amit",
                        "Priya",
                        "Neha",
                        "Ankit",
                        "Rahul"
                );

        // 191 Sum of First N Numbers
        int sum = numbers.stream()
                .reduce(Integer::sum)
                .orElse(0);

        System.out.println(sum);

        // 192 Average of Numbers
        double avg = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        System.out.println(avg);

        // 193 Partition Numbers > 30
        Map<Boolean, List<Integer>> partition =
                numbers.stream()
                        .collect(Collectors.partitioningBy(
                                n -> n > 30));

        System.out.println(partition);

        // 194 Group Names By First Character
        Map<Character, List<String>> grouped =
                names.stream()
                        .collect(Collectors.groupingBy(
                                s -> s.charAt(0)));

        System.out.println(grouped);

        // 195 Find Duplicate Names
        Set<String> unique = new HashSet<>();

        names.stream()
                .filter(name -> !unique.add(name))
                .forEach(System.out::println);

        // 196 Name Frequency
        Map<String, Long> frequency =
                names.stream()
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()));

        System.out.println(frequency);

        // 197 Longest Name
        names.stream()
                .max(Comparator.comparingInt(
                        String::length))
                .ifPresent(System.out::println);

        // 198 Shortest Name
        names.stream()
                .min(Comparator.comparingInt(
                        String::length))
                .ifPresent(System.out::println);

        // 199 Sort Names Ascending
        names.stream()
                .sorted()
                .forEach(System.out::println);

        // 200 Sort Names Descending
        names.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        // 201 Count Vowels In String
        String str = "Java Stream API";

        long vowels =
                str.toLowerCase()
                        .chars()
                        .filter(c ->
                                "aeiou".indexOf(c) >= 0)
                        .count();

        System.out.println(vowels);

        // 202 Count Consonants
        long consonants =
                str.toLowerCase()
                        .chars()
                        .filter(Character::isLetter)
                        .filter(c ->
                                "aeiou".indexOf(c) == -1)
                        .count();

        System.out.println(consonants);

        // 203 Reverse Words
        Arrays.stream(str.split(" "))
                .map(word ->
                        new StringBuilder(word)
                                .reverse()
                                .toString())
                .forEach(System.out::println);

        // 204 Sort Words Alphabetically
        Arrays.stream(str.split(" "))
                .sorted()
                .forEach(System.out::println);

        // 205 Sort Words By Length
        Arrays.stream(str.split(" "))
                .sorted(
                        Comparator.comparingInt(
