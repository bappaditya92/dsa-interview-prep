class DivideIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        long left = 0, right = dvd;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (mid * dvs <= dvd) left = mid + 1;
            else right = mid - 1;
        }

        long res = right;
        return ((dividend > 0) ^ (divisor > 0)) ? (int) -res : (int) res;
    }
}
