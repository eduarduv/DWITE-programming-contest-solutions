/* 
 * DWITE - December 2004 - Problem 1: Prime Factorization
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200412p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200412p1().run("DATA11.txt", "OUT11.txt");
	}
	
	
	protected void runOnce() {
		io.println(factor(io.readIntLine()));
	}
	
	
	private static String factor(int x) {
		for (int i = 2, end = DwiteAlgorithm.sqrt(x); i <= end; i++) {
			if (x % i == 0)
				return i + "*" + factor(x / i);  // x is composite
		}
		return Integer.toString(x);  // x is prime
	}
	
}
