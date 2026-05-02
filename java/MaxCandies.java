class MaxCandies {
    public int maximumCandies(int[] candies, long k) {
        int left = 1, right = 0;

        for (int c : candies) right = Math.max(right, c);

        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canDistribute(candies, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }

    private boolean canDistribute(int[] candies, long k, int x) {
        long count = 0;

        for (int c : candies)
            count += c / x;

        return count >= k;
    }
}
