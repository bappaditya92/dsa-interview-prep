
import java.util.Arrays;

class AggressiveCows {
    public int maxDistance(int[] stalls, int k) {
        Arrays.sort(stalls);

        int left = 1, right = stalls[stalls.length - 1] - stalls[0];

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canPlace(stalls, k, mid)) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }

    private boolean canPlace(int[] stalls, int k, int dist) {
        int count = 1, last = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= dist) {
                count++;
                last = stalls[i];
            }
        }
        return count >= k;
    }
}
