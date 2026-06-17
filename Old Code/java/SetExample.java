import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(10); 

        System.out.println(numbers);
    }
}
