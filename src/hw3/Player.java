package hw3;
import java.util.Arrays;

public class Player {
	// Instance Variable	
	// The number player hate
	int hateNum;	
	// The table player can choose
	int[] optionNum = new int[49];	
	// Numbers of choose table count
	int optCount;	
	// A 6 numbers array which player pick up 
	int[] pickUp = new int[6];
	
	// Constructor
	public Player(int hateNum) {
		// Get hateNum when create player
		this.hateNum = hateNum;	
		// Set up option table, also get optCount
		setOptionNumTable();
	}
	
	// Method
	public void setHateNumber(int hateNum) {
		this.hateNum = hateNum;
	}
	
	public int getHateNumber() {
		return hateNum;
	}
	
	public void setOptionNumTable() {
		optCount = 0;
		// Run 1~49, put number in optionNum
		for (int i = 1; i < 50; i++) {
			// If meet hateNumber, jump over
			if (i % 10 == this.hateNum || (i >= 10 && i / 10 == hateNum)) {
				// (i >= 10) deal if hateNum = 0, 1~9 will not choose bug
				continue;
			}
			// Put numbers to table, also calculate optCount
			optionNum[optCount++] = i;
		}
	}
	
	public void getOptionNumTable() {
		// Print optionNum table
		for (int i = 0; i < optionNum.length && optionNum[i] != 0; i++) {
			// New line every 6 elements, prefix newline for pretty console show
			if (i % 6 == 0)
				System.out.println();
			System.out.print(optionNum[i] + "\t");
		}
		System.out.println();
	}
	
	public int getOptCount() {
		return optCount;
	}
	
	public void pickUpNumber() {
		// Avoid modify the optionNum, copy a new Array: pickUpTmp
		int[] pickUpTmp = Arrays.copyOf(optionNum, optCount);
		// Set index for pick up & swap  
		int index;
		// Pick up 6 numbers
		for (int i = 0; i < 6; i++) {
			// Random get an index
			index = (int)(Math.random() * optCount);
			// Pick up pickUpTmp[index] as a pickup number
			pickUp[i] = pickUpTmp[index];
			// Swap this number with the latest number, also optCount -1
			// optCount need subtract first, then swap item.
			swap(pickUpTmp, index, --optCount);
			/*
			 * Once pick up a number, swap this number with latest number
			 * and decrease pick up range with 1, so next time pick will 
			 * guarantee not pick up the same numbers again. 
			 */
		}
		// After pick up finish, sort array. Just for pretty.
		Arrays.sort(pickUp);
	}
	
	private static void swap(int[] pickUpTmp, int index, int end) {
		pickUpTmp[index] = pickUpTmp[index] ^ pickUpTmp[end];
		pickUpTmp[end] = pickUpTmp[end] ^ pickUpTmp[index];
		pickUpTmp[index] = pickUpTmp[index] ^ pickUpTmp[end];
		
		/*
		 * swap A = 5 (0b 0000_0101), B = 2 (0b 0000_0010)
		 * A = A ^ B => A = 7 (0b 0000_0111)
		 * B = B ^ A => B = 5 (0b 0000_0101)
		 * A = A ^ B => A = 2 (0b 0000_0010)
		 */
	}

	public void printPickUp() {
		System.out.println("Your pick up numbers are:");
		// Print each pick up number with space
		for (int i = 0; i < pickUp.length; i++) {
			System.out.print(pickUp[i] + " ");
		}
		System.out.println();
	}
}