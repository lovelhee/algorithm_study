import java.util.*;

public class 경쟁적 {
    // 입력값: N x N 크기의 시험관, K개의 바이러스
    static int N, K, S, X, Y;
    static int[][] arr; // 시험관 상태 배열
    // 상, 하, 좌, 우 이동을 위한 방향 벡터
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 시험관 크기 N, 바이러스 종류 개수 K
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N][N];

        // 초기 바이러스 정보 저장
        List<int[]> viruses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
                // 바이러스가 존재하는 경우 (번호, 좌표, 시간=0) 저장
                if (arr[i][j] != 0) {
                    viruses.add(new int[]{arr[i][j], i, j, 0});
                }
            }
        }

        // S초 후, (X, Y)에 존재하는 바이러스 번호 확인
        S = sc.nextInt();
        X = sc.nextInt() - 1; // 문제에서 1-index → 배열은 0-index
        Y = sc.nextInt() - 1;

        // 낮은 번호의 바이러스가 먼저 증식하도록 정렬
        viruses.sort(Comparator.comparingInt(a -> a[0]));

        // BFS를 위한 큐 생성 (바이러스 전염 순서대로 삽입)
        Queue<int[]> q = new LinkedList<>(viruses);

        // BFS 시작
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int type = cur[0]; // 바이러스 종류
            int x = cur[1];    // 현재 x 좌표
            int y = cur[2];    // 현재 y 좌표
            int time = cur[3]; // 현재 시간

            // 시간이 S에 도달하면 탐색 종료
            if (time == S) break;

            // 4방향으로 전염 시도
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 시험관 범위 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                // 빈 칸(0)인 경우 전염
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = type; // 바이러스 증식
                    q.add(new int[]{type, nx, ny, time + 1}); // 새로운 위치 큐에 삽입
                }
            }
        }

        // S초 후 (X, Y)에 있는 바이러스 번호 출력 (없으면 0)
        System.out.println(arr[X][Y]);
    }
}
