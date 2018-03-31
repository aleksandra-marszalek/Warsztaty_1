package lotto_game;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Lotto_game {
	
	public static void main(String[] args) {
		
		lotto();
		
	}
	static void lotto() {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		//it's needed to change the type from int to object type Integer to use the Lists (---> line 35)
		Integer[] chosenNumbers = new Integer[6];
		Integer[] lottoNumbers = new Integer[6];
		int i=0;
		
		//I build the while loop to build chosenNumbers array with numbers chosen by user, 
		//then check if the number is in the range 1-49
		//Try catch - to throw exception if the input is not a number
		
		try {
			while (i != 6) {
				try {
				System.out.println("Podaj liczbę: ");
				
				int number = Integer.parseInt(scan.nextLine());
				
				if (number <= 49 && number >=1) {
			
		/*
		 * I create a list of Integers from the array;
		 * I check if in the list already is present the number given by user;
		 * if so --> you need to go back to the beginning and choose another one 			
		 */
					
					List<Integer> tmpList = Arrays.asList(chosenNumbers);
						if (tmpList.contains(number) == false) {
							chosenNumbers[i] = number;
							i++;
						} else {
							System.out.println("Ta już była! Wybierz inną.");
						}
				} else {
					System.out.println("Musi być z zakresu 1-49!");
				}
				} catch (NumberFormatException e) {
					System.out.println("Zły format!" + e.getMessage());
				}
			}
			
			/*
			 * As above - I create a list of Integers from the array;
			 * I check if in the list already is present the number chosen by random by computer
			 * if so --> you need to go back to the beginning and choose another one 			
			 */
			
			i = 0;
			while (i != 6) {
				int  n = rand.nextInt(49) + 1;
				List<Integer> tmpList2 = Arrays.asList(lottoNumbers);
				if (tmpList2.contains(n) == false) {
					lottoNumbers[i] = n;
					i++;
				}
			}
			
			// Sort arrays
			Arrays.sort(chosenNumbers);
			Arrays.sort(lottoNumbers);
			
			
			// Count how many numbers are present in both arrays
			int counter = 0;
			for (int j=0; j<chosenNumbers.length; j ++) {
				for (int k=0; k<lottoNumbers.length; k++) {
					if (chosenNumbers[j].equals( lottoNumbers[k]) ) {
						counter++;
					}
				}
			}
			
			// Show the results; with adequate comment - if less than 3 numbers are in both arrays - you lose.
			
			System.out.println("Twoje liczby to: " + Arrays.toString(chosenNumbers));
			System.out.println("Liczby, które dziś wygrały to: " + Arrays.toString(lottoNumbers));
			if (counter < 3) {
				System.out.println("Przegrałeś!");
			} else if (counter ==3) {
				System.out.println("Trafiłeś trójkę!");
			} else if (counter ==4) {
				System.out.println("Trafiłeś czwórkę!");
			} else if (counter ==5) {
				System.out.println("Trafiłeś piątkę!");
			} else if (counter ==6) {
				System.out.println("Trafiłeś szóstkę!");
			}
			scan.close();
			
		} catch (Exception e) {
			System.out.println("Error!" + e.getMessage());
		}
		
	}

}

