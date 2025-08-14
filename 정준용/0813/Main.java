// https://www.acmicpc.net/problem/2606
//dfs로 완전탐색
//양방향이라는것을 주의 하기
import java.util.*;

public class Virus {
	static boolean visited[];
	static int count = 0;
	static List<List<Integer>> list;

	static void DFS(int x) {
		List<Integer> index = list.get(x);
		visited[x] = true;
		for (int next : index) {
			if (!visited[next]) {
				count++;
				DFS(next);
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		list = new ArrayList<>();

		int com = sc.nextInt();
		int N = sc.nextInt();

		for (int i = 0; i <= com; i++) {
			list.add(new ArrayList<>());
		}

		visited = new boolean[com + 1];

		for (int i = 0; i < N; i++) {
			int index = sc.nextInt();
			int value = sc.nextInt();

			list.get(index).add(value);
			list.get(value).add(index);
		}

		DFS(1);

		System.out.println(count);
	}
}
