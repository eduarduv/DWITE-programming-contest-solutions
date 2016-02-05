/* 
 * DWITE - October 2009 - Problem 1: iProfits
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200910p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200910p1().run("DATA1.txt", "OUT1.txt");
	}
	
	
	protected void runOnce() {
		// Use exact integer arithmetic
		int n = io.readIntLine();
		io.println((n * 1000L + 99L * 7 * 1000 - 1) / 693000 * 1000);
	}
	
}
