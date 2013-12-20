import java.util.Arrays;


public final class DwiteAlgorithm {
	
	public static int sqrt(int x) {
		if (x < 0)
			throw new IllegalArgumentException();
		int y = 0;
		for (int i = 15; i >= 0; i--) {
			y |= 1 << i;
			if (y > 46340 || y * y > x)
				y ^= 1 << i;
		}
		return y;
	}
	
	
	public static int gcd(int x, int y) {
		if (x == Integer.MIN_VALUE && y == Integer.MIN_VALUE)
			throw new IllegalArgumentException("Answer overflow");
		
		x = Math.abs(x);
		y = Math.abs(y);
		while (y != 0) {
			int z = x % y;
			x = y;
			y = z;
		}
		return Math.abs(x);
	}
	
	
	public static int[] toDigits(String str) {
		int[] digits = new int[str.length()];
		for (int i = 0; i < digits.length; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9')
				throw new IllegalArgumentException();
			digits[i] = c - '0';
		}
		return digits;
	}
	
	
	public static boolean[] sievePrimes(int n) {
		boolean[] isPrime = new boolean[n + 1];
		if (n >= 2)
			isPrime[2] = true;
		for (int i = 3; i <= n; i += 2)
			isPrime[i] = true;
		for (int i = 3, end = sqrt(n); i <= end; i += 2) {
			if (isPrime[i]) {
				for (int j = i * 3; j <= n; j += i << 1)
					isPrime[j] = false;
			}
		}
		return isPrime;
	}
	
	
	public static int[][] newIntGrid(int height, int width, int fill) {
		int[][] result = new int[height][width];
		for (int[] row : result)
			Arrays.fill(row, fill);
		return result;
	}
	
	
	public static char[][] newCharGrid(int height, int width, char fill) {
		char[][] result = new char[height][width];
		for (int i = 0; i < height; i++)
			Arrays.fill(result[i], fill);
		return result;
	}
	
	
	// Von Neumann neighborhood directions (4 cells: cardinal directions only)
	public static final int[][] FOUR_DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	// Moore neighborhood directions (8 cells: cardinal directions and diagonals)
	public static final int[][] EIGHT_DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
	
	
	
	private DwiteAlgorithm() {}
	
}
