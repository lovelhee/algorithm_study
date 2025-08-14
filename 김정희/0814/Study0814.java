import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Study0814 {
	public static void main(String[] args)throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		int pascal[][] = new int [n][n];
		
		for (int i = 0; i < n; i++) {
			pascal[i][0] = 1;
			pascal[i][i] = 1;
		}
		
		for (int i = 2; i < n; i++) {
			for (int j = 1; j < n; j++) {
				pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
			}
		}
		
//		for (int i = 0; i < pascal.length; i++) {
//			System.out.println();
//			for (int j = 0; j < pascal.length; j++) {
//				System.out.print(pascal[i][j]);
//			}
//		}
		
		System.out.println(pascal[n-1][k-1]);
		
	}
}
