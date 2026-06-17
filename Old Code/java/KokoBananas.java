class KokoBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;

        for (int p : piles) right = Math.max(right, p);

        while (left < right) {
            int mid = (left + right) / 2;

            if (canEat(piles, h, mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean canEat(int[] piles, int h, int speed) {
        int time = 0;

        for (int p : piles) {
            time += (p + speed - 1) / speed;
        }
        return time <= h;
    }
}
