import java.util.*;
public class Java8Example {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2, 5, 8, 10, 3, 12);
        int result = numbers.stream()
                .filter(n -> n % 2 == 0)     
                .map(n -> n * n)             
                .filter(n -> n > 100)         
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(result); 
    }
}
