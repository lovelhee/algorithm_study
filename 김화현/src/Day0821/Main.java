package Day0821;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//자바에서 하나의 Java에는 하나의 public class만 존재가능 
//큐에 x좌표, y좌표, 거리 3개의 값을 함께 저장해야함 
public class Main {
	static int[][] map;// 지도 1은 육지, 0은 바
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int R,C; //지도 크기 전역변수로 선언 
	
	//Point 클래스 (x,y좌표 , 시작점으로부터 거리)를 하나로 묶어서 
	//큐에 하나의 객체로 add하려고 
	static class Point{
		int x,y,dist;
		Point(int x,int y, int dist){
			this.x=x; //현재 위치에서 x좌
			this.y=y;
			this.dist=dist; //시작점부터 이곳까지의 거
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt(); //지도의 세로 크
		C = sc.nextInt();
		//nextint랑 nextline같이 쓰면 개행 문자 제거 필
		sc.nextLine(); //개행문자 제거 

		map = new int[R][C];//0으로 초기

		// L은 1이고, W는 0임!
		for (int i = 0; i < R; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				if (ch == 'L') {
					map[i][j] = 1;//육지 
				} else {
					map[i][j] = 0;
				}

			}
		} // 지도 입력 완료
		
		int answer=0;
		
		//모든 육지를 시작점으로 BFS수행
		for(int i=0; i<R;i++) {
			for(int j=0; j<C;j++) {
				if(map[i][j]==1) {
					//육지인 경우에만 이 육지에서 시작하는 가장 먼 거리 계산 
					int maxDist=bfs(i,j);
					answer=Math.max(answer, maxDist);
				}
			}
		}
		System.out.println(answer);
		sc.close();
	}

/**
 * 
 * @param startx 시작 x
 * @param starty 시작 Y
 * @return 해당 스타트점에서 갈 수 있는 가장 먼 육지까지의 최단 거리 
 */
	private static int bfs(int startx, int starty) {
		
		Queue<Point>queue = new LinkedList<>();
		boolean[][] visited = new boolean[R][C]; 
		//모든 시작점 들어올 때마다 매번 새롭게 생성
		
		queue.add(new Point(startx,starty,0));
		visited[startx][starty]=true;
		int maxDistance=0;
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			maxDistance=Math.max(current.dist, maxDistance);
			//현재까지 도달한 거리 중 최댓값 
			
			for(int i=0; i<4;i++) {
				int newX=current.x+dx[i];
				int newY=current.y+dy[i];
				
				if(newX>=0&&newX<R&&newY>=0&&newY<C&&map[newX][newY]==1&&!visited[newX][newY]) {
					//벽아니고, 육지이고, 아직 방문 안한 곳이면 
					visited[newX][newY]=true;
					queue.add(new Point(newX,newY,current.dist+1));
				}
			}
			
		}//while종료 
		
		return maxDistance;
	}

}
