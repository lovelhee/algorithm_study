package Day0827;

import java.util.*;

public class Main {
    // 4방향 이동을 위한 방향 배열
    static int[] dx = {-1, 1, 0, 0};  // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};  // 상, 하, 좌, 우
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int problemNum = 1;
        
        // N=0이 나올 때까지 반복 (문제 조건)
        while (true) {
            int N = sc.nextInt();
            if (N == 0) break;  // 종료 조건
            
            // 동굴 지도 입력받기
            int[][] cave = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cave[i][j] = sc.nextInt();
                }
            }
            
            // 다익스트라 알고리즘으로 최소 비용 계산
            int result = dijkstra(cave, N);
            System.out.println("Problem " + problemNum + ": " + result);
            problemNum++;
        }
        sc.close();
    }
    
    /**
     * 다익스트라 알고리즘으로 최소 비용 경로 찾기
     * @param cave 동굴 지도 (각 칸의 도둑루피 값)
     * @param N 지도 크기
     * @return 최소 비용
     */
    static int dijkstra(int[][] cave, int N) {
        // 1. 각 위치까지의 최소 비용을 저장할 배열
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);  // 무한대로 초기화
        }
        
        // 2. 우선순위 큐: 비용이 적은 것부터 처리
        // 배열 형태: [비용, x좌표, y좌표]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // 3. 시작점 설정
        // 시작점 (0,0)을 지나가므로 해당 칸의 도둑루피도 잃음
        dist[0][0] = cave[0][0];
        pq.offer(new int[]{cave[0][0], 0, 0});
        
        // 4. 다익스트라 메인 루프
        while (!pq.isEmpty()) {
            // 4-1. 현재 처리할 위치 (가장 비용이 적은 곳)
            int[] current = pq.poll();
            int cost = current[0];    // 현재까지의 누적 비용
            int x = current[1];       // 현재 x좌표
            int y = current[2];       // 현재 y좌표
            
            // 4-2. 이미 더 좋은 경로를 찾았다면 무시
            // (같은 위치를 여러 번 큐에 넣을 수 있기 때문)
            if (cost > dist[x][y]) continue;
            
            // 4-3. 현재 위치에서 4방향으로 이동 시도
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];  // 새로운 x좌표
                int ny = y + dy[i];  // 새로운 y좌표
                
                // 4-4. 범위를 벗어나면 무시
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                
                // 4-5. 새로운 위치로 이동할 때의 총 비용 계산
                int newCost = cost + cave[nx][ny];
                
                // 4-6. 더 효율적인 경로를 발견했다면
                if (newCost < dist[nx][ny]) {
                    dist[nx][ny] = newCost;  // 최소 비용 갱신
                    pq.offer(new int[]{newCost, nx, ny});  // 큐에 추가
                }
            }
        }
        
        // 5. 목적지 (N-1, N-1)까지의 최소 비용 반환
        return dist[N-1][N-1];
    }
}