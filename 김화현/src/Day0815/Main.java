package Day0815;
//BJ 7576 토마토 

//BFS로 같은 위치에 있는 애들 숙성 시키기 
//시간 제한 1초 . 메모리 256MB

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int M, N;
	static int[][] box;
	static int[][] distance; // 거리배열 (일수) 저장
	static Queue<int[]> que = new LinkedList<>();

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();// 가로
		N = sc.nextInt();// 세로

		box = new int[N][M];
		distance = new int[N][M];

		// 거리배열 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				distance[i][j] = -1; // 아직 방문하지 않음 //초기값

				// 입력 받으면서 토마토 1은 모두 큐에 넣기
				box[i][j] = sc.nextInt();
				if (box[i][j] == 1) {
					que.offer(new int[] { i, j });
					distance[i][j] = 0;

				}
			}
		}
		System.out.println(bfs());
	}

	static int bfs() {
		int maxDays = 0;

		while (!que.isEmpty()) {
			int[] current = que.poll();
			int x = current[0];
			int y = current[1];

			// 상하좌우 탐색
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				// 범위체크
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					// 익지 않은 토마토 (0)이고 아직 방문하지 않은 곳
					if (box[nx][ny] == 0 && distance[nx][ny] == -1) {
						box[nx][ny] = 1;// 익은 토마토로 변경
						distance[nx][ny] = distance[x][y] + 1;// 날짜 증가
						maxDays = Math.max(maxDays, distance[nx][ny]);
						que.offer(new int[] { nx, ny });
					}
				}

			}
		} // while 문 탈출( 큐가 다 빔)
		// 모든 토마토가 익었는지 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					return -1;
				}
			}
		}
		return maxDays;
	}
}
