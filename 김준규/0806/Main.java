package test;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static int N;
	public static int Ti;
	public static int Pi;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		int dp[] = new int[N + 1];
		

		for (int i = 0; i < N; i++) {
			Ti = sc.nextInt();
			Pi = sc.nextInt();

			dp[i + 1] = Math.max(dp[i + 1], dp[i]);

			if (i + Ti <= N) {
				dp[i + Ti] = Math.max(dp[i + Ti], dp[i] + Pi);
			}
		}
		System.out.println(dp[N]);
	}
}
