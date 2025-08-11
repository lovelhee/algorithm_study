import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ4963 :: 섬의 개수
 * DFS/BFS
 * 
 * 여러개의 테스트케이스, 마지막 입력은 0 0
 * 첫 째 줄에는 너비 w, 높이 h.(0 < w, h <= 50)
 * 둘 째 줄부터 지도. 1은 땅, 0은 바다.
 * 
 * 이 때, 가로, 세로, 대각선으로 연결된 섬의 갯수를 구하라.
 */
public class Main {
	static boolean[][] arr;
	static boolean[][] visited;
	static int w;
	static int h;
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String[] tmp = br.readLine().split(" ");
			w = Integer.parseInt(tmp[0]);
			h = Integer.parseInt(tmp[1]);
			
			if(w == 0 && h == 0) {
				break;
			}
			
			arr = new boolean[h][w];
			visited = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				tmp = br.readLine().split(" ");
				for(int j = 0; j < w; j++) {
					arr[i][j] = tmp[j].equals("1") ? true : false;
				}
			}
			
			int cnt = 0;
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					cnt = dfs(j, i) ? cnt + 1 : cnt;
				}
			}
			
			sb.append(cnt + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static boolean dfs(int x, int y) {
		if(visited[y][x] || !arr[y][x]) return false;
		
		visited[y][x] = true;
		
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isValid(nx, ny) && !visited[ny][nx] && arr[ny][nx]) {
				dfs(nx, ny);
			}
		}
		
		return true;
	}
	
	static boolean isValid(int nx, int ny) {
		return nx >= 0 && nx < w && ny >= 0 && ny < h;
	}
}