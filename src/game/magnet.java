/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author dikshant
 */
public class magnet extends Component implements Serializable
{
    
    magnet()
    {
        Random rand=new Random();
        this.rx=rand.nextInt(480)+20;
        this.ry=(rand.nextInt(2000)*(-1))-100;
        Circle base=new Circle(1,1,10,Color.BLUE);
    }
}
