class SqrtX {
    public int mySqrt(int x) {
        int left = 0, right = x;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (mid * mid == x) return (int) mid;
            else if (mid * mid < x) left = (int) mid + 1;
            else right = (int) mid - 1;
        }
        return right;
    }
}
