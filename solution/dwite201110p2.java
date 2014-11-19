/* 
 * DWITE - October 2011 - Problem 2: Penny Game
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201110p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201110p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	protected void runOnce() {
		// Read input
		int n = io.readIntLine();
		int[] stacks = new int[n];
		for (int i = 0; i < n; i++)
			stacks[i] = io.readIntLine();
		
		// Compute sum and average
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += stacks[i];
		if (sum % n != 0)
			throw new IllegalArgumentException();
		int average = sum / n;
		
		// Compute sum of absolute differences with average and write output
		int diffsum = 0;
		for (int i = 0; i < n; i++)
			diffsum += Math.abs(stacks[i] - average);
		io.println(diffsum / 2);  // Each move fixes a positive difference and a negative difference
	}
	
}
