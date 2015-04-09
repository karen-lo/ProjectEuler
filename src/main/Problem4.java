/* Project Euler Problem 4: Largest Palindrome Product
 * Finds the largest palindrome product of two 3-digit numbers.
 * Karen Lo © 2015
 */

public class Problem4 {
	public static void main(String[] args) {
        int numDigits = 3;
        System.out.println(maxProductPalindrome((double)numDigits));
    }

    public static int maxProductPalindrome(double numDigits) {
	    int biggestNum = (int)Math.pow(10.0, numDigits)-1;
	    int largestP = 0;

	    for(int a=biggestNum; a>0; a--) {
	        for(int b=biggestNum; b>0; b--) {
	            int p = a*b;
	            if(isPalindrome(p) && p > largestP) {
	                largestP = p;
                }
            }
        }
	    return largestP;
    }

    public static boolean isPalindrome(int num) {
	    String n = Integer.toString(num);
	    for(int i=0, j=n.length()-1; j > i; i++, j--) {
	        if(n.charAt(i) != n.charAt(j)) return false;
        }
        return true;
    }
}
