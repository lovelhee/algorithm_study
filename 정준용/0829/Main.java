import java.util.*;

public class Main {
	static int N, M, D;
	static int[][] map;
	static int maxKill = 0;
	static int dx[] = {0, -1, 0};
	static int dy[] = {-1, 0, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();

		map = new int[N][M];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();

		for (int i = 0; i < M - 2; i++)
			for (int j = i + 1; j < M - 1; j++)
				for (int k = j + 1; k < M; k++) {
					int[][] temp = new int[N][M];

					for (int r = 0; r < N; r++)
						for (int c = 0; c < M; c++)
							temp[r][c] = map[r][c];
					simulate(temp, new int[] { i, j, k });
				}

		System.out.println(maxKill);
	}

	static void simulate(int[][] temp, int[] archers) {
		int kill = 0;

		for (int t = 0; t < N; t++) {
			List<int[]> targets = new ArrayList<>();
			for (int a : archers) {
				int[] target = find(temp, N, a);
				if (target != null)
					targets.add(target);
			}
			
			for (int[] n : targets) {
				int x = n[0], y = n[1];
				if (temp[x][y] == 1) {
					temp[x][y] = 0;
					kill++;
				}
			}
			
			for (int i = N - 1; i > 0; i--)
				temp[i] = Arrays.copyOf(temp[i - 1], M);
			Arrays.fill(temp[0], 0);
		}
		maxKill = Math.max(maxKill, kill);
	}

	static int[] find(int[][] temp, int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		q.add(new int[] { row - 1, col, 1 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0], y = cur[1], d = cur[2];
			if (x < 0 || y < 0 || x >= N || y >= M || visited[x][y] || d > D)	continue;
			
			visited[x][y] = true;
			
			if (temp[x][y] == 1)
				return new int[] { x, y };
			
			for (int dir = 0; dir < 3; dir++)
				q.add(new int[] { x + dx[dir], y + dy[dir], d + 1 });
			
		}
		return null;
	}
}
