
/*
 * Aditya Yadav
 * Today's date
 * Current version
 * Description: this program 
 * import java.util
 * create and initialize dealer variable for dealer card total
 * create and initialize player variable for player card total
 * create random variable
 * create a scanner
 * create and initialize variable for card
 * create and initialize variable for total card value
 * create and initialize variable for value of ace
 * make string for choiceTurn(should turn keep running) and choiceGame(should game keep running)
 * create and initialize variable for number of playerWins
 * boolean for i (allows for turn to loop)
 * boolean for x (allows for game to loop)
 * run all the stuff in main 
 * create method for Instruction
 * create method for drawing card
 * create second method for drawing card 
 * get card for user
 * get card for dealer
 * keep getting cards for dealer until they have 17
 * ask user if they want to draw another card
 * find out who the winner is by checking all conditions
 * if player wins, increment amount won by 1
 * loop program
 */
import java.util.*;

public class Assignment2 {
	// create variables
	static int dealer = 0;
	static int player = 0;
	static Random random = new Random();
	static Scanner sc = new Scanner(System.in);
	static int card = 0;
	static int total = 0;
	static int ace = 0;
	static String choiceTurn, choiceGame;
	static int playerWin = 0;
	static boolean i = true;
	static boolean x = true;

	public static void main(String[] args) {
		while (x) {
			// display methods
			displayInstructions();
			determineWinner();
			// loop if user wants to play again
			System.out.println("Do you want to play again (yes or no)? ");
			choiceGame = sc.next();
			if (choiceGame.equalsIgnoreCase("no")) {
				System.out.println("You have " + playerWin + " wins.");
				x = false;
				System.exit(0);
			}
		}
	}
	// this method displays instructions
	public static void displayInstructions() {
		System.out.println("First, the dealer and player each gets two cards.");
		System.out.println(
				"The goal of the game is to get as close, or equal, to 21 as possible without going over. Whoever is closest to 21 is the winner. If anyone goes over"
						+ " 21, "
						+ "they automatically lose. After the first two cards are drawn, you may decide whether \nor not to draw again. Aces may either be 1 or 11. Good luck!");
	}
	// this method draws card for user
	public static void drawCard() {
		// create random card between 1 and 13
		card = random.nextInt(13) + 1;
		switch (card) {
		// create cases for Ace, Jack, Queen, King, 
		case 1:
			System.out.println(" Ace");
			System.out.println("Would you like Ace to be counted as 1 or 11: ");
			ace = sc.nextInt();
			if (ace == 1) {
				total = total + 1;
			} else if (ace == 11) {
				total = total + 11;
			}
			break;
		case 11:
			System.out.println("Jack");
			total = total + 10;
			break;
		case 12:
			System.out.println("Queen");
			total = total + 10;
			break;
		case 13:
			System.out.println("King");
			total = total + 10;
			break;
		default:
			System.out.println(card);
			total = total + card;
			break;
		}

	}
	// this method is only used for when dealer is less than 17
	public static void drawCard2() {
		card = random.nextInt(13) + 1;
		switch (card) {
		case 1:
			System.out.println("Would you like Ace to be counted as 1 or 11: ");
			ace = sc.nextInt();
			if (ace == 1) {
				total = total + 1;
			} else if (ace == 11) {
				total = total + 11;
			}
			break;
		case 11:
			total = total + 10;
			break;
		case 12:
			total = total + 10;
			break;
		case 13:
			total = total + 10;
			break;
		default:
			total = total + card;
			break;

		}

	}
	// find out who the winner is 
	public static void determineWinner() {

		System.out.println("Player draws two cards: ");
		System.out.print("Draw 1: ");
		drawCard();
		player = total;
		System.out.print("Draw 2: ");
		drawCard();
		player = total;
		System.out.println(" ");
		total = 0;
		System.out.println("Dealer draws two cards: ");
		System.out.print("Draw 1: ");
		drawCard();
		dealer = total;
		System.out.print("Draw 2: ");
		drawCard();
		dealer = total;
		while (dealer < 17) {
			drawCard2();
			dealer = total;
		}
		total = 0;

		// Check to see who won
		i = true;
		while (i) {
			System.out.println("Would you like to draw another card (yes or no)? ");
			choiceTurn = sc.next();
			if (choiceTurn.equalsIgnoreCase("yes")) {
				System.out.print("You drew a ");
				drawCard();
				player = player + total;
				total = 0;
			} else if (choiceTurn.equalsIgnoreCase("no")) {
				i = false;
			}
		}
		System.out.println("Your total is: " + player);
		System.out.println("The dealer's total is: " + dealer);
		if (dealer == 21 && player == 21 || dealer > 21 && player > 21 || dealer == player)
			System.out.println("This was a tie!");
		else if (dealer < 21 && player > 21 || player != 21 && dealer == 21)
			System.out.println("The dealer won this turn :(");
		else if (dealer > 21 && player < 21 || player == 21 && dealer != 21) {
			System.out.println("The player won this turn :)");
			playerWin += 1;
		} else if (dealer < 21 && player < 21) {
			if (dealer > player)
				System.out.println("The dealer won this turn :(");
			else if (player > dealer) {
				System.out.println("The player won this turn :)");
				playerWin += 1;
			}
		}

	}
}
