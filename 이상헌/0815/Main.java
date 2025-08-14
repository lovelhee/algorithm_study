import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 1) {
					q.offer(new int[] {i, j});
				}
			}
		}
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int s = 0; s < size; s++) {
				int[] crnt = q.poll();
				int y = crnt[0];
				int x = crnt[1];
				
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(isValid(nx, ny) && arr[ny][nx] == 0) {
						arr[ny][nx] = 1;
						q.offer(new int[] {ny, nx});
					}
				}
			}
			
			if(!q.isEmpty()) {
				cnt++;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 0) {
					return -1;
				}
			}
		}
		
		return cnt;
	}
	
	static boolean isValid(int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}
}
