/* 
 * DWITE - November 2004 - Problem 1: Credit Card Check Digit
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200411p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200411p1().run("DATA11.txt", "OUT11.txt");
	}
	
	
	protected void runOnce() {
		int[] digits = DwiteAlgorithm.toDigits(io.readLine());
		if (isLuhnValid(digits))
			io.println("VALID");
		else {
			// Try all values for the last digit
			for (int i = 0; i < 10; i++) {
				digits[digits.length - 1] = i;
				if (isLuhnValid(digits)) {  // Guaranteed to execute before the loop ends
					io.printf("INVALID %d%n", digits[digits.length - 1]);
					break;
				}
			}
		}
	}
	
	
	private static boolean isLuhnValid(int[] digits) {
		int sum = 0;
		for (int i = 0; i < digits.length; i++) {
			if ((i + digits.length) % 2 == 1)
				sum += digits[i];
			else
				sum += digits[i] / 5 + digits[i] % 5 * 2;
		}
		return sum % 10 == 0;
	}
	
}
