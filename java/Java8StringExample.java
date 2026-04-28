import java.util.*;
import java.util.stream.*;

public class Java8StringExample {
    public static void main(String[] args) {

        String sentence = "Java is Very Powerful Language Java Stream API";

        List<String> result = Arrays.stream(sentence.split(" "))
                .map(String::toLowerCase)
                .filter(word -> word.length() > 3)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
