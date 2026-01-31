import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeat {
    public static void main(String[] args) {

        String input = "aabbcddeff";

        Character result = input.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(result);
    }
}
