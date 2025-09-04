//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18TrIqIwUCFAZN
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
         
        for(int T =1; T <= 10 ; T++) {
            int V = sc.nextInt();
            int E = sc.nextInt();
             
            List<List<Integer>> l = new ArrayList<List<Integer>>();
             
            for(int i =0; i <= V; i++)
                l.add(new ArrayList<Integer>());
            int temp []= new int[V+1];
            for(int i = 0 ; i <E; i++) {
                int a = sc.nextInt();
                int b=  sc.nextInt();
                 
                l.get(a).add(b);
                temp[b]++;
            }
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
             
            for(int i = 1 ; i <=V; i++)
                if(temp[i] == 0) pq.add(i);
            System.out.print("#" + T + " ");
            while(!pq.isEmpty()) {
                int cur = pq.poll();
                System.out.print(cur + " ");
                for(int next : l.get(cur)) {
                    if(--temp[next] == 0) {
                        pq.add(next);
                    }
                }
  
                     
            }
             
            System.out.println();
        }
    }
}
