import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * 나무의 키
 * 
 * N개의 나무가 있다.
 * 초기에 각 나무의 키가 주어지고, 하루에 한 나무에 물을 줄 수 있다.
 * 홀수번째 날에는 키가 1, 짝수번째 날에는 키가 2 자람.
 * 물 안줘도 됨.
 * 
 * 이 때, 모든 나무의 키가 처음에 가장 키가 컸던 나무와 같아지도록 하라.
 * 근데 최소 날짜 수.
 * 
 * 예를 들어, 나무가 2그루, 높이가 4, 2라고 했을 때.
 * 1) 1, 0, 1 -> 3일
 * 2) 0, 2 -> 2일 
 * 
 * * 백트래킹.
 * 하나를 선택해서, 첫날 주든. 둘째날 주든. 안주든.
 */
public class Solution {
	static int[] tree;
//	static boolean[] visited;
	static int n;
	
	static int max; // 나무 높이 max
	static int maxIdx;
	
	static int min; // 나무 높이 min
	static int minIdx;
	
	static int notMaxCnt;
	
	static int isAvailablePlusTwoEndIdx;
	static int isAvailablePlusOneEndIdx;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			tree = new int[n];
//			visited = new boolean[n];
			max = Integer.MIN_VALUE;
			maxIdx = -1;
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < n; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				if(max < tree[i]) {
					max = tree[i];
					maxIdx = i;
				}
			}
			
			int day = 0;
			
			while(!check()) {
				day++;
				
				if(day % 2 == 0) { // 짝수
					if(isAvailablePlusTwoEndIdx != -1) {
						tree[isAvailablePlusTwoEndIdx] += 2;
						continue;
					}
					
					if(tree[minIdx] + 2 <= max) {
						tree[minIdx] += 2;
					}
				}
				else { // 홀수
					if(isAvailablePlusOneEndIdx != -1) {
						tree[isAvailablePlusOneEndIdx] += 1;
						continue;
					}
					
					if(notMaxCnt == 1) { // 나무 단 하나. 
						 if(tree[minIdx] + 2 == max) {
							 continue;
						 }
					}
					
					if(tree[minIdx] + 1 <= max) {
						tree[minIdx] += 1;
					}
				}
			}
			
			System.out.println("#" + tc + " " + day);
		}
	}
	
//	static void dfs(int day, int sel) {
//		if(tree[sel] == max) {
//			if(check()) {
//				min = Math.min(min, day);
//			}
//		}
//		
//		for(int i = 0; i < 3; i++) {
//			// case 1
//			if(tree[sel] + 1 <= max) {
//				dfs(day + 1, sel);
//			}
//		}
//		 
//	}
	
	static boolean check() {
		min = Integer.MAX_VALUE;
		minIdx = -1;
		notMaxCnt = 0;
		isAvailablePlusTwoEndIdx = -1;
		isAvailablePlusOneEndIdx = -1;
		
		boolean flag = true;
		for(int i = 0; i < n; i++) {
			if(tree[i] != max) {
				flag = false;
				notMaxCnt++;
			}
			
			if(tree[i] < min) {
				min = tree[i];
				minIdx = i;
			}
			
			if(tree[i] + 2 == max) {
				isAvailablePlusTwoEndIdx = i;
			}
			
			if(tree[i] + 1 == max) {
				isAvailablePlusOneEndIdx = i;
			}
		}
		
		return flag;
	}
}
