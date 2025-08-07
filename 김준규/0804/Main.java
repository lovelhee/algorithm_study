import java.util.Scanner;

public class Main {
	public static String sick;
	public static String temp = "";
	public static int re = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		sick = sc.next();
		
		int[] result = new int[sick.length()];
		int count = 0;
		int count1 = 1;
		
		for(int i = 0; i < sick.length(); i++) {
			char c = sick.charAt(i);
			
			if(Character.isDigit(c)) {
				temp += c;
			}
			else {
				result[count] = Integer.parseInt(temp);
				temp = "";
				count++;
			}
		}
		
		if(!temp.isEmpty()) {
			result[count] = Integer.parseInt(temp);
		}
		
		re = result[0];
		
		loop:
		for(int i = 0; i < sick.length(); i++) {
			char c = sick.charAt(i);
			
			if(c == '+') {
				re += result[count1];
				count1++;
			}
			else if(c == '-'){
				for(int j = count1; j <= count; j++) {
					re -= result[j];
				}
				break loop;
			}
		}
		
		System.out.println(re);
	}
}