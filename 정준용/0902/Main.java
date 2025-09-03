//https://www.acmicpc.net/problem/2178
//우선순위큐
import java.util.*;

public class Main {
	static int N, M, map[][];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		sc.nextLine();
		map = new int[N][M];
		int sum[][] = new int[N][M]; 
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				sum[i][j] = Integer.MAX_VALUE;
			}
		}
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0] - b[0]);
		sum[0][0] = map[0][0];
		q.add(new int[] {1, 0, 0});
		

		while (!q.isEmpty()) {
			int temp [] = q.poll();
			if(temp[1] == N-1 && temp[2] == M-1)break;
			for(int i = 0 ; i < 4; i++) {
				int nx = temp[1] + dx[i];
				int ny = temp[2] + dy[i];
				
				if(nx< 0|| ny < 0 || nx >= N || ny >= M) continue;
				if( map[nx][ny] == 0 )continue;
				int cost = temp[0] + map[nx][ny];
				if(cost < sum[nx][ny]) {
					sum[nx][ny] = cost ; 
					q.add(new int[] {cost, nx, ny});
				}
			}
		}
		System.out.println(sum[N-1][M-1]);
	}
}
