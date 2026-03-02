import java.util.Arrays;
import java.util.List;

public class ParallelVsStream {

    public static void main(String[] args) {

        List<String> list = Arrays.asList(
                "A", "B", "C", "D", "E", "F"
        );

        System.out.println("Normal Stream:");

        list.stream()
                .forEach(name ->
                        System.out.println(name + " : " + Thread.currentThread().getName())
                );


        System.out.println("\nParallel Stream:");

        list.parallelStream()
                .forEach(name ->
                        System.out.println(name + " : " + Thread.currentThread().getName())
                );

    }
}
