//https://www.acmicpc.net/problem/14501
// 이전값이랑 비교하고 또한 상담 걸리는 시간을 인덱스에다가 추가로 줘서 그 배열에 값을 넣어줬다.

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();
		
		int [] dp = new int[N+1];
		
		for(int i = 0; i< N; i++) {
			int index = sc.nextInt();
			int P = sc.nextInt();
			dp[i+1] = Math.max(dp[i+1], dp[i]); 
			if(i + index <= N) {
				dp[i+ index] = Math.max(dp[i + index], dp[i] + P);
			}
		}
		
		Arrays.sort(dp);
		
		System.out.println(dp[N]);				
		
	}
}