import java.util.Scanner;

public class Main {
	static int w, h;
	static int map[][];
	static int nx, ny;
	static int dx[] = { 0, 0, -1, 1, -1, 1, 1, -1 };
	static int dy[] = { -1, 1, 0, 0, 1, 1, -1, -1 };
	static boolean visit[][];
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();

			if (w == 0 && h == 0) {
				break;
			}

			map = new int[h + 1][w + 1];
			visit = new boolean[h + 1][w + 1];

			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					if (!visit[i][j] && map[i][j] == 1) {
						count++;
						dfs(i, j);
					}
				}
			}

			System.out.println(count);
			count = 0;
		}
	}

	public static void dfs(int x, int y) {
		visit[x][y] = true;

		for (int i = 0; i < 8; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if (nx > 0 && nx <= h && ny > 0 && ny <= w) {
				if (!visit[nx][ny] && map[nx][ny] == 1) {
				    dfs(nx, ny);
				}
			}
		}
	}
}
