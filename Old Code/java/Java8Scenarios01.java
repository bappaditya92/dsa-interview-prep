import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Scenarios01 {

    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(5, 10, 15, 20, 25, 30, 35, 40);

        List<String> words =
                Arrays.asList(
                        "java",
                        "spring",
                        "java",
                        "aws",
                        "docker",
                        "spring",
                        "kafka"
                );

        // 251 Running Sum
        List<Integer> runningSum = new ArrayList<>();
        final int[] sum = {0};

        numbers.forEach(n -> {
            sum[0] += n;
            runningSum.add(sum[0]);
        });

        System.out.println(runningSum);

        // 252 Percentage of Even Numbers
        double percentage =
                numbers.stream()
                        .filter(n -> n % 2 == 0)
                        .count() * 100.0 / numbers.size();

        System.out.println(percentage);

        // 253 Find Closest Number To 22
        int target = 22;

        Integer closest =
                numbers.stream()
                        .min(Comparator.comparingInt(
                                n -> Math.abs(n - target)))
                        .orElse(null);

        System.out.println(closest);

        // 254 Group Numbers By Odd/Even
        Map<String, List<Integer>> oddEven =
                numbers.stream()
                        .collect(Collectors.groupingBy(
                                n -> n % 2 == 0 ? "EVEN" : "ODD"));

        System.out.println(oddEven);

        // 255 Find Consecutive Pairs
        IntStream.range(0, numbers.size() - 1)
                .forEach(i ->
                        System.out.println(
                                numbers.get(i) + "," +
                                numbers.get(i + 1)));

        // 256 Find Missing Elements Between Min-Max
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);

        List<Integer> missing =
                IntStream.rangeClosed(min, max)
                        .filter(i -> !numbers.contains(i))
                        .boxed()
                        .collect(Collectors.toList());

        System.out.println(missing);

        // 257 Convert Words To Length Map
        Map<String, Integer> map =
                words.stream()
                        .distinct()
                        .collect(Collectors.toMap(
                                Function.identity(),
                                String::length));

        System.out.println(map);

        // 258 Sort By Last Character
        words.stream()
                .sorted(Comparator.comparing(
                        s -> s.charAt(s.length() - 1)))
                .forEach(System.out::println);

        // 259 Find Word With Most Vowels
        words.stream()
                .max(Comparator.comparingLong(
                        w -> w.chars()
                                .filter(c ->
                                        "aeiou".indexOf(c) >= 0)
                                .count()))
                .ifPresent(System.out::println);

        // 260 Count Total Vowels
        long vowels =
                words.stream()
                        .flatMapToInt(String::chars)
                        .filter(c ->
                                "aeiou".indexOf(c) >= 0)
                        .count();

        System.out.println(vowels);

        // 261 Find Longest Common Prefix
        List<String> prefixWords =
                Arrays.asList(
                        "flower",
                        "flow",
                        "flight"
                );

        String prefix = prefixWords.get(0);

        for(String word : prefixWords){
            while(!word.startsWith(prefix)){
                prefix =
                        prefix.substring(
                                0,
                                prefix.length()-1
                        );
            }
        }

        System.out.println(prefix);

        // 262 Count Words Ending With 'a'
        long ending =
                words.stream()
                        .filter(w -> w.endsWith("a"))
                        .count();

        System.out.println(ending);

        // 263 Find Duplicate Words
        words.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .forEach(System.out::println);

        // 264 Sort Frequency Desc
        words.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(
                        Map.Entry
                                .<String,Long>comparingByValue()
                                .reversed())
                .forEach(System.out::println);

        // 265 Find Most Frequent Word
        words.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // 266 Find Least Frequent Word
        words.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // 267 Chunk List Into Groups Of 3
        List<List<Integer>> chunks =
                IntStream.range(0,
                        (numbers.size()+2)/3)
                        .mapToObj(i ->
                                numbers.subList(
                                        i*3,
                                        Math.min(
                                                (i+1)*3,
                                                numbers.size())))
                        .collect(Collectors.toList());

        System.out.println(chunks);

        // 268 Reverse Words In Sentence
        String sentence =
                "Java Spring Boot";

        String reversed =
                Arrays.stream(sentence.split(" "))
                        .reduce((a,b) ->
                                b + " " + a)
                        .orElse("");

        System.out.println(reversed);

        // 269 Convert Numbers To Binary
        numbers.stream()
                .map(Integer::toBinaryString)
                .forEach(System.out::println);

        // 270 Find Sum Of Digits
        int number = 12345;

        int digitSum =
                String.valueOf(number)
                        .chars()
                        .map(c -> c - '0')
                        .sum();

        System.out.println(digitSum);
    }
}
