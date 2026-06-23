import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8scenario {

    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80);

        List<String> words =
                Arrays.asList(
                        "java",
                        "spring",
                        "boot",
                        "microservices",
                        "aws",
                        "docker"
                );

        // 51 Check all numbers are even
        System.out.println("51");
        System.out.println(
                numbers.stream()
                        .allMatch(n -> n % 2 == 0)
        );

        // 52 Check any number greater than 50
        System.out.println("52");
        System.out.println(
                numbers.stream()
                        .anyMatch(n -> n > 50)
        );

        // 53 Check no negative numbers
        System.out.println("53");
        System.out.println(
                numbers.stream()
                        .noneMatch(n -> n < 0)
        );

        // 54 Find first number > 30
        System.out.println("54");
        numbers.stream()
                .filter(n -> n > 30)
                .findFirst()
                .ifPresent(System.out::println);

        // 55 Find random element
        System.out.println("55");
        numbers.stream()
                .findAny()
                .ifPresent(System.out::println);

        // 56 Convert list to set
        System.out.println("56");
        Set<Integer> set =
                numbers.stream()
                        .collect(Collectors.toSet());

        System.out.println(set);

        // 57 Convert set to list
        System.out.println("57");
        List<Integer> list =
                set.stream()
                        .collect(Collectors.toList());

        System.out.println(list);

        // 58 Count total elements
        System.out.println("58");
        System.out.println(
                numbers.stream().count()
        );

        // 59 Average of numbers
        System.out.println("59");
        System.out.println(
                numbers.stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0)
        );

        // 60 Square each number
        System.out.println("60");
        numbers.stream()
                .map(n -> n * n)
                .forEach(System.out::println);

        // 61 Cube each number
        System.out.println("61");
        numbers.stream()
                .map(n -> n * n * n)
                .forEach(System.out::println);

        // 62 Numbers greater than average
        System.out.println("62");

        double avg =
                numbers.stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0);

        numbers.stream()
                .filter(n -> n > avg)
                .forEach(System.out::println);

        // 63 Reverse sort
        System.out.println("63");
        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        // 64 Sort strings by length
        System.out.println("64");
        words.stream()
                .sorted(
                        Comparator.comparingInt(
                                String::length))
                .forEach(System.out::println);

        // 65 Longest string
        System.out.println("65");
        words.stream()
                .max(
                        Comparator.comparingInt(
                                String::length))
                .ifPresent(System.out::println);

        // 66 Shortest string
        System.out.println("66");
        words.stream()
                .min(
                        Comparator.comparingInt(
                                String::length))
                .ifPresent(System.out::println);

        // 67 Reverse strings
        System.out.println("67");
        words.stream()
                .map(s ->
                        new StringBuilder(s)
                                .reverse()
                                .toString())
                .forEach(System.out::println);

        // 68 First character frequency
        System.out.println("68");
        Map<Character, Long> result =
                words.stream()
                        .collect(
                                Collectors.groupingBy(
                                        s -> s.charAt(0),
                                        Collectors.counting()
                                ));

        System.out.println(result);

        // 69 Generate Fibonacci
        System.out.println("69");

        Stream.iterate(
                        new int[]{0, 1},
                        a -> new int[]{
                                a[1],
                                a[0] + a[1]
                        })
                .limit(10)
                .map(a -> a[0])
                .forEach(System.out::println);

        // 70 Prime numbers 1-50
        System.out.println("70");

        IntStream.rangeClosed(2, 50)
                .filter(n ->
                        IntStream.rangeClosed(
                                        2,
                                        (int) Math.sqrt(n))
                                .allMatch(
                                        i -> n % i != 0))
                .forEach(System.out::println);
    }
}
