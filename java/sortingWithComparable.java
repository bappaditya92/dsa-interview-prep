import java.util.*;

class Student implements Comparable<Student> {
    int marks;
    String name;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int compareTo(Student s) {
        return this.marks - s.marks; // ascending
    }

    public String toString() {
        return name + " " + marks;
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Amit", 85));
        list.add(new Student("Neha", 92));
        list.add(new Student("Rahul", 78));

        Collections.sort(list);
        System.out.println(list);
    }
}
