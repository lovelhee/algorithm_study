// https://www.acmicpc.net/problem/1541
// 제목 : 잃어버린 괄호 1541
// 알고리즘 : 그리디 알고리즘
// 난이도 : 실버2
// 내꼬

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        // 숫자와 연산자를 저장하기 위한 리스트
        List<Integer> arr = new ArrayList<>();
        List<Character> chr = new ArrayList<>();

        String str_num = "";
        g
        boolean isMinus = false;  // 마이너스가 나온것을 판별하기 위한변수
        
        // 숫자와 연산자를 따로 저장하여 숫자는 변환
        for(int i = 0;i <str.length(); i++){
            if('0' <= str.charAt(i) && str.charAt(i) <= '9'){
                str_num += str.charAt(i);
            }else{
                arr.add( Integer.parseInt(str_num));
                str_num = "";
                chr.add(str.charAt(i));
            }
        }
        // 마지막은 따로 저장
        if (!str_num.equals("")) {
            arr.add(Integer.parseInt(str_num));
        }
        
        int total = arr.get(0);
        
        // -가 나왔는지 판별하여 -가 나온 순간부터 모두 total에서 빼기
        for(int i = 1;i <arr.size();i++ ){
            if(chr.get(i-1) == '-'){
                isMinus = true;
            }
            if( isMinus){
                total -= arr.get(i);
            }else{
                total += arr.get(i);
            }
        }
        System.out.println(total);        

    }
}
