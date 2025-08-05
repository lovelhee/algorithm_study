package 김화현;
//문자 6개중 4개를 택함 6C4
//모두 소문자
//최소 1개의 모음 aeiou
//최소 2개의 자음 
//기본 소트되어있음

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int L,C;// L : 암호 길이, C : 문자 개수 
	static char[] arr; // 주어진 문자들 정렬해서 저장 배
	static char[] result; // 암호 조합을 만들 배열 
	static final Set<Character> vowels = Set.of('a','e','i','o','u');//모음 판별
	// 중복없이, 고정된 값으로, 불변(수정 불가)인 Set만들어// O(1)로 O(n)리스트 보다 빠름 
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		L=sc.nextInt();// 암호길이 ex)4
		C= sc.nextInt();//사용할 문자 개수 ex)6
		
	    arr= new char[C]; //주어진 문자들을 저장할 배열 생성 (C개) 불변
		
		for (int i=0;i<C;i++) {
			arr[i] = sc.next().charAt(0);//문자열 입력받고 첫 글자만 저
		} //sc.next()하면 "a"인데charAt 'a'로 바껴서 char[] arr 저장 가
		
		//사전순 출력을 위한 문자들을 정렬 
		Arrays.sort(arr); //재귀 돌때마다 변
		
		//암호 조합 결과를 저장할 배열 초기화 (길이 L만큼)
		result = new char[L]; //4개
		
		//조합 생성 시작 (start=0부터 시작, depth=0)
		backtrack(0,0);
	}
		
		/**
		 * 조합을 생성하는 백트래킹 함
		 * @Param start 다음 문자를 고를 인덱스 시작점 (중복 방지를  위해 이전보다 큰 인덱스만 사용)
		 * @Param depth 지금까지 고른 문자 개수 (암호 길이가 되면 종료 조건)
		 * 
		 */
		static void backtrack (int start, int depth) {
			//종료 조건 : 암호 길이 L개를 다 골랐을 때
			if(depth==L) {
				//모음이 1개 이상, 자음이 2개 이상인지 확인
				if(isValid(result)) {
					//조건을 마족하면 char배열을 문자열로 변환해서 출력
					//System.out.println("depth: " + depth + ", start: " + start + ", result: " + Arrays.toString(result));
					System.out.println(new String(result));
				}
				return; //조건과 관계없이 더 이상 문자를 고를 수 없음으로 backtrack종
			}
			
			//start부터 C (전체 문자) 순회하며 문자 선택 (오름차순 조합 생성)
			for (int i= start; i<C;i++) {
				result[depth]=arr[i];//현재 문자를 result에 넣
				backtrack(i+1,depth+1);//다음 문자를 고르러 재귀 호
			}
			
		}
	
		
		/**
		 * 암호가 모음 1개 이상, 자음 2개 이상 포함하는 지 확
		 * 
		 * @Param password 완성된 암호 조합 (char 배열)
		 * @return 조건 만족하면 true, 아니면 false
		 */
		static boolean isValid(char[] password) {
			int vowelCount=0; //모음 개수 카운트
			int consonantCount=0;//자음 개수 카운트
			
			//password배열 돌면서 모음.자음 개수 세기
			for(char c : password) {
				if(vowels.contains(c)) {
					vowelCount++; //모음이면 모음 카운트 증가 
				}else {
					consonantCount++; //자음이면 자음 카운트 증
				}
				
			}
			return vowelCount>=1&& consonantCount>=2;

		
	}
}
