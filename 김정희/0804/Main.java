import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		String input = bReader.readLine();
		
		int result = 0;
		String number = "";
		char cal = '+'; 

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);

			if (ch != '+' && ch != '-') {
				number += ch;
			} else {
				int n = Integer.parseInt(number);

				if (cal == '+') {
					result += n;
				} else if (cal == '-') {
					result -= n;
				}
		
				if (ch == '-') {
					cal = '-';
				}

				number = ""; 
			}
		}

		int n = Integer.parseInt(number);
		if (cal == '+') {
			result += n;
		} else if (cal == '-') {
			result -= n;
		}

		System.out.println(result);
	}

}