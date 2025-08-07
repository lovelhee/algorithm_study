package solvingProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Study0807 {
	public static void main(String[] args) throws Exception {

		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		int aSize = Integer.parseInt(bReader.readLine());

		String[] inputStrings = bReader.readLine().split(" ");

		int[] numArr = new int[aSize];

		for (int i = 0; i < inputStrings.length; i++) {
			numArr[i] = Integer.parseInt(inputStrings[i]);
		}

//		int count = 1;

//		int idx = 0;
//		
//		for (int i = 0; i < numArr.length-1; i++) {
//			if (numArr[idx] < numArr[i+1]) {
//				count++;
//				idx = i+1;
//			}
//			
//		}

//		System.out.println(count);
		
		int[] newArr = new int[aSize]; 	

		int maxLength = 1; 

		for (int i = 0; i < aSize; i++) {								
			newArr[i] = 1; 												

			for (int j = 0; j < i; j++) {								
				if (numArr[j] < numArr[i]) { 							
					newArr[i] = Math.max(newArr[i], newArr[j] + 1); 	
				}
			}

			maxLength = Math.max(maxLength, newArr[i]); 			
		}

		System.out.println(maxLength); 						
	}
}
