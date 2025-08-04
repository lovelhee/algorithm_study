import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * BOJ1541 :: 잃어버린 괄호
 * 괄호를 사용해 식의 값을 최소로 만듦.
 * 
 * 첫째 줄에 식이 주어진다.
 * 
 * 0~9의 숫자, +, -의 기호.
 * 가장 처음과 마지막은 숫자이다.
 * 한 번에 하나의 연산자, 숫자는 0으로 시작할 수 있는 최대 5자리수.
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] sArr = br.readLine().split("-");
		
		int sum = Integer.MAX_VALUE;
		
		for(int i = 0; i < sArr.length; i++) {
			int tmp = 0;
			
			String[] sArr2 = sArr[i].split("\\+");
			for(String s : sArr2) {
				tmp += Integer.parseInt(s);
			}
			
			sum = sum == Integer.MAX_VALUE ? tmp : sum - tmp;
		}
		
		bw.append(sum + "");
		bw.flush();
		bw.close();
	}
}
