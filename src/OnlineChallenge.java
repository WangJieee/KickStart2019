import java.util.Scanner;

public class OnlineChallenge {
    public static int compute(int[] arr, int max) {
        int[][] dp = new int[arr.length][max];
        for (int i = arr[0]; i < max; i++) {
            dp[0][i] = arr[0];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i < 2) {
                    dp[i][j] = (j-arr[i] >= 0)? Math.max(arr[i], dp[i-1][j]) : dp[i-1][j];
                } else {
                    dp[i][j] = (j-arr[i] >= 0)? Math.max(dp[i-2][j-arr[i]] + arr[i], dp[i-1][j]) : dp[i-1][j];
                }
            }
        }
        return dp[arr.length-1][max-1];
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int max = in.nextInt();
        int num = in.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = in.nextInt();
            
        }
        System.out.println(compute(arr, max));
    }
}
