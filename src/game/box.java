/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author dikshant
 */
public class box extends Component implements Serializable
{

    
    protected int blocknum;
    
    public int getnum()
    {
        return this.blocknum;
    }
    
    protected void destroy()
    {
        this.blocknum=0;
        this.setScaleX(0);
        this.setScaleY(0);
    }
    
   box(int c)
   {
        Random rand=new Random();
    	 	
    	blocknum=rand.nextInt(15)+1;
    	this.rx=rand.nextInt(4)*120+35;
    	this.ry=(300*(-1)*(c+1));

    	 	
    	Rectangle b=new Rectangle(rx,ry,100,100);
	
        int sw=blocknum%4;
        switch(sw)
        {
            case 0 :b.setFill(Color.LIME);
                    break;
            case 1 :b.setFill(Color.RED);
                    break;
            case 2 :b.setFill(Color.ORANGE);
                    break;
            case 3 :b.setFill(Color.AQUA);
                    break;
        }
	

                 
        b.setArcHeight(20);
        b.setArcWidth(20);

        Text t=new Text(Integer.toString(blocknum));
        t.setScaleX(3);
        t.setScaleY(3);
        
        this.getChildren().addAll(b,t);
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
