import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Java8AdvancedScenarios {

    public static void main(String[] args) {

        // 91 Consumer Example
        Consumer<String> consumer =
                System.out::println;
        consumer.accept("Hello Java 8");

        // 92 Supplier Example
        Supplier<String> supplier =
                () -> "Generated Value";
        System.out.println(supplier.get());

        // 93 Predicate Example
        Predicate<Integer> predicate =
                n -> n > 10;
        System.out.println(predicate.test(15));

        // 94 Function Example
        Function<String,Integer> function =
                String::length;
        System.out.println(function.apply("SpringBoot"));

        // 95 BiFunction Example
        BiFunction<Integer,Integer,Integer> add =
                Integer::sum;
        System.out.println(add.apply(10,20));

        // 96 UnaryOperator
        UnaryOperator<Integer> square =
                n -> n * n;
        System.out.println(square.apply(5));

        // 97 BinaryOperator
        BinaryOperator<Integer> multiply =
                (a,b) -> a * b;
        System.out.println(multiply.apply(10,5));

        // 98 Method Reference
        List<String> names =
                Arrays.asList("Java","Spring","AWS");

        names.forEach(System.out::println);

        // 99 Constructor Reference
        Supplier<List<String>> listSupplier =
                ArrayList::new;

        List<String> list = listSupplier.get();
        list.add("Java");
        System.out.println(list);

        // 100 Parallel Stream
        Arrays.asList(1,2,3,4,5,6,7,8)
                .parallelStream()
                .forEach(System.out::println);

        // 101 Sequential vs Parallel Count
        long count =
                IntStream.rangeClosed(1,1000000)
                        .parallel()
                        .count();

        System.out.println(count);

        // 102 Generate Infinite Stream
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        // 103 Iterate Stream
        Stream.iterate(1,n->n+2)
                .limit(10)
                .forEach(System.out::println);

        // 104 Peek Example
        List<Integer> result =
                Arrays.asList(1,2,3,4,5)
                        .stream()
                        .peek(System.out::println)
                        .map(n->n*n)
                        .collect(Collectors.toList());

        System.out.println(result);

        // 105 Collect To Set
        Set<String> set =
                names.stream()
                        .collect(Collectors.toSet());

        System.out.println(set);

        // 106 Collect To TreeSet
        TreeSet<String> treeSet =
                names.stream()
                        .collect(Collectors.toCollection(
                                TreeSet::new));

        System.out.println(treeSet);

        // 107 Summarizing Statistics
        IntSummaryStatistics stats =
                Arrays.asList(10,20,30,40,50)
                        .stream()
                        .collect(Collectors.summarizingInt(
                                Integer::intValue));

        System.out.println(stats);

        // 108 Average Using Collectors
        Double avg =
                Arrays.asList(10,20,30,40)
                        .stream()
                        .collect(Collectors.averagingInt(
                                Integer::intValue));

        System.out.println(avg);

        // 109 Summing Using Collectors
        Integer total =
                Arrays.asList(10,20,30)
                        .stream()
                        .collect(Collectors.summingInt(
                                Integer::intValue));

        System.out.println(total);

        // 110 Mapping Collector
        List<Integer> lengths =
                names.stream()
                        .collect(Collectors.mapping(
                                String::length,
                                Collectors.toList()));

        System.out.println(lengths);
    }
}
