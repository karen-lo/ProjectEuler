/* In progress...
 * Project Euler Problem 8: Largest Product In a Series
 * Finds the largest product of n consecutive numbers in a given series .
 */
import java.util.*;
import java.io.*;

public class Problem8 {
	public static void main(String[] args) {
		int numOfConseqFac = 4;
		int answer;
		String file = new String("Problem8num.txt");

		answer = greatestProduct(file, numOfConseqFac);
		System.out.println(answer);
	}
	
	public static int greatestProduct(String file, int numOfFactors) throws FileNotFoundException {
		int product = 1;
		int maxProd = 1;
		int iterator = 0;
		int count = 0;
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		Scanner scanner;
		
		try {
			scanner = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		
		while(scanner.hasNextInt()) {
			arraylist.add(scanner.nextInt());
		}

		while(iterator < arraylist.size()) {
			while(count<numOfFactors) {
				if(arraylist.get(iterator) == 0) {
					iterator++; 
					count = 0;
					product = 1;
				} else {
					product = product*arraylist.get(iterator);
					count++;
					iterator++;
				}
			}
			
			if(product > maxProd) {
				maxProd = product;
			}
			
			product = 1;
			iterator-=(numOfFactors-(numOfFactors-2));
		}
		
		return maxProd;
	}
}
