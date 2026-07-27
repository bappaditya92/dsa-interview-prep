import java.util.HashMap;
//Given a random integer array A of size N. Find and print the count of pair of elements in the
// array which sum up to 0.
//Note: Array A can contain duplicate elements as well.
public class PairSumTo0 {
    //Time Complexity = O(n)
    public static int PairSum(int[] input, int size) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <input.length ; i++) {
            int num =input[i];
            if(map.containsKey(num)){
                int count = map.get(num);
                map.put(num, count+1);
            }else
                map.put(num, 1);
        }
        //count pairs
        int pairCount = 0;
        for(Integer num:map.keySet()) {
            int first = num;
            int firstCount = map.get(first);
            int second = 0 - first;
            if (firstCount > 0 && map.containsKey(second) && map.get(second) > 0) {
                int secondCount = map.get(second);
                int sumCount = firstCount * secondCount;
                if(first==second) {
                    //when both numbers are same then
                    //number of ways to pick 2 elements out of n = nC2
                    sumCount = firstCount*(firstCount-1)/2;
                }
                pairCount += sumCount;
                map.put(first, 0);
                map.put(second, 0);
            }
        }
        return pairCount;
    }
    public static void main(String[] args) {
        int arr[] = {2,1,-2,2,3};
        System.out.println(PairSum(arr,5));
    }
}
