import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		String[] inputNumStrings = bReader.readLine().split(" ");
		int l = Integer.parseInt(inputNumStrings[0]); // l개의 문자
		int c = Integer.parseInt(inputNumStrings[1]); // c개의 문자열 중에서

		String[] inputStrings = bReader.readLine().split(" ");

		Arrays.sort(inputStrings);

		boolean[] visited = new boolean[c];

		comb(inputStrings, visited, 0, c, l);

	}

	private static void comb(String[] arr, boolean[] visited, int start, int n, int r) {
		if (r == 0) {
			print(arr, visited, n);
			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true;
			comb(arr, visited, i + 1, n, r - 1);
			visited[i] = false;
		}

	}

	private static void print(String[] arr, boolean[] visited, int n) {
		String resultString = "";
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				resultString += arr[i];
				if ("aeiou".contains(arr[i])) {
				    count++;
				}
			}

		}

		if (resultString.contains("a") || resultString.contains("e") || resultString.contains("i")
				|| resultString.contains("o") || resultString.contains("u")) {

			if (resultString.length() - count >= 2) {

				System.out.println(resultString);
			}

		}

	}

}