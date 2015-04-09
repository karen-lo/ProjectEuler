/* Project Euler Problem 4: Largest Palindrome Product
 * Finds the largest palindrome product of two 3-digit numbers.
 */

public class Problem4 {
	public static void main(String[] args) {
		int x;
		int y;
		int product;
		boolean palindrome;
		int largestP = 0;

		for (x = 100; x <= 999; x++) {
			for (y = 100; y <= 999; y++) {
				product = x * y;
				palindrome = checkPalindrome(product);
				
				if (palindrome == true && product>largestP){
					largestP = product;
				}
			}
		}
		
		System.out.println(largestP);
	}

	public static boolean checkPalindrome(int number) {
		String stringNum = String.valueOf(number);
		
		for (int i = 0; i<(stringNum.length()/2); i++){
			if (stringNum.charAt(i) != stringNum.charAt(stringNum.length()-1-i)){
				return false;
			}
		}
		
		return true;
	}
}
