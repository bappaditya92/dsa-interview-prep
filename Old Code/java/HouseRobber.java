public class HouseRobber {

    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;

        int prev1 = 0;
        int prev2 = 0;

        for (int money : nums) {
            int temp = Math.max(prev1, prev2 + money);
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums)); //12
    }
}
