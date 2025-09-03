import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
//	static int k;

	static int[][] arr;

	static int min;

	static ArrayList<int[]> al = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] != 0 && arr[i][j] != 6) {
					al.add(new int[] { i, j });
				}

			}
		}

		min = Integer.MAX_VALUE;

		simulation(0);

		System.out.println(min);
	}
	
	static int[][] deepCopy(int[][] o) {
		int[][] copy = new int[o.length][];
		for(int i = 0; i < o.length; i++) {
			copy[i] = o[i].clone();
		}
		
		return copy;
	}
	
	static int getMaxDirection(int cctvType) {
		switch (cctvType) {
			case 1: return 4;  // 4방향
			case 2: return 2;  // 2방향 (가로/세로)
			case 3: return 4;  // 4방향
			case 4: return 4;  // 4방향
			case 5: return 1;  // 1방향 (고정)
			default: return 0;
		}
	}

	static void simulation(int idx) {
		if(idx >= al.size()) {
			min = Math.min(min, calc());
			return;
		}
		
		int[][] nArr = deepCopy(arr);

		int[] np = al.get(idx);
		int cctvType = arr[np[0]][np[1]];
		int maxDir = getMaxDirection(cctvType);

		for (int dir = 0; dir < maxDir; dir++) {
			change(cctvType, dir, np[0], np[1]);
			simulation(idx + 1);
			arr = deepCopy(nArr);
		}
	}

	static void right(int row, int col) {
		for (int j = col + 1; j < m; j++) {
			if (arr[row][j] == 6) return; 
			if (arr[row][j] >= 1 && arr[row][j] <= 5) continue;
			arr[row][j] = 9;
		}
	}

	static void down(int row, int col) {
		for (int i = row + 1; i < n; i++) {
			if (arr[i][col] == 6) return;
			if (arr[i][col] >= 1 && arr[i][col] <= 5) continue;
			arr[i][col] = 9;
		}
	}

	static void left(int row, int col) {
		for (int j = col - 1; j >= 0; j--) {
			if (arr[row][j] == 6) return;
			if (arr[row][j] >= 1 && arr[row][j] <= 5) continue;
			arr[row][j] = 9;
		}
	}

	static void up(int row, int col) {
		for (int i = row - 1; i >= 0; i--) {
			if (arr[i][col] == 6) return;
			if (arr[i][col] >= 1 && arr[i][col] <= 5) continue;
			arr[i][col] = 9;
		}
	}

	static void change(int type, int dir, int x, int y) {
		switch (type) {
		case 1: // 4
			switch (dir) {
			case 0:
				right(x, y); break;
			case 1:
				down(x, y); break;
			case 2:
				left(x, y); break;
			case 3:
				up(x, y);
				break;
			}
			break;
		case 2: // 2
			switch (dir) {
			case 0:
				right(x, y);
				left(x, y);
				break;
			case 1:
				down(x, y);
				up(x, y);
				break;
			}
			break;
		case 3: // 4
			switch (dir) {
			case 0:
				up(x, y);
				right(x, y);
				break;
			case 1:
				right(x, y);
				down(x, y);
				break;
			case 2:
				down(x, y);
				left(x, y);
				break;
			case 3:
				left(x, y);
				up(x, y);
				break;
			}
			break;
		case 4: // 4
			switch (dir) {
			case 0:
				left(x, y);
				up(x, y);
				right(x, y);
				break;
			case 1:
				up(x, y);
				right(x, y);
				down(x, y);
				break;
			case 2:
				right(x, y);
				down(x, y);
				left(x, y);
				break;
			case 3:
				down(x, y);
				left(x, y);
				up(x, y);
				break;
			}
			break;
		case 5: // 1
			up(x, y);
			right(x, y);
			down(x, y);
			left(x, y);
			break;

		default:
			return;
		}
		
	}

	static boolean isValid(int nx, int ny) {
		return nx >= 0 && nx < m && ny >= 0 && ny < n && arr[ny][nx] != 6;
	}

	static boolean isCCTV(int nx, int ny) {
		return arr[ny][nx] >= 1 && arr[ny][nx] <= 5;
	}

	static int calc() {
	    int cnt = 0;
	    
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            if (arr[i][j] == 0) {
	                cnt++;
	            }
	        }
	    }
	    return cnt;
	}

}
