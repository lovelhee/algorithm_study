import java.util.*;

public class 녹색옷 {

    // 지도 크기
    static int N;

    // map[x][y] : 칸 (x,y)에 도착했을 때 추가로 드는 비용(루피)
    static int[][] map;

    // dist[x][y] : (0,0) → (x,y)까지의 최소 누적 비용
    static int[][] dist;

    // 4방향 이동 (상, 하, 좌, 우)
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    // 도달하지 않았음을 나타내는 큰 값 (int 오버플로우 방지를 위해 여유 있게 설정)
    static final int INF = 1_000_000_000;

    /**
     * 우선순위 큐에 넣을 노드 정의
     * - x, y : 격자 좌표
     * - cost : (0,0)에서 이 칸까지의 누적 비용(dist)
     * - compareTo : 우선순위 큐가 cost가 작은 순으로 poll 하도록 한다.
     */
    static class Node implements Comparable<Node> {
        int x, y, cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            // 비용이 작은 노드가 먼저 나오도록 정렬
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = 1; // 출력 형식에 필요한 테스트 케이스 인덱스 (Problem 1:, Problem 2:, ...)

        while (true) {
            N = sc.nextInt();

            // N == 0 이면 입력 종료
            if (N == 0) break;

            // 입력 받을 자료구조 초기화
            map = new int[N][N];
            dist = new int[N][N];

            // 지도 입력과 dist 초기화
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    dist[i][j] = INF; // 일단 매우 큰 값으로 채워서 '아직 최단거리 모름'을 표시한다.
                }
            }

            // 다익스트라 실행: (0,0)에서 시작
            dijkstra(0, 0);

            // 요구 출력 형식: "Problem k: 최소비용"
            System.out.println("Problem " + tc++ + ": " + dist[N - 1][N - 1]);
        }

        sc.close();
    }

    /**
     * 다익스트라 알고리즘 (우선순위 큐 사용)
     * - 시작 정점 (startX, startY)에서 출발하여 모든 칸의 최소 비용을 계산한다.
     * - dist 배열이 갱신되며, 목적지 (N-1,N-1)의 dist가 최소 비용이 된다.
     */
    static void dijkstra(int startX, int startY) {
        // 최소 힙(비용이 작은 순) 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작점 초기화:
        // - 시작 칸에 들어가자마자 해당 칸의 비용을 지불하므로 dist는 map[startX][startY]로 시작한다.
        dist[startX][startY] = map[startX][startY];
        pq.offer(new Node(startX, startY, dist[startX][startY]));

        // PQ가 빌 때까지 반복 (모든 도달 가능한 칸의 최소 비용 확정)
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int x = cur.x;
            int y = cur.y;
            int cost = cur.cost;

            // 우선순위 큐 특성상, 이미 더 작은 비용으로 (x,y)를 방문한 적이 있으면 건너뛴다.
            // (Lazy deletion 패턴)
            if (cost > dist[x][y]) continue;

            // 4방향 이웃 칸 검사
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 격자 범위를 벗어나면 무시
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                // 이웃 칸으로 이동했을 때의 새로운 누적 비용
                int newCost = cost + map[nx][ny];

                // 더 짧은 경로를 찾았다면 dist 갱신 후 PQ에 삽입
                if (newCost < dist[nx][ny]) {
                    dist[nx][ny] = newCost;
                    pq.offer(new Node(nx, ny, newCost));
                }
            }
        }
        // 반복 종료 시점:
        // - dist 배열에는 각 칸에 대한 최소 누적 비용이 확정되어 있다.
        // - 특히 dist[N-1][N-1]가 정답이다.
    }
}
