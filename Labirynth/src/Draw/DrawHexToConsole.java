/**
 * @author vyder
 * @created 15 gru 2014
 * @since
 *
 */
package Draw;

/**
 * Drukowanie wygenerowanych tabel w konsoli jako JSON i dla processingu.
 * 
 * @author vyder
 * @created 15 gru 2014
 * @since
 *
 */
public class DrawHexToConsole {

	/**
	 * tworzenie wynikowego pliku tekstowego (w konsoli) w formacie JSON
	 * 
	 * @param maze
	 *            - tablica dwuwymiarowa zawierająca informacje o labiryncie
	 */
	public void simpleLabiryntDrawyer(int[][] maze, int x, int y) {
		String exit = "";
		for (int i = 0; i < y; i++) {
			if (i == 0) {
				exit += "{[ \r\n";
			}
			for (int j = 0; j < x; j++) {
				if (j == 0 && i % 2 == 0) {
					exit += "    [";
				} else if (j == 0 && i % 2 != 0) {
					exit += "     [";
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
		// wynik na konsolę
		System.out.println(exit);
	}

	/**
	 * tworzenie wynikowego pliku tekstowego (w konsoli) w formacie tablicy
	 * dwuwymiarowej dla javy/processingu
	 * 
	 * @param maze
	 *            - tablica dwuwymiarowa zawierająca informacje o labiryncie
	 */
	public void simpleLabiryntDrawyerForProcessing(int[][] maze, int x, int y) {
		String exit = "";
		for (int i = 0; i < y; i++) {
			if (i == 0) {
				exit += "{ \r\n";
			}
			for (int j = 0; j < x; j++) {
				if (j == 0 && i % 2 == 0) {
					exit += "    {";
				} else if (j == 0 && i % 2 != 0) {
					exit += "     {";
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
		// wynik na konsolę
		System.out.println(exit);
	}

}
