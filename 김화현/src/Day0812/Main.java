package Day0812;

import java.util.Scanner;

public class Main {
	static int N;
	static int arr[][];
	static boolean[] team; // 1이면 스타트팀, 0이면 링크
	static int minc = Integer.MAX_VALUE;
	static int star, link;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N][N];
		team = new boolean[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		} // 팀원조합별 능력치 배열 입력 완료

		dfs(0, 0);

		System.out.println(minc);
	}

	// DF로 N명 중 N/2를 선택하는 조합 생
	private static void dfs(int index, int count) {
		int star, link;
		if (count == N / 2) {
			// 전체 팀 능력치 각각 더하고 최소값 갱신
			calculate();
			return;

		}
		// 인덱스 범위 체크
		if (index >= N)
			return;

		// 현재 사람을 스타트팀에 포함
		team[index] = true;
		dfs(index + 1, count + 1);// 다음 사람으

		team[index] = false;
		dfs(index + 1, count);

	}

	private static void calculate() {
		star= 0; // 전체 배열 sum
		link=0;
		
		// 스타트팀 능력치
		for (int i = 0; i < N; i++)
			if (team[i]) {// 스타트팀 멤버라
				for (int j = 0; j < N; j++) {
					if (team[j] && i != j) {// 스타트팀이고 다른 사람임
						star += arr[i][j];

					}
				}
			}

		// 링크팀 능력
		for (int i = 0; i < N; i++)
			if (!team[i]) {
				for (int j = 0; j < N; j++) {
					if (!team[j] && i != j) {
						link += arr[i][j];
					}
				}
			}

		minc = Math.min(minc, Math.abs(star - link));

	}

}
