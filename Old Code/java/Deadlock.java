class A {}
class B {}

public class Deadlock {

    public static void main(String[] args) {

        A a = new A();
        B b = new B();

        Thread t1 = new Thread(() -> {

            synchronized (a) {

                System.out.println("Thread1 locked A");

                synchronized (b) {

                    System.out.println("Thread1 locked B");
                }
            }
        });

        Thread t2 = new Thread(() -> {

            synchronized (b) {

                System.out.println("Thread2 locked B");

                synchronized (a) {

                    System.out.println("Thread2 locked A");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
