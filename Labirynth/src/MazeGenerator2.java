
import java.util.Collections;
import java.util.Arrays;
 
/*
 * recursive backtracking algorithm
 * shamelessly borrowed from the ruby at
 * http://weblog.jamisbuck.org/2010/12/27/maze-generation-recursive-backtracking
 */
public class MazeGenerator2 {
	private final int x;
	private final int y;
	private static int[][] mazeArray;
 
	public MazeGenerator2(int x, int y) {
		this.x = x;
		this.y = y;
		mazeArray = new int[this.x][this.y];
		generateMaze(0, 0);
	}
 
	public void display() {
		for (int i = 0; i < y; i++) {
			// draw the north edge
			for (int j = 0; j < x; j++) {
				System.out.print((mazeArray[j][i] & 1) == 0 ? "+---" : "+   ");
			}
			System.out.println("+");
			// draw the west edge
			for (int j = 0; j < x; j++) {
				System.out.print((mazeArray[j][i] & 8) == 0 ? "|   " : "    ");
			}
			System.out.println("|");
		}
		// draw the bottom line
		for (int j = 0; j < x; j++) {
			System.out.print("+---");
		}
		System.out.println("+");
	}
 
	private void generateMaze(int cx, int cy) {
		DIR[] dirs = DIR.values();
		Collections.shuffle(Arrays.asList(dirs));
		for (DIR dir : dirs) {
			int nx = cx + dir.dx;
			int ny = cy + dir.dy;
			if (between(nx, x) && between(ny, y)
					&& (mazeArray[nx][ny] == 0)) {
				mazeArray[cx][cy] |= dir.bit;
				mazeArray[nx][ny] |= dir.opposite.bit;
				generateMaze(nx, ny);
			}
		}
	}
 
	private static boolean between(int v, int upper) {
		return (v >= 0) && (v < upper);
	}
 
	private enum DIR {
		N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);
		private final int bit;
		private final int dx;
		private final int dy;
		private DIR opposite;
 
		// use the static initializer to resolve forward references
		static {
			N.opposite = S;
			S.opposite = N;
			E.opposite = W;
			W.opposite = E;
		}
 
		private DIR(int bit, int dx, int dy) {
			this.bit = bit;
			this.dx = dx;
			this.dy = dy;
		}
	};
 
	public static void main(String[] args) {
		int x = args.length >= 1 ? (Integer.parseInt(args[0])) : 8;
		int y = args.length == 2 ? (Integer.parseInt(args[1])) : 8;
		MazeGenerator2 maze = new MazeGenerator2(x, y);
		maze.display();
		simpleLabiryntDrawyer(x, y, mazeArray);
	}
	
    public static void simpleLabiryntDrawyer(int x, int y, int[][] maze){
    	String exit = "";
		for(int i=0; i<y; i++){
			if(i==0){
				exit += "{[ \r\n";
			}
			for(int j=0; j<x; j++){
				if(j==0){
					exit += "    [";
				} 
				int O = maze[i][j];
				exit += "" + O;
				
				if(j==x-1 && i < y-1){
					exit += "],\r\n";
				} else if(j==x-1 && i == y-1) {
					exit += "]\r\n";
				} else {
					exit += ", ";
				}
			}
			if(i==y-1){
				exit += "]}";
			}
		}
		System.out.println(exit);
	}
 
}