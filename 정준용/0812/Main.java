// https://www.acmicpc.net/problem/14889
// 링크 스타트
// dfs를 활용하여 백트래킹, 팀을 boolean으로 나누고(나중에 팀이 3명이면 배열로 나눠야할듯) 속한 인원의 점수를 더하기
import java.util.*;

public class StartLink {
	static boolean visited[];
	static int[][] team;
	static int N;
	static int min_value = Integer.MAX_VALUE;

	static void dfs(int count, int index) {
		if (count == N / 2) {
			int start = 0;
			int link = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i] && !visited[j]) {
						start += team[i][j];
					} else if (visited[i] && visited[j]) {
						link += team[i][j];
					}
				}
			}
			min_value = Math.min(min_value, Math.abs(start - link));
			return;
		}

		for (int i = index; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(count + 1, i + 1);
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		team = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				team[i][j] = sc.nextInt();
			}
		}

		dfs(0, 0);

		System.out.println(min_value);

	}
}
