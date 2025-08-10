package com.ssafy.algo;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int testCase;
		int num;
		int dp[][];
		
		Scanner sc = new Scanner(System.in);
		
		testCase = sc.nextInt();
		
		for(int T = 0; T < testCase; T++) {
			num = sc.nextInt();
			
			dp = new int[10004][4];
			
			for(int i = 1; i < 4; i++) {
				for(int j = 1; j <= i; j++) {
					dp[i][j] = 1;
				}
			}
			
			for(int i = 4; i <= num; i++) {
				dp[i][1] = dp[i-1][1];
                dp[i][2] = dp[i-2][1] + dp[i-2][2];
                dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
			}
			
			System.out.println(dp[num][1] + dp[num][2] + dp[num][3]);
		}
	}
}
