//경쟁적 감
//1초마다 번식,우선 순위가 있는 BFS 


package Day0822;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Virus {
    int type;  // 바이러스 종류
    int x, y;  // 위치
    int time;  // 퍼진 시간
    
    Virus(int type, int x, int y, int time) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {
    static int N, K;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};  // 상하좌우
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        
        map = new int[N][N];
        List<Virus> initialViruses = new ArrayList<>();
        
        // 시험관 정보 입력 및 초기 바이러스 위치 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] != 0) {
                    initialViruses.add(new Virus(map[i][j], i, j, 0));
                //							바이러스 종류, 행, 열, 시작시간 0
                // 예시 Virus(2, 0, 2, 0) - 2번 바이러스가 (0,2)에 시간 0에 위치

                }
            }
        }
        // 초기 바이러스들을 바이러스 번호 순으로 정렬
        // 낮은 번호부터 먼저 퍼져야 하므로
        Collections.sort(initialViruses, (a, b) -> a.type - b.type);
       
        
        int S = sc.nextInt();  // 시간
        int X = sc.nextInt() - 1;  // 행 (0-indexed로 변환)
        int Y = sc.nextInt() - 1;  // 열 (0-indexed로 변환)
    
        

        // BFS를 위한 큐
        Queue<Virus> queue = new LinkedList<>();
        for (Virus v : initialViruses) {
            queue.offer(v);
        }
        
        // BFS 시뮬레이션
        while (!queue.isEmpty()) {
            Virus current = queue.poll();
            
            // S초가 지났으면 더 이상 진행하지 않음
            if (current.time >= S) {
                break;
            }
            
            // 현재 바이러스에서 4방향으로 퍼뜨리기
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                // 범위 체크
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                
                // 이미 다른 바이러스가 있으면 퍼질 수 없음
                if (map[nx][ny] != 0) continue;
                
                // 바이러스 퍼뜨리기
                map[nx][ny] = current.type;
                queue.offer(new Virus(current.type, nx, ny, current.time + 1));
            }
        }
        
        // S초 후 (X, Y) 위치의 바이러스 출력
        System.out.println(map[X][Y]);
        sc.close();
    }
}