public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];

            tank += gas[i] - cost[i];

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return totalGas >= totalCost ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};

        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};

        System.out.println("Example 1 Output: " +
                canCompleteCircuit(gas1, cost1)); // 3

        System.out.println("Example 2 Output: " +
                canCompleteCircuit(gas2, cost2)); // -1
    }
}
