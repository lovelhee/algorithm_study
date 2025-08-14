import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Study0813 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int computer = Integer.parseInt(br.readLine());
		int network = Integer.parseInt(br.readLine());
		
		int[][] link = new int [computer+1][computer+1];
		boolean[] visited = new boolean[computer + 1];
		
		for (int i = 0; i < network; i++) {
			String[] input = br.readLine().split(" ");
			link[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;
			link[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = 1;
		}
		
		boolean continueFind = true;
		
		int count = 0;
		visited[1] = true;
		
		while (continueFind) {
			continueFind = false;
            for (int i = 1; i <= computer; i++) {
                if (visited[i]) { // 감염된 컴퓨터면
                    for (int j = 1; j <= computer; j++) {
                        if (link[i][j] == 1 && !visited[j]) {
                            visited[j] = true; // 새로 감염
                            count++;
                            continueFind = true; // 새로 찾았으니 다시
                        }
                    }
                }
            }
        }

        System.out.println(count);
	}
}
