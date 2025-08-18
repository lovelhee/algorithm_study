//https://www.acmicpc.net/problem/7576
//BFS로 풀었고 q에 들어간 만큼 반복하여 day를 구함
import java.util.*;

public class Main {
    static int dx[] = { 1, -1, 0, 0 };
    static int dy[] = { 0, 0, 1, -1 };
    static int map[][];
    static int N;
    static int M;
    static int day = 0;

    static void BFS() {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    q.add(new int[] { i, j });
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for(int a = 0; a < size; a++){
                int curLo[] = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = curLo[0] + dx[i];
                    int ny = curLo[1] + dy[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                    if (map[nx][ny] == 1 || map[nx][ny] == -1)
                    continue;
                    map[nx][ny] = 1;
                    q.add(new int[] { nx, ny });
                }
            }
            if(!q.isEmpty()) day++;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        boolean isTrue = false;
        BFS();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    isTrue = true;
                    break;
                }
            }
        }

        if (isTrue == true) {
            System.out.println(-1);
        } else {
            System.out.println(day);
        }
    }
}
