class Shared {

    int data;
    boolean hasData = false;

    public synchronized void produce(int value) throws InterruptedException {

        while (hasData) {
            wait();
        }

        data = value;
        hasData = true;
        System.out.println("Produced: " + value);

        notify();
    }

    public synchronized void consume() throws InterruptedException {

        while (!hasData) {
            wait();
        }

        System.out.println("Consumed: " + data);
        hasData = false;

        notify();
    }
}

public class PC {

    public static void main(String[] args) {

        Shared obj = new Shared();

        Thread producer = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {
                try {
                    obj.produce(i);
                } catch (Exception e) {}
            }
        });

        Thread consumer = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {
                try {
                    obj.consume();
                } catch (Exception e) {}
            }
        });

        producer.start();
        consumer.start();
    }
}
