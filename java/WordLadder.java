import java.util.*;

public class WordLadder {

    public static int ladderLength(String beginWord,
                                   String endWord,
                                   List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();

                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {

                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {

                        chars[j] = c;

                        String next = new String(chars);

                        if (next.equals(endWord)) {
                            return level + 1;
                        }

                        if (set.contains(next)) {

                            queue.offer(next);
                            set.remove(next);
                        }
                    }

                    chars[j] = original;
                }
            }

            level++;
        }

        return 0;
    }

    public static void main(String[] args) {

        List<String> list =
                Arrays.asList("hot","dot","dog","lot","log","cog");

        System.out.println(
                ladderLength("hit", "cog", list)
        );
    }
}
