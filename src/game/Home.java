/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.text.Text;

/**
 *
  *@author dikshant sagar, mukul kumar
 * @version Snake Vs Block Game AP Project
 * 
 * Home Class
 * The homepage/start page of the game.
 */
public class Home extends AnchorPane

<<<<<<< HEAD
{   
    protected Color co;
=======
{
>>>>>>> ff52a881dadf2717db4578383938414fc9172487
	/** Create home page*/
    Home() throws FileNotFoundException
    {
        Text h=new Text("Snake V/s Blocks");
        h.setFill(WHITE);
        h.setLayoutX(210);
        h.setLayoutY(250);
        h.setScaleX(4.5);
        h.setScaleY(4.5);
        ComboBox cb = new ComboBox();
        cb.setLayoutX(330);
        cb.setLayoutY(350);
        cb.getItems().add("YELLOW");
        cb.getItems().add("GREEN");
        cb.getItems().add("RED");
        cb.getItems().add("BLUE");
        cb.getItems().add("CYAN");
        cb.getItems().add("BROWN");
        Text n=new Text("IIIT DELHI");
        n.setFill(WHITE);
        n.setLayoutX(230);
        n.setLayoutY(600);
        n.setScaleX(2);
        n.setScaleY(2);
        Image image = new Image(new FileInputStream("./src/game/logo.png"));
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(170);
        imageView.setLayoutY(20);
        imageView.setScaleX(0.7);
        imageView.setScaleY(0.7);
        Button btn1=new Button("START");
        btn1.setStyle("-fx-font: 30 arial; -fx-base: #ee2211;");
        btn1.setLayoutX(180);
        btn1.setLayoutY(330);
        Button btn2=new Button("LEADERBOARD");
        btn2.setStyle("-fx-font: 30 arial; -fx-base: #ee2211;");
        btn2.setLayoutX(120);
        btn2.setLayoutY(420);
        this.getChildren().addAll(n,h,btn1,btn2,imageView,cb);
        this.setId("pane");
        
        btn1.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>()
        {
        	/** event handles
        	 * @param e    mouse event e */
            @Override
            public void handle(MouseEvent e)
            {
               
                try {
                    AnchorPane game = new gameplay(0,4,co);
                    game.setId("pane");
                    Scene scene=getScene();
                    scene.setRoot(game);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }

               
               
            }
        });
        
        /** event handles
    	 * @param e    mouse event e */
         btn2.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
               AnchorPane lead;
                try {
                    lead = new LeaderBoard();
                    lead.setId("lpane");
                    Scene scene=getScene();
                    scene.setRoot(lead);
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
               
               
            }
        });
         
       
         
          cb.valueProperty().addListener(new ChangeListener<String>() {
        @Override public void changed(ObservableValue ov, String t, String t1) {
          System.out.println(ov);
            System.out.println(t);
            System.out.println(t1);
            String col=(String)cb.getValue();
               if(col.equals("YELLOW"))
               {
                   co=Color.YELLOW;
               }
               else if(col.equals("YELLOW"))
               {
                   co=Color.YELLOW;
               }
               else if(col.equals("RED"))
               {
                   co=Color.RED;
               }
               else if(col.equals("GREEN"))
               {
                   co=Color.GREEN;
               }
               else if(col.equals("BLUE"))
               {
                   co=Color.BLUE;
               }
               else if(col.equals("CYAN"))
               {
                   co=Color.CYAN;
               }
               else if(col.equals("BROWN"))
               {
                   co=Color.BROWN;
               }
               
               
            
        }    
    });
         
         

    }
}
