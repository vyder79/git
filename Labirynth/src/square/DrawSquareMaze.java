/**
 * @author vyder
 * @created 17 gru 2014
 * @since
 *
 */
package square;

/**
 * @author vyder
 * @created 17 gru 2014
 * @since
 *
 */
public class DrawSquareMaze {

	 public static void main (String args[]){
		 
		 SquareMaze squareMaze = new SquareMaze();
		 int[][] labirynth = squareMaze.generateMaze();
		 squareMaze.generateOutputData(labirynth);
	 }

}
