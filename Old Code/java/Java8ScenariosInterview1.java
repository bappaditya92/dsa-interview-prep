import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8ScenariosInterview1 {

    public static void main(String[] args) {

        List<String> words = Arrays.asList(
                "java", "spring", "boot",
                "microservices", "aws",
                "docker", "kubernetes"
        );

        List<Integer> numbers = Arrays.asList(
                12, 45, 67, 23, 89, 34, 90, 11
        );

        // 231 Find Top 3 Largest Numbers
        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);

        // 232 Find Top 3 Smallest Numbers
        numbers.stream()
                .sorted()
                .limit(3)
                .forEach(System.out::println);

        // 233 Find Median
        List<Integer> sorted =
                numbers.stream()
                        .sorted()
                        .collect(Collectors.toList());

        int size = sorted.size();

        double median =
                (sorted.get(size / 2 - 1)
                        + sorted.get(size / 2)) / 2.0;

        System.out.println(median);

        // 234 Find Numbers Divisible By 3 and 5
        numbers.stream()
                .filter(n -> n % 3 == 0 && n % 5 == 0)
                .forEach(System.out::println);

        // 235 Find All Prime Numbers
        numbers.stream()
                .filter(n ->
                        n > 1 &&
                        java.util.stream.IntStream
                                .rangeClosed(2,
                                        (int) Math.sqrt(n))
                                .allMatch(i -> n % i != 0))
                .forEach(System.out::println);

        // 236 Find Longest Word
        words.stream()
                .max(Comparator.comparingInt(String::length))
                .ifPresent(System.out::println);

        // 237 Find Shortest Word
        words.stream()
                .min(Comparator.comparingInt(String::length))
                .ifPresent(System.out::println);

        // 238 Group Words By First Letter
        Map<Character, List<String>> grouped =
                words.stream()
                        .collect(Collectors.groupingBy(
                                s -> s.charAt(0)));

        System.out.println(grouped);

        // 239 Count Words By Length
        Map<Integer, Long> count =
                words.stream()
                        .collect(Collectors.groupingBy(
                                String::length,
                                Collectors.counting()));

        System.out.println(count);

        // 240 Convert List<String> To Map
        Map<String, Integer> lengthMap =
                words.stream()
                        .collect(Collectors.toMap(
                                Function.identity(),
                                String::length));

        System.out.println(lengthMap);

        // 241 Join Strings With Delimiter
        String joined =
                words.stream()
                        .collect(Collectors.joining(" | "));

        System.out.println(joined);

        // 242 Partition By Length > 5
        Map<Boolean, List<String>> partition =
                words.stream()
                        .collect(Collectors.partitioningBy(
                                s -> s.length() > 5));

        System.out.println(partition);

        // 243 Find Duplicate Characters
        String str = "programming";

        Set<Character> seen = new HashSet<>();

        str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !seen.add(c))
                .distinct()
                .forEach(System.out::println);

        // 244 Find Unique Characters
        str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .forEach(System.out::println);

        // 245 Find Character Frequency
        Map<Character, Long> freq =
                str.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()));

        System.out.println(freq);

        // 246 Sort Character Frequency Desc
        freq.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Long>
                        comparingByValue()
                        .reversed())
                .forEach(System.out::println);

        // 247 Find Most Frequent Character
        freq.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // 248 Find Least Frequent Character
        freq.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // 249 Create Immutable List
        List<String> immutable =
                Collections.unmodifiableList(words);

        System.out.println(immutable);

        // 250 Convert List To LinkedHashMap
        Map<Integer, String> linkedMap =
                java.util.stream.IntStream
                        .range(0, words.size())
                        .boxed()
                        .collect(Collectors.toMap(
                                i -> i,
                                words::get,
                                (a, b) -> a,
                                LinkedHashMap::new));

        System.out.println(linkedMap);
    }
}
