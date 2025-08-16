package Day0814;

import java.util.Scanner;

//BJ16395 파스칼의 삼각형 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		//n*n 크기의 2차원 배열 생성(안쓰는 곳도 0으로 초기화됨)
		int triangle [][] =new int [N][N];
		
		for(int i=0; i<N; i++) {// 그냥 냅다 왼쪽 정렬해버
			for(int j=0;j<i+1;j++) { //1행은 1개 / 2행은 2개 / 3행은 3개 값들어가도
				//각 행의 처음과 마지막은 1임
				if(j==0||j==i) {
					triangle[i][j]=1;
				}else {
					triangle[i][j]=triangle[i-1][j-1]+triangle[i-1][j];
				}
			}
		
		}//배열 입력 종료 
		System.out.println(triangle[N-1][K-1]); //배열은 0,0에서 시작하니
	}
}
