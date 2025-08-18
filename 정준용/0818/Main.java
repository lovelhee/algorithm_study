//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V1SYKAaUDFAWu
// DFS 백트래킹으로 하였다 초반에는 복사할 배열을 1차원으로하였는데 1차원으로 하면 전역변수로 설정하여 dfs들어가면 다른 값으로 채워져 다른값이 나옴
// DFS는 0으로 바꿀때, 1으로 바꿀때, 아무것도 안하고 넘어갈때로 설정
// 시간복잡도 따위 날려버림

import java.util.Scanner;

public class Main {
    static int map[][];
    static int D;
    static int W;
    static int K;
    static int minCount;
    static int temp[][];

    static void Put(int x, int yak) {
        for (int i = 0; i < W; i++) {
            temp[x][i] = map[x][i];
            map[x][i] = yak;
        }
    }

    static void back(int x) {
        for (int i = 0; i < W; i++) {
            map[x][i] = temp[x][i];
        }
    }

    static void DFS(int x, int depth) {

        if (depth >= minCount)
            return;
        boolean okAll = true;
        if (K > 1) {
            for (int col = 0; col < W; col++) {
                int cnt = 1;
                boolean okCol = false;
                for (int row = 1; row < D; row++) {
                    if (map[row][col] == map[row - 1][col]) {
                        cnt++;
                        if (cnt >= K) {
                            okCol = true;
                            break;
                        }
                    } else {
                        cnt = 1;
                    }
                }
                if (!okCol) {
                    okAll = false;
                    break;
                }
            }
        }
        if (K == 1 || okAll) {
            minCount = Math.min(minCount, depth);
            return;
        }
        if (x == D)
            return;

        DFS(x + 1, depth);

        Put(x, 1);
        DFS(x + 1, depth + 1);
        back(x);

        Put(x, 0);
        DFS(x + 1, depth + 1);
        back(x);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int T = 1; T <= tc; T++) {

            D = sc.nextInt();
            W = sc.nextInt();
            K = sc.nextInt();
            map = new int[D][W];
            temp = new int[D][W];
            minCount = Integer.MAX_VALUE;

            for (int i = 0; i < D; i++) {
                for (int j = 0; j < W; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            DFS(0, 0);
            System.out.println("#" + T + " " + minCount);
        }
    }
}
