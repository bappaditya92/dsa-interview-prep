import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        String input = "Java is great and Java is powerful";

        String[] words = input.toLowerCase().split("\\s+");

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        System.out.println(map);
    }
}
