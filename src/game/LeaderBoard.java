/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author dikshant
 */
public class LeaderBoard extends AnchorPane implements Serializable
{
    LeaderBoard()
    {
        Text head=new Text("-- Leader Board --");
        head.setFill(Color.WHITE);
        head.setScaleX(3);
        head.setScaleY(3);
        head.setLayoutX(200);
        head.setLayoutY(100);
        this.getChildren().add(head);
        
        Text dum=new Text("1. Name   ------ Score");
        dum.setLayoutX(150);
        dum.setLayoutY(200);
        dum.setScaleX(2);
        dum.setScaleY(2);
        dum.setFill(Color.WHITE);
        this.getChildren().add(dum);
        
        
        Button b=new Button("<-Back");
        this.getChildren().add(b);
        
        
    }
}
