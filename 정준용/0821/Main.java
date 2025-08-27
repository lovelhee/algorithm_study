//https://www.acmicpc.net/problem/2589
// DFS + 백트래킹은 별로다 BFS 로 해라
import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int row, col;
    static char[][] map;

    static int bfs(int x, int y) {
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;
        int maxDist = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1], dist = cur[2];
            maxDist = Math.max(maxDist, dist);

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                if (!visited[nx][ny] && map[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return maxDist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        sc.nextLine();

        map = new char[row][col];
        for (int i = 0; i < row; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int answer = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 'L') {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }
        System.out.println(answer);
    }
}

// public class Main {
//     static int[] dx = {1, -1, 0, 0};
//     static int[] dy = {0, 0, 1, -1};
//     static int row, col;
//     static char[][] map;
//     static boolean[][] visited;
//     static int max = 0;

//     static void DFS(int x, int y, int count) {
//         visited[x][y] = true;
//         max = Math.max(max, count);

//         for (int i = 0; i < 4; i++) {
//             int nx = x + dx[i];
//             int ny = y + dy[i];

//             if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
//             if (map[nx][ny] == 'L' && !visited[nx][ny]) {
//                 DFS(nx, ny, count + 1);
//             }
//         }
//         visited[x][y] = false; 
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         row = sc.nextInt();
//         col = sc.nextInt();
//         sc.nextLine();

//         map = new char[row][col];

//         for (int i = 0; i < row; i++) {
//             String line = sc.nextLine();
//             for (int j = 0; j < col; j++) {
//                 map[i][j] = line.charAt(j);
//             }
//         }

//         for (int i = 0; i < row; i++) {
//             for (int j = 0; j < col; j++) {
//                 if (map[i][j] == 'L') {
//                     visited = new boolean[row][col];
//                     DFS(i, j, 0);
//                 }
//             }
//         }
//         System.out.println(max);
//     }
// }

