import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private static final int CAPACITY = 5;
    private final Queue<Integer> queue = new LinkedList<>();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (queue.size() == CAPACITY) {
                    wait();
                }
                queue.add(value);
                System.out.println("Produced: " + value++);
                notify();
                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.isEmpty()) {
                    wait();
                }
                int value = queue.poll();
                System.out.println("Consumed: " + value);
                notify();
                Thread.sleep(800);
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        Thread producer = new Thread(() -> {
            try { pc.produce(); } catch (InterruptedException e) {}
        });
        Thread consumer = new Thread(() -> {
            try { pc.consume(); } catch (InterruptedException e) {}
        });
        producer.start();
        consumer.start();
    }
}
