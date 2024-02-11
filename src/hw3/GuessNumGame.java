package hw3;

public class GuessNumGame {
	// Instance Variable
	// Declare game's answer
	int answer;
	// Declare is asnwer been get or not
	boolean getAnswer;

	// Constructor
	public GuessNumGame() {
		// Once game build,
		generateAnswer();
		// generate game's answer and
		getAnswer = false;
		// set getAnswer to false.
	}

	// Methods
	public void generateAnswer() {
		// Random generate a number between 0~9
		answer = (int) (Math.random() * 10);
	}

	public boolean isGameOver() {
		// return if answer been get or not
		return getAnswer;
	}

	public void checkAnswer(int guess) {
		// Declare check to save subtract
		int check = answer - guess;
		// If get answer, print correct prompt and
		if (check == 0) {
			System.out.println("Correct! The answer is " + answer);
			// set getAnswer to true
			getAnswer = true;
		} else {
			// Otherwise, print bigger/smaller prompt
			System.out.println("Answer is " + (check > 0 ? "bigger." : "smaller"));
		}
	}

}