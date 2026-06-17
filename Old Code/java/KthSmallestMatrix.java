class KthSmallestMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];

        while (left < right) {
            int mid = (left + right) / 2;

            if (count(matrix, mid) < k) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    private int count(int[][] matrix, int mid) {
        int n = matrix.length;
        int row = n - 1, col = 0, count = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                count += row + 1;
                col++;
            } else row--;
        }
        return count;
    }
}
