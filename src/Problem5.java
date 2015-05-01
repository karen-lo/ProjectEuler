/* Project Euler Problem 5: Smallest Multiple
 * Finds the smallest positive number evenly divisible by numbers 1-20.
 */

import java.util.*;

public class Problem5 {
	public static void main (String[] args) {
		int factorRange = 20;
		ArrayList<Integer> factors = new ArrayList<Integer>();
		int answer;
		
		System.out.println("Factors are:");
		for (int i=0; i<factorRange; i++) {
			factors.add(i+1);
			System.out.println(i+1);
		}
		
		ArrayList<Integer> newFactors = primeFactorization(factors);
		
		System.out.println("Prime Factors are:");
		for (int i=0; i<newFactors.size(); i++) {
			System.out.println(newFactors.get(i));
		}
		
		answer = multiply(newFactors);
		
		System.out.println("Answer:" + answer);
	}
	
	
	/*Finds all prime factors*/
	public static ArrayList<Integer> primeFactorization(ArrayList<Integer> factors) {
		ArrayList<Integer> newFac = new ArrayList<Integer>();
		
		/*base cases for arrays of size 1, 2, 3 to save time*/
		if(factors.size() >= 1) {
			newFac.add(1);
		}
		
		if(factors.size() >= 2) {
			newFac.add(2);
		}
		
		if(factors.size() >= 3) {
			newFac.add(3);
		}
		
		if(factors.size()>3) {
			/*if size is bigger than 3*/
			
			for(int i=3; i<factors.size(); i++) {
				/*loops through all the factors*/
				ArrayList<Integer> tempFac = new ArrayList<Integer>(newFac);
				int fac = factors.get(i);
				int origFac = fac;
				//System.out.println("factor before for loops: " + fac);
				
				for(int j=tempFac.size()-1; j>0; j--) {
					/*j>0 because dont need to check 1*/
					/*loops through a copy of all the factors currently in newFac*/
					
					if(fac%tempFac.get(j) == 0) {
						/*if evenly divisble, divide, and remove the factor from the list*/
						fac = fac/tempFac.get(j);
						//System.out.println("factor: " + fac);
						tempFac.remove(j);
					} 	
				}
				
				if(fac != 1) {
					/*if there is a remainder*/
					
					if(newFac.contains(fac)) {
						/*if the remainder was in the list of newFac, add the remainder*/
						newFac.add(fac);
						//System.out.println("added exponent: " + fac);
					} else {
						/*if the remainder was not on the list, then add the original fac variable to the list*/
						newFac.add(origFac);
						//System.out.println("added: " + origFac);
					}
				}
			}
		}
		return newFac;
	}
	
	/*multiplies a list of numbers*/
	public static int multiply(ArrayList<Integer> factors) {
		int multiple = 1;
		
		for(int i=1; i<factors.size(); i++) {
			//System.out.println(multiple + "*" + factors.get(i));
			multiple = multiple*factors.get(i);
		}
		
		return multiple;
	}
	
	
	
/*	wrong implementation
 * //filters list of factors for primes
		public static void findPrimes(ArrayList<Integer> factors){
			ArrayList<Integer> repeats = new ArrayList<Integer>();

			//if 20 evenly divisible
			for(int i=1; i<factors.size()-1; i++) {
			
				System.out.println("i: " + factors.get(i));
				
				for(int j=i+1; j<factors.size(); j++) {
					
					System.out.println(factors.get(j));
					
					if(factors.get(j)%factors.get(i) == 0) {
						repeats.add(factors.get(j));
						System.out.println("j: " + j + " factor: " + factors.get(j));
					}
				}
				
				for(int k=0; k<repeats.size()-1; k++) {
					System.out.println(repeats.get(k));
				}
				
				
				for(int x=0; x<repeats.size()-1; x++) {
					int repeat = repeats.get(x);
					System.out.println("repeated factor: " + repeat);
					factors.remove(new Integer(repeat));
					//size keeps changing
					System.out.println("removed factor " + repeat);
				}
			}
		}
	*/
}

