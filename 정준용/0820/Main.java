// https://www.acmicpc.net/problem/14503
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static int answer = 0;
    static int[][] map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();
        int c = scanner.nextInt();

        int sr = scanner.nextInt();
        int sc = scanner.nextInt();
        int d = scanner.nextInt();

        map = new int[r + 2][c + 2];
        for (int i = 0; i < r + 2; i++) {
            Arrays.fill(map[i], -1);
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                int val = scanner.nextInt();
                if (val == 0) map[i][j] = 0;
            }
        }

        DFS(sr + 1, sc + 1, d);

        System.out.println(answer);
    }

    static void DFS(int x, int y, int d) {
        if (map[x][y] == -1) return;

        if (map[x][y] == 0) {
            answer++;
            map[x][y] = 1;
        }

        for (int i = 0; i < 4; i++) {
            if (d == 0) d = 3;
            else d = d - 1;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (map[nx][ny] == 0) {
                DFS(nx, ny, d);
                return;
            }
        }

        int bx = x, by = y;
        switch (d) {
            case 0: bx = x + 1; by = y; break; 
            case 1: bx = x; by = y - 1; break; 
            case 2: bx = x - 1; by = y; break; 
            case 3: bx = x; by = y + 1; break; 
        }
        DFS(bx, by, d);
    }
}
