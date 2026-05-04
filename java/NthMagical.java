class NthMagical {
    public int nthMagicalNumber(int n, int a, int b) {
        long left = 1, right = (long) n * Math.min(a, b);
        long lcm = (long) a * b / gcd(a, b);

        while (left < right) {
            long mid = (left + right) / 2;

            if (mid / a + mid / b - mid / lcm < n)
                left = mid + 1;
            else
                right = mid;
        }
        return (int) (left % 1_000_000_007);
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
