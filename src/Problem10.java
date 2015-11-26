import java.util.ArrayList;
import java.math.BigInteger;;

/* In progress...
 * Project Euler Problem 10: Summation of Primes 
 * Finds the sum of all the primes below two million.
 */

public class Problem10 {
	public static void main(String[] args) {
		int index = 2000000;
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes = findPrime(index);
		
		System.out.printf("The array has %d elements.\n", primes.size());
		
		BigInteger sum = BigInteger.valueOf(0);
		sum = findSum(primes);
		
		System.out.printf("The sum is %d.\n", sum);
		
	}
	
	public static ArrayList<Integer> findPrime(int index) {
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for(int i=2; i<index; i++) {
			//System.out.printf("i: %d\n", i);
			primes.add(i);
		}
		
		System.out.printf("The array has %d elements.\n", primes.size());
		
		int j=0;
		for(int i=1; i<primes.size(); i++) {
			int factor = primes.get(j);
			
			if(primes.get(i)%factor == 0) {
				primes.remove(i);
				i--;
			}
			
			if(i == primes.size()-1) {
				j++;
				i=j;
			}
			//System.out.printf("factor: %d\n", factor);
			
//			for(int j=i+1; j<primes.size(); j++) {
//				//System.out.printf("The element is %d\n", primes.get(j));
//				
//				if(primes.get(j)%factor == 0) {
//					
//					primes.remove(j);
//					j--; //so that it does not skip over the next element
//					//System.out.printf("The array has %d elements.\n", primes.size());
//				}
//			}
			//System.out.printf("The array has %d elements.\n", primes.size());
		}
		
		System.out.println("DONE!");
		
		return primes;
		
		
//		int origNum = 5;
//		
//		ArrayList<Integer> primes = new ArrayList<Integer>();
//		primes.add(2);
//		primes.add(3);
//			
//		while(origNum < index) { //while arraylist is less than index
//			int num = origNum;
//			int iterator = 1;
//			
//			while(iterator<primes.size()) { //while iterator is less than arraylist size
//				while(num%primes.get(iterator) == 0) { //goes through arraylist of primes to find factor, then divides until not divisible anymore
//					num = num/primes.get(iterator);
//				}
//				if(num%primes.get(iterator) != 0) { //if not divisible by iterator, move on
//					iterator++;
//				} 
//
//			} //You have now stripped the number of all its factors
//			
//			if(num != 1) { //if number does not equal to 1, its a prime
//				primes.add(origNum);
//				//System.out.printf("New prime added: %d\n", num);
//			}
//			origNum+=2; //skips the even numbers
//		}
//		
//		return primes;
	}
	
	public static BigInteger findSum(ArrayList<Integer> primes) {
		BigInteger sum = BigInteger.valueOf(0);
		
		for(int i=0; i<primes.size(); i++) {
			int val = primes.get(i);
			sum = sum.add(BigInteger.valueOf(val));
			//System.out.printf("The element is %d\n", val);
		}
		
		return sum;
	}
}
