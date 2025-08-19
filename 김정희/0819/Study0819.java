package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Study0819 {
	public static void main(String[] args) throws Exception {

		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		String[] nkInputStrings = bReader.readLine().split(" ");
		int n = Integer.parseInt(nkInputStrings[0]);
		int k = Integer.parseInt(nkInputStrings[1]);
		int[] a = new int[n * 2];
		String[] aInputStrings = bReader.readLine().split(" ");
		for (int i = 0; i < aInputStrings.length; i++) {
			a[i] = Integer.parseInt(aInputStrings[i]);

		}
		boolean haveRobot[] = new boolean[n];

		int stage = 0;

		while (true) {
			stage++;

			// 1. 벨트 + 로봇 회전
			int last = a[a.length - 1];
			for (int i = a.length - 1; i > 0; i--) {
				a[i] = a[i - 1];
			}
			a[0] = last;
			for (int i = n - 1; i > 0; i--) {
				haveRobot[i] = haveRobot[i - 1];
			}
			haveRobot[0] = false;
			if (haveRobot[n - 1] == true) {
				haveRobot[n - 1] = false;
			}

			// 2. 로봇 이동
			for (int i = n - 2; i >= 0; i--) {
				if (haveRobot[i] == true && haveRobot[i + 1] == false && a[i + 1] >= 1) {
					haveRobot[i] = false;
					haveRobot[i + 1] = true;
					a[i + 1] -= 1;
				}
			}
			if (haveRobot[n - 1] == true) {
				haveRobot[n - 1] = false;
			}

			// 3. 로봇 올리기
			if (a[0] > 0) {
				haveRobot[0] = true;
				a[0] -= 1;
			}

			// 4. 종료
			int zero = 0;
			for (int i = 0; i < a.length; i++) {
				if (a[i] == 0) {
					zero++;
				}
			}

			if (zero >= k) {
				break;
			}

		}

		System.out.println(stage);

	}
}
