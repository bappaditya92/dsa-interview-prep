import java.util.Arrays;

public class MoveZeroesAllVariants {

    // 1. Two-pointer: overwrite + fill (in-place, O(1) space, stable order)
    public static void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    // 2. Two-pointer: swap (in-place, single pass, stable order)
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

    // 3. Extra array (not in-place, O(n) space)
    public static int[] moveZeroesExtra(int[] nums) {
        int[] result = new int[nums.length];
        int idx = 0;
        for (int num : nums) {
            if (num != 0) result[idx++] = num;
        }
        return result; // remaining slots default to 0
    }

    // 4. Move zeroes to the FRONT instead of the end
    public static void moveZeroesToFront(int[] nums) {
        int insertPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) {
                nums[insertPos--] = nums[i];
            }
        }
        while (insertPos >= 0) {
            nums[insertPos--] = 0;
        }
    }

    // 5. Generic: move any target value to the end
    public static void moveElement(int[] nums, int target) {
        int insertPos = 0;
        for (int num : nums) {
            if (num != target) {
                nums[insertPos++] = num;
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = target;
        }
    }

    // 6. Two-pointer from both ends (order not preserved, fewer swaps in some cases)
    public static void moveZeroesUnordered(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] != 0) {
                left++;
            } else if (nums[right] == 0) {
                right--;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a1 = {0, 1, 0, 3, 12};
        moveZeroes(a1);
        System.out.println("Overwrite+fi
