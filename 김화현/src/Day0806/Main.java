package Day0806;
//백준 14501 퇴사


import java.util.Scanner;

public class Main {
	static int N;//N+1일자에 퇴사!
	static int [] T,P;//T : 소요 기간/ P: 건당 보수
	static int [] memo; //day일부터 N일까지 남은 기간 동안 얻을 수 있는 최대 이익
	// DP에서 중요한 memo, 연산 줄임!
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt(); //퇴사일까지 남은 일수
		
		//배열을 1일부터 쓰고 싶어서 N+1 크기로 초기화함
		//T[0].P[0].memo[0]은 0으로 초기화되나 안쓸 것임
		T=new int[N+1];
		P=new int[N+1];
		memo = new int [N+1]; 

		for (int i=1;i<N+1;i++) {
			T[i]=sc.nextInt(); //해당 일에 잡힌 상담 진행시 소요 기간
			P[i]=sc.nextInt();// 해당 일에 잡힌 상담시 버는 보수
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
	 * @return day에 상담 시작했을 때 얻을 수 있는 최대 수익
	 */
	private static int dfs(int day) {// int day=1;과 동일 
		//day는 당일 
		
		if (day>N) return 0; //퇴사일 지나면 수익벌 수 없음
		if (memo[day] !=-1) return memo [day]; // 이미 계산한 적 있다면 저장해둔 값 리턴 
		
		int result =0; //각 DFS(일수)마다 초기화
		
		//당일 상담 가능한 경우 (퇴사 전에 끝낼 수 있음)
		if(day+T[day]-1<=N) {//상담 일수 카운트에 -1의미 : 2틀 걸리는데 1일 시작시+2일하면 3일라서 -1해줘야
			result = Math.max(result,P[day]+dfs(day+T[day]));
				
		}
		//당일 상담안하고 넘어가는 경우
		result = Math.max(result, dfs(day+1));//여기서 dfs(2)호출
		
		return memo[day]=result; //메모에 이미 계산한 최대 보수 넣고 바로 리턴때림
	
	}

}
