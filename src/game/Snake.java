/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.io.Serializable;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

/**
 *
  *@author dikshant sagar, mukul kumar
 * @version Snake Vs Block Game AP Project
 * Snake class
 * Snake adds balls to it and its length increases.
 */
public class Snake extends Group implements Serializable
{
	/** Gives length, position coordinates of snake and the status of shield*/
    private int len;
    private double sx=300;
    private double sy=500;
    private double ey;
    boolean shield=false;
    
    /** making shield active*/
    boolean shieldalive()
    {
        return shield;
    }
    /** set shield on the screen */
    void setshield()
    {
        this.shield=true;
    }
    
    /** remove shield from the screen*/
    void removeshield()
    {
        this.shield=false;
    }
   /** Add balls to snake
    * @param x   value of ball*/
    public void addlen(int x)
    {
        
        this.len+=x;
        Text t=new Text(Integer.toString(this.len));
        t.setFill(WHITE);
        t.setLayoutX(sx-5);
        t.setLayoutY(sy-20);
        this.getChildren().set(0, t);
        for(int i=0;i<x;i++)
        {
            this.getChildren().add(new Circle(sx,ey,10,Color.YELLOW));
            this.ey=ey+20;
        }
    }
    
    /** decrease the length of the snake according to the the value of block
     * @param x      value of the block */
    public void declen(int x)
    {
        if(this.len-x>1)
        {
            this.len-=x;
            Text t=new Text(Integer.toString(this.len));
            t.setFill(WHITE);
            t.setLayoutX(sx-5);
            t.setLayoutY(sy-20);
            this.getChildren().set(0, t);
            for(int i=0;i<x;i++)
            {
                this.getChildren().remove(this.getlen()+1);
                this.ey-=20;
            }
        }
        
    }
    
    /** function to get the length of snake*/
    
    public int getlen()
    {
        return this.len;
    }
    
    /** Snake contructor
     * @param le        initial length of the snake*/
    Snake(int le)
    {   
        this.len=le;
        Text l=new Text(Integer.toString(len));
        l.setFill(WHITE);
        l.setLayoutX(sx-5);
        l.setLayoutY(sy-20);
        this.getChildren().add(l);
        for(int i=0;i<this.len;i++)
        {
            this.getChildren().add(new Circle(sx,sy+i*20,10,Color.YELLOW));
            this.ey=sy+(i+1)*20;
            
        }
        
        
       
        
        
        
    }
    
}
