import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(1, "Rahul");
        students.put(2, "Amit");
        students.put(3, "Sita");

        System.out.println(students);

        for(Map.Entry<Integer, String> entry : students.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
