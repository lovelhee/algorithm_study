import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * BOJ11053 :: 가장 긴 증가하는 부분 수열(12015, 12738)
 * 정직한 LIS 문제
 * 
 * 첫째 줄에 N(1 <= N <= 1000)이 주어진다. 
 * 둘째 줄에는 공백으로 구분된 수열이 주어진다.
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		String[] tmp = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		
		ArrayList<Integer> dp = new ArrayList<Integer>();
		
		for(int i : arr) {
			int pos = Collections.binarySearch(dp, i);
			
			if(pos < 0) {
				pos = -(pos + 1);
			}
			
			if(pos == dp.size()) {
				dp.add(i);
			}
			else {
				dp.set(pos, i);
			}
		}
		
		bw.append(dp.size() + "");
		bw.flush();
	}
}
