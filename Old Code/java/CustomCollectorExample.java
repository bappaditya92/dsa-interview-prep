import java.util.*;
import java.util.stream.*;

class CustomCollectorExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apricot", "blueberry");

        Map<Character, String> result = list.stream()
                .collect(Collectors.toMap(
                        s -> s.charAt(0),
                        s -> s,
                        (existing, replacement) -> existing + "," + replacement
                ));

        System.out.println(result);
        // {a=apple,apricot, b=banana,blueberry}
    }
}
