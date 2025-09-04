import java.util.Scanner;

public class 도만맛음 {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int[] S, B;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		N = sc.nextInt();
		
		S = new int[N];
		B = new int[N];
		
		for (int i = 0; i < N; i++) {
			S[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}
		
		dfs(0, 1, 0, 0);
		
		System.out.println(min);
	}	
	
	static void dfs(int idx, int gob, int sum, int count) {
		if (idx == N) {
			if (count > 0) {
				min = Math.min(min, Math.abs(gob - sum));
			}
			
			return;
		}
		
		dfs(idx + 1, gob * S[idx], sum + B[idx], count + 1);
		
		dfs(idx + 1, gob, sum, count);
	}
}


