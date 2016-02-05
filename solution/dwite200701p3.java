/* 
 * DWITE - January 2007 - Problem 3: Elapsed Time in Seconds
 * Solution by Project Nayuki
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200701p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200701p3().run("DATA31.txt", "OUT31.txt");
	}
	
	
	protected void runOnce() {
		String[] tokens = io.readLine().split("[ /:]");
		int day = Integer.parseInt(tokens[0]);
		int mth = Integer.parseInt(tokens[1]);
		int yr  = Integer.parseInt(tokens[2]);
		int hr  = Integer.parseInt(tokens[3]);
		int min = Integer.parseInt(tokens[4]);
		int sec = Integer.parseInt(tokens[5]);
		io.println(toSeconds(yr, mth, day, hr, min, sec) - toSeconds(2000, 1, 1, 0, 0, 0));
	}
	
	
	private static final int[] cumulativeDays = {-1, -1, -1, 0, 31, 61, 92, 122, 153, 184, 214, 245, 275, 306, 337};
	
	
	/*
	 * Returns the number of seconds after an arbitrary, fixed epoch.
	 * At the very least, it requires that yr >= 0 and 01 <= mth <= 12.
	 */
	private static long toSeconds(int yr, int mth, int day, int hr, int min, int sec) {
		if (mth < 3) {
			mth += 12;
			yr--;
		}
		int d = yr*365 + yr/4 - yr/100 + yr/400 + cumulativeDays[mth] + day;  // The epoch is 0000-02-29, to be exact
		return d*86400L + hr*3600 + min*60 + sec*1;
	}
	
}
