//https://www.acmicpc.net/problem/2961
import java.util.*;
public class Main
{
	
	static int sin [];
	static int ssn[];
	static int N;
	static int min = Integer.MAX_VALUE;
	static void dfs(int i,int a, int b) {
		
		if(i == N) {
			if(a == 1 && b == 0) return;
			min = Math.min(min, Math.abs(a - b));
			return;
		}

		dfs(i+1, a, b);
		dfs(i+1, a*sin[i], b+ssn[i]);
		
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		N = sc.nextInt();
		
		sin = new int[N];
		ssn = new int[N];
		
		for(int i = 0; i < N; i++) {
			sin[i] = sc.nextInt();
			ssn[i] = sc.nextInt();
		}
		
		dfs(0,1,0);
		
		System.out.println(min);
	}
}
