//https://www.acmicpc.net/problem/16395
// dp 말고는 푸는 방법이 안떠오름 기존값에 더하고 더한느것인데........
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int [][]dp = new int[31][31];
		for(int i = 0 ; i < 31; i++) {
				dp[i][0] = 1;
				dp[i][i] = 1;
		}
		
		for(int i = 1; i < 31; i++) {
			for(int j = 1; j < 31; j++) {
				dp[i][j] = dp[i-1][j-1] + dp [i-1][j];
			}
		}
	
		System.out.println(dp[n-1][k-1]);
	}
}
