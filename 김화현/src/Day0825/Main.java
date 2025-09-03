package Day0825;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for (int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            int[] trees = new int[n];
            
            // 나무 높이 입력
            for (int i = 0; i < n; i++) {
                trees[i] = sc.nextInt();
            }
            
            // 소트해서 최소값 빼기로 연산량 줄이기!
            Arrays.sort(trees);
            int minHeight = trees[0];           // 최소 높이
            int maxHeight = trees[n - 1];       // 최대 높이 (목표)
            
            // 모든 높이에서 최소값 빼기 (연산 줄이기)
            for (int i = 0; i < n; i++) {
                trees[i] = trees[i] - minHeight;
            }
            
   