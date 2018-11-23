/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author dikshant
 */
public class Game extends Application implements Serializable{
    
    public Scene scene;
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        
        
        AnchorPane root = new AnchorPane();
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
        root.getChildren().addAll(n,h,btn1,btn2,imageView);
        root.setId("pane");
        scene = new Scene(root,520,700);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("SNAKE V/S BLOCKS");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
        
        
        btn1.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
               AnchorPane game = null;
                try {
                    game = new gameplay();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
               game.setId("gpane");
               scene.setRoot(game);
               
            }
        });
        
         btn2.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
               AnchorPane lead=new LeaderBoard();
               lead.setId("lpane");
               scene.setRoot(lead);
               
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
