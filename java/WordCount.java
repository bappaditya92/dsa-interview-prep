import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        String input = "Java is great and Java is powerful";

        input = input.toLowerCase();
        String[] words = input.split("\\s+");
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }
        System.out.println("Word counts:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
