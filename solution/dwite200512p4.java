/* 
 * DWITE - December 2005 - Problem 4: Now I Know My ABC's
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200512p4 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200512p4().run("DATA41.txt", "OUT41.txt");
	}
	
	
	protected void runOnce() {
		// Read input
		String line = io.readLine();
		
		// Count frequencies
		int[] freq = new int[26];
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (isLetter(c))
				freq[(c - 'A') % 32]++;
		}
		
		// Write output
		boolean initial = true;
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] != 0) {
				if (initial) initial = false;
				else io.print(":");
				io.printf("%c-%d", (char)('A' + i), freq[i]);
			}
		}
		io.println();
	}
	
	
	private static boolean isLetter(char c) {
		return c >= 'A' && c <= 'Z'
		    || c >= 'a' && c <= 'z';
	}
	
}
