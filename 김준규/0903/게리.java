import java.util.*;

public class 게리 {
    static int N;
    static int[] population;
    static ArrayList<Integer>[] graph;
    static boolean[] selected;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        population = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            population[i] = sc.nextInt();
        }

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            int cnt = sc.nextInt();
            for (int j = 0; j < cnt; j++) {
                int v = sc.nextInt();
                graph[i].add(v);
            }
        }

        selected = new boolean[N + 1];
        dfs(1);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void dfs(int idx) {
        if (idx == N + 1) {
            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (selected[i]) A.add(i);
                else B.add(i);
            }

            if (A.size() == 0 || B.size() == 0) return;

            if (isConnected(A) && isConnected(B)) {
                int sumA = 0, sumB = 0;
                for (int v : A) sumA += population[v];
                for (int v : B) sumB += population[v];
                answer = Math.min(answer, Math.abs(sumA - sumB));
            }
            return;
        }

        selected[idx] = true;
        dfs(idx + 1);
        selected[idx] = false;
        dfs(idx + 1);
    }

    static boolean isConnected(ArrayList<Integer> area) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.add(area.get(0));
        visited[area.get(0)] = true;

        int cnt = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (area.contains(next) && !visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
        }
        return cnt == area.size();
    }
}
