/* Project Euler Problem 9: Special Pythagorean Triplet 
 * Finds the one Pythagorean triplet where a+b+c=1000 and then returns the product of abc.
 */

public class Problem9 {
	public static void main(String[] args) {
		int sum = 1000;
		
		int product = pythTripletProd(sum);
		System.out.printf("The product is %d\n", product);
	}
	
	public static int pythTripletProd(int TSum) {
		
		for(int c=3; c<TSum; c++) {
			
			for(int b=2; b<c; b++) {
				
				for(int a=1; a<b; a++) {
					int squareA = a*a;
					int squareB = b*b;
					int squareC = c*c;
					
					//System.out.printf("C = %d\nB = %d\nA = %d\n", c, b, a);
					//System.out.printf("squareC = %d\nsquareB = %d\nsquareA = %d\n", squareC, squareB, squareA);
					
					if(squareA+squareB != squareC) {
						//System.out.printf("a^2 + b^2 != c^2\n");
						
					} else {
						int sum = a+b;
						sum += c;
						
						//System.out.printf("The sum of a, b, and c is %d\n", sum);
						
						if(sum == TSum) {
							System.out.printf("FOUND!\n");
							System.out.printf("C = %d\nB = %d\nA = %d\n", c, b, a);
							return a*b*c;
						} else {
							
						}
					}
				}
			}
		}
		
		System.out.printf("CANNOT FIND ANY PYTHAGOREAN TRIPLETS WITH THAT SUM!\n");
		return 0;
	}
}
