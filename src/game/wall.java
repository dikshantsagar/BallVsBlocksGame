/*
 * Class for the wall component.
 */
package game;

import java.io.Serializable;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
  *@author dikshant sagar, mukul kumar
 * @version Snake Vs Block Game AP Project
 * wall class
 * blocks the horizontal movement of the snake.
 * 
 */
public class wall extends Component implements Serializable
{
	
	/**  Creates a wall at random 
<<<<<<< HEAD
	 * @param c  parameter to generate wall at random position on the screen*/
=======
	 * @param c  parameter to geneerate wall at random position on the screen*/
>>>>>>> ff52a881dadf2717db4578383938414fc9172487
    wall(int c)
    {
        Random rand=new Random();
        Rectangle w=new Rectangle(0,0,4,100);
        this.rx=rand.nextInt(4)*120+20;
    	this.ry=(300*(-1)*(c+1)+70);
        w.setFill(Color.WHITE);
        this.getChildren().add(w);
        this.setTranslateX(rx);
        this.setTranslateY(ry);
    }
    
    
}
