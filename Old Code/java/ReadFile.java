import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {

    public static void main(String[] args) throws Exception {

        Files.lines(Paths.get("test.txt"))
                .forEach(System.out::println);
    }
}
