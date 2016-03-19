/**
 * @author vyder
 * @created 17 gru 2014
 * @since
 *
 */
package circle;

/**
 * @author vyder
 * @created 17 gru 2014
 * @since
 *
 */
public class DrawCircleMaze {

	 public static void main (String args[]){
		 
		 CircleMaze circleMaze = new CircleMaze();
		 int[][] labirynth = circleMaze.generateMaze();
		 circleMaze.generateOutputData(labirynth);
	 }

}
