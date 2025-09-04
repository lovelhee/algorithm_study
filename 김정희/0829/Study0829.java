package solvingProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Study0829 {

	static int N;
	static int M;
	static int D;
	static int pan[][];
	static int cpPan[][];
	static int max = Integer.MIN_VALUE;
	static int result;

	public static void main(String[] args) throws Exception {

		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String[] nmdInputStrings = bReader.readLine().split(" ");

		N = Integer.parseInt(nmdInputStrings[0]);
		M = Integer.parseInt(nmdInputStrings[1]);
		D = Integer.parseInt(nmdInputStrings[2]);

		pan = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] canStrings = bReader.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				pan[i][j] = Integer.parseInt(canStrings[j]);
			}
		}

		for (int i = 0; i < M - 2; i++) {
			for (int j = i + 1; j < M - 1; j++) {
				for (int k = j + 1; k < M; k++) {

					cpPan = new int[N][M];
					for (int l = 0; l < N; l++) {
						cpPan[l] = pan[l].clone();
					}

					result = 0;
					int n = N - 1;
					fight(i, j, k, n);
					if (result > max) {
						max = result;
					}
				}
			}
		}

		System.out.println(max);

	}

	private static void fight(int i, int j, int k, int n) {

		if (n < 0) {
			return;
		}

		int target1R = -1;
		int target1C = -1;
		int closeI = Integer.MAX_VALUE;
		for (int r = 0; r <= n; r++) {
			for (int c = 0; c < M; c++) {
				if (cpPan[r][c] != 1) {
					continue;
				}
				int dist = Math.abs(n + 1 - r) + Math.abs(i - c);
				if (dist <= D) {
					if (dist < closeI || (dist == closeI && c < target1C)) {
						closeI = dist;
						target1R = r;
						target1C = c;
					}
				}
			}
		}

		int target2R = -1;
		int target2C = -1;
		int closeJ = Integer.MAX_VALUE;
		for (int r = 0; r <= n; r++) {
			for (int c = 0; c < M; c++) {
				if (cpPan[r][c] != 1) {
					continue;
				}
				int dist = Math.abs(n + 1 - r) + Math.abs(j - c);
				if (dist <= D) {
					if (dist < closeJ || (dist == closeJ && c < target2C)) {
						closeJ = dist;
						target2R = r;
						target2C = c;
					}
				}
			}
		}

		int target3R = -1;
		int target3C = -1;
		int closeK = Integer.MAX_VALUE;
		for (int r = 0; r <= n; r++) {
			for (int c = 0; c < M; c++) {
				if (cpPan[r][c] != 1) {
					continue;
				}
				int dist = Math.abs(n + 1 - r) + Math.abs(k - c);
				if (dist <= D) {
					if (dist < closeK || (dist == closeK && c < target3C)) {
						closeK = dist;
						target3R = r;
						target3C = c;
					}
				}
			}
		}

		if (target1R != -1 && cpPan[target1R][target1C] == 1) {
			cpPan[target1R][target1C] = 2;
			result++;
		}
		if (target2R != -1 && cpPan[target2R][target2C] == 1) {
			cpPan[target2R][target2C] = 2;
			result++;
		}
		if (target3R != -1 && cpPan[target3R][target3C] == 1) {
			cpPan[target3R][target3C] = 2;
			result++;
		}

//		for (int l = 0; l < M; l++) {
//
//			int iFightNum = 1;
//			int jFightNum = 1;
//			int kFightNum = 1;
//
//			if (pan[n][l] == 1) {
//
//				int ri = 1 + Math.abs(i - l);
//				int rj = 1 + Math.abs(j - l);
//				int rk = 1 + Math.abs(k - l);
//
//				if (ri <= D && iFightNum > 0) {
//					pan[n][l] = 2;
//					iFightNum--;
//					result++;
//				}
//				if (rj <= D && jFightNum > 0) {
//					pan[n][l] = 2;
//					jFightNum--;
//					if (pan[n][l] == 1) {
//						result++;
//					}
//
//				}
//				if (rk <= D && kFightNum > 0) {
//					pan[n][l] = 2;
//					kFightNum--;
//					if (pan[n][l] == 1) {
//						result++;
//					}
//				}
//
//			}
//
//		}

		fight(i, j, k, n - 1);

	}
}
