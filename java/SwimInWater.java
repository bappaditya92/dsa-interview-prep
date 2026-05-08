class SwimInWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int left = grid[0][0];
        int right = n * n;

        while (left < right) {
            int mid = (left + right) / 2;

            if (canReach(grid, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canReach(int[][] grid, int time) {
        int n = grid.length;

        boolean[][] visited = new boolean[n][n];

        return dfs(grid, visited, 0, 0, time);
    }

    private boolean dfs(int[][] grid, boolean[][] visited,
                        int r, int c, int time) {

        int n = grid.length;

        if (r < 0 || c < 0 || r >= n || c >= n)
            return false;

        if (visited[r][c] || grid[r][c] > time)
            return false;

        if (r == n - 1 && c == n - 1)
            return true;

        visited[r][c] = true;

        return dfs(grid, visited, r + 1, c, time) ||
               dfs(grid, visited, r - 1, c, time) ||
               dfs(grid, visited, r, c + 1, time) ||
               dfs(grid, visited, r, c - 1, time);
    }
}
