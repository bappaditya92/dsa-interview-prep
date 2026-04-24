import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {

        
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Spring");
        list.add("Java"); 

        System.out.println("List:");
        for (String item : list) {
            System.out.println(item);
        }

  
        Set<String> set = new HashSet<>();
        set.add("AWS");
        set.add("Docker");
        set.add("AWS"); 

        System.out.println("\nSet:");
        set.forEach(System.out::println);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Node.js");
        map.put(2, "React");
        map.put(1, "MERN"); 

        System.out.println("\nMap:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
