package hw3;

public class GuessNumGame {
	// Instance Variable
	// Declare game's answer
	int answer;
	// Declare is answer been get or not
	boolean getAnswer;
	// Add range parameters
	int min, max;

	// Constructor
	public GuessNumGame(int min, int max) {
		// Once game build,
		this.min = min;
		this.max = max;
		// set up range
		generateAnswer();
		// generate game's answer and
		getAnswer = false;
		// set getAnswer to false.
	}

	// Methods
	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public void generateAnswer() {
		// Random generate a number between range
		int range = max - min + 1;
		answer = (int) (Math.random() * range);
	}

	public boolean isGameOver() {
		// return answer been get or not
		return getAnswer;
	}

	public void checkAnswer(int guess) {
		// Declare check to save subtract
		int check = answer - guess;
		// If get answer, print correct prompts and
		if (check == 0) {
			System.out.println("Correct! The answer is " + answer);
			// set getAnswer to true
			getAnswer = true;
		} else {
			// Otherwise, print bigger/smaller prompts
			System.out.println("Answer is " + (check > 0 ? "bigger." : "smaller"));
		}
	}
}