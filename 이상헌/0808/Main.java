import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * BOJ15989 :: 1, 2, 3 더하기 4 
 * 정수 N을 1, 2, 3의 합으로 나타내는 방법의 수를 구하라.
 * 
 * 첫째 줄에는 테스트 케이스의 개수 T,
 * 그 아래부터 정수 N(0 < N <= 10000)
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] dp = new int [n + 1];
			dp[0] = 1;
			
			for(int i = 1; i <= 3; i++) {
				for(int j = i; j <= n; j++) {
					dp[j] += dp[j - i];
				}
			}
			
			bw.append(dp[n] + "\n");
			
		}
		
		bw.flush();
	}
}
