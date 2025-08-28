import java.util.*;

public class 창용마을 {
    static int N, M;                  // 사람 수(N), 관계 수(M)
    static List<Integer>[] adj;       // 인접 리스트 (사람들의 관계 저장)
    static boolean[] visited;         // 방문 여부 체크 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수 입력

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt(); // 사람 수
            M = sc.nextInt(); // 관계 수

            // 인접 리스트 초기화
            adj = new ArrayList[N + 1];  // 1번부터 N번까지 사용
            visited = new boolean[N + 1]; // 방문 배열 초기화

            for (int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }

            // 사람들의 관계 입력 (양방향 연결)
            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                adj[a].add(b);
                adj[b].add(a);
            }

            int count = 0; // 무리의 개수

            // 모든 사람에 대해 DFS 탐색
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {   // 아직 방문하지 않은 사람 발견 시
                    dfs(i);          // 해당 사람을 시작으로 DFS
                    count++;         // 새로운 무리 발견 → 개수 증가
                }
            }

            // 결과 출력 (테스트케이스 번호와 무리 개수)
            System.out.println("#" + t + " " + count);
        }
    }

    // 깊이 우선 탐색(DFS)
    static void dfs(int cur) {
        visited[cur] = true; // 현재 노드 방문 처리
        for (int next : adj[cur]) { // 인접한 사람들 탐색
            if (!visited[next]) {   // 아직 방문하지 않았다면
                dfs(next);          // 재귀 호출
            }
        }
    }
}
