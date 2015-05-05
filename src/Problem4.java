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
				//String num = String.valueOf(product);
				palindrome = checkPalindrome(product);
				
				if (palindrome == true && product>largestP){
					largestP = product;
				}
			}
		}
		
//		for(int x=100; x<=999; x++) {
//			for(int y=100; y<=999; y++) {
//				product = x*y;
//				palindrome = newPalindromeCheck(product);
//				if (palindrome == true) {
//					System.out.println("product: " + product);
//				}
//				
//				if (palindrome == true && product>largestP){
//					largestP = product;
//				}
//			}
//		}
		
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
	
	public static boolean newPalindromeCheck(int number) {
		String num = String.valueOf(number);
		
		if(num.length() == 0 || num.length() == 1) {
			return true;
		}
		
		String s1 = num.substring(0, 0);
		String sn = num.substring(num.length()-1);
		
		if(s1.equals(sn)) {
			int newNum = Integer.parseInt(num.substring(1,num.length()-2));
			return newPalindromeCheck(newNum);
		} else {
			return false;
		}
	}
	
}
