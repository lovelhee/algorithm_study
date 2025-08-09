package Day0806;


import java.util.Scanner;

public class Main {
	static int N;
	static int [] T,P;//T와 P는 열이다라고 자료형만 알려
	static int [] memo; //DP에서 중요한 memo, 연산 줄임!
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt(); //퇴사일까지 남은 일수
		
		//진짜 배열 만들
		//배열을 1일부터 쓰고 싶어서 N+1 크기로 초기화함
		//T[0].P[0].memo[0]은 0으로 초기화되나 안쓸 것임
		T=new int[N+1];
		P=new int[N+1];
		memo = new int [N+1]; 
		
		for (int i=1;i<N+1;i++) {
			T[i]=sc.nextInt(); //해당 일에 잡힌 상담 진행시 소요 일
			P[i]=sc.nextInt();// 해당 일에 잡힌 상담시 버는 돈 
		}
		
		//memo값을 초기화해서 0이 들어가있을 텐데 버는 돈이 0일수도 있으니 -1로
		for (int i=0;i<N+1;i++) {
			memo[i]=-1;
		}
		
		System.out.println(dfs(1));
		
		
	}

	/**
	 * 
	 * @param day 시작 날짜 
	 * @return day에 상담 시작했을 때 얻을 수 있는 최대 수 
	 */
	private static int dfs(int day) {// int day=1;과 동일 
		//day는 당일 일
		
		if (day>N) return 0; //퇴사일 지나면 수익 없음
		if (memo[day] !=-1) return memo [day]; // 이미 계산한 적 있다면 저장해둔 값 리턴 
		
		int result =0; //여기서 선언하면 memo덕분에 연산 줄일 수 있
		
		//당일 상담 가능한 경우 (퇴사 전에 끝낼 수 있음)
		if(day+T[day]-1<=N) {//상담 일수 카운트에 -1은  2틀 걸리는데 3일+2일=5라서 -1해줘야
			result = Math.max(result,P[day]+dfs(day+T[day]));
				
		}
		//당일 상담안하고 넘어가는 경
		result = Math.max(result, dfs(day+1));
		
		return memo[day]=result;
	
	}

}
