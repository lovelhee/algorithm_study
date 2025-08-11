package Day0811;

import java.util.Scanner;

//BJ4963 섬의 개수
//8방향 탐색+dfs재귀
//입력 마지막에 0  0 들어옴!
//1은 땅, 0은 바
public class Main {
	static int w, h, countc;
	static int arr[][];
	static int landc;
	static int dx[] = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static int dy[] = { 0, 0, 1, -1, 1, 1, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();

			if (w == 0 && h == 0)
				break; // 0 0들어오면 종료

			arr = new int[h][w];

			for (int x = 0; x < h; x++) {
				for (int y = 0; y < w; y++) {

					arr[x][y] = sc.nextInt();

				} // for y
			} // for x//지도 정보 입력 끝

			countc = 0;// 초기
			for (int x = 0; x < h; x++) {
				for (int y = 0; y < w; y++) {

					if (arr[x][y] == 1) {
						dfs(x, y);
						countc++;
					}

				}
			}
			System.out.println(countc);
		}

	}

	/**
	 * 섬 방문 처
	 * 
	 * @param x좌표
	 * @param y좌표
	 */
	private static void dfs(int x, int y) {
		if (arr[x][y] == 0)
			return;

		else {// arr[x][y]=1바다인 경우
			arr[x][y] = 0;// 방문처리

			for (int i = 0; i < 8; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];

				if (xx > -1 && yy > -1 && xx < h && yy < w)
					if (arr[xx][yy] - arr[x][y] == 1) {
						dfs(xx, yy);
					}
			}

		}
	}
}