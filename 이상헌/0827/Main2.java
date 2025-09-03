import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	static int n;
	static int m;
	static char[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static int sX;
	static int sY;

	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == '0') {
					sX = j;
					sY = i;
				}
			}
		}

		// 2^0 ~ 2^6
		visited = new boolean[n][m][64];

		System.out.println(bfs());
	}

	static int bfs() {
		Queue<Integer[]> q = new LinkedList<Integer[]>();
		int keyState = 0;
		int cnt = 0;

		visited[sY][sX][keyState] = true;

		q.offer(new Integer[] { sY, sX, keyState, cnt });

		while (!q.isEmpty()) {
			Integer[] arr = q.poll();

			int x = arr[1];
			int y = arr[0];
			keyState = arr[2];
			cnt = arr[3];

			if (map[y][x] == '1') {
				return cnt;
			}

			if (Character.isLowerCase(map[y][x])) { // 소문자 알파벳 = 열쇠
				char c = map[y][x];
				keyState |= (1 << (c - 'a'));
			}

			for (int i = 0; i < 4; i++) {
				int nX = x + dx[i];
				int nY = y + dy[i];

				if (isValid(nX, nY)) {
					// 문?
					if (Character.isUpperCase(map[nY][nX])) {
						char c = map[nY][nX];
						int bitPosition = c - 'A';

						if ((keyState & (1 << bitPosition)) != 0) { // 키 있음

							if (!visited[nY][nX][keyState]) {
								visited[nY][nX][keyState] = true;
								q.offer(new Integer[] { nY, nX, keyState, cnt + 1 });
							}
						}

						continue;
					}

					if (!visited[nY][nX][keyState]) {
						visited[nY][nX][keyState] = true;
						q.offer(new Integer[] { nY, nX, keyState, cnt + 1 });
					}
				}
			}
		}

		return -1;
	}

	static boolean isValid(int nx, int ny) {
		return nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] != '#';
	}
}
