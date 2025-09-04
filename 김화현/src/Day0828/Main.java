package Day0828;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//BJ2178 미로 탐색
//N*M크기의 배열로 표현되는 미로 
//

//1은 이동가능. 0은 이동불가
//(1,1)에서 시작해서 (N,M)의 위치로 이동해야할 때 지나야하는 칸의 개수
//상하좌우로만 이동가능
public class Main {
	static int depth= 4;
	static int N, M;
	static int map[][];
	static boolean visited[][];
	static int dr[] = { -1, 1, 0, 0 };// 상,하,좌,우
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws FileNotFoundException {
		long start = System.currentTimeMillis();
		
		System.setIn(new java.io.FileInputStream("res/unittest.txt"));
		// 맨위에 res폴더만들고 거기다가 파일 txt로 만들어서 넣으면 됨!
		// 백준 제출시에는 21번 줄만 주석하면 됨!FileNotFoundException으로 declare한거는 무시해도 제출시 문제없음!
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		map = new int[N][M];
		visited = new boolean[N][M];

		System.out.println(N);
		System.out.println(M);

		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			System.out.println(str);
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		} // 입력 완료 (0,0)이 문제에서 주어진 (1,1)임
		bfs(0, 0);
		System.out.println(( System.currentTimeMillis() - start )/1000.0 ); 
		System.out.println(depth);
	}

	/**
	 * 
	 * @param r 현재 도달한 row
	 * @param c 현재 도달한 column
	 * @param k 현재 길이 카운트
	 */
	// 1안 bfs로 풀기
	private static void bfs(int r, int c) {
		Queue<myclass> q = new LinkedList<myclass>();
		q.add(new myclass(r, c, 1));// 시작점 v를 큐에 넣기
		visited[r][c] = true;// 시작점 v 방문 표기

		while (!q.isEmpty()) {// 큐가 비어있지 않은 경우
			myclass front = q.poll();

//	q.poll();//해도 되는데 그러면 이 한줄에서만 접근할 수 있고 못씀
//  System.out.println(front.row);
//  System.out.println(front);//하면 객체로 봐 주소값이 뜸

			int row1 = front.row;//
			int col1 = front.column;
			int depth1 = front.depth;// 정점이 자신이 뎁스 (start에서 얼마나 떨어져있는지)도 들고 다니도록함.
//			depth=Math.max(depth1, depth);
			
			if(row1==N-1&&col1==M-1){//가지치기 
				depth=depth1;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nr = row1 + dr[i];
				int nc = col1 + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M) { // 벽만나면 해당 상하좌우 중 한개는 컨티뉴
					continue;
				}
				if (visited[nr][nc] == false&&map[nr][nc]==1) {
					q.add(new myclass(nr, nc, depth1 + 1));
					visited[nr][nc] = true;
				}

			} // 상하좌우 탐방 종료
			
		} // while문 종료
	}// bfs종료

}// Main종료

class myclass {
	int row; // 필드 변수
	int column;
	int depth;

	myclass() {// 기본 생성자
	}

	myclass(int ro, int col, int dep) {
		this.row = ro; // 받아온 ro를 이 myclass의 값으로 넣는다는 의미임!
		this.column = col;
		this.depth = dep;
	}
	
	@Override
	public String toString() {
		return this.row+" "+this.column+" "+this.depth;
	}//이렇게하면 println하면서 큐 디버깅 가능
//	
	
} // myclass생성
