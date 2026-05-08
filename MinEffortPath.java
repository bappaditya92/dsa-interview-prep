class MinEffortPath {
    public int minimumEffortPath(int[][] heights) {
        int left = 0;
        int right = 1_000_000;

        while (left < right) {
            int mid = (left + right) / 2;

            if (canReach(heights, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canReach(int[][] h, int limit) {
        int m = h.length;
        int n = h[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];

            if (r == m - 1 && c == n - 1)
                return true;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 &&
                    nr < m && nc < n &&
                    !visited[nr][nc] &&
                    Math.abs(h[nr][nc] - h[r][c]) <= limit) {

                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return false;
    }
}
