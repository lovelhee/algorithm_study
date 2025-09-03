import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int d;

	static int[][] arr;

	static int max = Integer.MIN_VALUE;

	static int[] dx = { 1, -1, 0 };
	static int[] dy = { 0, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		arr = new int[n + 1][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1. 조합으로 궁수 세명 배치 후(조합마다 max 검증)

		// 2. 그냥 전체 배열 돌면서(n^2) 조건 맞는 애 고르기.(거꾸로 올라가기)

		// 3. 공격 후 적 이동 로직(아래로 한칸 씩)

		// 4. 적이 남아있는지 확인 후 없다면 1번, 있다면 2번으로 돌아가기.
		
		comb(0, 0);
		
		System.out.println(max);
	}

	static void comb(int idx, int r) {
		if (r == 3) { // 세개 다 고름
			simulate();
			return;
		}

		if (idx >= m) { // 인덱스 끝까지 옴.
			return;
		}

		comb(idx + 1, r);

		arr[n][idx] = 9;

		comb(idx + 1, r + 1);

		arr[n][idx] = 0;
	}

	static void simulate() {
		ArrayList<Integer> ar = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			if (arr[n][i] == 9) {
				ar.add(i);
			}
		}

		int cnt = 0;
		
		int[][] copy = new int[n+1][m];
		for(int i = 0; i <= n; i++) {
			copy[i] = arr[i].clone();
		}

		while (true) {
			// 1. 조건 맞는 애 고르기.
			for (int a = 0; a < 3; a++) {
				int arIdx = ar.get(a);

				int distance = d + 1;
				int disYIdx = -1;
				int disXIdx = -1;
				
				for (int i = n - 1; i >= 0; i--) { // 거꾸로
					for (int j = 0; j < m; j++) { // 왼쪽부터
						if (copy[i][j] != 0 && canAttack(j, i, arIdx)) {
							if(distance > getDistance(j, i, arIdx) ||
									(distance == getDistance(j, i, arIdx) && j < disXIdx)) {
								distance = getDistance(j, i, arIdx);
								disYIdx = i;
								disXIdx = j;
							}
						}
					}
				}
				
				if(disYIdx != -1) {
					if (copy[disYIdx][disXIdx] == 1) {
						cnt++;
					}
					copy[disYIdx][disXIdx] = 2;
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (copy[i][j] == 2) {
						copy[i][j] = 0;
					}
				}
			}

			// 2. 이동
			for (int i = n - 1; i > 0; i--) {
				copy[i] = copy[i-1].clone();
			}

			copy[0] = new int[m];

			// 3. 체크
			if (!check(copy)) {
				continue;
			}

			max = Math.max(max, cnt);
			break;
		}
	}

	static boolean canAttack(int x, int y, int idx) {
		return Math.abs(y - n) + Math.abs(x - idx) <= d;
	}
	
	static int getDistance(int x, int y, int idx) {
		return Math.abs(y - n) + Math.abs(x - idx);
	}

	static boolean check(int[][] copy) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copy[i][j] == 1) {
					return false;
				}
			}
		}

		return true;
	}
}
