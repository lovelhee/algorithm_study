import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bReader.readLine());

		int[] day = new int[n];
		int[] pay = new int[n];

		for (int i = 0; i  n; i++) {
			String[] inputStrings = bReader.readLine().split( );
			day[i] = Integer.parseInt(inputStrings[0]);
			pay[i] = Integer.parseInt(inputStrings[1]);
		}

		int[] dp = new int[n + 1]; 

		for (int i = n - 1; i = 0; i--) {
			if (i + day[i] = n) {
				dp[i] = Math.max(pay[i] + dp[i + day[i]], dp[i + 1]);
			} else {
				dp[i] = dp[i + 1];
			}
		}

		System.out.println(dp[0]);
	}
}
