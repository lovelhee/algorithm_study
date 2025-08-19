package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Study0815 {

	public static void main(String[] args) throws Exception {

		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		String[] mnInputStrings = bReader.readLine().split(" ");
		int m = Integer.parseInt(mnInputStrings[0]);
		int n = Integer.parseInt(mnInputStrings[1]);

		int box[][] = new int[n][m];

		int countDay = 0;

		int num0 = 0;

		for (int i = 0; i < n; i++) {
			String[] boxInputStrings = bReader.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(boxInputStrings[j]);
				if (box[i][j] == 0) num0++;
			}
		}

		if (num0 == 0) countDay = 0;
		else countDay = cal(countDay, box, n, m);
		
		System.out.println(countDay);
		

	}

	private static int cal(int countDay, int[][] box, int n, int m) {

//        while (true) {
//            boolean changed = false;
//
//            int[][] next = new int[n][m];
//            for (int i = 0; i < n; i++) {
//                System.arraycopy(box[i], 0, next[i], 0, m);
//            }
//
//            for (int y = 0; y < n; y++) {
//                for (int x = 0; x < m; x++) {
//                    if (box[y][x] == 0) {
//                        if ((y > 0 && box[y - 1][x] == 1) ||  		
//                            (y + 1 < n && box[y + 1][x] == 1) ||  	
//                            (x > 0 && box[y][x - 1] == 1) ||  		
//                            (x + 1 < m && box[y][x + 1] == 1))    	
//                        {
//                            next[y][x] = 1;
//                            changed = true;
//                        }
//                    }
//                }
//            }
//
//            if (!changed) break;      
//            box = next;                 
//            countDay++;                 
//        }
//
//        for (int y = 0; y < n; y++) {
//            for (int x = 0; x < m; x++) {
//                if (box[y][x] == 0) return -1;
//            }
//        }
//        return countDay; 
		
		Queue<int[]> q = new LinkedList<>();

	    // 익은 토마토들 큐에 넣음
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            if (box[i][j] == 1) {
	                q.add(new int[]{i, j}); 
	            }
	        }
	    }
	    
	    int[] dy = {-1, 1, 0, 0};
	    int[] dx = {0, 0, -1, 1};

	    while (!q.isEmpty()) {
	        int[] now = q.poll();   // 하나 꺼내기
	        int y = now[0];
	        int x = now[1];

	        for (int d = 0; d < 4; d++) {
	            int ny = y + dy[d];
	            int nx = x + dx[d];

	            // 범위 벗어나면 건너뜀
	            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

	            // 안 익은 토마토면 익게 만들고 날짜 기록
	            if (box[ny][nx] == 0) {
	                box[ny][nx] = box[y][x] + 1; // 오늘보다 하루 뒤
	                q.add(new int[]{ny, nx});
	            }
	        }
	    }

	    int maxDay = 1;
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            if (box[i][j] == 0) return -1; // 아직 안 익은 게 있으면 실패
	            maxDay = Math.max(maxDay, box[i][j]);
	        }
	    }

	    return maxDay - 1; // 처음이 1부터라 -1
	}

}
