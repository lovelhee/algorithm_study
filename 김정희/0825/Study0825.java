package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Study0825 {

	public static void main(String args[]) throws Exception {

		BufferedReader brBufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(brBufferedReader.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			int n = Integer.parseInt(brBufferedReader.readLine());

			String[] input = brBufferedReader.readLine().split(" ");
			int[] treeHeight = new int[n];

			int max = 0;

			for (int i = 0; i < input.length; i++) {
				treeHeight[i] = Integer.parseInt(input[i]);
				if (treeHeight[i] > max) {
					max = treeHeight[i];
				}
			}

			int one = 0;	// 홀수 날에 물 주는 횟수 (+1)
			int two = 0;	// 짝수 날에 물 주는 횟수 (+2)

			for (int i = 0; i < treeHeight.length; i++) {
				int diff = max - treeHeight[i];	// 이 나무가 자라야 하는 키 
				// 핵심 -> +2성장을 최대로
				one += diff % 2;	 
				two += diff / 2;	
			}

			// 이미 다 같으면 
			if (one == 0 && two == 0) {
				System.out.println("#" + test_case + " 0");
				continue;
			}

			// 2일 짜리가 너무 많으면 계속 짝수날만을 기다려야함 -> 1일짜리를 이용
			// 예를 들어 8 / 4 / 2 면 2로만 가득 채우면 +10일
			// 2일 3번, 1일 4번이면 7일만에 가
			while (two > one + 1) {
				two -= 1;
				one += 2;
			}

			int answer = 0;

			// 홀수/짝수 중 더 많은 쪽이 최종 날임 (= 가장 늦게??)
			if (one > two) {
				// 3이면 1, 3, 5일 -> 3*2-1 
				answer = one * 2 - 1;
			} else {
				// 3이면 2, 4, 6일 -> 3*2
				answer = two * 2;
			}

			System.out.println("#" + test_case + " " + answer);
		}

	}

}
