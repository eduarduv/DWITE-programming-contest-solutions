/* 
 * DWITE programming contest solutions
 * October 2006 - Problem 3: "Basketball Statistics II"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class dwite200610p3 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200610p3().run("DATA31.txt", "OUT31.txt");
	}
	
	
	protected void run() {
		// Read input
		int n = io.readIntLine();
		List<Player> players = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String name = io.readLine();
			int foulshots = io.readIntLine();
			int fieldgoals = io.readIntLine();
			int threepointbaskets = io.readIntLine();
			int time = io.readIntLine();
			players.add(new Player(name, foulshots, fieldgoals, threepointbaskets, time));
		}
		
		// Sort descending by points per minute and write output
		Collections.sort(players, Collections.reverseOrder());
		for (int i = 0; i < Math.min(5, players.size()); i++) {
			Player player = players.get(i);
			io.printf("%s-%.3f%n", player.name, player.getPpm());
		}
	}
	
	
	
	private static final class Player implements Comparable<Player> {
		
		public final String name;
		public final int score;
		public final int time;  // In minutes
		
		
		public Player(String name, int foulShots, int fieldGoals, int threePointBaskets, int time) {
			this.name = name;
			score = foulShots*1 + fieldGoals*2 + threePointBaskets*3;
			this.time = time;
		}
		
		
		public double getPpm() {
			return (double)score / time;
		}
		
		
		public int compareTo(Player p) {
			return Double.compare(getPpm(), p.getPpm());
		}
		
		
		public String toString() {
			return String.format("%s (score %d, time %d, PPM %.2f)", name, score, time, getPpm());
		}
		
	}
	
}
