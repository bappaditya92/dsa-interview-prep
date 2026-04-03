import java.util.*;
import java.util.stream.*;

class ParallelStreamExample {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        long count = IntStream.range(1, 1_000_000)
                .parallel()
                .filter(n -> n % 2 == 0)
                .count();

        long end = System.currentTimeMillis();

        System.out.println("Count: " + count);
        System.out.println("Time: " + (end - start));
    }
}
