import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> l;
	static int com;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		com = Integer.parseInt(br.readLine());
		
		l = new ArrayList<>();
		
		int line = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < com + 1; i++) {
			l.add(new ArrayList<>());
		}
		
		for(int i = 0; i < line; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			l.get(a).add(b);
			l.get(b).add(a);
		}
		
		visited = new boolean[com + 1];
		
		dfs(1);
		
		int cnt = 0;
		for(boolean b : visited) {
			cnt = b ? cnt + 1 : cnt;
		}
		
		System.out.println(cnt - 1);
	}
	
	static void dfs(int s) {
		visited[s] = true;
		
		for(int i : l.get(s)) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
}
