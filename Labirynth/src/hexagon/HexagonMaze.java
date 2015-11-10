package hexagon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import Draw.DrawHexToConsole;

/** 
 * @author vyder
 * @created 18 lis 2014
 * @since
 *
 *	klasa generuje labirynt składający się z sześciokątów
 *	do generowania wykorystywany jest algorytm Deep First Search
 *	(rekurencyjnie)
 */
public class HexagonMaze {
	
	/** 
	 * określenie wielkości labiryntu
	 */
	private static int width = 31;
	private static int height = 61;
	private static int[][] maze = new int[height][width];
	
	/**
	 * generator labiryntu
	 * 
	 * @return tablica dwuwymiarowa
	 * 1 = ściana
	 * 0 = przejście
	 */
	public int[][] generateMaze() {
	    // inicjalizacja labiryntu
	    for (int i = 0; i < height; i++)
	        for (int j = 0; j < width; j++)
	            maze[i][j] = 1;
	 
	     Random rand = new Random();
	     int r = rand.nextInt(height);
	     while (r % 2 == 0) {
	         r = rand.nextInt(height);
	     }
	     int c = rand.nextInt(width);
	     while (c % 2 == 0) {
	         c = rand.nextInt(width);
	     }
	     // pole startowe, z którego zacznie się
	     // generowanie labiryntu
	     // r - rząd, c - kolumna
	     maze[r][c] = 0;
	 
	     //　rekurencyjne tworzenie labiryntu
	     recursion(r, c);
	 
	     return maze;
	 }
	 
	/**
	 * losowo porusza się po powierzchni labiryntu
	 * i w zależności od wartości pól sąsiadujących
	 * z aktualnym polem tworzy drogę labiryntu
	 * 
	 * @param r row - rząd labiryntu
	 * @param c column - kolumna labiryntu
	 */
	 private void recursion(int r, int c) {
	     // 6 losowych kierunków ruchu
	     Integer[] randDirs = generateRandomDirections(r);
	     for (int i = 0; i < randDirs.length; i++) {
	         switch(randDirs[i]){
	         // dla parzystych wierszy
	         case 1: // Up //
	             if (r - 4 <= 0)
	                 continue;
	             if (maze[r - 4][c] != 0) {
	                 maze[r-4][c] = 0;
	                 maze[r-2][c] = 0;
	                 recursion(r - 4, c);
	             }
	             break;
	         case 2: // Up-Right //
	             if (c + 1 >= width || r - 2 <= 0)
	                 continue;
	             if (maze[r - 2][c + 1] != 0) {
	                 maze[r - 2][c + 1] = 0;
	                 maze[r - 1][c] = 0;
	                 recursion(r - 2, c + 1);
	             }
	             break;
	         case 3: // Down //
	             if (r + 4 >= height - 1)
	                 continue;
	             if (maze[r + 4][c] != 0) {
	                 maze[r+4][c] = 0;
	                 maze[r+2][c] = 0;
	                 recursion(r + 4, c);
	             }
	             break;
	         case 4: // Up-Left //
	             if (c - 1 <= 0 || r - 2 <= 0)
	                 continue;
	             if (maze[r - 2][c - 1] != 0) {
	                 maze[r - 2][c - 1] = 0;
	                 maze[r - 1][c - 1] = 0;
	                 recursion(r - 2, c - 1);
	             }
	             break;
	         case 5: // Down-Left //
	             if (c - 1 <= 0 || r + 2 >= height - 1)
	                 continue;
	             if (maze[r + 2][c - 1] != 0) {
	                 maze[r + 2][c - 1] = 0;
	                 maze[r + 1][c - 1] = 0;
	                 recursion(r + 2, c - 1);
	             }
	             break;
	         case 6: // Down-Right //
	        	 if (c + 1 >= width || r + 2 >= height - 1)
	                 continue;
	             if (maze[r + 2][c + 1] != 0) {
	                 maze[r + 2][c + 1] = 0;
	                 maze[r + 1][c] = 0;
	                 recursion(r + 2, c + 1);
	             }
	             break;
	         
	         // dla nieparzystych wierszy
	         case 11: // Up //
	             if (r - 4 <= 0)
	                 continue;
	             if (maze[r - 4][c] != 0) {
	                 maze[r-4][c] = 0;
	                 maze[r-2][c] = 0;
	                 recursion(r - 4, c);
	             }
	             break;
	         case 12: // Up-Right //
	             if (c + 1 >= width || r - 2 <= 0)
	                 continue;
	             if (maze[r - 2][c + 1] != 0) {
	                 maze[r - 2][c + 1] = 0;
	                 maze[r - 1][c + 1] = 0;
	                 recursion(r - 2, c + 1);
	             }
	             break;
	         case 13: // Down //
	             if (r + 4 >= height - 1)
	                 continue;
	             if (maze[r + 4][c] != 0) {
	                 maze[r+4][c] = 0;
	                 maze[r+2][c] = 0;
	                 recursion(r + 4, c);
	             }
	             break;
	         case 14: // Up-Left //
	             if (c - 1 <= 0 || r - 2 <= 0)
	                 continue;
	             if (maze[r - 2][c - 1] != 0) {
	                 maze[r - 2][c - 1] = 0;
	                 maze[r - 1][c] = 0; //
	                 recursion(r - 2, c - 1);
	             }
	             break;
	         case 15: // Down-Left //
	             if (c - 1 <= 0 || r + 2 >= height - 1)
	                 continue;
	             if (maze[r + 2][c - 1] != 0) {
	                 maze[r + 2][c - 1] = 0;
	                 maze[r + 1][c] = 0; //
	                 recursion(r + 2, c - 1);
	             }
	             break;
	         case 16: // Down-Right //
	        	 if (c + 1 >= width || r + 2 >= height - 1)
	                 continue;
	             if (maze[r + 2][c + 1] != 0) {
	                 maze[r + 2][c + 1] = 0;
	                 maze[r + 1][c + 1] = 0;
	                 recursion(r + 2, c + 1);
	             }
	             break;
	         
	         }
	     }
	 
	 }
	 
	 /**
	 * generuje tablicę z losowo wybranymi kierunkami ruchu 1-6
	 * 
	 * @return tablicę zawierającą 6 kierunków ruchu w losowej kolejności
	 * jeśli wiersz jest parzysty zwracane są wartości 1-6
	 * jeśli wiersz jest nieparzysty zwracane są wartości 11-16
	 */
	 private Integer[] generateRandomDirections(int r) {
		 //jeśli parzyste -> 1-6, jeśli nieparzyste -> 11-16
		 int isOdd = r % 2 > 0 ? 0 : 10;
	      ArrayList<Integer> randoms = new ArrayList<Integer>();
	      for (int i = 0; i < 6; i++)
	           randoms.add(i + 1 + isOdd);
	      Collections.shuffle(randoms);
	 
	     return randoms.toArray(new Integer[6]);
	 }
	 
	 /**
	  * wyświetlanie danych wyjściowych w konsoli
	  * 
	  * @param labirynth - tablica dwuwymiarowa zawierająca informacje o labiryncie
	  */
	 public void generateOutputData(int[][] labirynth){
		 new DrawHexToConsole().simpleLabiryntDrawyer(labirynth, width, height);
		 //new DrawHexToConsole().simpleLabiryntDrawyerForProcessing(labirynth, width, height);
	 }
	 
	 
}

