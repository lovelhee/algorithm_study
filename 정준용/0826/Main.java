// BFS 형식으로 BFS 가 실행될때마다 count 증가
import java.util.*;

public class Main {
	static boolean visited[];
	static List<List<Integer>> list ;
	static int N, M;
	static void BFS(int a) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		visited[a] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next: list.get(cur)) {
				if(visited[next]) continue;
				visited[next] = true;
				q.add(next);
			}
		}
	
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			visited= new boolean[N+1];
			int count = 0;
            list = new ArrayList<>(); 
            
			for (int i = 0; i <= N; i++) { 
			    list.add(new ArrayList<>());
			}

			for(int i = 0 ; i < M; i++) {
				int p1 = sc.nextInt();
				int p2 = sc.nextInt();
				
				list.get(p1).add(p2);
				list.get(p2).add(p1);
			}
			
			for(int i= 1 ; i <= N; i++) {
				if(!visited[i]) {
					BFS(i);
					count++;
				}
			}
			
			System.out.println("#" + tc + " " + count);
			
			
		}
	}
}
