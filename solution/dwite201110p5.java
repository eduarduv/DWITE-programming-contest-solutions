/* 
 * DWITE - October 2011 - Problem 5: Tattarrattat
 * Solution by Project Nayuki
 * 
 * http://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite201110p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201110p5().run("DATA5.txt", "OUT5.txt");
	}
	
	
	protected void runOnce() {
		String str = io.readLine();
		int n = str.length();
		
		int[][] maxPal = new int[n + 1][n + 1];  // maxPal[i][j] is the length of the longest possible palindrome for str.substring(i, j)
		for (int start = 0; start < n; start++)  // Length 1 is obviously always a palindrome
			maxPal[start][start + 1] = 1;
		
		for (int len = 2; len <= n; len++) {
			for (int start = 0; start + len <= n; start++) {
				int end = start + len;
				if (str.charAt(start) == str.charAt(end - 1))
					maxPal[start][end] = maxPal[start + 1][end - 1] + 2;  // Accept first and last characters
				else
					maxPal[start][end] = Math.max(maxPal[start + 1][end], maxPal[start][end - 1]);  // Delete first or last character and choose the best
			}
		}
		
		io.println(maxPal[0][n]);
	}
	
}
