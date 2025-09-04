import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] popu;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static boolean[] sel;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		popu = new int[n + 1];
		sel = new boolean[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		list.add(new ArrayList<Integer>()); // 0번
		for (int i = 1; i <= n; i++) {
			popu[i] = Integer.parseInt(st.nextToken());
			list.add(new ArrayList<Integer>());
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());

			for (int j = 0; j < tmp; j++) {
				int region = Integer.parseInt(st.nextToken());
				list.get(i).add(region);
				list.get(region).add(i);
			}
		}

		for (int i = 1; i < n; i++) {
			dfs(1, 0, i);
		}

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static void dfs(int idx, int r, int max) {
		if (r == max) {
			bfs();
			return;
		}

		if (idx >= n) {
			return;
		}

		dfs(idx + 1, r, max);
		sel[idx] = true;
		dfs(idx + 1, r + 1, max);
		sel[idx] = false;
	}
	
	static void bfs() {
		visited = new boolean[n + 1];
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		boolean flag = sel[1];
		visited[1] = true;
		q.offer(1);
		
		for(int i = 2; i <= n; i++) {
			if(sel[i] != flag) {
				visited[i] = true;
				q.offer(i);
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int k = q.poll();
			
			for(int i : list.get(k)) {
				if(!visited[i] && (sel[k] == sel[i])) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				return;
			}
		}
		
		calc();
	}
	
	static void calc() {
		int sum1 = 0; // t
		int sum2 = 0; // f
		
		for(int i = 1; i <= n; i++) {
			if(sel[i]) {
				sum1 += popu[i];
			}
			else {
				sum2 += popu[i];
			}
		}
		
		min = Math.min(min, Math.abs(sum1 - sum2));
	}
	
}
