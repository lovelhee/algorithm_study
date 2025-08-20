
import java.util.Scanner;

public class Main {
	static int t, d, w, k;
	static int[][] map;
	static int[] vis;// �Ѹ� ��ǰ ������ �����Ѵ�. a(1), b(2)
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

//			 -- �Է� �� ---
			// �ʱ� �˻�
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
					answer = cnt;// �� ���� ����
			}

			return;
		}

		vis[idx] = 1;// a�� �Ѹ�
		comb(idx + 1, cnt + 1);
		vis[idx] = 2;// b�� �Ѹ�
		comb(idx + 1, cnt + 1);
		vis[idx] = 0;// ���� ����
		comb(idx + 1, cnt);

	}

	// k ���� ����ߴ���
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
					flag = true;// �����
					break;
				}
			}
			if (!flag)
				return false; // ��� ���� ���� �ִ�.
		}

		return true;
	}
}
