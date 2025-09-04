//https://www.acmicpc.net/problem/17471
import java.util.*;

public class Main {
	static int N, ans = Integer.MAX_VALUE;
	static int []arr;
	static List<Integer> l [];
	static boolean team[];
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		 N = sc.nextInt();
		arr= new int[N+1];
		l = new ArrayList[N+1];
		team = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
			l[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i <= N; i++) {
			int k = sc.nextInt();
			for(int j = 0 ; j < k; j++) {
				l[i].add(sc.nextInt());
			}
		}
		
		DFS(1);
		System.out.println(ans == Integer.MAX_VALUE? -1 : ans);
		
		
	}
	static void DFS(int i ) {
		if(N+1 == i) {
			int cntA = 0, cntB = 0;
			for(int j = 1; j <= N; j++) {
				if(team[j]) cntA++;
				else cntB++;
			}
			
			if(cntA == 0 || cntB == 0)return;
			
			if(connected(true) && connected(false)) {
				int sumA = 0, sumB = 0;
				for(int j= 1; j <=N; j++) {
					if(team[j]) sumA+=arr[j];
					else sumB+=arr[j]; 
				}
				ans = Math.min(Math.abs(sumA-sumB), ans);
			}
			return;
		}
		
		team[i] = true;
		DFS(i+1);
		team[i] = false;
		DFS(i+1);
		return;
	}
	
	static boolean connected(boolean g) {
		boolean visited[] = new boolean[N+1];
		int start = -1;
		int temp = 0;
		for(int i = 1; i <= N; i++) {
			if(team[i] == g) {
				temp++;
				if(start == -1) start = i;
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		visited[start] = true;
		q.add(start);
		int got = 1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : l[cur]) {
				if(!visited[next] && team[next] == g) {
					q.add(next);
					visited[next] = true;
					got++;
				}
			}
			
		}
		
		
		return temp == got;
	}
}
