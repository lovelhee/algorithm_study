import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * BOJ1759 :: 암호 만들기
 * C개의 알파벳이 주어졌을 때, L개의 알파벳을 사용하여 가능성 있는 암호를 모두 구함.
 * 
 * 첫 째 줄에는 L, C가 주어진다.(3 <= L <= C <= 15)
 * 그 다음 줄에는 C개의 문자들이 주어진다.
 * 
 * 알파벳 소문자, 중복은 없음.
 * 암호는 알파벳 오름차순.
 * 최소 한 개의 모음과, 최소 두 개의 자음으로 구성되어 있음.
 */

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = 0, C = 0; // nCr -> n = C / r = L
		String[] arr = br.readLine().split(" ");
		L = Integer.parseInt(arr[0]);
		C = Integer.parseInt(arr[1]);
		
		boolean[] visited = new boolean[C];
		
		arr = br.readLine().split(" ");
		
		Arrays.sort(arr);
		
		comb(arr, visited, 0, C, L);
		
		bw.flush();
		bw.close();
	}
	
	public static void comb(String[] arr, boolean[] visited, int start, int n, int r) throws IOException {
		if(r == 0) {
			StringBuilder sb = new StringBuilder();
			int vCnt = 0;
			int cCnt = 0;
			
			for(int i = 0; i < n; i++) {
				if(visited[i]) {
					sb.append(arr[i]);
					
					if(isVowel(arr[i].charAt(0))) {
						vCnt++;
					}
					else {
						cCnt++;
					}
				}
			}
			
			if(vCnt >= 1 && cCnt >= 2) {
				bw.append(sb.toString() + "\n");
			}
			
			sb.setLength(0);
			
			return;
		}
		
		for (int i = start; i < n; i++) {
			visited[i] = true;
			comb(arr, visited, i + 1, n, r - 1);
			visited[i] = false;
		}
	}
	
	public static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
}