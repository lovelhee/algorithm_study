import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static class Node {
		Node prev;
		Node next;
		boolean isRobotOn;
		int capa;
		int idx;
		
		Node(Node prev, Node next, boolean isRobotOn, int capa, int idx) {
			this.prev = prev;
			this.next = next;
			this.isRobotOn = isRobotOn;
			this.capa = capa;
			this.idx = idx;
		}
	}
	
	static Node[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new Node[n * 2];
		
		st = new StringTokenizer(br.readLine());
		Node tmp = null;
		for(int i = 0; i < n * 2; i++) {
			int capa = Integer.parseInt(st.nextToken());
			arr[i] = new Node(null, null, false, capa, i);
			if(tmp != null) {
				arr[i].prev = tmp;
				tmp.next = arr[i];
			}
			tmp = arr[i];
		}
		
		arr[0].prev = tmp;
		tmp.next = arr[0];
		
		int upIdx = 0;
		int downIdx = n - 1;
		
		int step = 1;
		
		while(true) {
			// 1단계. 벨트 회전.
			upIdx = arr[upIdx].prev.idx; // 왼쪽으로
			downIdx = arr[downIdx].prev.idx; // 왼쪽으로
			
			if(arr[downIdx].isRobotOn) { // 로봇이 있나요?
				arr[downIdx].isRobotOn = false; // 내릴게요
			}
			
//			int tmpIdx = downIdx - 1;
			int tmpIdx = arr[downIdx].prev.idx;
			// 2단계. 로봇 이동.
			while(tmpIdx != upIdx) {
				if(arr[tmpIdx].isRobotOn) {
					if(!arr[arr[tmpIdx].next.idx].isRobotOn && arr[arr[tmpIdx].next.idx].capa >= 1) { // 다음께 false라면
						arr[arr[tmpIdx].next.idx].isRobotOn = true;
						arr[arr[tmpIdx].next.idx].capa--; // 이동했으니까 내구도 감소
						arr[tmpIdx].isRobotOn = false; // 원래 있던 칸은 로봇 없어짐
					}
				}
				
				tmpIdx = arr[tmpIdx].prev.idx;
			}
			
			if(arr[downIdx].isRobotOn) { // 이동 다 하고 끝에 로봇?
				arr[downIdx].isRobotOn = false;
			}
			
			// 3단계. 로봇 올리기
			if(arr[upIdx].capa != 0) {
				arr[upIdx].isRobotOn = true;
				arr[upIdx].capa--;
			}
			
			// 4단계. 체크
			if(!check(k)) {
				break;
			}
			
			step++;
		}
		
		System.out.println(step);
	}
	
	static boolean check(int k) {
		int cnt = 0;
		for(int i = 0; i < arr.length; i++) {
			cnt = arr[i].capa == 0 ? cnt + 1 : cnt;
			
			if(cnt >= k) return false;
		}
		
		return true;
	}
}
