package Day0808;
import java.util.Scanner;

//1,2,3더하기 4 백준 15989

//정수 n을 1,2,3 중복 조합으로 구하
public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt(); // 테스트 케이스

		for (int i = 1; i <= Tc; i++) {
			int aim = sc.nextInt();

			// i를 1,2,3의 합으로 나타내는 방법의
			int dp[] = new int[aim + 1];
			dp[0] = 1;

			int coins[] = { 1, 2, 3 };
			for (int coin : coins) {
				for (int j = coin; j <= aim; j++) {
					dp[j] += dp[j - coin];

				
				}

			}	
			System.out.println(dp[aim]);

		}

	}

}
