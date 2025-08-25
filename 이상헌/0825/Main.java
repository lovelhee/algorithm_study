import java.util.Scanner;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int max;
    static int n;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            int m = sc.nextInt();
            
            arr = new int[m][2];
            visited = new boolean[m];
            
            for(int i = 0; i < m; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt(); 
            }
            
            max = -1;
            
            comb(0, 0, 0);
            
            System.out.println("#" + tc + " " + max);
        }
        
        sc.close();
    }
    
    static void comb(int idx, int currentCost, int currentValue) {
        if(idx == arr.length) {
            max = Math.max(max, currentValue);
            return;
        }
        
        if(currentCost + arr[idx][0] <= n) {
            comb(idx + 1, currentCost + arr[idx][0], currentValue + arr[idx][1]);
        }
        
        comb(idx + 1, currentCost, currentValue);
    }
}
