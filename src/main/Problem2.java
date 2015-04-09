/* Project Euler Problem 2: Even Fibonacci Numbers
 * Finds the sum of all the even-numbered terms in the Fibonacci sequence.
 * Karen Lo © 2015
 */

public class Problem2 {
	public static void main(String[] args) {
		int max = 4000000;
		System.out.println(evenFibSum(max));
	}

	public static int evenFibSum(int max) {
		int a = 1, b = 2, c, sum = 2;

		while((c = a + b) < max) {
			if(c%2 == 0) sum += c;
			a = b;
			b = c;
		}
		return sum;
	}
}
