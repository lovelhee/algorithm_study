// 서칭 -> 문제 이해
import java.util.*;
 
public class Main {
     
    static boolean isCheck(int day, int ones, int twos) {
        int oddDay = (day + 1) / 2; 
        int evenDay = day / 2;      
 
        int needOdd = ones + Math.max(0, 2 * (twos - evenDay));
 
        return oddDay >= needOdd;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
         
        for(int T = 1 ; T <= tc; T++) {
            int N = sc.nextInt();
            int tree[] = new int[N];
            int maxTree = 0;
            for(int i= 0 ; i < N; i++) {
                tree[i] = sc.nextInt();
                maxTree = Math.max(maxTree, tree[i]);
            }
            int odd = 0;
            int even = 0;
            for(int i = 0 ; i < N; i++) {
                int n = (maxTree - tree[i]);
                 if(n % 2 == 1) odd++;
                 even += n /2;
            }
            int D = 0;
            while(!isCheck(D , odd, even))D++;
             
            System.out.println("#" + T + " " +D);
             
             
             
             
             
             
             
             
             
             
             
             
        }
         
    }
}
