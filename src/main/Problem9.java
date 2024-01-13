/* Project Euler Problem 9: Special Pythagorean Triplet 
 * Finds the one Pythagorean triplet where a+b+c=1000 and then returns the product of abc.
 * Karen Lo © 2015
 */

public class Problem9 {
	public static void main(String[] args) {
        int sum = 1000;
        System.out.println("Euclid: " + pyTripletProductEuclid(sum));
        System.out.println("Brute force: " + pyTripletProduct(sum));
    }

    /* a = 2mn, b = m^2 - n^2, c = m^2 + n^2 - where m > n
     * a + b + c = sum
     * 2mn + 2m^2 = sum
     */
    public static int pyTripletProductEuclid(int pyTripletSum) {
        for(int n=0; n<pyTripletSum-1; n++) {
            for(int m=n+1; m<pyTripletSum; m++) {
                if((2*m*n + 2*Math.pow((double)m, 2.0)) == pyTripletSum) {
                    int a = 2*m*n;
                    int b = (int)Math.pow((double)m, 2.0) - (int)Math.pow((double)n, 2.0);
                    int c = (int)Math.pow((double)m, 2.0) + (int)Math.pow((double)n, 2.0);
                    return a*b*c;
                }
            }
        }
        return 0;
    }

    public static int pyTripletProduct(int pyTripletSum) {
        for(int c=3; c < pyTripletSum; c++) {
            for(int b=2; b < c; b++) {
                for(int a=1; a < b; a++) {
                    if((a*a + b*b) == c*c && (a+b+c) == pyTripletSum) {
                        return a*b*c;
                    }
                }
            }
        }
        return 0;
    }
}
