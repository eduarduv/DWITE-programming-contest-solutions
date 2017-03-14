/* 
 * DWITE programming contest solutions
 * December 2005 - Problem 2: "The Maze"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.LinkedList;
import java.util.Queue;


public final class dwite200512p2 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200512p2().run("DATA21.txt", "OUT21.txt");
	}
	
	
	private char[][] grid;
	
	
	protected void runOnce() {
		// Read input
		io.tokenizeLine();
		int height = io.readIntToken();
		int width = io.readIntToken();
		grid = io.readGridAndPad(width, height, '#');
		
		// Find entry cell position
		int startx = -1;
		int starty = -1;
		outer:
		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++) {
				if (grid[y][x] == 'E') {
					startx = x;
					starty = y;
					break outer;
				}
			}
		}
		
		// Compute shortest path length
		//int length = findShortestPathDfs(startx, starty);
		int length = findShortestPathBfs(startx, starty);
		
		// Write output
		io.println(length - 1);  // The number of dots is length-1
	}
	
	
	@SuppressWarnings("unused")
	private int findShortestPathDfs(int x, int y) {
		if (grid[y][x] == 'X')
			return 0;
		if (grid[y][x] == '#')
			return Integer.MAX_VALUE / 2;
		
		int min = Integer.MAX_VALUE / 2;  // Length of the rest of the path
		grid[y][x] = '#';
		min = Math.min(findShortestPathDfs(x - 1, y + 0), min);
		min = Math.min(findShortestPathDfs(x + 1, y + 0), min);
		min = Math.min(findShortestPathDfs(x + 0, y - 1), min);
		min = Math.min(findShortestPathDfs(x + 0, y + 1), min);
		grid[y][x] = '.';
		return 1 + min;
	}
	
	
	private int findShortestPathBfs(int startx, int starty) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(startx, starty, 0));
		while (!queue.isEmpty()) {
			Point cell = queue.remove();
			int x = cell.x;
			int y = cell.y;
			int dist = cell.distance;
			if (grid[y][x] == 'X')
				return cell.distance;
			else if (grid[y][x] == '#')
				continue;
			else {
				grid[y][x] = '#';
				queue.add(new Point(x - 1, y + 0, dist + 1));
				queue.add(new Point(x + 1, y + 0, dist + 1));
				queue.add(new Point(x + 0, y - 1, dist + 1));
				queue.add(new Point(x + 0, y + 1, dist + 1));
			}
		}
		throw new AssertionError("No path exists");
	}
	
	
	
	private static final class Point {
		
		public final int x;
		public final int y;
		public final int distance;
		
		
		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.distance = dist;
		}
		
	}
	
}
