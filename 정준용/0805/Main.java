// https://www.acmicpc.net/problem/1759
// 정렬후 자음과 모음을 카운트해서 자음이 2개이상 모음이 1개이상이면 출력하는 방식으로 했다 dfs
import java.util.*;

public class Main {
	public static void dfs(String word, String[] str, int index, int max, int end) {
			int word_len = word.length();
			if(word_len == max) {
				int mo = 0;
				int ja = 0;
				for(int i = 0;iword_len; i++) {
					char a = word.charAt(i);
					if(a == 'a'  a =='e'  a== 'i'  a == 'o' a == 'u') {
						mo++;
					}else {
						ja++;
					}
				}
				if(mo  0 && ja  1) {
					System.out.println(word);
				}
				return;
			}
			if(index == end) {
				return;
			}
			dfs(word + str[index], str, index +1, max, end);
			dfs(word,str, index + 1, max, end);
			return;
			
    }

	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int L = sc.nextInt();
	int C = sc.nextInt();
	sc.nextLine();
	
	String line = sc.nextLine();
	String[] chr = line.split( );  
	Arrays.sort(chr);
	
	dfs(, chr, 0, L, C);
	
	}
}
