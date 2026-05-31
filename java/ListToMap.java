import java.util.*;
import java.util.stream.Collectors;

public class ListToMap {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Java", "Spring", "Kafka");

        Map<Integer, String> map =
                list.stream()
                    .collect(Collectors.toMap(
                            String::length,
                            s -> s,
                            (a, b) -> a
                    ));

        System.out.println(map);
    }
}
