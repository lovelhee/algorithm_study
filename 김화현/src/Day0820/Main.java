import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	
	//입력 받기
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K= sc.nextInt();
		int [] durability = new int [2*N]; //1부터 2N이지만 배열에서는 0에서 2N-1
		
		for (int i=0; i<2*N; i++) {
			durability[i]=sc.nextInt();//2*N개 모두 입력 받
		}//내구성 입력 완료
		
		boolean[] robot = new boolean[2*N];//로봇 위치 추
		
		int step=0;
		while (true) {
			step++;
			
		//1번 벨트 회전+ 로봇 회전 (동시에 일어남)
		//마지막 값을 따로 저장해두고
			boolean tempRobot = robot[2*N-1];
			int temp = durability[2*N-1];
			
			for (int i=2*N-1;i>0;i--) {
				durability[i]=durability[i-1];
				robot[i]=robot[i-1];
			}
			robot[0]=tempRobot;
			durability[0]=temp; //마지막값도 넣어줌
			
			robot[N-1]=false; //내리는 위치에 있는 로봇 제
			//내리는 위치 도달시 즉시 내린다.
		
		//2번 로봇 이동
		for(int i=N-2; i>0;i--) {//N-1은 내리는 위치라 제외
			if(robot[i]&&!robot[i+1]&&durability[i+1]>=1) {
				robot[i]=false;
				robot[i+1]=true;
				durability[i+1]--;
			}
		}
		robot[N-1]=false; //내리는 위치 도달시 바로 지운
		
		//3번 로봇 추가
		if(!robot[0]&&durability[0]>=1) {
			robot[0]=true;
			durability[0]--;
		}
	
		
		//4번 종료 조건 확인 
		//내구도 0인 칸 개수 세기 
		int zerocount=0;
		for(int i=0; i<2*N; i++) {
			if(durability[i]==0)
				zerocount++;}
		
		if(zerocount>=K) {
			System.out.println(step);
			break;
		}
	}//메인 종료
	
	}
}// 클래스 종
