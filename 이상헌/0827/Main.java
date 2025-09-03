import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//import java.util.LinkedList;
import java.util.PriorityQueue;
//import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
//	static boolean[][] visited; 
	static int min;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = 0;
		while(true) {
			tc++;
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			if(n == 0) break;
			
			map = new int[n][n];
//			visited = new boolean[n][n];
			min = Integer.MAX_VALUE;
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			bfs();
			dijkstra();
				
			sb.append("Problem ").append(tc).append(":").append(" ").append(min).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
		int[][] dist = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		dist[0][0] = map[0][0];
		
		pq.offer(new int[] {0, 0, map[0][0]});
		
		while(!pq.isEmpty()) {
			int[] crnt = pq.poll();
			int y = crnt[0];
			int x = crnt[1];
			int lost = crnt[2];
			
			if(lost > dist[y][x]) continue;
			
			if(y == n-1 && x == n-1) {
				min = lost;
				return;
			}
			
			for(int i = 0; i < 4; i++) {
	            int ny = y + dy[i];
	            int nx = x + dx[i];
	            
	            if(isValid(nx, ny)) {
	                int newCost = lost + map[ny][nx];
	                if(newCost < dist[ny][nx]) {
	                    dist[ny][nx] = newCost;
	                    pq.offer(new int[]{ny, nx, newCost});
	                }
	            }
			}
		}
	}
	
//	static void bfs() {
//		Queue<Integer[]> q = new LinkedList<Integer[]>();
//		
//		visited[0][0] = true;
//		q.offer(new Integer[] {0, 0, map[0][0]});
//		
//		while(!q.isEmpty()) {
//			Integer[] arr = q.poll();
//			
//			int y = arr[0];
//			int x = arr[1];
//			int lost = arr[2];
//			
//			if(y == n - 1 && x == n - 1) {
//				min = Math.min(min, lost);
//				continue;
//			}
//			
//			for(int i = 0; i < 4; i++) {
//				int ny = y + dy[i];
//				int nx = x + dx[i];
//				
//				if(isValid(nx, ny) && !visited[ny][nx]) {
//					visited[ny][nx] = true;
//					q.offer(new Integer[] {ny, nx, lost + map[ny][nx]});
//				}
//			}
//		}
//	}
	
	static boolean isValid(int nx, int ny) {
		return nx >= 0 && nx < n && ny >= 0 && ny < n;
	}
}
