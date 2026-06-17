import java.util.*;

public class SimpleCollection {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Java");
        names.add("Node");
        names.add("React");

        for (String name : names) {
            System.out.println(name);
        }
    }
}
