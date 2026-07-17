import java.util.HashMap;

public class DuplicateChars {
    public static void main(String[] args) {
        String str = "programming";

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : map.keySet()) {
            if (map.get(c) > 1) {
                System.out.println(c + " -> " + map.get(c));
            }
        }
    }
}
