import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int computer;
	static int line;
	static int count = 0;
	static int arr[][];
	static boolean visit[];

	public static void main(String[] args) {
		computer = sc.nextInt();
		line = sc.nextInt();

		arr = new int[computer + 1][computer + 1];
		visit = new boolean[computer + 1];

		for (int i = 0; i < line; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a][b] = 1;		//����� ���� ǥ��
			arr[b][a] = 1;
		}
		
		visit[1] = true;		//1�� ��ǻ�ͺ��� ����
		dfs(1);				
		
		System.out.println(count);
	}
	
	static void dfs(int L) {
		for(int i = 1; i <= computer; i++) {		//1�� ��ǻ�ͺ��� ������
			if(arr[L][i] == 1 && !visit[i]) {			//�� ��ǻ�Ͱ� ������ �Ǿ��ְ� �湮�� �� ������
				visit[i] = true;
				count++;
				dfs(i);
			}
		}
	}
}
