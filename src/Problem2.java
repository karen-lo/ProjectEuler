/* Project Euler Problem 2: Even Fibonacci Numbers
 * Finds the sum of all the even-numbered terms in the Fibonacci sequence.
 */

public class Problem2 {
	public static void main (String[] args){
		int sum = 2;
		int x = 1;
		int y = 2;
		int z;
		
		while (y < 4000000){
			z = x + y;
			
			x = y;
			y = z;
			
			if (z%2 == 0){
				sum = sum + z;
			}
		}
		
		System.out.println(sum);
	}
}
