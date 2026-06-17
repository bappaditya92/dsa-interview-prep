class TokenBucket {
    private final int capacity;
    private final int refillRate;
    private int tokens;
    private long lastRefillTime;

    public TokenBucket(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity;
        this.lastRefillTime = System.nanoTime();
    }

    public synchronized boolean allowRequest() {
        refill();

        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        double tokensToAdd = (now - lastRefillTime) / 1e9 * refillRate;

        if (tokensToAdd > 0) {
            tokens = Math.min(capacity, tokens + (int) tokensToAdd);
            lastRefillTime = now;
        }
    }
}
