package Day0808;
import java.util.Scanner;

//1,2,3더하기 4 백준 15989

//정수 n을 1,2,3 중복 조합으로 목표값 만들기
//dp로 해결하자!
public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //총 테스트 케이스

		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();//1,2,3으로 만들 목표값

			// i를 1,2,3의 합으로 나타내는 방법을 배열에 저장해 넣음
			int dp[] = new int[N + 1];
			dp[0] = 1;//아무것도 선택 안하기 1가지

			int coins[] = { 1, 2, 3 }; //순서 중요함! 
			
			for (int coin : coins) {
				for (int j = coin; j <= N; j++) {
					dp[j] += dp[j - coin];//coin을 빼고 남은 숫자를 만드는 방법의 수		
				}

			}	
			System.out.println(dp[N]);

		}//테이스케이스 종료

	}

}
