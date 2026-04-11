import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 4);
        Set<Integer> set = new LinkedHashSet<>(list);
        System.out.println(set);
    }
}
