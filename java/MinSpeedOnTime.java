class MinSpeedOnTime {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1, right = 10000000, ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canReach(dist, hour, mid)) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }

    private boolean canReach(int[] dist, double hour, int speed) {
        double time = 0;

        for (int i = 0; i < dist.length; i++) {
            if (i == dist.length - 1)
                time += (double) dist[i] / speed;
            else
                time += Math.ceil((double) dist[i] / speed);
        }
        return time <= hour;
    }
}
