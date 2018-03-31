package rolling_dice;

import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Rolling_dice {

	public static void main(String[] args) {
		try {
			diceRoll();
		} catch (NumberFormatException e) {
			System.out.println("Zły format! Spróbuj ponownie później.");
		} catch (InterruptedException e) {
			System.out.println("Error! " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
	/*
	 * 2D10+12 
	 * xDy+z
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	
	static void diceRoll() throws InterruptedException {
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj liczbę:\nxD+y+z\n" + 
				"gdzie:\n" + 
				"x – liczba rzutów kośćmi\n" +
				"y – rodzaj kostek, których należy użyć\n" + 
				"z – (opcjonalnie) liczba, którą należy dodać (lub odjąć) do wyniku rzutów.");
		
		
		String userInput = (scan.nextLine());
		int rollNumber = 1;
		int diceType = 0;
		int additionalNumber = 0;
		// Model is xDy+z - we need to find out what are the amounts for each argument: x(rollNumber), y(diceType), z(additionalNumber)
		
		//At first I try to split the user Input by D - to have the roll Number: 
		//if the content before the D is empty - there is no rollNumber input, so the rollNumber should be 1 by default
		String[] x = userInput.split("D");
		if (x[0].contentEquals("")) {
			rollNumber = 1;
			
		// then with another if statement, I check if there is a "+", a "-" or nothing
		// if there is a "+" - I split again by plus and the values are diceType(y[0] - first value) and additionalNumber(y[1] - second value)
		// analogically for "-"
		// if there is no "+" nor "-" ---> there is no additional number and the remaining str is our diceType
			
			if (StringUtils.containsAny(x[1], "\\+") == true) {
				String[] y = x[1].split("\\+");
				diceType = Integer.parseInt( y[0] );
				additionalNumber = Integer.parseInt( y[1] );
			} else if (StringUtils.containsAny(x[1], "\\-") == true) {
				String[] y = x[1].split("\\-");
				diceType = Integer.parseInt( y[0] );
				additionalNumber = -(Integer.parseInt(y[1]));
			} else {
				diceType = Integer.parseInt( x[1] );
				additionalNumber = 0;
			}
		
		//analogically I do the same as above for another option ---> this time for the situation where there is a value before D,
		// so this first value is rollNumber, and the rest as above
			
		} else {
			rollNumber = Integer.parseInt( x[0] );
			x[1] = (x[1].trim());
			if (StringUtils.containsAny(x[1], "\\+") == true) {
				String[] y = x[1].split("\\+");
				diceType = Integer.parseInt( y[0] );
				additionalNumber = Integer.parseInt( y[1] );
			} else if (StringUtils.containsAny(x[1], "\\-") == true) {
				String[] y = x[1].split("\\-");
				diceType = Integer.parseInt( y[0] );
				additionalNumber = - (Integer.parseInt( (y[1]) ));
			} else {
				diceType = Integer.parseInt( x[1] );
				additionalNumber = 0;
			}
		}
		// I check if the parameters are right:
		System.out.println("Liczba rzutów to: " + rollNumber + ". Rodzaj kostek to: " + diceType + ". Dodatkowy parametr to: " + additionalNumber);
		int result = 0;
		int oneRoll=0;
		Random rand = new Random();
		for (int i = 1; i<=rollNumber; i++) {
			oneRoll = rand.nextInt(diceType) + 1;
			result += oneRoll;
		}
		result+=additionalNumber;
		
		System.out.println("Uwaga, rzucam...");
		Thread.sleep(1500);
		System.out.println("Wynik Twojego rzutu to: " + result);
	}
	
	
	
	
	
}
