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
 * @author dikshant
 */
public class score extends Text implements Serializable{
    int score;
    
    public void setscore(int x)
    {
        this.score+=x;
        this.setText(Integer.toString(score));
    }
    
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
    
}
