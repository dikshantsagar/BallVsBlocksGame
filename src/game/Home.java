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
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.text.Text;

/**
 *
 * @author dikshant
 */
public class Home extends AnchorPane
{
    Home() throws FileNotFoundException
    {
        Text h=new Text("Snake V/s Blocks");
        h.setFill(WHITE);
        h.setLayoutX(210);
        h.setLayoutY(250);
        h.setScaleX(4.5);
        h.setScaleY(4.5);
        Text n=new Text("by : Dikshant Sagar & Mukul Kumar");
        n.setFill(WHITE);
        n.setLayoutX(150);
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
        this.getChildren().addAll(n,h,btn1,btn2,imageView);
        this.setId("pane");
        
        btn1.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
               
                try {
                    AnchorPane game = new gameplay(0,4);
                    game.setId("pane");
                    Scene scene=getScene();
                    scene.setRoot(game);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }

               
               
            }
        });
        
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

    }
}
