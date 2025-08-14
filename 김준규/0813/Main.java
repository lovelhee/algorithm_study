import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int computer;
	static int line;
	static int count = 0;
	static int arr[][];
	static boolean visit[];

	public static void main(String[] args) {
		computer = sc.nextInt();
		line = sc.nextInt();

		arr = new int[computer + 1][computer + 1];
		visit = new boolean[computer + 1];

		for (int i = 0; i < line; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a][b] = 1;		//양방향 연결 표현
			arr[b][a] = 1;
		}
		
		visit[1] = true;		//1번 컴퓨터부터 시작
		dfs(1);				
		
		System.out.println(count);
	}
	
	static void dfs(int L) {
		for(int i = 1; i <= computer; i++) {		//1번 컴퓨터부터 끝까지
			if(arr[L][i] == 1 && !visit[i]) {			//두 컴퓨터가 연결이 되어있고 방문을 안 했으면
				visit[i] = true;
				count++;
				dfs(i);
			}
		}
	}
}
