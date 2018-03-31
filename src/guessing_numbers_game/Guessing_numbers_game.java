package guessing_numbers_game;

import java.util.Random;
import java.util.Scanner;

public class Guessing_numbers_game {

	public static void main(String[] args) {
    		try {
		guessNumber();
    		}catch (Exception e) {
				System.out.println(e.getMessage());
			}
    }
	

    static void guessNumber() {
    	
    	// Use scanner to take input from the user and random to take number from the program
    	
    		Scanner scan = new Scanner(System.in);
    		Random rand = new Random();
    		int  n = rand.nextInt(101) + 1;
    		System.out.println("Zgadnij liczbę: ");
		
    	// While keeps user inputing new integers until there is a guess; in if there is condition
    	// If there is a guess, return finishes the program
    		
		while(scan.hasNext()) {
    		try {
    	// In try - catch: if the number cannot be parsed into Integer - throws exception
    			int number = Integer.parseInt(scan.nextLine());
    			if (number < n) {
    				System.out.println("Za mało!");
    			} else if (number > n) {
    				System.out.println("Za dużo!");
    			} else {
    				System.out.println("Zgadłeś!");
    			}
    			} catch (Exception e) {
    			// if couldn't parsed
    				System.out.println("To nie jest liczba! Wprowadź liczbę: ");
			}scan.close();
		}
			
    }
    
}
