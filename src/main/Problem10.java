/* Project Euler Problem 10: Summation of Primes
 * Finds the sum of all the primes below two million.
 * Karen Lo © 2015
 */

import java.util.Arrays;

public class Problem10 {
    public static void main(String[] args) {
        int max = 2000000;
        System.out.println(sumPrimeBelowX(max));
    }

    // Sieve of Eratosthenes
    public static long sumPrimeBelowX(int x) {
        long sum = 0;
        int[] primeList = new int[x];
        Arrays.fill(primeList, 1);

        int prime = 2;
        while(prime < primeList.length) {
            for (int index = prime+prime; index < primeList.length; index += prime) {
                primeList[index] = 0;
            }

            while(++prime < primeList.length && primeList[prime] == 0);
        }

        for(int i=2; i<primeList.length; i++) {
            if(primeList[i] == 1) sum += i;
        }

        return sum;
    }
}
