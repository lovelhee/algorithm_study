package Day0826;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	 static ArrayList<Integer>[] adjList; // 인접 리스트 배열 
	    static boolean[] visited; // 방문 체크
	    
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int T = sc.nextInt();
	        
	        for (int t = 1; t <= T; t++) {
	            int N = sc.nextInt(); // 사람 수
	            int M = sc.nextInt(); // 관계 수
	            
	            //각각의 사람마다 친구리스트 만들어놓
	            // 인접 리스트 초기화
	            adjList = new ArrayList[N + 1];
	            for (int i = 1; i <= N; i++) {
	                adjList[i] = new ArrayList<>();
//	                배열 안에 ArrayList들: [[2], [3,4], [5,6]]
//                         adjList 배열  인덱스1 인덱스2 인덱스3
	            } 
	            
	            visited = new boolean[N + 1];
	            
	            // 관계 입력 (양방향 그래프)
	            for (int i = 0; i < M; i++) {
	                int a = sc.nextInt();
	                int b = sc.nextInt();
	                adjList[a].add(b); // a와 b는 서로 알고 있음
	                adjList[b].add(a); // b와 a도 서로 알고 있음
	            }
	            
	            int groups = 0; // 무리의 개수
	            
	            // 모든 사람에 대해 DFS 실행
	            for (int i = 1; i <= N; i++) {
	                if (!visited[i]) { // 아직 방문하지 않은 사람이면
	                    dfs(i); // 이 사람과 연결된 모든 사람 방문
	                    groups++; // 하나의 무리 완성
	                }
	            }
	            
	            System.out.println("#" + t + " " + groups);
	        }
	        sc.close();
	    }
	    
	    /**
	     * DFS로 person과 연결된 모든 사람들을 방문
	     * @param person 현재 방문 중인 사람
	     */
	    static void dfs(int person) {
	        visited[person] = true; // 현재 사람 방문 표시
	        
	        // 현재 사람과 연결된 모든 친구들 확인
	        for (int friend : adjList[person]) {
	            if (!visited[friend]) { // 아직 방문하지 않은 친구라면
	                dfs(friend); // 재귀적으로 그 친구의 무리 탐색
	            }
	        }
	    }
	}