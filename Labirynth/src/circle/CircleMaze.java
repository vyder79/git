package circle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import Draw.DrawSquareToConsole;

/**
 * Kołowy labirynt jest generowany tak jak zwykły, z tym, że początek
 * jest wyznaczony nie losowo tylko w środku labityntu, i tam 
 * zaczyna się rysowanie przejść
 * 
 * @author vyder
 *
 */
public class CircleMaze {
	
	// ważne, aby rozmiar był nieparzysty, aby 
	// początek był dokładnie w środku labiryntu:)
	static int width = 51;
	static int height = 51;
	static int[][] maze = new int[height][width];
	
	public int[][] generateMaze() {
	    
	    // Initialize
	    for (int i = 0; i < height; i++)
	        for (int j = 0; j < width; j++)
	            maze[i][j] = 1;
	 
	     
	     int r = height/2;
	     int c = width/2;
	     
	     maze[r][c] = 0;
	     recursion(r, c);
	 
	     return maze;
	 }
	 
	 public void recursion(int r, int c) {
	     Integer[] randDirs = generateRandomDirections();
	     for (int i = 0; i < randDirs.length; i++) {
	 
	         switch(randDirs[i]){
	         case 1: // Up
	             if (r - 2 <= 0)
	                 continue;
	             if (maze[r - 2][c] != 0) {
	                 maze[r-2][c] = 0;
	                 maze[r-1][c] = 0;
	                 recursion(r - 2, c);
	             }
	             break;
	         case 2: // Right
	             if (c + 2 >= width - 1)
	                 continue;
	             if (maze[r][c + 2] != 0) {
	                 maze[r][c + 2] = 0;
	                 maze[r][c + 1] = 0;
	                 recursion(r, c + 2);
	             }
	             break;
	         case 3: // Down
	             if (r + 2 >= height - 1)
	                 continue;
	             if (maze[r + 2][c] != 0) {
	                 maze[r+2][c] = 0;
	                 maze[r+1][c] = 0;
	                 recursion(r + 2, c);
	             }
	             break;
	         case 4: // Left
	             if (c - 2 <= 0)
	                 continue;
	             if (maze[r][c - 2] != 0) {
	                 maze[r][c - 2] = 0;
	                 maze[r][c - 1] = 0;
	                 recursion(r, c - 2);
	             }
	             break;
	         }
	     }
	 
	 }
	 

	 public Integer[] generateRandomDirections() {
	      ArrayList<Integer> randoms = new ArrayList<Integer>();
	      for (int i = 0; i < 4; i++)
	           randoms.add(i + 1);
	      Collections.shuffle(randoms);
	 
	     return randoms.toArray(new Integer[4]);
	 }
	 
	 /**
	  * wyświetlanie danych wyjściowych w konsoli
	  * 
	  * @param labirynth - tablica dwuwymiarowa zawierająca informacje o labiryncie
	  */
	 public void generateOutputData(int[][] labirynth){
		 new DrawSquareToConsole().simpleLabiryntDrawyer(labirynth, width, height);
		 //new DrawSquareToConsole().simpleLabiryntDrawyerForProcessing(labirynth, width, height);
	 }
	 
		 
}

