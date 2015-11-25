import java.util.ArrayList;

/* In progress...
 * Project Euler Problem 10: Summation of Primes 
 * Finds the sum of all the primes below two million.
 */

public class Problem10 {
	public static void main(String[] args) {
		int index = 2000000;
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes = findPrime(index);
		
		long sum = findSum(primes);
		
		System.out.printf("The sum is %d\n.", sum);
		
	}
	
	public static ArrayList<Integer> findPrime(int index) {
		int origNum = 5;
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);
			
		while(primes.size() <= index) { //while arraylist is less than index
			int num = origNum;
			int iterator = 1;
			
			while(iterator<primes.size()) { //while iterator is less than arraylist size
				while(num%primes.get(iterator) == 0) { //goes through arraylist of primes to find factor, then divides until not divisible anymore
					num = num/primes.get(iterator);
				}
				if(num%primes.get(iterator) != 0) { //if not divisible by iterator, move on
					iterator++;
				} 

			} //You have now stripped the number of all its factors
			
			if(num != 1) { //if number does not equal to 1, its a prime
				primes.add(origNum);
			}
			origNum+=2; //skips the even numbers
		}
		
		return primes;
	}
	
	public static long findSum(ArrayList<Integer> primes) {
		int sum = 0;
		
		for(int i=0; i<primes.size(); i++) {
			int val = primes.get(i);
			sum += val;
		}
		
		return sum;
	}
}
