
import java.util.Scanner;

public class Main {
	static int t, d, w, k;
	static int[][] map;
	static int[] vis;// 뿌릴 약품 종류를 지정한다. a(1), b(2)
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			d = sc.nextInt();
			w = sc.nextInt();
			k = sc.nextInt();
			map = new int[d][w];
			vis = new int[d + 1];
			answer = d;
			for (int i = 0; i < d; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}

//			 -- 입력 끝 ---
			// 초기 검사
			if (check(map)) {
				System.out.printf("#%d %d\n", tc, 0);
				continue;
			}
			comb(0, 0);
			System.out.printf("#%d %d\n", tc, answer);

		}

	}

	private static void comb(int idx, int cnt) {
		if (cnt > answer)
			return;
		if (idx == d) {
			if (check(map)) {
				if (answer > cnt)
					answer = cnt;// 고른 행의 개수
			}

			return;
		}

		vis[idx] = 1;// a를 뿌림
		comb(idx + 1, cnt + 1);
		vis[idx] = 2;// b를 뿌림
		comb(idx + 1, cnt + 1);
		vis[idx] = 0;// 선택 안함
		comb(idx + 1, cnt);

	}

	// k 기준 통과했는지
	private static boolean check(int[][] map) {
		for (int j = 0; j < w; j++) {
			boolean flag = false;
			int cnt = 1;
			for (int i = 1; i < d; i++) {
				int a = map[i - 1][j];
				int b = map[i][j];
				if (vis[i - 1] != 0) {
					a = vis[i - 1] == 1 ? 0 : 1;
				}
				if (vis[i] != 0) {
					b = vis[i] == 1 ? 0 : 1;
				}
				if (a == b) {
					cnt += 1;
				} else {
					cnt = 1;
				}
				if (cnt == k) {
					flag = true;// 통과함
					break;
				}
			}
			if (!flag)
				return false; // 통과 못한 열이 있다.
		}

		return true;
	}
}
