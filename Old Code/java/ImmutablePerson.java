import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public final class ImmutablePerson {
    private final String name;
    private final int age;
    private final List<String> hobbies;

    public ImmutablePerson(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = new ArrayList<>(hobbies); // defensive copy
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    public List<String> getHobbies() {
        return Collections.unmodifiableList(hobbies); // prevent modification
    }

    public static void main(String[] args) {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Reading");
        ImmutablePerson p = new ImmutablePerson("Bappaditya", 25, hobbies);
        System.out.println(p.getName() + ", " + p.getAge());
    }
}
