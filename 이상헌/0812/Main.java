import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ14889 :: 스타트와 링크
 * 브루트포스, 백트래킹, 조합론
 * 
 * 첫 째 줄에는 N(4 <= N <= 20, N%2 == 0)
 * 둘 째 줄부터 S
 * 
 * 이 때, 스타트 팀과 링크 팀의 능력치 차이의 최솟값을 출력한다.
 */

public class Main {
	static int n;
	static int[][] arr;
	static boolean[] team;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		team = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		comb(0, 0);
		
		System.out.println(min);
	}
	
	static void comb(int idx, int depth) {
		if(depth == n/2) {
			min = Math.min(min, calc());
			return;
		}
		
		for (int i = idx; i < n; i++) {
			team[i] = true;
			comb(i + 1, depth + 1);
			team[i] = false;
		}
	}
	
	static int calc() {
		int t1 = 0;
		int t2 = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if(team[i] && team[j]) {
					t1 += arr[i][j] + arr[j][i];
				}
				else if(!team[i] && !team[j]) {
					t2 += arr[i][j] + arr[j][i];
				}
			}
		}
		
		return Math.abs(t1 - t2);
	}
}