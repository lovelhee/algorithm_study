package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Study0820 {
	public static void main(String[] args) throws Exception {

		BufferedReader brBufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] nmInput = brBufferedReader.readLine().split(" ");
		int n = Integer.parseInt(nmInput[0]);
		int m = Integer.parseInt(nmInput[1]);

		String[] rcdInput = brBufferedReader.readLine().split(" ");
		int r = Integer.parseInt(rcdInput[0]);
		int c = Integer.parseInt(rcdInput[1]);
		int d = Integer.parseInt(rcdInput[2]);

		int[][] state = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] stateInput = brBufferedReader.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				state[i][j] = Integer.parseInt(stateInput[j]);
			}
		}

		int clean = 0;

		while (true) {

			// 1단계
			if (state[r][c] == 0) {
				state[r][c] = 2;
				clean++;
			}

			// 2단계
			boolean noClean = false;
			if (r - 1 >= 0 && state[r - 1][c] == 0)
				noClean = true;
			else if (c + 1 < m && state[r][c + 1] == 0)
				noClean = true;
			else if (r + 1 < n && state[r + 1][c] == 0)
				noClean = true;
			else if (c - 1 >= 0 && state[r][c - 1] == 0)
				noClean = true;

			if (!noClean) {
				// 주변에 0이 하나도 없으면 뒤로 한 칸
				if (d == 0) {
					if (r + 1 < n && state[r + 1][c] != 1) {
						r += 1;
						continue;
					} else
						break; // 뒤가 벽이면 종료
				} else if (d == 1) {
					if (c - 1 >= 0 && state[r][c - 1] != 1) {
						c -= 1;
						continue;
					} else
						break;
				} else if (d == 2) {
					if (r - 1 >= 0 && state[r - 1][c] != 1) {
						r -= 1;
						continue;
					} else
						break;
				} else {
					if (c + 1 < m && state[r][c + 1] != 1) {
						c += 1;
						continue;
					} else
						break;
				}
			}

			// 3단계
			int trytry = 0;
			boolean canMove = false;
			// 4방향 회전
			while (trytry < 4) {
				if (d == 0)
					d = 3;
				else if (d == 1)
					d = 0;
				else if (d == 2)
					d = 1;
				else
					d = 2;
				// 청소 안되어이쓰면 -> 이동 후 1단계로
				if (d == 0) {
					if (r - 1 >= 0 && state[r - 1][c] == 0) {
						r -= 1;
						canMove = true;
						break;
					}
				} else if (d == 1) {
					if (c + 1 < m && state[r][c + 1] == 0) {
						c += 1;
						canMove = true;
						break;
					}
				} else if (d == 2) {
					if (r + 1 < n && state[r + 1][c] == 0) {
						r += 1;
						canMove = true;
						break;
					}
				} else {
					if (c - 1 >= 0 && state[r][c - 1] == 0) {
						c -= 1;
						canMove = true;
						break;
						// continue; 위에 두 줄 없이 이거만 쓰면 시간 초과
					}
				}

				// 이 방향 청소 안하면 다른 방향
				trytry++;

			}

			if (canMove) {
				continue;
			}

		}

		System.out.println(clean);
	}
}
