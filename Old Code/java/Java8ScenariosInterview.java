import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class Java8ScenariosInterview {

    public static void main(String[] args) {

        // 131 Convert List<Integer> to Map(Number, Square)
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        Map<Integer,Integer> squareMap = numbers.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        n -> n * n));
        System.out.println(squareMap);

        // 132 Convert List<Integer> to Map(Number, Cube)
        Map<Integer,Integer> cubeMap = numbers.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        n -> n * n * n));
        System.out.println(cubeMap);

        // 133 Find Sum of Squares
        int sumSquare = numbers.stream()
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println(sumSquare);

        // 134 Find Sum of Cubes
        int sumCube = numbers.stream()
                .map(n -> n * n * n)
                .reduce(0, Integer::sum);
        System.out.println(sumCube);

        // 135 Multiply all numbers
        int multiply = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println(multiply);

        // 136 Create Index Map
        List<String> names = Arrays.asList("Java","Spring","AWS");
        Map<Integer,String> indexMap =
                IntStream.range(0, names.size())
                        .boxed()
                        .collect(Collectors.toMap(
                                i -> i,
                                names::get));
        System.out.println(indexMap);

        // 137 Reverse List
        List<Integer> reverse =
                IntStream.range(0, numbers.size())
                        .mapToObj(i -> numbers.get(numbers.size()-1-i))
                        .collect(Collectors.toList());
        System.out.println(reverse);

        // 138 Find Middle Element
        Integer middle =
                numbers.get(numbers.size()/2);
        System.out.println(middle);

        // 139 Remove Blank Strings
        List<String> list =
                Arrays.asList("Java",""," ","Spring",null,"AWS");

        List<String> clean =
                list.stream()
                        .filter(Objects::nonNull)
                       
