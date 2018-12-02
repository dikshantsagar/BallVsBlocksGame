/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
  *@author dikshant sagar, mukul kumar
 * @version Snake Vs Block Game AP Project
 * score class
 * Contains and keep record of scpre of a player.
 * Score is displayed on the gameplay screen
 */
public class score extends Text implements Serializable{
	/** score counter : keeps the score of the player*/
    int score;
    
    /** SEts the score of the user
     * @param x    adds the score x to be added to the score of user*/
    public void setscore(int x)
    {
        this.score+=x;
        this.setText(Integer.toString(score));
    }
    
    /** get the score of user*/
    
    public int getscore()
    {
        return this.score;
    }
    
    /** creates the instance of score*/
    
    score()
    {
        this.score=0;
        this.setText(Integer.toString(score));
        this.setFill(Color.WHITE);
        this.setScaleX(2);
        this.setScaleY(2);
        this.setLayoutX(490);
        this.setLayoutY(20);
    }
    /** creates the instance of score
     * @param x :  initial score of x*/
    score(int x)
    {
        this.score=x;
        this.setText(Integer.toString(score));
        this.setFill(Color.WHITE);
        this.setScaleX(2);
        this.setScaleY(2);
        this.setLayoutX(490);
        this.setLayoutY(20);
    }
    
    /** set the score component on the screen
     * @param x  score
     * @param xc  x coordinate
     * @param yc  y coordinate
     * @param s  scale */
    score(int x,int xc,int yc,int s)
    {
        this.score=x;
        this.setText(Integer.toString(score));
        this.setFill(Color.WHITE);
        this.setScaleX(s);
        this.setScaleY(s);
        this.setLayoutX(xc);
        this.setLayoutY(yc);
    }
    
}
