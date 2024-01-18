/* Project Euler Problem 8: Largest Product In a Series
 * Finds the largest product of n consecutive numbers in a given d-digit number .
 * Karen Lo © 2015
 */

import java.util.*;
import java.io.*;

public class Problem8 {
	public static void main(String[] args) throws FileNotFoundException {
	    String filename = "data/Problem8num.txt";
        int digit = 1000;
        int lengthOfSeries = 13;

	    String numS;
	    try {
	        Scanner scanner = new Scanner(new File(filename));
            numS = scanner.next();
        } catch (FileNotFoundException e) {
	        e.printStackTrace();
	        throw e;
        }

        int[] num = new int[digit];
        for(int i=0; i<numS.length(); i++) {
            num[i] = Character.getNumericValue(numS.charAt(i));
        }

        System.out.println(largestProdInSeries(num, lengthOfSeries));
    }

    public static long largestProdInSeries(int[] num, int lengthOfSeries) {
	    int front = lengthOfSeries - 1, back = 0;
	    long largestP = 0;

	    // find the first n numbers with no 0s
	    int pad = 0;
	    for(int i=0; i<lengthOfSeries; i++) {
	        if(num[i + pad] == 0) {
	            back += i;
	            front += i;
	            pad += i;
	            i = 0;
            }
        }

	    while(front <= num.length-1) {
            long newP = multList(back, front, num);
            if(newP > largestP) largestP = newP;

            if(num[++front] == 0) {
                pad = 0;
                while(pad < lengthOfSeries) {
                    if(front >= num.length-1) return largestP;
                    if(num[++front] == 0) {
                        pad = 0;
                    } else {
                        pad++;
                    }
                }
                back = front - (lengthOfSeries-1);
            } else {
                back++;
            }
        }
        return largestP;
    }

    public static long multList(int startIncl, int endIncl, int[] numlist) {
	    long product = 1;
	    for(int i=startIncl; i<= endIncl; i++) {
	        product *= numlist[i];
        }
        return product;
    }
}
