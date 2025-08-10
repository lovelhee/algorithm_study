import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[10001];
        for (int i = 0; i <= 10000; i++) dp[i] = 1;
        for (int i = 2; i <= 10000; i++) dp[i] += dp[i - 2];
        for (int i = 3; i <= 10000; i++) dp[i] += dp[i - 3];
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            System.out.println(dp[a]);
        }
    }
}
