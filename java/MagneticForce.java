class MagneticForce {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int left = 1, right = position[position.length - 1];

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canPlace(position, m, mid)) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }

    private boolean canPlace(int[] pos, int m, int dist) {
        int count = 1, last = pos[0];

        for (int i = 1; i < pos.length; i++) {
            if (pos[i] - last >= dist) {
                count++;
                last = pos[i];
            }
        }
        return count >= m;
    }
}
