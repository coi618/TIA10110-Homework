package hw3;

public class TestPlayer {
	public static void main(String[] args) {
		// Set all player's hate number
		int[] hateNumArray = {0, 1, 4, 5, 6, 9, 100, -100};		
		// Declare player array
		Player[] p = new Player[8];
		
		for(int i = 0; i < p.length; i++) {
			// Declare each player and give its hate number
			p[i] = new Player(hateNumArray[i]);
			// Print prompt
			System.out.print("p[" + i + "]'s hate number is ");
			// Print player's hate number 
			System.out.print(p[i].getHateNumber());
			// Print option number table
			p[i].getOptionNumTable();
			// Print how many numbers player can choose
			System.out.printf("There are %d numbers can choose.\n", p[i].getOptCount());
			// Player pick up 6 number
			p[i].pickUpNumber();
			// Print player's pick up
			p[i].printPickUp();
			System.out.println("------------------------------\n");
		
			// Also call printPickUp()
		}
	}
}