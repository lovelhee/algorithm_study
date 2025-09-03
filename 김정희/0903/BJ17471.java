package solvingProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ17471 {

	static int N;
	static int[] peopleNum;
	static List<Integer>[] linkLists;
	static boolean[] isSelected;
	static int minDiff = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bReader.readLine());

		String[] peoleStrings = bReader.readLine().split(" ");
		peopleNum = new int[N + 1]; // 1번부터 시작할 거임
		isSelected = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			peopleNum[i] =  Integer.parseInt(peoleStrings[i - 1]);
		}

		linkLists = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			linkLists[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			String[] nStrings = bReader.readLine().split(" ");
			int cnt = Integer.parseInt(nStrings[0]);
			for (int j = 1; j <= cnt; j++) {
				int link = Integer.parseInt(nStrings[j]);
				linkLists[i].add(link);
			}
		}

		generateSubsets(1);

		if (minDiff == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(minDiff);
		}

	}

	private static void generateSubsets(int index) {

		if (index == N + 1) {
			check();
			return;
		}

		isSelected[index] = true;
		generateSubsets(index + 1);

		isSelected[index] = false;
		generateSubsets(index + 1);

	}

	private static void check() {
		List<Integer> teamAIntegers = new ArrayList<Integer>();
		List<Integer> teamBIntegers = new ArrayList<Integer>();

		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) {
				teamAIntegers.add(i);
			} else {
				teamBIntegers.add(i);
			}
		}

		if (teamAIntegers.isEmpty() || teamBIntegers.isEmpty()) {
			return;
		}

		if (isTeamConnected(teamAIntegers) && isTeamConnected(teamBIntegers)) {
			int numA = 0;
			int numB = 0;

			for (Integer integer : teamAIntegers) {
				numA += peopleNum[integer];
			}

			for (Integer integer : teamBIntegers) {
				numB += peopleNum[integer];
			}

			int diff = Math.abs(numA - numB);
			minDiff = Math.min(minDiff, diff);
		}
	}

	private static boolean isTeamConnected(List<Integer> team) {

		if (team.isEmpty()) {
			return true;
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];
		int start = team.get(0);

		queue.add(start);
		visited[start] = true;
		int count = 1;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int neighbor : linkLists[current]) {
				if (team.contains(neighbor) && !visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
					count++;
				}
			}
		}

		return count == team.size();

	}
}
