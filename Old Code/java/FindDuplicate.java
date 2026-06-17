class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            int count = 0;
            for (int n : nums) {
                if (n <= mid) count++;
            }

            if (count > mid) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
