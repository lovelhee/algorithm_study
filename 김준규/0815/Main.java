
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dy = { -1, 1, 0, 0 };
        int[] dx = { 0, 0, -1, 1 };
        int M = sc.nextInt(), N = sc.nextInt();

        int[][] box = new int[N][M];
        int count = 0, day = 0;
        Queue<int[]> q = new LinkedList<>();	//익은 토마토 큐에 넣기

        for (int n = 0; n < N; n++)
            for (int m = 0; m < M; m++) {
                box[n][m] = sc.nextInt();
                if (box[n][m] == 1)
                    q.add(new int[] { n, m });
                else if (box[n][m] == 0)
                    count++;
            }

        while (count > 0 && !q.isEmpty()) {
            for (int s = q.size(); s > 0; s--) {	//
                int[] cur = q.poll();		//익은 토마토 꺼내기

                for (int k = 0; k < 4; k++) {
                    int ny = cur[0] + dy[k];
                    int nx = cur[1] + dx[k];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= M || box[ny][nx] != 0)
                        continue;

                    count--;
                    box[ny][nx] = 1;
                    q.add(new int[] { ny, nx });
                }
            }
            day++;
        }
        System.out.println(count == 0 ? day : -1);

    }
}