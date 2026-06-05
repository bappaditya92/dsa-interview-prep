import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

    public static void main(String[] args) {

        ExecutorService service =
                Executors.newFixedThreadPool(3);

        for(int i = 1; i <= 5; i++) {

            int task = i;

            service.execute(() -> {
                System.out.println(
                        "Executing task " + task
                );
            });
        }

        service.shutdown();
    }
}
