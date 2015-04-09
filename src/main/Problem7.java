/* Project Euler Problem 7: 10001st Prime
 * Finds the 10001st prime number.
 * Karen Lo © 2015
 */

import java.util.ArrayList;

public class Problem7 {
    public static void main(String[] args) {
        int n = 10001;
        System.out.println("nth prime: " + findNthPrime(n));
    }

    public static int findNthPrime(int n) {
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        int num = 2;
        primeList.add(num);
        boolean prime = true;

        while(primeList.size() < n) {
            int firstHalfFactors = (int) Math.ceil(Math.sqrt((double) num));

            int i = 0;
            while(primeList.size() > i && primeList.get(i) <= firstHalfFactors) {
                int factor = primeList.get(i);
                if (num % factor == 0) {
                    prime = false;
                    break;
                }
                i++;
            }

            if (prime) primeList.add(num);
            else prime = true;
            num++;
        }
//        System.out.println(primeList.toString());
        return num-1;
   }
}
