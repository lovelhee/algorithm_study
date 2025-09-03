import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int n;
	static int m;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
				
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		
		visited[0][0] = true;
		
		q.offer(new int[] {0, 0, 1});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[1];
			int y = tmp[0];
			int cnt = tmp[2];
			
			if(y == n - 1 && x == m - 1) {
				return cnt;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(isValid(nx, ny) && !visited[ny][nx]) {
					visited[ny][nx] = true;
					q.offer(new int[] {ny, nx, cnt + 1});
				}
			}
		}
		
		return -1;
	}
	
	static boolean isValid(int nx, int ny) {
		return nx >= 0 && nx < m && ny >= 0 && ny < n
				&& arr[ny][nx] == 1;
	}
}
