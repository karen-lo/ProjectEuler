/* Project Euler Problem 1: Multiples of 3 and 5
 * Finds the sum of all the multiples of 3 or 5 below 1000.
 * Karen Lo © 2015
 */

public class Problem1 {
	public static void main(String[] args) {
		int factors[] = {3, 5};
		int max = 1000;
		System.out.println(sumMultiples(max, factors));
	}

	public static int sumMultiples(int max, int[] factors) {
		int sum = 0;

		for(int i=1; i<max; i++) {
			for(int x : factors) {
				if(i%x == 0) {
				    sum += i;
				    break;
                }
            }
		}

		return sum;
	}
}
