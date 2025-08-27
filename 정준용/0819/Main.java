//https://www.acmicpc.net/problem/14503
// 올리는 위치와 내리는 위치를 직접 이동하여 계산하였다

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int len = 2 * n;

        int[] a = new int[len];
        for (int i = 0; i < len; i++)
            a[i] = sc.nextInt();

        boolean[] robot = new boolean[len];
        int up = 0;
        int down = n - 1;
        int count = 0;

        while (true) {
            count++;

            up = (up - 1 + len) % len;
            down = (down - 1 + len) % len;
            if (robot[down])
                robot[down] = false;

            for (int i = n - 2; i >= 0; i--) {
                int cur = (up + i) % len;
                int next = (up + i + 1) % len;
                if (robot[cur] && !robot[next] && a[next] > 0) {
                    robot[cur] = false;
                    if (next != down)
                        robot[next] = true;
                    a[next]--;
                }
            }
            if (robot[down])
                robot[down] = false;

            if (a[up] > 0 && !robot[up]) {
                robot[up] = true;
                a[up]--;
            }

            int zero = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] == 0) {
                    zero++;
                }
            }
            if (zero >= k)
                break;
        }

        System.out.println(count);
    }
}
