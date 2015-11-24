/* Project Euler Problem 8: Largest Product In a Series
 * Finds the largest product of n consecutive numbers in a given series .
 */
import java.util.*;
import java.io.*;

public class Problem8 {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(System.getProperty("user.dir"));
		int numOfConseqFac = 13;
		long answer;
		String file = new String("Problem8num.txt");
		Scanner scanner;
		
		//try to make scanner
		try {
			scanner = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		
		String num = scanner.next();
		
		answer = greatestProduct(numOfConseqFac, num);
		
		System.out.printf("The answer is %d.", answer);
		scanner.close();
	}
	
	public static long greatestProduct(int numOfFactors, String num) {
		long product = 1;
		long maxProd = 1;
		int iterator = 0;
		int count = 0;
		ArrayList<Integer> arraylist = new ArrayList<Integer>();	
		
		//place each individual number into the arraylist
		for(int x=0; x<num.length(); x++) {
			
			int temp = Integer.parseInt(num.substring(x, x+1));
			arraylist.add(temp);
		}
		

		while(iterator < arraylist.size()) {
			
			while(count < numOfFactors && iterator < arraylist.size()) {
				
				if(arraylist.get(iterator) == 0) {
					iterator++; 
					count = 0;
					product = 1;
				} else {
					product *= arraylist.get(iterator);
					count++;
					iterator++;
				}
			}
			System.out.printf("The new product is %d.\n", product);
			
			if(product > maxProd) {
				maxProd = product;
				System.out.printf("The max product is %d.\n", maxProd);
			}
			
			product = 1;
			count = 0;
			
			//reset back to the second integer for the next set of factors
			if(iterator < arraylist.size()-numOfFactors){
				iterator-=(numOfFactors-1);
			} else {
				break;
			}
		}
		
		return maxProd;
	}
}
