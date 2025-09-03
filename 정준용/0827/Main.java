// https://www.acmicpc.net/problem/4485
// 처음에 마지막에 도달하면 break문 넣어서 틀림

import java.util.*;

public class Main {
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

		int tc = 0;
		while (true) {
			tc++;
			int N = sc.nextInt();
			if (N == 0)
				break;
			int map[][] = new int[N][N];
			int minvalue[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					minvalue[i][j] = Integer.MAX_VALUE;
				}
			}
			pq.add(new int[] { map[0][0], 0, 0 });
			minvalue[0][0] = map[0][0];

			while (!pq.isEmpty()) {
				int temp[] = pq.poll();

//				if (temp[1] == N - 1 && temp[2] == N - 1)
//					break;
				for (int i = 0; i < 4; i++) {
					int nx = temp[1] + dx[i];
					int ny = temp[2] + dy[i];
					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;
					int cost = temp[0] + map[nx][ny];

					if (minvalue[nx][ny] > cost) {
						minvalue[nx][ny] = cost;
						pq.add(new int[] { cost, nx, ny });
					}
				}
			}

			System.out.println("Problem " + tc + ": " + minvalue[N - 1][N - 1]);
		}
	}
}
