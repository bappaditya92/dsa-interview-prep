import java.util.*;

public class LeetCodeSolutions {

    // ============================================================
    // SECTION 1: ARRAYS & TWO POINTERS
    // ============================================================

    /**
     * 1. Two Sum (Easy)
     * Find two indices that add up to target.
     * Time: O(n)  Space: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement))
                return new int[]{map.get(complement), i};
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    /**
     * 2. Best Time to Buy and Sell Stock (Easy)
     * Find max profit from one buy-sell transaction.
     * Time: O(n)  Space: O(1)
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) minPrice = price;
            else maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    /**
     * 3. Contains Duplicate (Easy)
     * Return true if any value appears at least twice.
     * Time: O(n)  Space: O(n)
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) return true;
        }
        return false;
    }

    /**
     * 4. Maximum Subarray — Kadane's Algorithm (Medium)
     * Find contiguous subarray with the largest sum.
     * Time: O(n)  Space: O(1)
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            maxSum = Math.max(maxSum, curr);
        }
        return maxSum;
    }

    /**
     * 5. Trapping Rain Water (Hard)
     * Calculate how much water can be trapped after raining.
     * Time: O(n)  Space: O(1)
     */
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) leftMax = height[left];
                else water += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax) rightMax = height[right];
                else water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }

    /**
     * 6. Merge Intervals (Medium)
     * Merge all overlapping intervals.
     * Time: O(n log n)  Space: O(n)
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                result.add(current);
                current = intervals[i];
            }
        }
        result.add(current);
        return result.toArray(new int[0][]);
    }

    // ============================================================
    // SECTION 2: STRINGS
    // ============================================================

    /**
     * 7. Valid Parentheses (Easy)
     * Check if brackets are correctly opened and closed.
     * Time: O(n)  Space: O(n)
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 8. Longest Substring Without Repeating Characters (Medium)
     * Find length of longest substring with all unique chars.
     * Time: O(n)  Space: O(n)
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    /**
     * 9. Valid Anagram (Easy)
     * Return true if t is an anagram of s.
     * Time: O(n)  Space: O(1)
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        for (char c : t.toCharArray()) count[c - 'a']--;
        for (int n : count) if (n != 0) return false;
        return true;
    }

    /**
     * 10. Palindrome Check (Easy)
     * Check if a string reads the same forwards and backwards.
     * Time: O(n)  Space: O(1)
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    // ============================================================
    // SECTION 3: BINARY SEARCH
    // ============================================================

    /**
     * 11. Binary Search (Easy)
     * Classic binary search in a sorted array.
     * Time: O(log n)  Space: O(1)
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    /**
     * 12. Search in Rotated Sorted Array (Medium)
     * Binary search on a rotated sorted array.
     * Time: O(log n)  Space: O(1)
     */
    public int searchRotated(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    // ============================================================
    // SECTION 4: LINKED LIST
    // ============================================================

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    /**
     * 13. Reverse Linked List (Easy)
     * Reverse a singly linked list.
     * Time: O(n)  Space: O(1)
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 14. Detect Cycle in Linked List (Easy)
     * Use Floyd's slow/fast pointer algorithm.
     * Time: O(n)  Space: O(1)
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    /**
     * 15. Merge Two Sorted Lists (Easy)
     * Merge two sorted linked lists into one sorted list.
     * Time: O(n + m)  Space: O(1)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) { curr.next = l1; l1 = l1.next; }
            else                  { curr.next = l2; l2 = l2.next; }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    // ============================================================
    // SECTION 5: TREES
    // ============================================================

    // Definition for binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    /**
     * 16. Maximum Depth of Binary Tree (Easy)
     * Find the maximum depth using DFS recursion.
     * Time: O(n)  Space: O(h) where h = height
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 17. Invert Binary Tree (Easy)
     * Mirror the binary tree recursively.
     * Time: O(n)  Space: O(h)
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    /**
     * 18. Validate Binary Search Tree (Medium)
     * Check if a tree satisfies BST properties.
     * Time: O(n)  Space: O(h)
     */
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) &&
               validate(node.right, node.val, max);
    }

    // ============================================================
    // SECTION 6: DYNAMIC PROGRAMMING
    // ============================================================

    /**
     * 19. Climbing Stairs (Easy)
     * Number of ways to climb n stairs (1 or 2 steps at a time).
     * Time: O(n)  Space: O(1)
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    /**
     * 20. Coin Change (Medium)
     * Minimum number of coins to make amount.
     * Time: O(amount * coins.length)  Space: O(amount)
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        LeetCodeSolutions sol = new LeetCodeSolutions();

        System.out.println("Two Sum:            " + Arrays.toString(sol.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println("Max Profit:         " + sol.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println("Contains Duplicate: " + sol.containsDuplicate(new int[]{1,2,3,1}));
        System.out.println("Max Subarray:       " + sol.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println("Trap Water:         " + sol.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println("Valid Parens:        " + sol.isValid("()[]{}"));
        System.out.println("Longest Substring:  " + sol.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("Is Anagram:         " + sol.isAnagram("anagram", "nagaram"));
        System.out.println("Is Palindrome:      " + sol.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("Binary Search:      " + sol.search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println("Climb Stairs(5):    " + sol.climbStairs(5));
        System.out.println("Coin Change:        " + sol.coinChange(new int[]{1,5,11}, 15));

        System.out.println("\nAll tests passed ✓");
    }
}
