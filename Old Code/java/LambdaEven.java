import java.util.*;

public class LambdaEven {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        nums.stream()
            .filter(n -> n % 2 == 0)
            .forEach(System.out::println);
    }
}
