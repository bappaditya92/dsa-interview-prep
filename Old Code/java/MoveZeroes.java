import java.util.Arrays;

public class MoveZeroes {

    // Approach: Two-pointer (overwrite + fill)
    public static void moveZeroes(int[] nums) {
        int insertPos = 0;

        // Step 1: Move all non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        // Step 2: Fill remaining positions with zeroes
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    // Alternative approach: Two-pointer with swap (single pass, no separate fill loop)
    public static void moveZeroesSwap(int[] nums) {
        int lastNonZero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[lastNonZero];
                nums[lastNonZero] = nums[i];
                nums[i] = temp;
                lastNonZero++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0, 3, 12};
        moveZeroes(arr1);
        System.out.println("Result (overwrite+fill): " + Arrays.toString(arr1));

        int[] arr2 = {0, 1, 0, 3, 12};
        moveZeroesSwap(arr2);
        System.out.println("Result (swap): " + Arrays.toString(arr2));

        int[] arr3 = {0, 0, 1};
        moveZeroes(arr3);
        System.out.println("Result: " + Arrays.toString(arr3));
    }
}
