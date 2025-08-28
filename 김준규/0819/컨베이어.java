import java.util.*;

public class 컨베이어 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] belt = new int[2 * N];
        boolean[] robots = new boolean[2 * N];

        for (int i = 0; i < 2 * N; i++) {
            belt[i] = sc.nextInt();
        }

        int step = 0;
        while (true) {
            step++;

            int lastBelt = belt[2*N - 1];
            for (int i = 2*N - 1; i > 0; i--) {
                belt[i] = belt[i-1];
                robots[i] = robots[i-1];
            }
            belt[0] = lastBelt;
            robots[0] = false;

            robots[N-1] = false;

            for (int i = N-2; i >= 0; i--) {
                if (robots[i] && !robots[i+1] && belt[i+1] > 0) {
                    robots[i] = false;
                    robots[i+1] = true;
                    belt[i+1]--;
                }
            }
            robots[N-1] = false;

            if (belt[0] > 0) {
                robots[0] = true;
                belt[0]--;
            }

            int zeroCount = 0;
            for (int i = 0; i < 2*N; i++) {
                if (belt[i] == 0) zeroCount++;
            }
            if (zeroCount >= K) break;
        }

        System.out.println(step);
    }
}
