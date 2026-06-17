class ShipCapacity {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = (left + right) / 2;

            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canShip(int[] weights, int days, int cap) {
        int curr = 0, d = 1;

        for (int w : weights) {
            if (curr + w > cap) {
                d++;
                curr = 0;
            }
            curr += w;
        }
        return d <= days;
    }
}
