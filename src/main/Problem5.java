/* Project Euler Problem 5: Smallest Multiple
 * Finds the smallest positive number evenly divisible by numbers 1-20.
 *
 * Notice that some factors can be evenly divided by other factors in the list, a redundancy.
 * Find the list of prime numbers amongst the factors.
 * Also notice that even though a number is evenly divisible by 2, it may not be evenly divisible by 4.
 * But a number evenly divisible by 4 will be evenly divisible by 2.
 * Karen Lo © 2015
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.IntStream;

public class Problem5 {
    public static void main(String[] args) {
        int[] factorList = IntStream.rangeClosed(1, 20).toArray();
        ArrayList<Integer> uniqueFactors = findUniqueFactors(factorList);
        System.out.println("List of unique factors: " + uniqueFactors.toString());
        System.out.println(multList(uniqueFactors));
    }

    public static ArrayList<Integer> findUniqueFactors(int[] factors) {
        ArrayList<Integer> newFactors = new ArrayList<Integer>();
        boolean add = true;

        for(int i=0; i < factors.length; i++) {
            Iterator<Integer> iterator = newFactors.iterator();
            while(iterator.hasNext()) {
                int newFactor = iterator.next();

                if(factors[i]%newFactor == 0) {
                    if (isPowerOfX(newFactor, factors[i])) {
                        newFactors.remove(newFactors.indexOf(newFactor));
                        break;
                    } else {
                        add = false;
                        break;
                    }
                }
            }

            if(add == true) {
                newFactors.add(factors[i]);
            } else {
                add = true;
            }
        }
        return newFactors;
    }

    public static boolean isPowerOfX(int x, int num) {
        if(x == 0 || num == 0) return false;
        if(x == 1) return true;

        while(num%x == 0) {
            num = num/x;
        }
        if(num > 1) return false;
        else return true;
    }

    public static int multList(ArrayList<Integer> list) {
        int product = 1;
        for (Integer i : list) {
            product *= i;
        }
        return product;
    }
}

