package Day0813;

import java.util.Scanner;

public class Main{
	static int N, warmc;
	static int arr[][];
	static int visited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 총 컴퓨터 개수
		arr = new int[N + 1][N + 1]; // 연결 그래프 정보
		// arr[0,0]은 무시할 것

		warmc = sc.nextInt();
		visited = new int[N + 1];// 0은 안쓸 것임! 바이러스 걸린 컴터 표

		for (int i = 1; i <= warmc; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			arr[a][b] = 1;
			arr[b][a] = 1;

		}

		visit(1);

		int count = 0;
		for (int i = 2; i <= N; i++) {// 1번 컴퓨터 통해서 걸리게됨!
			if (visited[i] == 1) {
				count++;
			}

		}
		System.out.println(count);
	}

	/**
	 * 웜 바이러스 걸린 컴퓨터 visited[]에 1로 바꾸
	 * 
	 * @param i
	 */
	private static void visit(int i) {
		visited[i] = 1;// 일단 방문처리

		for (int j = 1; j <= N; j++) {
			if (arr[i][j] == 1 & visited[j] == 0) {// &&조건없으면 1과 2연결되어있을시 무한 반
				// 방문다 되어있어서 할게없으면 자동 종료됨. 베이스 필요없
				visit(j);
			}
		}
		return;

	}
}
