class MinOperations {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int ans = n;
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j < n && nums[j] < nums[i] + n) j++;
            ans = Math.min(ans, n - (j - i));
        }
        return ans;
    }
}
