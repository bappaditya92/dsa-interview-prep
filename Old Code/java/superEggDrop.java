import java.util.*;

public class Main {

    public static int superEggDrop(int k, int n) {
        long[] dp = new long[k + 1];
        int moves = 0;

        while (dp[k] < n) {
            moves++;

            for (int eggs = k; eggs >= 1; eggs--) {
                dp[eggs] = dp[eggs] + dp[eggs - 1] + 1;
            }
        }

        return moves;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(superEggDrop(k, n));

        sc.close();
    }
}
