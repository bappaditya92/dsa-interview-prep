import java.util.concurrent.*;

class CompletableFutureExample {
    public static void main(String[] args) throws Exception {

        CompletableFuture<String> service1 =
                CompletableFuture.supplyAsync(() -> {
                    sleep(1000);
                    return "User Data";
                });

        CompletableFuture<String> service2 =
                CompletableFuture.supplyAsync(() -> {
                    sleep(1500);
                    return "Order Data";
                });

        CompletableFuture<String> result =
                service1.thenCombine(service2, (s1, s2) -> s1 + " + " + s2);

        System.out.println(result.get());
    }

    static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (Exception e) {}
    }
}
