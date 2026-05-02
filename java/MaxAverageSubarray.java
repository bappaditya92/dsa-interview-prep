class MaxAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        double left = -10000, right = 10000;

        while (right - left > 1e-5) {
            double mid = (left + right) / 2;

            if (canFind(nums, k, mid)) left = mid;
            else right = mid;
        }
        return left;
    }

    private boolean canFind(int[] nums, int k, double avg) {
        double sum = 0, prev = 0, minPrev = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] - avg;

            if (i >= k) {
                prev += nums[i - k] - avg;
                minPrev = Math.min(minPrev, prev);
            }

            if (i >= k - 1 && sum > minPrev) return true;
        }
        return false;
    }
}
