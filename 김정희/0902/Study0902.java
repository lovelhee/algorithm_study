package solvingProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

public class Study0902 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nmInputStrings = bReader.readLine().split(" ");
		int N = Integer.parseInt(nmInputStrings[0]);
		int M = Integer.parseInt(nmInputStrings[1]);
		int miro[][] = new int [N][M];
		
		for (int i = 0; i < N; i++) {
			String[] miroInputStrings = bReader.readLine().split("");
			for (int j = 0; j < miroInputStrings.length; j++) {
				miro[i][j] = Integer.parseInt(miroInputStrings[j]);
			}
		}
		
		int dist[][] = new int[N][M];
		boolean visited[][] = new boolean[N][M];
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Queue<int[]> queue = new ArrayDeque<int[]>();
		
		visited[0][0] = true;
		dist[0][0] = 1;
		queue.offer(new int[] {0,0});
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				if (miro[nx][ny] == 0) {
					continue;
				}
				if (visited[nx][ny]) {
					continue;
				}
				
				visited[nx][ny] = true;
				dist[nx][ny] = dist[x][y] + 1;
				queue.offer(new int[] {nx, ny});
			}
		}
		
		System.out.println(dist[N-1][M-1]);
		
		
		
	}
}
