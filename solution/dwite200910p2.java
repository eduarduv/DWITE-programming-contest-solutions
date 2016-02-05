/* 
 * DWITE - October 2009 - Problem 2: Word Scrambler
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.Arrays;


public final class dwite200910p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200910p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	protected void runOnce() {
		char[] c = io.readLine().toCharArray();
		Arrays.sort(c);
		do io.println(new String(c));
		while (nextPermutation(c));
	}
	
	
	private static boolean nextPermutation(char[] a) {
		// Find longest nonincreasing suffix
		int i = a.length - 1;
		while (i >= 1 && a[i - 1] >= a[i])
			i--;
		if (i == 0)  // The suffix is entire sequence
			return false;
		
		// Reverse the suffix
		for (int j = 0; i + j < a.length - 1 - j; j++) {
			char temp = a[i + j];
			a[i + j] = a[a.length - 1 - j];
			a[a.length - 1 - j] = temp;
		}
		
		// Exchange the item immediately before the suffix with a bigger item in the suffix
		int j = i;
		while (j < a.length && a[j] < a[i - 1])
			j++;
		if (j == a.length)
			throw new AssertionError();
		char temp = a[i - 1];
		a[i - 1] = a[j];
		a[j] = temp;
		
		return true;
	}
	
}
