import java.util.HashMap;
import java.util.Map;

public class WordCountClean {
    public static void main(String[] args) {
        String input = "Java is great, and Java is powerful!";

        // Remove punctuation
        input = input.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        String[] words = input.split("\\s+");

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
