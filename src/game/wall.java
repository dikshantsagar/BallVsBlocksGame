/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author dikshant
 */
public class wall extends Component implements Serializable
{
    wall(int i)
    {
        Random rand=new Random();
        Rectangle w=new Rectangle(0,0,4,100);
        this.rx=rand.nextInt(4)*120+20;
    	this.ry=(rand.nextInt(2000)*(-1)*(i+1))-100;
        w.setFill(Color.WHITE);
        this.getChildren().add(w);
        this.setTranslateX(rx);
        this.setTranslateY(ry);
    }
    
    
}