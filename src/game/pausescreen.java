/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
 * pausescreen class.
 * Will be in action when the pause button will be pressed.
 * Will give option to resume button.
 */
public class pausescreen extends AnchorPane
{
	/** Score and length of snake is recorded and stored*/
    protected int score;
    protected int len;
    protected Color co;
    
    /** Pause the screen
     * @param sc     score of user 
     * @param l      length of snake */
    pausescreen(int sc,int l,Color co) throws FileNotFoundException
    {
        this.co=co;
        this.score=sc;
        this.len=l;
        Image image = new Image(new FileInputStream("./src/game/logo.png"));
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(170);
        imageView.setLayoutY(20);
        imageView.setScaleX(0.7);
        imageView.setScaleY(0.7);
        Text h=new Text("GAME PAUSED !");
        h.setFill(WHITE);
        h.setLayoutX(210);
        h.setLayoutY(250);
        h.setScaleX(4.5);
        h.setScaleY(4.5);
        Button btn1=new Button("RESUME");
        btn1.setStyle("-fx-font: 30 arial; -fx-base: #ee2211;");
        btn1.setLayoutX(180);
        btn1.setLayoutY(330);
        Button btn2=new Button("RESTART");
        btn2.setStyle("-fx-font: 30 arial; -fx-base: #ee2211;");
        btn2.setLayoutX(175);
        btn2.setLayoutY(420);
        this.getChildren().addAll(imageView,h,btn1,btn2);
        this.setId("pane");
        
        /** Mosue event handler 
         * @param mouseevent  takes in mouse_clicked event and hhandles it */
        
        btn1.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
               
                AnchorPane regame;
                try {
                    regame = new gameplay(score,len,co);
                    regame.setId("pane");
                    Scene scene=getScene();
                    scene.setRoot(regame);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(pausescreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        /** Mosue event handler 
         * @param mouseevent  takes in mouse_clicked event and hhandles it */
        
        
         btn2.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>()
        {
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
    }
}
