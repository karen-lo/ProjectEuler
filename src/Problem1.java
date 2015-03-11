/* Project Euler Problem 1: Multiples of 3 and 5
 * Finds the sum of all the multiples of 3 or 5 below 1000.
 */

public class Problem1 {
	public static void main (String[] args){
		int sum = 0;
		
		for (int i = 1; i<1000; i++){
			if (i%3 == 0){
				sum = i + sum;
			} else if (i%5 == 0){
				sum = i + sum;
			}
		}
		System.out.println(sum);
	}

}
