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
 * @author dikshant
 */
public class ball extends Component implements Serializable
{
    
    protected int num;
    
    public int getnum()
    {
        return this.num;
    }
    protected void destroy()
    {
        this.num=0;
        this.setScaleX(0);
        this.setScaleY(0);
    }
    
    ball(int i)
    {
        Random rand=new Random();
        this.rx=rand.nextInt(480)+20;
        this.ry=(rand.nextInt(2000)*(-1)*(i+1))-100;
    Circle base=new Circle(1,1,10,Color.YELLOW);
     this.num=rand.nextInt(4)+1;
    Text text =new Text(Integer.toString(num));
    this.getChildren().addAll(base,text);
    this.setTranslateX(rx);
    this.setTranslateY(ry);
    
     }
    
}