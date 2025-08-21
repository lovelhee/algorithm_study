import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 육지 L, 바다 W
 */
public class Main {
	static int h;
	static int w;
	static boolean[][] map;
	static boolean[][] visited;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int maxDistance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		map = new boolean[h][w];
		
		for(int i = 0; i < h; i++) {
			String s = br.readLine();
			for(int j = 0; j < w; j++) {
				map[i][j] = s.charAt(j) == 'W' ? false : true;
			}
		}
		
		maxDistance = -1;
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(map[i][j]) {
					visited = new boolean[h][w];
					bfs(j, i);
				}
			}
		}
		
		System.out.println(maxDistance - 1);
	}
	
	static void bfs(int x, int y) {
		Queue<Integer[]> q = new LinkedList<Integer[]>();
		
		visited[y][x] = true;
		
		q.offer(new Integer[] {y, x});
		
		int d = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s < size; s++) {
				Integer[] arr = q.poll();
			
				for(int i = 0; i < 4; i++) {
					int ny = arr[0] + dy[i];
					int nx = arr[1] + dx[i];
					
					if(isValid(nx, ny) && !visited[ny][nx] && map[ny][nx]) {
						visited[ny][nx] = true;
						q.offer(new Integer[] { ny, nx });
					}
				}
			}
			
			d++;
		}
		
		maxDistance = Math.max(maxDistance, d);
	}
	
	static boolean isValid(int x, int y) {
		return x >= 0 && x < w && y >= 0 && y < h;
	}
}
