class KthSmallestSum {
    public int kthSmallest(int[][] mat, int k) {
        int left = mat.length, right = mat.length * 5000;

        while (left < right) {
            int mid = (left + right) / 2;

            if (count(mat, 0, mid, k) >= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private int count(int[][] mat, int row, int sum, int k) {
        if (row == mat.length) return 1;

        int res = 0;
        for (int val : mat[row]) {
            if (val > sum) break;
            res += count(mat, row + 1, sum - val, k);
            if (res >= k) return res;
        }
        return res;
    }
}
