import java.util.ArrayList;

public class ArrayListIterationExample {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Mango");
        System.out.println("Using for loop:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("\nUsing while loop:");
        int i = 0;
        while (i < list.size()) {
            System.out.println(list.get(i));
            i++;
        }
        System.out.println("\nUsing enhanced for loop:");
        for (String fruit : list) {
            System.out.println(fruit);
        }
    }
}
