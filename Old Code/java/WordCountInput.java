import java.util.*;

public class WordCountInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        input = input.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] words = input.split("\\s+");

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequency:");
        map.forEach((k, v) -> System.out.println(k + " : " + v));

        sc.close();
    }
}
