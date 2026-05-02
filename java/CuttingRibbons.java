class CuttingRibbons {
    public int maxLength(int[] ribbons, int k) {
        int left = 1, right = 0;

        for (int r : ribbons) right = Math.max(right, r);

        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (pieces(ribbons, mid) >= k) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }

    private int pieces(int[] ribbons, int len) {
        int count = 0;
        for (int r : ribbons) count += r / len;
        return count;
    }
}
