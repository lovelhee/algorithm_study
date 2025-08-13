package solvingProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Study0812 {

	static int min = 10000000;

	public static void main(String[] args) throws Exception {

		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bReader.readLine());

		int[][] cap = new int[n][n];

		boolean[] visited = new boolean[n];
		visited[0] = true;

		for (int i = 0; i < cap.length; i++) {
			String[] inputStrings = bReader.readLine().split(" ");
			for (int j = 0; j < inputStrings.length; j++) {
				cap[i][j] = Integer.parseInt(inputStrings[j]);
			}
		}

		comb(1, n / 2 - 1, cap, visited);
		System.out.println(min);

	}

	private static void comb(int start, int r, int[][] cap, boolean[] visited) {

		if (r == 0) {
			// 다 뽑아쏭
			int startTeam = 0;
			int linkTeam = 0;
			
			for (int i = 0; i < cap.length; i++) {
				for (int j = i + 1; j < cap.length; j++) {
					if (visited[i] && visited[j]) {
						startTeam += cap[i][j] + cap[j][i];
					} else if (!visited[i] && !visited[j]) {
						linkTeam += cap[i][j] + cap[j][i];
					}
				}
			}
			
			int diff = startTeam - linkTeam;
			
			if (diff < 0) {
			    diff = -diff;     
			}

			if (diff < min) {         
			    min = diff;
			}

			return;
			
		} else {
			for (int i = start; i < cap.length; i++) {
				visited[i] = true;
				comb(i + 1, r - 1, cap, visited);
				visited[i] = false;
			}
		}
	}
}
