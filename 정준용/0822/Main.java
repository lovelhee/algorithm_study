// https://www.acmicpc.net/problem/18405
//BFS 로 풀음 1인 값을 먼저 q에 넣고 함
import java.util.*;
public class Main {
	static int map[][];
	static int N, K, T;
	static int [] dx = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	static Queue<int[]> q;
	
	static void Check(int t) {
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				if(map[i][j] == t)
					q.add(new int[] {i, j, t});
			}
		}
	}
	
	static void BFS() {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		int time = 0;
		q = new LinkedList<>();
		for(int i = 1 ; i <= K; i++)
			Check(i);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0 ; i< size; i++) {
				int cur[] = q.poll();
				int val = cur[2];
				for(int j = 0 ; j < 4; j++) {
					int nx = cur[0] + dx[j];
					int ny = cur[1] + dy[j];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] != 0) continue;
					map[nx][ny] = val;
					q.add(new int[] { nx, ny, val});
				}
			}
			if(T == ++time) {
				break;
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		T = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		
		if(T == 0) {
		}else {
			BFS();			
		}
		System.out.println(map[X-1][Y-1]);
		
		
	}

}
