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
 * shield class
 * When a snake captures it. It can't get eliminated by the blocks.
 */
public class shield extends Component implements Serializable
{
    
	/** Shield constructor
	 * @param i   interger to generate shield at random places on the screen */
    shield(int i) throws FileNotFoundException
    {
         Random rand=new Random();
        this.rx=rand.nextInt(480)+20;
        this.ry=(rand.nextInt(2000)*(-1)*(i+1)*4)-1000;
        Image image = new Image(new FileInputStream("./src/game/shield.png"));
        ImageView base = new ImageView(image);
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
