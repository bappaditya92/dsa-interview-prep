import java.util.*;

public class FirstUniqueChar {

    public static char firstUnique(String str) {

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '#';
    }

    public static void main(String[] args) {

        System.out.println(firstUnique("aabbccdxe"));
    }
}
