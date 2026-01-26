import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Amit");
        names.add("Rahul");
        names.add("Neha");
        System.out.println(names);
      
        for (String name : names) {
            System.out.println(name);
        }
    }
}
