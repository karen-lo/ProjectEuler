/* In progress...
 * Project Euler Problem 8: Largest Product In a Series
 * Finds the largest product of n consecutive numbers in a given series .
 */
import java.util.*;
import java.io.*;

public class Problem8 {
	public static void main(String[] args) {
		int numOfConseqFac = 4;
		File file = new File("Problem8num.txt");

		
	}
	
	public static int greatestProduct(File file, int numOfFactors) throws FileNotFoundException {
		int product = 1;
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		Scanner scanner;
		
		try {
			scanner = new Scanner(new File("Problem8num.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(scanner.hasNextInt()) {
			arraylist.add(scanner.nextInt());
		}
		
		
	}
}
