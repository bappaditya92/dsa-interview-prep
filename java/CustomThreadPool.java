import java.util.concurrent.*;
import java.util.*;

class CustomThreadPool {
    private final BlockingQueue<Runnable> queue;
    private final List<Worker> workers;

    public CustomThreadPool(int size) {
        queue = new LinkedBlockingQueue<>();
        workers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Worker w = new Worker();
            workers.add(w);
            new Thread(w).start();
        }
    }

    public void submit(Runnable task) {
        queue.offer(task);
    }

    class Worker implements Runnable {
        public void run() {
            while (true) {
                try {
                    Runnable task = queue.take();
                    task.run();
                } catch (Exception e) {}
            }
        }
    }

    public static void main(String[] args) {
        CustomThreadPool pool = new CustomThreadPool(3);

        for (int i = 0; i < 5; i++) {
            int num = i;
            pool.submit(() -> {
                System.out.println(Thread.currentThread().get
