import java.util.Scanner;
import java.io.FileInputStream;

class Main {
	static int[][] arr;
	static boolean[] visited;
	static int d;
	static int w;
	static int k;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			d = sc.nextInt(); // 세로
			w = sc.nextInt(); // 가로
			k = sc.nextInt(); // 합격 기준

			arr = new int[d][w];
			visited = new boolean[d];

			for (int i = 0; i < d; i++) {
				for (int j = 0; j < w; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			min = d;

			for (int i = 0; i < d; i++) {
				visited = new boolean[d];
				if (comb(0, 0, i)) {
					min = i;
					break;
				}
			}

			System.out.println("#" + tc + " " + min);
		}
	}

	static boolean comb(int depth, int sel, int r) { // n개 라인 중 m개를 선택해서 변환하겠다.
		if (sel == r) {
			return comb2(0);
		}

		if (depth == d) {
			return false;
		}

		visited[depth] = true;
		if (comb(depth + 1, sel + 1, r))
			return true;

		visited[depth] = false;
		if (comb(depth + 1, sel, r))
			return true;

		return false;
	}

	static boolean comb2(int depth2) { // 선택 된 m개를 각 a, b로 변환하겠다.
		if (depth2 == d) {
			return check();
		}

		if (!visited[depth2]) {
			return comb2(depth2 + 1);
		}

		int[] o = arr[depth2].clone();
		for (int j = 0; j < w; j++) {
			arr[depth2][j] = 0;
		}

		if (comb2(depth2 + 1))
			return true;

		for (int j = 0; j < w; j++) {
			arr[depth2][j] = 1;
		}

		if (comb2(depth2 + 1))
			return true;

		arr[depth2] = o;

		return false;
	}

	static boolean check() {
		for (int j = 0; j < w; j++) {
			int cnt = 0;
			int type = -1;
			for (int i = 0; i < d; i++) {
				int n = arr[i][j];

				if (type == n) {
					cnt++;
					if (cnt >= k) {
						break;
					}
				} else {
					type = n;
					cnt = 1;
				}
			}

			if (cnt < k) {
				return false;
			}
		}

		return true;
	}
}
