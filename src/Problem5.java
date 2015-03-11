/* Project Euler Problem 5: Smallest Multiple
 * Finds the smallest positive number evenly divisible by all the numbers from 1 to 20.
 */

public class Problem5 {
	public static void main (String[] args){
		int factorRange = 20;
		int[] factors = new int[factorRange];
		
	}
	
	public int[] findPrimes(int number){
		int[] primeFactors = new int[number];
		primeFactors[0] = 1;
		
		for (int i = 2, x = 1; i <= number; i++){
			while (number%i == 0){
				number = number/i;
			}
			for (prime )
			
			x++;
			primeFactors[x] = i;
		}
		
		
	}
}


/*int factor = 2;
int x = 1;

while (factor <= 20){
	if (x%factor == 0){
		factor++;
		System.out.println("x is " + x + ", factor is " + factor);
		if (factor == 20){
			System.out.println(x);
		}
	} else {
		x++;
		factor = 2;
	}
}*/