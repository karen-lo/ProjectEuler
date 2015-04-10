import java.util.*;
/* In progress...
 * Project Euler Proble5: Smallest Multiple
 * Finds the smallest positive number evenly divisible by numbers 1-20.
 */

public class Problem5 {
	public static void main (String[] args){
		int factorRange = 20;
		int[] factors = new int[factorRange];
		int answer;
		
		for (int i=0, j=1; i<factors.length; i++, j++) {
			factors[i] = j;
		}
		
		ArrayList<Integer> revisedFactors = new ArrayList<Integer>(findPrimes(factors));
		answer = multiple(revisedFactors);
		System.out.println("Asnwer: " + answer);
	}
	
	//filters list of factors for primes
	public static ArrayList<Integer> findPrimes(int[] factors){
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		int maxFac = factors[factors.length-1];
		System.out.println(maxFac);
		primeFactors.add(1);
		
		
		for (int i=2; i <= factors[factors.length-1]; i++){
			int length = primeFactors.size(); //bads
			
			for (int j=0; j<length; i++) {
				
				if (primeFactors.get(j)%i != 0) {
					primeFactors.add(i);
					System.out.println(i);
				}
				
			}
			
//			Integer x = new Integer(i);
//			if (!primeFactors.contains(x)) {
//				//if divisible by any of the current list
//				if()
//			} 
//			
//			if (maxFac%i == 0) { //if divisible, keep dividing
//				primeFactors.add(i);
//				maxFac = maxFac/i;
//				System.out.println(maxFac);
//			}
//			if (maxFac%i != 0) { //if not divisible, add to factor list
//				primeFactors.add(i);
//				System.out.println(i);
//			}
		}
		
		for (int i=0; i<primeFactors.size(); i++) {
			System.out.println("list" + i + ": " + primeFactors.get(i));
		}
		
		return primeFactors;	
	}
	
	//finds the smallest multiple divisible by list of prime factors
	public static int multiple(ArrayList<Integer> factors) {
		int num = 1;
		
		for(int i=0; i<factors.size(); i++) {
			while (num%factors.get(i) != 0) {
				num++;
			}
		}
		
		return num;
	}
	
}
