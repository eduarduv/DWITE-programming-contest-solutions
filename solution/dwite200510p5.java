/* 
 * DWITE - October 2005 - Problem 5: Five Digit Divisibility
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200510p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200510p5().run("DATA51.txt", "OUT51.txt");
	}
	
	
	protected void runOnce() {
		// Read input
		io.tokenizeLine();
		int d1 = io.readIntToken();
		int d2 = io.readIntToken();
		
		// Compute
		int[] digits = new int[d1];
		int divisible = 0;
		for (int i = 0, end = factorial(d1); i < end; i++) {
			for (int j = 0; j < d1; j++)
				digits[j] = j + 1;
			permute(digits, i);
			if (toNumber(digits) % d2 == 0)
				divisible++;
		}
		
		// Write output
		io.println(divisible);
	}
	
	
	
	private static int toNumber(int[] digits) {
		int num = 0;
		for (int i = digits.length - 1; i >= 0; i--)
			num = num * 10 + digits[i];
		return num;
	}
	
	
	private static void permute(int[] array, int perm) {
		// A modification of the Knuth shuffle
		for (int i = array.length - 1; i >= 0; i--) {
			int temp = array[i];
			array[i] = array[perm % (i + 1)];
			array[perm % (i + 1)] = temp;
			perm /= i + 1;
		}
	}
	
	
	private static int factorial(int x) {
		int prod = 1;
		for (int i = 1; i <= x; i++)
			prod *= i;
		return prod;
	}
	
}
