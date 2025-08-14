import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			arr.add(new ArrayList<>());
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					arr.get(i).add(1);
				} else {
					arr.get(i).add(arr.get(i - 1).get(j - 1) + arr.get(i - 1).get(j));
				}
			}
		}

		System.out.println(arr.get(n - 1).get(k - 1));
	}
}
