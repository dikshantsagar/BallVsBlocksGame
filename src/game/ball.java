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
import javafx.scene.text.Text;

/**
 *
 * @author dikshant sagar, mukul kumar
 * @version Snake Vs Block Game AP Project
 * Ball GUI component of game
 * 
 */
public class ball extends Component implements Serializable
{
    
    protected int num;
    
    public int getnum()
    {
        return this.num;
    }
    /**
	 * Balls get added to snake and gets vanished/removed from the screen
	 * 
	 */
    protected void destroy()
    
    {
    	
        this.num=0;
        this.setScaleX(0);
        this.setScaleY(0);
    }
    /** Constructor for Ball
	 * @param c      parameter int value to set the position of ball on the screen
	 */
    ball(int c)
    {
    	
        Random rand=new Random();
        this.rx=rand.nextInt(480)+20;
        this.ry=(305*(-1)*(c+1));
        
    Circle base=new Circle(1,1,10,Color.YELLOW);
     this.num=rand.nextInt(4)+1;
    Text text =new Text(Integer.toString(num));
    this.getChildren().addAll(base,text);
    this.setLayoutX(rx);
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
