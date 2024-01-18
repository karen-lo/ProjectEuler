/* Project Euler Problem 6: Sum Square Difference
 * Finds the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * Karen Lo © 2015
 */

import java.util.stream.IntStream;

public class Problem6 {
	public static void main(String[] args) {
		int[] firstXNatNum = IntStream.rangeClosed(1, 100).toArray();
		int diff = Math.abs((sumOfSquares(firstXNatNum) - squareOfSum(firstXNatNum)));
		System.out.println(diff);
	}

	public static int sumOfSquares(int[] numList) {
		int sum = 0;
		for(int i=0; i<numList.length; i++) {
			sum += (numList[i]*numList[i]);
		}
		return sum;
	}

	public static int squareOfSum(int[] numList) {
		int sum = 0;
		for(int i=0; i<numList.length; i++) {
			sum += numList[i];
		}
		return sum*sum;
	}
}
