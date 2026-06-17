class ShipPackages {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

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

    private boolean canShip(int[] weights, int days, int capacity) {
        int usedDays = 1;
        int curr = 0;

        for (int w : weights) {
            if (curr + w > capacity) {
                usedDays++;
                curr = 0;
            }

            curr += w;
        }

        return usedDays <= days;
    }
}
