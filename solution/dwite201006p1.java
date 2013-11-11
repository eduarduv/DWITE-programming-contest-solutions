/* 
 * DWITE - June 2010 - Problem 1: Binary Equipment
 * Solution by Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201006p1 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201006p1().run("DATA1.txt", "OUT1.txt");
	}
	
	
	protected void runOnce() {
		io.tokenizeLine();
		int equipped = io.readIntToken();
		int item = io.readIntToken();
		if (equipped < 0 || equipped >= 256 || item < 0 || item >= 8)
			throw new IllegalArgumentException();
		io.println((equipped >>> item) & 1);
	}
	
}
