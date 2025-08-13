package Day0807;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	//공지 Lis-가장 긴 증가하는 부분 수열 
	//첫번째,두번째 등 아예 안 고를 수 있다 즉 부분 수열
	//따라서 전부 고려하는 dp나 이진 탐색
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		//입력받기
		int N = sc.nextInt();//전체 수열 길이
		int [] A = new int [N]; //배열 : 원본 수열 저장 
		
		for (int i=0;i<N;i++) {
			A[i] =sc.nextInt();}//수열의 각 원소 입력
		
		//dp 배열 만들기 : 길이 N, 자기만 가도 1이니까 기본값 1
		//dp[i] : i번째 원소를 반드시 마지막으로 포함하는 가장 긴 증가 부분 수열 길이
		int [] dp = new int [N];
		Arrays.fill(dp,1);
		
		//이중 for :i(현재 위치)앞 j들 보며 점화식 사용 j***i
		for (int i=0;i<N;i++) { //i : 이 원소를 마지막으로 하는 수열을 만들기
			for (int j=0;j<i;j++) { //j : i보다 앞에 있는 모든 원소들 검사
			
				if (A[j]<A[i]) {//증가 수열인가?
       					dp[i]=Math.max(dp[i],dp[j]+1);
       					//j는 뒤에 무조건 i붙일 수 있음 
       					//dp[i]는 i번째 원소를 끝으로 하는 모든 가능한 증가 수열 중 가장 긴 것의 길이
       					
				}//else는 존재 불가 증가수열이 아님
			}
		}
		
		//정답은 dp전체 탐색한 것 중에서 최대
		int ans =0;
		for (int i=0;i<N;i++) ans = Math.max(ans,dp[i]);
		System.out.println(ans);
	}

}