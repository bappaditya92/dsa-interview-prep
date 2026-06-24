import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Scenarios {

    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "Rahul",
                "Amit",
                "Priya",
                "Neha",
                "Ankit"
        );

        List<Integer> numbers = Arrays.asList(
                10, 20, 30, 40, 50, 60, 70
        );

        // 111 Reverse String
        String str = "Java";
        String reverse =
                new StringBuilder(str)
                        .reverse()
                        .toString();

        System.out.println(reverse);

        // 112 Check Anagram
        String s1 = "listen";
        String s2 = "silent";

        boolean anagram =
                Arrays.stream(s1.split(""))
                        .sorted()
                        .collect(Collectors.joining())
                        .equals(
                                Arrays.stream(s2.split(""))
                                        .sorted()
                                        .collect(Collectors.joining())
                        );

        System.out.println(anagram);

        // 113 Remove Spaces
        String sentence =
                "Java Stream API";

        System.out.println(
                sentence.replaceAll("\\s+", "")
        );

        // 114 Count Words
        long count =
                Arrays.stream(sentence.split(" "))
                        .count();

        System.out.println(count);

        // 115 Find Largest Number
        System.out.println(
                Collections.max(numbers)
        );

        // 116 Find Smallest Number
        System.out.println(
                Collections.min(numbers)
        );

        // 117 Sort Descending
        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        // 118 Convert List To Array
        String[] arr =
                names.toArray(new String[0]);

        System.out.println(
                Arrays.toString(arr)
        );

        // 119 Convert Array To List
        List<String> list =
                Arrays.asList(arr);

        System.out.println(list);

        // 120 Create Immutable List
        List<String> immutable =
                Collections.unmodifiableList(
                        names
                );

        System.out.println(immutable);

        // 121 Find Common Characters
        String a = "JAVA";
        String b = "JSP";

        a.chars()
                .mapToObj(c -> (char) c)
                .filter(ch ->
                        b.indexOf(ch) >= 0)
                .distinct()
                .forEach(System.out::println);

        // 122 Remove Duplicate Characters
        String input = "programming";

        String unique =
                input.chars()
                        .distinct()
                        .mapToObj(c ->
                                String.valueOf((char)c))
                        .collect(Collectors.joining());

        System.out.println(unique);

        // 123 Convert List To LinkedList
        LinkedList<String> linkedList =
                names.stream()
                        .collect(Collectors.toCollection(
                                LinkedList::new));

        System.out.println(linkedList);

        // 124 Find Last Element
        Integer last =
                numbers.stream()
                        .reduce((a1,a2) -> a2)
                        .orElse(null);

        System.out.println(last);

        // 125 Product Of Numbers
        Integer product =
                numbers.stream()
                        .reduce(1,
                                (x,y) -> x*y);

        System.out.println(product);

        // 126 Sort By Length
        names.stream()
                .sorted(
                        Comparator.comparingInt(
                                String::length))
                .forEach(System.out::println);

        // 127 Create Frequency Map
        Map<String, Long> freq =
                names.stream()
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()));

        System.out.println(freq);

        // 128 Convert To HashSet
        HashSet<String> hashSet =
                names.stream()
                        .collect(Collectors.toCollection(
                                HashSet::new));

        System.out.println(hashSet);

        // 129 Check Palindrome
        String word = "madam";

        boolean palindrome =
                word.equals(
                        new StringBuilder(word)
                                .reverse()
                                .toString());

        System.out.println(palindrome);

        // 130 Find String With Maximum Length
        names.stream()
                .max(Comparator.comparingInt(
                        String::length))
                .ifPresent(System.out::println);
    }
}
