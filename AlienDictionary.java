import java.util.*;

public class AlienDictionary {

    public static String alienOrder(String[] words) {

        Map<Character, Set<Character>> graph =
                new HashMap<>();

        Map<Character, Integer> indegree =
                new HashMap<>();

        for (String word : words) {

            for (char ch : word.toCharArray()) {

                graph.putIfAbsent(ch,
                        new HashSet<>());

                indegree.putIfAbsent(ch, 0);
            }
        }

        for (int i = 0;
             i < words.length - 1;
             i++) {

            String word1 = words[i];
            String word2 = words[i + 1];

            int len =
                    Math.min(word1.length(),
                            word2.length());

            for (int j = 0; j < len; j++) {

                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {

                    if (!graph.get(c1).contains(c2)) {

                        graph.get(c1).add(c2);

                        indegree.put(c2,
                                indegree.get(c2) + 1);
                    }

                    break;
                }
            }
        }

        Queue<Character> queue =
                new LinkedList<>();

        for (char ch : indegree.keySet()) {

            if (indegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        StringBuilder result =
                new StringBuilder();

        while (!queue.isEmpty()) {

            char current = queue.poll();

            result.append(current);

            for (char neighbor :
                    graph.get(current)) {

                indegree.put(neighbor,
                        indegree.get(neighbor) - 1);

                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return result.length() ==
                indegree.size()
                ? result.toString()
                : "";
    }
}
