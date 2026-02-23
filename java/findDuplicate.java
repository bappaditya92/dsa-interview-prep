import java.util.*;
import java.util.stream.*;

public class Duplicate {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10, 20, 30, 20, 40, 10);

        Set<Integer> duplicates =
                list.stream()
                    .filter(n -> Collections.frequency(list, n) > 1)
                    .collect(Collectors.toSet());

        System.out.println(duplicates);
    }
}
