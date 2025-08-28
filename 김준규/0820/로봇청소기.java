import java.util.Scanner;

public class 로봇청소기 {
    // 방의 크기 N x M, 로봇의 현재 위치 (r, c), 바라보는 방향 d
    static int N, M, r, c, d;
    static int[][] map; // 방의 상태 (0: 청소 안 됨, 1: 벽, 2: 청소 완료)

    // 방향 벡터 (북, 동, 남, 서) → 시계 방향 순서
    static int[] dx = {-1, 0, 1, 0}; 
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력: 방의 크기 N, M
        N = sc.nextInt();
        M = sc.nextInt();

        // 로봇의 시작 좌표 (r, c)와 바라보는 방향 d
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        // 방의 상태 입력 (0: 청소 필요, 1: 벽)
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int result = 0; // 청소한 칸 개수

        // 시뮬레이션 시작
        while (true) {
            // 1. 현재 위치가 아직 청소되지 않은 경우 청소
            if (map[r][c] == 0) {
                map[r][c] = 2; // 청소 완료 표시
                result++;      // 청소 횟수 증가
            }

            boolean moved = false; // 청소 가능한 칸으로 이동했는지 여부

            // 2. 네 방향 탐색 (왼쪽부터 차례대로 확인)
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 왼쪽 방향으로 회전
                int nx = r + dx[d];
                int ny = c + dy[d];

                // 청소되지 않은 빈 칸을 찾으면 이동
                if (map[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    moved = true;
                    break;
                }
            }

            // 3. 네 방향 모두 청소할 수 없는 경우
            if (!moved) {
                int back = (d + 2) % 4; // 뒤쪽 방향
                int nx = r + dx[back];
                int ny = c + dy[back];

                // 뒤쪽이 벽이면 작동 종료
                if (map[nx][ny] == 1) {
                    break;
                }

                // 벽이 아니면 뒤로 한 칸 후진 (방향은 유지)
                r = nx;
                c = ny;
            }
        }

        // 최종 청소한 칸 개수 출력
        System.out.println(result);
    }
}
