package Day0818;

import java.util.Arrays;
import java.util.Scanner;

public class S2112_보호필름 {

	static int D, W, K;// 행, 열, 통과기준
	static int[][] film;
	static int ans;
	static int[] A, B;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt();

		for (int i = 0; i <= Tc; i++) {
			D = sc.nextInt(); // 두께 (높이)
			W = sc.nextInt();// 너비 (행)
			K = sc.nextInt();// 합격기준

			film = new int[D][W];
			for (int a = 0; a < D; a++) {
				for (int b = 0; b < W; b++) {
					film[a][b] = sc.nextInt();
				}
			} // 필름 원본 정보 입력 //특성 A=0. B=1

			// 완전탐색 가짓수 3개 :A,B,X하는 방
			A = new int[W];
			B = new int[W];
			Arrays.fill(B, 1);

			// 최소값 구할 때는 아주아주 큰 수로 초기화 시켜놓자!
			// ans=Integer.MAX_VALUE;지만
			// 여기서는 K까지만 주입하면 이미 조건 만족으로
			ans = K;

			// 주입X,A주입,B주입하는 메서드

			make(0, 0);

		} // Tc종료
	}

	/**
	 * 
	 * @param 1열  중 탐색하고 있는 행
	 * @param cnt 주입 횟수
	 */
	private static void make(int r, int cnt) {
		if (check()) {
			ans = Math.min(ans, cnt);
			return;
		}
		if (ans < cnt)
			return; // 어짜피 최소값 구하는 거라 정답 불가 재귀 안보내
		if (r == D)// 가볼만큼 다 가봤
			return;

		// 재귀파트

		// 1번 주입 안함
		int[] tmp = film[r];
		make(r + 1, cnt); // 원본 상태로 다음 막 탐

		// 2번 A주입
		film[r] = A;
		make(r + 1, cnt + 1);

		// 3번 B주
		film[r] = B;
		make(r + 1, cnt + 1);

		// 4번 원상복구
		film[r] = tmp;
	}// make종료

	// 막의 성능 검사할꺼
	private static boolean check() {
		// 막검사(열 우선 순회 방식)
		for (int c = 0; c < W; c++) {// 모든 열을 순회
			boolean flag = false; // 열마다 초기화해야함
			// ㄴ 이 열이 조건을 만족했는가를 나타냄!
			// ㄴ flase면 이 열에서 K개 이상 연속된 특성 못찾았

			int cnt = 1;// 열마다 연속된 K값이 있는지 체크해야함
			for (int r = 1; r < D; r++) {// c번째 열의 모든 행을 검
				if (film[r][c] == film[r - 1][c])
					cnt++;
				else
					cnt = 1;// 연속성이 끊어지면 다시 카운트 1로 내려서 다시 이어가야함!
				if (cnt == K) {
					flag = true;
					break;
				}
			} // 내부 포문 열 순회 종료
			if (!flag)
				return false; // 더 이상 진행은 무의미! 즉시 종료 다른 열 검사할 필요 없이 불가함!

		} // 외부 포문 끝
		return true;
	}
}
