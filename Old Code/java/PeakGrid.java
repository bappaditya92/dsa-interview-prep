class PeakGrid {
    public int[] findPeakGrid(int[][] mat) {
        int left = 0, right = mat[0].length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int maxRow = 0;
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) maxRow = i;
            }

            boolean leftBig = mid > 0 && mat[maxRow][mid - 1] > mat[maxRow][mid];
            boolean rightBig = mid < mat[0].length - 1 && mat[maxRow][mid + 1] > mat[maxRow][mid];

            if (!leftBig && !rightBig) return new int[]{maxRow, mid};
            else if (rightBig) left = mid + 1;
            else right = mid - 1;
        }
        return new int[]{-1, -1};
    }
}
