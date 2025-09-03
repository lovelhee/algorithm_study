import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int team[][];
	static boolean visited[];
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		N = sc.nextInt();
		team = new int[N][N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				team[i][j] = sc.nextInt();
			}
		}
		
		combination(0, 0);
		
		System.out.println(min);
	}

	static void combination(int depth, int idx) {
		if (depth == N / 2) {
			startlink();
			return;
		}

		for (int i = idx; i < N; i++) {
			visited[i] = true;
			combination(depth + 1, i + 1);
			visited[i] = false;
		}
	}

	static void startlink() {
		int start = 0, link = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i] && visited[j]) {
					start += team[i][j];
				} else if (!visited[i] && !visited[j]) {
					link += team[i][j];
				}
			}
		}
		
		int result = Math.abs(start - link);
		
		min = Math.min(min, result);
	}
}
