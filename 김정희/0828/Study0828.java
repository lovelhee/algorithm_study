package solvingProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Study0828 {
	public static void main(String[] args) throws Exception {

		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bReader.readLine());

		int S[] = new int[N + 1];
		int B[] = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			String[] sbInputStrings = bReader.readLine().split(" ");
			S[i] = Integer.parseInt(sbInputStrings[0]);
			B[i] = Integer.parseInt(sbInputStrings[1]);
		}

		int min = Integer.MAX_VALUE;
		int result = 0;

		for (int i = 1; i < (1 << N); i++) {
			int calA = 1;
			int calB = 0;
			for (int j = 0; j < N; j++) {
				if (((i & (1 << j)) != 0)) {

					calA *= S[j + 1];
					calB += B[j + 1];

				}
			}

//			System.out.println(calA + "/" + calB);
			result = Math.abs(calA - calB);
			if (min > result) {
				min = result;
			}
		}

		System.out.println(min);

	}
}
