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
		
//		String stringNum = String.valueOf(number);
//		char first = stringNum.charAt(0);
//		char last = stringNum.charAt(stringNum.length());
//
//		if (first == last) {
//			char second = stringNum.charAt(1);
//			char secondToLast = stringNum.charAt(stringNum.length() - 1);
//
//			if (second == secondToLast) {
//				
//				if (stringNum.length() > 5) {
//					char third = stringNum.charAt(2);
//					char thirdToLast = stringNum.charAt(stringNum.length() - 2);
//
//					if (third == thirdToLast) {
//						return true;
//					} else {
//						return false;
//					}
//				}
//				
//				return true;
//			} else {
//				return false;
//			}
//		} else {
//			return false;
//		}
	}
}
