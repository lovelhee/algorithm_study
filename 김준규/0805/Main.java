import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int L, C;
	public static char[] arr;
	public static char[] result;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		
		result = new char[L];
		arr = new char[C];
		
		for(int i = 0; i < C; i++) {
			arr[i] = sc.next().charAt(0);
		}
		
		Arrays.sort(arr);
		
		dfs(0, 0);
	}
	
	public static void dfs(int depth, int start) {
		if (depth == L) {
			if (isMoja(result)) {
				for (int i = 0; i < result.length; i++) {
					System.out.print(result[i]);
				}
				System.out.println();
			}
			return;
		}

		for (int i = start; i < C; i++) {
			result[depth] = arr[i];
			dfs(depth + 1, i + 1);
		}
	}
	
	public static boolean isMoja(char[] result) {
	    int mo = 0;
	    int ja = 0;

	    for (int i = 0; i < result.length; i++) {
	        if (result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u') {
	            mo++;
	        } else {
	            ja++;
	        }
	    }
	    
	    if(mo >= 1 && ja >= 2) {
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}
}
