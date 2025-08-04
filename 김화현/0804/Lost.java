
import java.util.Scanner;

public class Lost {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();

		String[] numbers = line.split("-");

		int sum = 0;

		for (int i = 0; i < numbers.length; i++) {
			String part = numbers[i];

			// part식에 +가 있는 경우
			if (part.contains("+")) {
				String[] plusParts = part.split("\\+");
				int partSum = 0;

				// 최소로 만드는 더하기 실행
				for (String p : plusParts) {
					partSum += Integer.parseInt(p);
				}

				if (i == 0)
					sum += partSum;// 첫 덩어리는 더하고
				else
					sum -= partSum;// 그 뒤는 빼기
			} else {
				// part식에 +없이 홀로 있는 경우
				int val = Integer.parseInt(part);
				if (i == 0)
					sum += val;
				else
					sum -= val;

			}
			
		}System.out.println(sum);

	}
}
