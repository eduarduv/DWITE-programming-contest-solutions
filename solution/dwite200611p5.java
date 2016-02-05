/* 
 * DWITE - November 2006 - Problem 5: Goldbach's Weak Conjecture
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200611p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200611p5().run("DATA51.txt", "OUT51.txt");
	}
	
	
	private static boolean[] isPrime;
	
	static {
		isPrime = DwiteAlgorithm.sievePrimes(999999);
		isPrime[2] = false;  // For the purposes of this problem
	}
	
	
	protected void runOnce() {
		int n = io.readIntLine();
		io.printf("%d=%s%n", n, solve(n));
	}
	
	
	private static String solve(int n) {
		if (n % 2 == 0)
			throw new IllegalArgumentException("Not applicable to even numbers");
		if (n <= 7)
			throw new IllegalArgumentException("Not applicable for numbers 7 or less");
		return solve(n, 3, Integer.MAX_VALUE);
	}
	
	
	private static String solve(int n, int terms, int max) {
		if (n > max)
			return null;
		else if (terms == 1) {
			if (isPrime[n])
				return Integer.toString(n);
			else
				return null;
		} else {
			for (int i = Math.min(n, max), end = (n + terms - 1) / terms; i >= end; i--) {
				if (!isPrime[i])
					continue;
				String temp = solve(n - i, terms - 1, i);
				if (temp != null)
					return String.format("%d+%s", i, temp);
			}
			return null;
		}
	}
	
}
