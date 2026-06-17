class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] start = new int[n][2];

        for (int i = 0; i < n; i++) {
            start[i][0] = intervals[i][0];
            start[i][1] = i;
        }

        Arrays.sort(start, (a, b) -> a[0] - b[0]);

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int target = intervals[i][1];
            int left = 0, right = n - 1, ans = -1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (start[mid][0] >= target) {
                    ans = start[mid][1];
                    right = mid - 1;
                } else left = mid + 1;
            }
            res[i] = ans;
        }
        return res;
    }
}
