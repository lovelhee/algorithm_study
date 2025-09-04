import java.util.*;

public class 스카이캐슬디펜스 {
    static int N, M, D;
    static int[][] map;
    static int killCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // M개의 열 중에서 3개를 고르는 조합
        comb(0, 0, new int[3]);

        System.out.println(killCount);
    }

    // 궁수 배치 조합
    static void comb(int idx, int start, int[] goong) {
        if (idx == 3) {
            simulate(goong);
            return;
        }
        for (int i = start; i < M; i++) {
            goong[idx] = i;
            comb(idx + 1, i + 1, goong);
        }
    }

    // 시뮬레이션 실행
    static void simulate(int[] goong) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) copy[i] = map[i].clone();

        int kill = 0;

        // 최대 N턴 (적이 내려올 수 있는 최대 턴)
        for (int turn = 0; turn < N; turn++) {
            Set<String> targets = new HashSet<>();

            // 각 궁수의 공격
            for (int a : goong) {
                int[] enemy = find(copy, a, N - turn); // 궁수 행 = N-turn
                if (enemy != null) {
                    targets.add(enemy[0] + "," + enemy[1]);
                }
            }

            // 적 제거
            for (String t : targets) {
                String[] parts = t.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                if (copy[x][y] == 1) {
                    kill++;
                    copy[x][y] = 0;
                }
            }

            // 적 이동 (맨 아랫줄 적은 성으로 들어감)
            for (int i = N - 1; i > 0; i--) {
                copy[i] = copy[i - 1];
            }
            copy[0] = new int[M]; // 새 줄은 비어 있음
        }

        killCount = Math.max(killCount, kill);
    }

    // 궁수가 쏠 수 있는 가장 가까운 적 찾기
    static int[] find(int[][] map, int col, int archerRow) {
        int minDist = Integer.MAX_VALUE;
        int[] target = null;

        for (int i = 0; i < archerRow; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    int dist = (archerRow - i) + Math.abs(col - j);
                    if (dist <= D) {
                        if (dist < minDist || (dist == minDist && j < target[1])) {
                            minDist = dist;
                            target = new int[]{i, j};
                        }
                    }
                }
            }
        }
        return target;
    }
}
