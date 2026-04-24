import java.util.*;

class StreamBug {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);

        List<Integer> result = list.stream().reduce(
                new ArrayList<>(),
                (acc, item) -> {
                    acc.add(item);
                    return acc; 
                },
                (left, right) -> {
                    left.addAll(right);
                    return left;
                }
        );

        System.out.println(result);
    }
}
