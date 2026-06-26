import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Scenarios1 {

    public static void main(String[] args) {

        // 171 Find Second Smallest Number
        List<Integer> nums = Arrays.asList(8,3,5,1,9,2);

        Integer secondSmallest = nums.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println(secondSmallest);

        // 172 Find Third Largest Number
        Integer thirdLargest = nums.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .orElse(null);

        System.out.println(thirdLargest);

        // 173 Count Numbers Greater Than 5
        long count = nums.stream()
                .filter(n -> n > 5)
                .count();

        System.out.println(count);

        // 174 Convert Integer List To String List
        List<String> stringList = nums.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(stringList);

        // 175 Find Duplicate Strings
        List<String> words =
                Arrays.asList("Java","Spring",
                        "Java","AWS","AWS");

        Set<String> unique = new HashSet<>();

        words.stream()
                .filter(w -> !unique.add(w))
                .forEach(System.out::println);

        // 176 Find Non-Repeated Strings
        words.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .forEach(System.out::println);

        // 177 Find Current Month Name
        System.out.println(
                LocalDate.now().getMonth()
        );

        // 178 Check Leap Year
        System.out.println(
                LocalDate.now().isLeapYear()
        );

        // 179 Find Total Days In Current Month
        System.out.println(
                LocalDate.now().lengthOfMonth()
        );

        // 180 Get Month Enum Values
        Arrays.stream(Month.values())
                .forEach(System.out::println);

        // 181 Convert Array To Stream
        int[] arr = {1,2,3,4,5};

        Arrays.stream(arr)
                .forEach(System.out::println);

        // 182 Sum Array Elements
        int sum = Arrays.stream(arr)
                .sum();

        System.out.println(sum);

        // 183 Average Array Elements
        double avg = Arrays.stream(arr)
                .average()
                .orElse(0);

        System.out.println(avg);

        // 184 Maximum Array Element
        int max = Arrays.stream(arr)
                .max()
                .orElse(0);

        System.out.println(max);

        // 185 Minimum Array Element
        int min = Arrays.stream(arr)
                .min()
                .orElse(0);

        System.out.println(min);

        // 186 Reverse Array Using Streams
        int[] reverse =
                IntStream.rangeClosed(1, arr.length)
                        .map(i ->
                                arr[arr.length - i])
                        .toArray();

        System.out.println(
                Arrays.toString(reverse)
        );

        // 187 Create Matrix Flatten
        int[][] matrix = {
                {1,2},
                {3,4},
                {5,6}
        };

        Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .forEach(System.out::println);

        // 188 Matrix Sum
        int matrixSum =
                Arrays.stream(matrix)
                        .flatMapToInt(Arrays::stream)
                        .sum();

        System.out.println(matrixSum);

        // 189 Matrix Max Value
        int matrixMax =
                Arrays.stream(matrix)
                        .flatMapToInt(Arrays::stream)
                        .max()
                        .orElse(0);

        System.out.println(matrixMax);

        // 190 Matrix Min Value
        int matrixMin =
                Arrays.stream(matrix)
                        .flatMapToInt(Arrays::stream)
                        .min()
                        .orElse(0);

        System.out.println(matrixMin);
    }
}
