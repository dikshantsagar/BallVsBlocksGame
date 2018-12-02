/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
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
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
  *@author dikshant sagar, mukul kumar
 * @version Snake Vs Block Game AP Project
 * 
 * gameover class
 * Shows on the screen when the game is over.
 * Contains functions which Handles mouse event
 */
public class gameover extends AnchorPane{
	
	/** Gameover function which shows the window when the game is over. */
<<<<<<< HEAD
    protected Color co;
=======
>>>>>>> ff52a881dadf2717db4578383938414fc9172487
    
    gameover(int sc,Color co) throws FileNotFoundException, IOException, ClassNotFoundException{
    
        this.co=co;
        Image image = new Image(new FileInputStream("./src/game/logo.png"));
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(170);
        imageView.setLayoutY(20);
        imageView.setScaleX(0.7);
        imageView.setScaleY(0.7);
        Text h=new Text("GAME OVER");
        h.setFill(WHITE);
        h.setLayoutX(210);
        h.setLayoutY(250);
        h.setScaleX(4.5);
        h.setScaleY(4.5);
        score sco=new score(sc,250,330,4);
        Button btn1=new Button("RESTART");
        btn1.setStyle("-fx-font: 30 arial; -fx-base: #ee2211;");
        btn1.setLayoutX(160);
        btn1.setLayoutY(380);
        Button btn2=new Button("HOME");
        btn2.setStyle("-fx-font: 30 arial; -fx-base: #ee2211;");
        btn2.setLayoutX(190);
        btn2.setLayoutY(460);
        this.getChildren().addAll(imageView,h,btn1,btn2,sco);
        this.setId("pane");
        
        FileInputStream r=new FileInputStream("scores.txt");
        ObjectInputStream in=new ObjectInputStream(r);
        ArrayList<Integer> t=(ArrayList<Integer>)in.readObject();
        t.add(sc);
        r.close();
        Collections.sort(t);
        Collections.reverse(t);
        FileOutputStream fin = new FileOutputStream("scores.txt");
        ObjectOutputStream out=new ObjectOutputStream(fin);
        out.writeObject(t);
        out.close();
        
        System.out.println(t);
        
        /** Mosue event handler 
         * @param mouseevent  takes in mouse_clicked event and hhandles it */
        
         btn1.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
               
                try 
                {
                    
                    AnchorPane newgame=new gameplay(0,4,co);
                    newgame.setId("fpane");
                    Scene scene =getScene();
                    scene.setRoot(newgame);
               
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(gameover.class.getName()).log(Level.SEVERE, null, ex);
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
               
                try 
                {
                    
                    Home H=new Home();
                    H.setId("fpane");
                    Scene scene =getScene();
                    scene.setRoot(H);
               
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(gameover.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
}
