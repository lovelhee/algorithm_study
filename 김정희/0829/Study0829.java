package solvingProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Study0829 {
	
	static int N;
	static int M;
	static int D;
	static int pan[][];
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
		
		for (int i = 0; i < M-2; i++) {
			for (int j = i+1; j < M-1; j++) {
				for (int k = j+1; k < M; k++) {
					System.out.println(i + "/" + j + "/" + k);
					result = 0;
					int n = N-1;
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
		
		if (n<0) {
			return;
		}
		
		int[] canFightI = new int[M];
		int[] canFightJ = new int[M];
		int[] canFightk = new int[M];
		
		// i = (n+1, i), j = (n+1, j), k = (n+1, k) 
		
		for (int l = 0; l < M; l++) {
			
			int iFightNum = 1;
			int jFightNum = 1;
			int kFightNum = 1;
			
			if (pan[n][l] == 1) {
				
				int ri = Math.abs(1+ i-l );
				int rj = Math.abs(1+ j-l );
				int rk = Math.abs(1+ k-l );
				
				if (ri <= D && iFightNum > 0) {
					pan[n][l] = 2;
					iFightNum--;
					result++;
				} else if (rj <= D && jFightNum > 0) {
					pan[n][l] = 2;
					jFightNum--;
					result++;
				} else if (rk <= D && kFightNum > 0) {
					pan[n][l] = 2;
					kFightNum--;
					result++;
				}
				
				
				
			}
			
		}
		
		
		
	}
}
