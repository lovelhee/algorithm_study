import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Study0808_2 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(count(n)).append('\n');
		}

		System.out.print(sb.toString());
	}

	private static int count(int n) {
		int result = 0;
		
		for (int i = 0; i <= n / 3; i++) {
			int rest = n - (3 * i);
			result += (rest / 2) + 1;
		}
		
		return result;
	}
}
