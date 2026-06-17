class MinTimeTrips {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1, right = (long) Arrays.stream(time).min().getAsInt() * totalTrips;

        while (left < right) {
            long mid = (left + right) / 2;

            if (trips(time, mid) >= totalTrips) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private long trips(int[] time, long t) {
        long count = 0;

        for (int x : time)
            count += t / x;

        return count;
    }
}
