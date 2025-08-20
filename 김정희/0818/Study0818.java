import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Study0818 {

	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bufferedReader.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			String[] dwk = bufferedReader.readLine().split(" ");
			int d = Integer.parseInt(dwk[0]);
			int w = Integer.parseInt(dwk[1]);
			int k = Integer.parseInt(dwk[2]);

			int[][] film = new int[d][w];

			for (int i = 0; i < d; i++) {
				String[] ab = bufferedReader.readLine().split(" ");
				for (int j = 0; j < w; j++) {
					film[i][j] = Integer.parseInt(ab[j]);
				}
			}

			min = k;

			// 0번째 행부터, 약물 0번
			dfs(0, 0, d, w, film, k);

			System.out.println("#" + test_case + " " + min);

		}
	}

	private static void dfs(int hang, int drug, int d, int w, int[][] film, int k) {

		if (drug >= min) {
			return;
		}

		if (hang == d) {
			// 성능 검사
			if (check(d, w, film, k)) {
				min = Math.min(min, drug);
			}
			return;
		}
		
		// 약물 X
		dfs(hang+1, drug, d, w, film, k);
		
		// 약물 A
		for (int i = 0; i < w; i++) {
			film[hang][i] = 0;
		}
		dfs(hang+1, drug+1, d, w, film, k);
		
		// 약물 B
		for (int i = 0; i < w; i++) {
			film[hang][i] = 1;
		}
		dfs(hang+1, drug+1, d, w, film, k);

	}

	// 성능 검사
	private static boolean check(int d, int w, int[][] film, int k) {

		for (int i = 0; i < w; i++) {
			// 몇 개 연속
			int yeonsok = 1;
			// 최대 몇 개 연속
			int maxYeonsok = 1;
			for (int j = 1; j < d; j++) {
				if (film[j][i] == film[j - 1][i]) {
					yeonsok++;
				} else
					yeonsok = 1;
				maxYeonsok = Math.max(maxYeonsok, yeonsok);
			}
			if (maxYeonsok < k) {
				return false;
			}
		}

		return true;
	}
}
