import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * BOJ14501 :: 퇴사 
 * N일 동안의 최대 이익 얻기.
 * 
 * 첫째 줄에 N(1 <= N <= 15)이 주어진다. 둘째 줄 부터 N개의 줄에 걸쳐 상담을 완료하는데 걸리는 기간 T, 받을 수 있는 금액
 * P가 주어진다.
 * 
 * T는 일수 기준. 범위처리 확실히.
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][2];
		int[] dp = new int[n + 1]; // i일차에서 마지막 퇴사일까지.

		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(tmp[0]); // T
			arr[i][1] = Integer.parseInt(tmp[1]); // P
		}

		int max = Integer.MIN_VALUE;
		
		for(int i = n - 1; i >= 0; i--) {
			if(arr[i][0] + i > n) {
				dp[i] = dp[i + 1];
				continue;
			}
			
			dp[i] = Math.max(arr[i][1] + dp[(i + arr[i][0])], dp[i + 1]);
		}
		
		for(int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		
		bw.append(max + "");
		bw.flush();
	}
}