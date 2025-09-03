import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int n;
	static int k;
	static int s;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		s = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		bfs();
		
		System.out.println(arr[x - 1][y - 1]);
	}
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		int t = 0;
		boolean[][] visited = new boolean[n][n];
		
		for(int i = 1; i <= k; i++) {
			for(int y = 0; y < n; y++) {
				for(int x = 0; x < n; x++) {
					if(arr[y][x] == i) {
						visited[y][x] = true;
						q.offer(new int[] {x, y});
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			if(t == s) {
				break;
			}
			
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				int[] tmp = q.poll();
				
				int x = tmp[0];
				int y = tmp[1];
				
				for(int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if(isValid(nx, ny) && !visited[ny][nx] && arr[ny][nx] == 0) {
						visited[ny][nx] = true;
						arr[ny][nx] = arr[y][x];
						q.offer(new int[] {nx, ny});
					}
				}
			}
			
			t++;
		}
		
	}
	
	static boolean isValid(int nx, int ny) {
		return nx >= 0 && nx < n && ny >= 0 && ny < n;
	}
}
