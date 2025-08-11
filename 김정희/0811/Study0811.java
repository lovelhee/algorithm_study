package solvingProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Study0811 {
	public static void main(String[] args) throws Exception {

		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			String[] inputStrings = bReader.readLine().split(" ");
			int w = Integer.parseInt(inputStrings[0]);
			int h = Integer.parseInt(inputStrings[1]);
			int[][] sea = new int[h][w];
			boolean[][] visited = new boolean[h][w];

			if (w == 0 && h == 0) {
				break;
			}

			for (int i = 0; i < h; i++) {
				String[] numInputStrings = bReader.readLine().split(" ");
				for (int j = 0; j < w; j++) {
					sea[i][j] = Integer.parseInt(numInputStrings[j]);
				}
			}

			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (sea[i][j] == 1 && visited[i][j] == false) {
						dfs(i, j, visited, sea, w, h);
						count++;
					}
				}
			}

			System.out.println(count);

		}

	}

	private static void dfs(int i, int j, boolean[][] visited, int[][] sea, int w, int h) {
		visited[i][j] = true;

		int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

		for (int k = 0; k < 8; k++) {
			int xx = i + dx[k];
			int yy = j + dy[k];

			if (xx < 0 || xx >= h || yy < 0 || yy >= w) {
				continue;
			}

			if (sea[xx][yy] == 0 || visited[xx][yy] == true) {
				continue;
			}

			dfs(xx, yy, visited, sea, w, h);
		}

	}
}
