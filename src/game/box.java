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
 * @author dikshant sagar, mukul kumar
 * @version Snake Vs Block Game AP Project
 * 
 * Box class
 * The snake will encounter blocks of different values and destroy them
<<<<<<< HEAD
 * if it has enough length (length less than value)
=======
 * if it has enough length (length>=value)
>>>>>>> ff52a881dadf2717db4578383938414fc9172487
 */
public class box extends Component implements Serializable
{

	/** Box class
	 * block number
	 * Rectangle object
	            */
    
    protected int blocknum;
    protected Rectangle b;
<<<<<<< HEAD
    protected Text t;

	/**
	 * get the block number
     * @return 
	 */
    protected int getnum()
=======
    

	/**
	 * get the block number
	 */
    public int getnum()
>>>>>>> ff52a881dadf2717db4578383938414fc9172487
    {
        return this.blocknum;
    }
    

	/**
	 * DEstroy the block
	 */
    protected void destroy()
    {
        this.blocknum=0;
        this.b.setScaleX(0);
        this.b.setScaleY(0);
        this.t.setScaleX(0);
        this.t.setScaleY(0);
        
    }
    
    /**
	    * Generation of random blocks of random values and random colours from the four given colours {LIme, red, aqua, orange}
	   	* @param c      parameter int value to set the position of ball on the screen

	    * <p> int sw to decide the colour of the block randomly  </p>
	    */
   box(int c)
   {
	   
        Random rand=new Random();
    	 	
    	blocknum=rand.nextInt(15)+1;
    	this.rx=rand.nextInt(4)*120+35;
    	this.ry=(300*(-1)*(c+1));

    	 	
    	 this.b=new Rectangle(rx,ry,100,100);
	
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

        t=new Text(Integer.toString(blocknum));
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
