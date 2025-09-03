import java.util.*;


public class Main {
	public static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int[] Ai = new int[A]; 
		
		for(int i  =0 ; i< A;  i++) {
			Ai[i] = sc.nextInt();
		}
		int []dp = new int[A];
		Arrays.fill(dp, 1);
		
		for(int i = 1 ; i< A; i++) {
			for(int j = 0; j  <i ; j++) {
				if (Ai[i] > Ai[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		for(int i = 0 ; i< dp.length; i++) {
			max = max > dp[i]? max : dp[i];
		}
		System.out.println(max);
	}
}
