package solvingProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Study0812 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bReader.readLine());
		
		int[][] cap = new int[n][n];
		
		boolean[] visited = new boolean[n/2];
		
		for (int i = 0; i < cap.length; i++) {
			String[] inputStrings = bReader.readLine().split(" ");
			for (int j = 0; j < inputStrings.length; j++) {
				cap[i][j] = Integer.parseInt(inputStrings[j]);
			}
		}
		
		comb(n, n/2, cap, visited);
		
		
	}

	private static void comb(int start, int r, int[][] cap, boolean[] visited) {
		
		if (r==0) {
			// 다 뽑아쏭
			
			return;
		} else {
			for (int i = start; i < cap.length; i++) {
				visited[i] = true;
				comb(i+1, r-1, cap, visited);
				visited[i] = false;
			}
		}
		
	}
}
