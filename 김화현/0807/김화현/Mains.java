package 김화현;

import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	//첫번째 두번째 등 안고를 수 있다 즉 부분 수열
	//따라서 전부 고려하는 dp나 이진 탐색
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//입
		int N = sc.nextInt();
		int [] A = new int [N];
		
		for (int i=0;i<N;i++) {
			
			A[i] =sc.nextInt();}
		
		//dp 배열 만들기 : 길이 N, 자기만 가도 1이니까 기본값 1
		int [] dp = new int [N];
		Arrays.fill(dp,1);
		
		//이중 for :앞 j들 보며 점화식 사용
		for (int i=0;i<N;i++) {
			for (int j=0;j<i;j++) {
			
				if (A[j]<A[i]) {
       					dp[i]=Math.max(dp[i],dp[j]+1);
				}
			}
		}//정답은 dp전체에서 최대
		int ans =0;
		for (int i=0;i<N;i++) ans = Math.max(ans,dp[i]);
		System.out.println(ans);
	}

}
