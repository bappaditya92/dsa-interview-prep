public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {

        int sum = 0;

        for (int num : nums)
            sum += num;

        // If total sum is odd, partition is impossible
        if (sum % 2 != 0)
            return false;

        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {

            // Traverse backwards to avoid reusing the same element
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {

        int[] nums = {1,5,11,5};

        System.out.println(canPartition(nums)); // true
    }
}
