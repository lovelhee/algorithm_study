import java.util.*;

public class 보물섬 {
    static int N, M;            // 지도 크기
    static char[][] map;        // 지도 정보
    // 4방향 이동 (상, 하, 좌, 우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // BFS 탐색: (startX, startY)에서 가장 멀리 있는 육지까지 거리 구하기
    static int bfs(int startX, int startY) {
        boolean[][] visited = new boolean[N][M]; // 방문 체크 배열
        Queue<int[]> queue = new LinkedList<>();
        // 큐에 시작 위치와 거리(0) 삽입
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        int maxDist = 0; // 해당 시작점에서의 최대 거리

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0];
            int y = p[1];
            int dist = p[2];

            // 현재까지의 거리 중 최댓값 갱신
            maxDist = Math.max(maxDist, dist);

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 지도 범위 내 && 방문하지 않았고 && 육지일 경우
                if (nx >= 0 && nx < N && ny >= 0 && ny < M
                    && !visited[nx][ny] && map[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist + 1}); // 거리 +1 해서 큐에 추가
                }
            }
        }
        return maxDist; // 시작점에서 가장 멀리 있는 육지까지의 최단 거리 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 지도 크기 입력
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); // 개행 제거

        // 지도 입력
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        int answer = 0; // 최종 답(보물까지의 최장 거리)

        // 모든 육지 칸에서 BFS 수행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') { // 육지인 경우 BFS 시작
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }

        // 결과 출력 (가장 먼 두 육지 사이의 최단 거리)
        System.out.println(answer);
    }
}
