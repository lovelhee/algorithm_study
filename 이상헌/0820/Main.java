import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int n;
	static int m;
	static int[] dx = {0, 1, 0, -1}; // 북 동 남 서
	static int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()); // 로봇 청소기가 있는 y좌표
		int c = Integer.parseInt(st.nextToken()); // '' x좌표
		int d = Integer.parseInt(st.nextToken()); // 0 북 1 동 2 남 3 서
		
		arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		
		while(true) {
			// 1. 현재 칸 청소
			if(arr[r][c] == 0) {
				arr[r][c] = 2;
				cnt++;
			}
			
			// 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우.(청소할데 없으면)
			int z = check4(r, c);
			if(z == -1) {
				int back = (d + 2) % 4;
				int nr = r + dy[back];
				int nc = c + dx[back];
				
				if(arr[nr][nc] != 1) { // 후진 가능?
					r = nr;
					c = nc;
					continue;
				}
				else { // 불가능?
					break;
				}
			}
			// 3. 청소 안된 빈칸 있으면.
			else {
				d = d - 1;
				if(d == -1) {
					d = 3;
				}
				
				int nr = r + dy[d];
				int nc = c + dx[d];
				
				if(arr[nr][nc] == 0) {
					r = nr;
					c = nc;
					continue;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	static int check4(int r, int c) {
		// 0 북 1 동 2 남 3 서
		for(int i = 0; i < 4; i++) {
			int nr = r + dy[i];
			int nc = c + dx[i];
			
			if(isValid(nr, nc) && arr[nr][nc] == 0) {
				return i;
			}
		}
		
		return -1;
	}
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}
}
