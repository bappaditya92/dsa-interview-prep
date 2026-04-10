import java.util.function.Supplier;

class RetryUtil {
    public static <T> T retry(Supplier<T> supplier, int maxAttempts) {
        int attempts = 0;
        while (true) {
            try {
                return supplier.get();
            } catch (Exception e) {
                attempts++;
                if (attempts >= maxAttempts) throw e;
            }
        }
    }

    public static void main(String[] args) {
        String result = retry(() -> {
            if (Math.random() < 0.7) throw new RuntimeException("Fail");
            return "Success";
        }, 5);

        System.out.println(result);
    }
}
