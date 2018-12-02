/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
  *@author dikshant sagar, mukul kumar
 * @version Snake Vs Block Game AP Project
 * magnet class
 * Gui component of the game.
 * If the snake captures it, it will attract  all the coins/balls present in the range of the snake.
 */
public class magnet extends Component implements Serializable
{
	/*** removes magnet*/
    
    protected void destroy()
    {
        
        this.setScaleX(0);
        this.setScaleY(0);
    }
    
    /** creates a magnet and places it on the screen at a random place on screen
     * @param i   i helps in generation of magnets at random places*/
    magnet(int i) throws FileNotFoundException
    {
        Random rand=new Random();
        this.rx=rand.nextInt(4)*120+35;
        this.ry=(rand.nextInt(2000)*(-1)*(i+1)*2);
        Image image = new Image(new FileInputStream("./src/game/mag.png"));
        ImageView base = new ImageView(image);
        base.setScaleX(0.1);
        base.setScaleY(0.1);
        this.getChildren().add(base);
        this.setTranslateX(rx);
        if(ry<0)
        {
            this.setTranslateY(ry);
        }
        else
        {
            this.setTranslateY(-3000);
        }
    
    }
}
