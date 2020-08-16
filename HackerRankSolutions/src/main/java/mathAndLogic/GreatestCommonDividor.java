package mathAndLogic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GreatestCommonDividor {
	
	public int[] sortArray(int[] intArray) {
		//Same Reference will be sorted
		Arrays.parallelSort(intArray);
		return intArray;
	}
	public List<Integer> sortList(List<Integer> intList) {
		//Same Array will be sorted
		Collections.sort(intList);
		return intList;
	}
	public List<String> sortListElements(List<String> strList){
		Collections.sort(strList, (str1,str2)->{
			return str1.compareTo(str2);
		});
		return strList;
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	//Using Euclidean Algorithm
	/**
	 * If A = B*Q +R , A%B = R then GCD(A,B) = GCD(B,R)
PROOF:
D any common divisor of A,B
D divides A, D divides B then D divides A - BQ
A/D - BQ/D = integer
A-BQ = R, then D divides R
	E  common divisor of B and R
	E | B, E | R -> E | BQ + R then E | A
D is a common divisor of A and B if it's common divisor for B and R

	 */
	public int generalizedGCD(int num, int[] arr) {
		//Sort the input array ascending
	 	;
		int finalGCD = arr[0];

		for (int i = 1; i < num; i++) {
			finalGCD = GCD(arr[i], finalGCD);
		}
		return finalGCD;
	}

	public int  generalizedLeastCommonMultiply(int num, int[] arr) {
		return generalizedGCD(num, arr);
	}
	/*
	 * this recursive method is to find the GCD between two numbers
	 */
	public int GCD(int x, int y) {
		// If any parameter is zero, then return the otherone
		if (x == 0) {
			return y;
		}
		
		return GCD(y % x, x);
	}
	// METHOD SIGNATURE ENDS
	public static void main(String[] args) {
		int[] input1 = {21,9,12};
		GreatestCommonDividor d = new GreatestCommonDividor();
		System.out.println(d.generalizedGCD(3, input1));
	}
}