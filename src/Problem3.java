/* Project Euler Problem 3: Largest Prime Factor
 * Finds the largest prime factor of the 600851475143.
 */

public class Problem3 {
	static long number = 600851475143L;

	public static void main (String[] args){
		long largestPFactor = 0;
		
		for (long factor = 2; factor <= number; factor++){
			while(number%factor == 0) {
				largestPFactor = factor;
				number = number/factor;
			}
		}
		System.out.println(largestPFactor);
	}

}