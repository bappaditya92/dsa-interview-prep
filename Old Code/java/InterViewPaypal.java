import java.util.*;

public class InterViewPaypal {

    public static List<Integer> findElements(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> candidates = new HashMap<>();
        for (int num : arr) {
            if (candidates.containsKey(num)) {
                candidates.put(num, candidates.get(num) + 1);
            } else if (candidates.size() < k - 1) {
                candidates.put(num, 1);
            } else {
                List<Integer> removeList = new ArrayList<>();
                for (Map.Entry<Integer, Integer> entry : candidates.entrySet()) {
                    int count = entry.getValue() - 1;
                    entry.setValue(count);
                    if (count == 0) {
                        removeList.add(entry.getKey());
                    }
                }

                for (int key : removeList) {
                    candidates.remove(key);
                }
            }
        }
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            if (candidates.containsKey(num)) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }
        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > n / k) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 2, 1, 2, 3, 3};
        int k = 4;
        List<Integer> result = findElements(arr, k);
        System.out.println(result);
    }
}
