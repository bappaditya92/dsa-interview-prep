import java.util.*;

class RateLimiter {

    private final Map<String, Deque<Long>> userRequests = new HashMap<>();

    public boolean allowRequest(String userId) {

        long currentTime = System.currentTimeMillis();

        userRequests.putIfAbsent(userId, new LinkedList<>());

        Deque<Long> queue = userRequests.get(userId);

        while (!queue.isEmpty() &&
                currentTime - queue.peekFirst() > 10000) {
            queue.pollFirst();
        }

        if (queue.size() < 5) {
            queue.offerLast(currentTime);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        RateLimiter limiter = new RateLimiter();

        for (int i = 1; i <= 7; i++) {
            System.out.println(
                "Request " + i + " : " +
                limiter.allowRequest("user1")
            );
        }
    }
}
