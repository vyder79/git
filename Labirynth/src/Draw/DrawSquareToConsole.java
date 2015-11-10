package Draw;

public class DrawSquareToConsole {

	public void simpleLabiryntDrawyer(int[][] maze, int x, int y) {
		String exit = "";
		for (int i = 0; i < y; i++) {
			if (i == 0) {
				exit += "{[ \r\n";
			}
			for (int j = 0; j < x; j++) {
				if (j == 0) {
					exit += "    [";
				}
				String O = maze[i][j] == 1 ? "1" : "0";
				exit += "" + O;

				if (j == x - 1 && i < y - 1) {
					exit += "],\r\n";
				} else if (j == x - 1 && i == y - 1) {
					exit += "]\r\n";
				} else {
					exit += ", ";
				}
			}
			if (i == y - 1) {
				exit += "]}";
			}
		}
		System.out.println(exit);
	}

	public void simpleLabiryntDrawyerForProcessing(int[][] maze, int x,
			int y) {
		String exit = "";
		for (int i = 0; i < y; i++) {
			if (i == 0) {
				exit += "{ \r\n";
			}
			for (int j = 0; j < x; j++) {
				if (j == 0 && i % 2 == 0) {
					exit += "    {";
				} else if (j == 0 && i % 2 != 0) {
					exit += "    {";
				}
				String O = maze[i][j] == 1 ? "1" : "0";

				exit += "" + O;

				if (j == x - 1 && i < y - 1) {
					exit += "},\r\n";
				} else if (j == x - 1 && i == y - 1) {
					exit += "}\r\n";
				} else {
					exit += ", ";
				}
			}
			if (i == y - 1) {
				exit += "}";
			}
		}
		System.out.println(exit);
	}

}
