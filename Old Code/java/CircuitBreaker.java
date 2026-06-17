import java.util.function.Supplier;

class CircuitBreaker {
    private int failureCount = 0;
    private final int threshold;
    private long lastFailureTime = 0;
    private final long timeout; // ms
    private boolean open = false;

    public CircuitBreaker(int threshold, long timeout) {
        this.threshold = threshold;
        this.timeout = timeout;
    }

    public <T> T call(Supplier<T> supplier) {
        if (open) {
            if (System.currentTimeMillis() - lastFailureTime > timeout) {
                open = false; // half-open
            } else {
                throw new RuntimeException("Circuit Open");
            }
        }

        try {
            T result = supplier.get();
            failureCount = 0;
            return result;
        } catch (Exception e) {
            failureCount++;
            lastFailureTime = System.currentTimeMillis();

            if (failureCount >= threshold) {
                open = true;
            }
            throw e;
        }
    }

    public static void main(String[] args) {
        CircuitBreaker cb = new CircuitBreaker(3, 5000);

        for (int i = 0; i < 10; i++) {
            try {
                cb.call(() -> {
                    if (Math.random() < 0.7) throw new RuntimeException("Fail");
                    return "Success";
                });
                System.out.println("Success");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
