class MinSpeedArrive {
    public int minSpeedOnTime(int[] dist, double hour) {

        int left = 1;
        int right = 10_000_000;

        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canReach(dist, hour, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canReach(int[] dist,
                             double hour,
                             int speed) {

        double time = 0;

        for (int i = 0; i < dist.length; i++) {

            double t = (double) dist[i] / speed;

            if (i != dist.length - 1)
                time += Math.ceil(t);
            else
                time += t;
        }

        return time <= hour;
    }
}
