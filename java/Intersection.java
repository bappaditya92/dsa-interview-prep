import java.util.*;

public class Intersection {
    public static void main(String[] args) {
        int[] a = {1,2,2,1};
        int[] b = {2,2};

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int n : a) set1.add(n);

        for (int n : b) {
            if (set1.contains(n)) {
                result.add(n);
            }
        }

        System.out.println(result);
    }
}
