interface Payment {
    void pay(double amount);

    default void printReceipt() {
        System.out.println("Receipt generated");
    }

    static void paymentInfo() {
        System.out.println("Payment service v1.0");
    }
}

class UPI implements Payment {
    public void pay(double amount) {
        System.out.println("Paid using UPI: " + amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Payment p = new UPI();

        p.pay(500);
        p.printReceipt();        // default
        Payment.paymentInfo();  // static
    }
}
