package guessing_numbers_game_2;


import java.util.Scanner;

public class Guessing_numbers_game_2 {

	
	public static void main(String[] args) {
		try {
	guessNumber();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
}


static void guessNumber() {
	
	/*
	 *  In this method the program uses algorithm and always chooses half of the range to guess a number --> 
	 *  if the number chosen before was too big, it is new max value; if number was too small, it is the new min value
	 *  the user needs to input the commands: mniej/wiecej/trafiles, to indicate what the program will do next.
	 *  
	 *  If the user not picks any of the commands suggested, the program will repeat asking until given the right command.
	 *  When given the command "trafiles" - it says: wygrałem and finish the loop and the program stops.
	 *  
	 *  As additional feature I added counter - to show how many moves does the computer require to win ;)
	 *  
	 */
	try {
		Scanner scan = new Scanner(System.in);
		System.out.println("Pomyśl liczbę od 0 do 1000, a ja ją zgadnę w max 10 próbach: ");
		int max = 1001;
		int min = 0;
		int computerGuess = (max+min)/2;
		String guess = "trafiles";
		String more = "mniej";
		String less = "wiecej";
		System.out.println("...");
		System.out.println("Zgaduję: "+ computerGuess +"\nWpisz: mniej/wiecej/trafiles: ");
		String clue = scan.nextLine();
		int counter = 1;
		while (!clue.equals(guess)) {

			if (clue.equals(more)) {
				max = computerGuess;
				counter ++; 
			} else if (clue.equals(less)) {
				min = computerGuess;
				counter ++; 
			} else {
				System.out.println("Nie oszukuj! \nMusisz podać prawidłową komendę: mniej/wiecej/trafiles!");
			}
			
			computerGuess = (max+min)/2;
			System.out.println("Zgaduję: " + computerGuess + "\nWpisz: mniej/wiecej/trafiles: ");
			clue = scan.nextLine();

		} 
		System.out.println("Wygrałem! Zajęło mi to: " + counter + " ruch/ów/y!");
	} catch (Exception e) {
		System.out.println("Error: "+e.getMessage());
	}
		
		
	}
		
}

