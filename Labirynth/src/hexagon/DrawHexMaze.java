package hexagon;

public class DrawHexMaze {

	public static void main(String[] args) {
		
		HexagonMaze hexagonMaze = new HexagonMaze();
		int[][] hexMaze = hexagonMaze.generateMaze();
		hexagonMaze.generateOutputData(hexMaze);
		
	}

}
