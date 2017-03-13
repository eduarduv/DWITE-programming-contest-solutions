/* 
 * DWITE programming contest solutions
 * January 2011 - Problem 2: "Primal Numbers"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.Arrays;


public final class dwite201101p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite201101p2().run("DATA2.txt", "OUT2.txt");
	}
	
	
	private static int[] primes;  // 2, 3, 5, 7, 11, 13, 17, 19, ...
	
	static {
		boolean[] isPrime = DwiteAlgorithm.sievePrimes(100000);
		primes = new int[isPrime.length];
		int primeslen = 0;
		for (int i = 0; i < isPrime.length; i++) {
			if (isPrime[i]) {
				primes[primeslen] = i;
				primeslen++;
			}
		}
		primes = Arrays.copyOf(primes, primeslen);
	}
	
	
	protected void runOnce() {
		io.println(nthPrime(nthPrime(io.readIntLine())));
	}
	
	
	private static int nthPrime(int n) {  // n is one-based, i.e. nthPrime(1) == 2, nthPrime(3) == 5, etc.
		return primes[n - 1];
	}
	
}
