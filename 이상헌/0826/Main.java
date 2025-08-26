import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			arr.clear();
			
			n = sc.nextInt();
			m = sc.nextInt();
			
			visited = new boolean[n + 1];
			
			for(int i = 0; i < n + 1; i++) {
				arr.add(new ArrayList<Integer>());
			}
			
			for(int i = 0; i < m; i++) {
				int to = sc.nextInt();
				int ta = sc.nextInt();
				
				arr.get(to).add(ta);
				arr.get(ta).add(to);
			}
			
			int cnt = 0;
			
			for(int i = 1; i < n + 1; i++) {
				if(!visited[i]) {
					dfs(i);
					cnt++;
				}
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
	}
	
	static void dfs(int idx) {
		if(idx > n) {
			return;
		}
		
		visited[idx] = true;
		for(int next : arr.get(idx)) {
			if(!visited[next]) {
				dfs(next);
			}
		}
	}
}
