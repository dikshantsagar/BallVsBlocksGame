/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
  *@author dikshant sagar, mukul kumar
 * @version Snake Vs Block Game AP Project
 * 
 * LeaderBoard class
 * LeaderBoard page contains the details of the top scorers of the game.
 * The names are in a arrayList. 
 */
public class LeaderBoard extends AnchorPane implements Serializable
{
	/** Creates leaderboard and put top 10 high scores in the arraylist and show them in a table*/
    LeaderBoard() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        Button head=new Button("Leader Board");
        head.setStyle("-fx-font: 30 arial; -fx-base: #ee2211;");
        head.setLayoutX(130);
        head.setLayoutY(100);
        this.getChildren().add(head);
        FileInputStream r=new FileInputStream("scores.txt");
        ObjectInputStream in=new ObjectInputStream(r);
        ArrayList<Integer> scores=(ArrayList<Integer>)in.readObject();
        r.close();
        ArrayList<Text> pr=new ArrayList<Text>(10);
        System.out.println(scores.get(0));
        for(int i=0;i<10;i++)
        {
            pr.add(new score());
        }
        
        for(int i=0;i<10;i++)
        {
            pr.get(i).setText(i+".  ----------------->  "+Integer.toString(scores.get(i)));
            pr.get(i).setLayoutX(170);
            pr.get(i).setLayoutY(220+i*30);
            this.getChildren().add(pr.get(i));
        }
        
        
        
        Button b=new Button("<");
        b.setStyle("-fx-font: 30 arial; -fx-base: #ee2211;");
        this.getChildren().add(b);
        
        /** Mosue event handler 
         * @param mouseevent  takes in mouse_clicked event and handles it */
        
        b.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
               AnchorPane lead;
                try {
                    lead = new Home();
                    lead.setId("lpane");
                    Scene scene=getScene();
                    scene.setRoot(lead);
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
               
               
            }
        });
        
        
    }
}
