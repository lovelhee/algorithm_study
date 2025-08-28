import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static boolean[] visited;
	static int n;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		arr = new int[n][2];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		comb(0);

		System.out.println(min);
	}

	static void comb(int idx) {
		if (idx == n) {
			boolean flag = false;

			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					flag = true;
					break;
				}
			}

			if (!flag)
				return;

			calc();
			return;
		}

		comb(idx + 1);

		visited[idx] = true;

		comb(idx + 1);

		visited[idx] = false;
	}

	static void calc() {
		int sour = 1;
		int bitter = 0;

		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				sour *= arr[i][0];
				bitter += arr[i][1];
			}
		}

		min = Math.min(min, Math.abs(sour - bitter));
	}
}
