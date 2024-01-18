/* Project Euler Problem 3: Largest Prime Factor
 * Finds the largest prime factor of the 600851475143.
 * Karen Lo © 2015
 */
public class Problem3 {
	public static void main(String[] args) {
		long num = 600851475143L;
		System.out.println(largestPrimeFactor(num));
	}

	public static long largestPrimeFactor(long num) {
		long largestPFactor = 0;

		for(long factor=2; factor <= num; factor++) {
			while(num%factor == 0) {
				largestPFactor = factor;
				num /= factor;
			}
		}
		return largestPFactor;
	}
}
