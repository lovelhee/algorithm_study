import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		int N = 0;
		int k = sc.nextInt();

		int dp[][] = new int[n+1][n+1];
		
		for(int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}

		dp[0][0] = 1;
		dp[1][0] = 1;
		dp[1][1] = 1;

		for (int i = 2; i < n; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}

		System.out.println(dp[n - 1][k - 1]);
	}
}
