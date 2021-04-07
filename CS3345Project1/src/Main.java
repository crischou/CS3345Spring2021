//Cris Chou
//CyC180001

import java.util.*;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int num;
		System.out.print("Enter a number greater than 1: "); //ask user for input
		num = input.nextInt();
		
		while(!(num > 1)) { //make sure valid input
			
			System.out.print("Enter a number greater than 1: ");
			num = input.nextInt();
			
		}
		
		SOfE(num); //run algorithim
		

	}
	
	public static void SOfE(int n) { //method for Sieve of Erotosthenes
		
		Boolean numList[] = new Boolean [n + 1]; //make array size n+1
		
		for(int i = 0 ; i < n; i ++) { //setting all values of numList to true
			
			numList[i] = true;
			
		}
		
		for(int i =2; i < Math.sqrt((double) n ) ; i++) { //while i is less than square root of n from 2
			
			if(numList[i] == true) { 
				
				for(int j = (i*i) ; j < n ; j = j + i) { //make the multiples false if true
					
					numList[j] = false;
					
				}
			}
			
		}
		
		for(int i = 2; i < n; i++ ) { //print primes
			
			if(numList[i] == true) {
				
				System.out.println(i);
			}
		}
		
	}

}
