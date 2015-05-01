/* Project Euler Problem 6: Sum Square Difference
 * Finds the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */

public class Problem6 {
	public static void main(String[] args) {
		int num = 100;
		double[] naturalNums = new double[num];
		
		for(int i=0, j=1; i<naturalNums.length; i++, j++) {
			naturalNums[i] = j;
		}
		
		int totalSum = sumOfSquares(naturalNums);
		int totalSq = squareOfSum(naturalNums);
		
		System.out.println("Difference: " + (totalSq-totalSum));
	}
	
	public static int sumOfSquares(double[] nums) {
		int sum = 0;
		
		for(int i=0; i<nums.length; i++) {
			int sq = (int)Math.pow(nums[i], 2);
			sum = sum + sq;
		}
		
		return sum;
	}
	
	public static int squareOfSum(double[] nums) {
		double sum = 0;
		
		for(int i=0; i<nums.length; i++) {
			sum = sum + nums[i];
		}
		
		return (int)Math.pow(sum, 2);
	}
}
