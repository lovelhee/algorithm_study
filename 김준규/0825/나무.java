import java.util.Scanner;

public class 나무 {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int arr[];
	static int max = 0;
	static int day = 1;
	static int result = 0;
	
	public static void main(String[] args) {
	    int T = sc.nextInt();

	    for (int t = 1; t <= T; t++) {
	        N = sc.nextInt();
	        arr = new int[N];
	        max = 0;
	        day = 1;

	        for (int i = 0; i < N; i++) {
	            arr[i] = sc.nextInt();

	            if (max < arr[i]) {
	                max = arr[i];
	            }
	        }

	        for (int i = 0; i < N; i++) {
	            int temp1;
	            temp1 = max - arr[i];
	            result += temp1;
	        }

	        for (int i = 0; i < N; i++) {
	            int temp;

	            temp = max - arr[i];

	            if (temp == 0) {
	                continue;
	            }

	            while (result > 2) {
	                if (day % 2 == 1) {
	                    result -= 1;
	                    day++;
	                } else if (day % 2 == 0) {
	                    result -= 2;
	                    day++;
	                }
	            }

	            if (result == 1) {
	                if (day % 2 == 0) {
	                    day++;
	                    result -= 1;
	                    day++;
	                } else if (day % 1 == 0) {
	                    result -= 1;
	                    day++;
	                }
	            }

	            else if (result == 2) {
	                if (day % 2 == 0) {
	                    result -= 2;
	                    day++;
	                } else if (day % 1 == 0) {
	                    day++;
	                    result -= 2;
	                    day++;
	                }
	            }
	        }
	        checkzero(arr);

	        System.out.println("#" + t + " " + (day - 1));
	    }
	}

	static void checkzero(int arr[]) {
	    for (int i = 0; i < N; i++) {
	        if (max == arr[i]) {
	            continue;
	        } else {
	            return;
	        }
	    }
	    day = 1;
	}
}
