class MinLimitBalls {
    public int minimumSize(int[] nums, int maxOps) {
        int left = 1, right = 0;

        for (int n : nums) right = Math.max(right, n);

        while (left < right) {
            int mid = (left + right) / 2;

            if (operations(nums, mid) <= maxOps) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private int operations(int[] nums, int limit) {
        int ops = 0;

        for (int n : nums)
            ops += (n - 1) / limit;

        return ops;
    }
}
