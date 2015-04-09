/* In Progress
 * Project Euler Problem 12: Highly Divisible Triangular Number
 * Finds first triangular number with over n divisors.
 * Karen Lo © 2018
 */

public class Problem12 {
    public static void main(String[] args) {
        int minDivisors = 500;
        System.out.println(triangleNumFinder(minDivisors));
    }

    public static int triangleNumFinder(int minDivisors) {
        int count = 1, triangleNum = 0, numDivisors = 0;

        while(numDivisors < minDivisors) {
            triangleNum += count;
            count++;

            if(Math.sqrt((double)triangleNum) > minDivisors/2) {
                numDivisors = findNumDivisors(triangleNum);
            }
        }
        return  triangleNum;
    }

    public static int findNumDivisors(int num) {
        int maxDivisor = (int) Math.sqrt((double) num);
        int numDivisors = 0;

        while(maxDivisor > 0) {
            if(num % maxDivisor == 0) numDivisors += 2;
            maxDivisor--;
        }
        return  numDivisors;
    }
}
