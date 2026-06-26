import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8ScenariosForInterviews{

    public static void main(String[] args) {

        // 151 Count Total Digits In String
        String str = "Java123Spring456";

        long digitCount = str.chars()
                .filter(Character::isDigit)
                .count();

        System.out.println(digitCount);

        // 152 Count Total Alphabets
        long alphabetCount = str.chars()
                .filter(Character::isLetter)
                .count();

        System.out.println(alphabetCount);

        // 153 Count Special Characters
        long specialCount = str.chars()
                .filter(ch ->
                        !Character.isLetterOrDigit(ch))
                .count();

        System.out.println(specialCount);

        // 154 Find First Digit
        Character firstDigit = str.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isDigit)
                .findFirst()
                .orElse(null);

        System.out.println(firstDigit);

        // 155 Find Last Digit
        Character lastDigit = str.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isDigit)
                .reduce((a, b) -> b)
                .orElse(null);

        System.out.println(lastDigit);

        // 156 Convert String To List<Character>
        List<Character> chars =
                str.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toList());

        System.out.println(chars);

        // 157 Count Character Occurrence
        String word = "programming";

        Map<Character, Long> frequency =
                word.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()));

        System.out.println(frequency);

        // 158 Most Frequent Character
        frequency.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // 159 Least Frequent Character
        frequency.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // 160 Reverse Integer Digits
        int number = 12345;

        String reverse =
                new StringBuilder(
                        String.valueOf(number))
                        .reverse()
                        .toString();

        System.out.println(reverse);

        // 161 Check Armstrong Number
        int n = 153;

        int armstrong =
                String.valueOf(n)
                        .chars()
                        .map(c -> c - '0')
                        .map(d -> d * d * d)
                        .sum();

        System.out.println(armstrong == n);

        // 162 Generate Even Numbers
        IntStream.rangeClosed(1, 20)
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);

        // 163 Generate Odd Numbers
        IntStream.rangeClosed(1, 20)
                .filter(i -> i % 2 != 0)
                .forEach(System.out::println);

        // 164 Find Perfect Square Numbers
        IntStream.rangeClosed(1, 100)
                .filter(i ->
                        Math.sqrt(i)
                                == (int) Math.sqrt(i))
                .forEach(System.out::println);

        // 165 Find Numbers Ending With 5
        List<Integer> numbers =
                Arrays.asList(
                        15,20,25,35,40,55,67);

        numbers.stream()
                .filter(i ->
                        String.valueOf(i)
                                .endsWith("5"))
                .forEach(System.out::println);

        // 166 Convert List To String
        List<String> technologies =
                Arrays.asList(
                        "Java",
                        "Spring",
                        "AWS");

        String result =
                technologies.stream()
                        .collect(
                                Collectors.joining(
                                        " | "));

        System.out.println(result);

        // 167 Find Longest Word In Sentence
        String sentence =
                "Java Spring Boot Microservices AWS";

        Arrays.stream(sentence.split(" "))
                .max(Comparator.comparingInt(
                        String::length))
                .ifPresent(System.out::println);

        // 168 Find Shortest Word In Sentence
        Arrays.stream(sentence.split(" "))
                .min(Comparator.comparingInt(
                        String::length))
                .ifPresent(System.out::println);

        // 169 Sort Words By Length
        Arrays.stream(sentence.split(" "))
                .sorted(
                        Comparator.comparingInt(
                                String::length))
                .forEach(System.out::println);

        // 170 Group Words By Length
        Map<Integer, List<String>> grouped =
                Arrays.stream(sentence.split(" "))
                        .collect(Collectors.groupingBy(
                                String::length));

        System.out.println(grouped);
    }
}
