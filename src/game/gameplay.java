/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.animation.TranslateTransitionBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author dikshant
 */
public class gameplay extends AnchorPane implements Serializable {
    
    
    private double initX;
    private Snake player;
    private score score;
    ArrayList<box> boxes=new ArrayList<box>();
    ArrayList<ball> balls=new ArrayList<ball>();
    ArrayList<wall> walls=new ArrayList<wall>();
    ArrayList<TranslateTransition> boxan = new ArrayList<TranslateTransition>(); 
    ArrayList<TranslateTransition> ballan = new ArrayList<TranslateTransition>();
    ArrayList<TranslateTransition> wallan = new ArrayList<TranslateTransition>();
    
    public void stopall()
    {
       
    }
    
    private Snake getplayer()
    {
        Snake player=new Snake();
        player.setCursor(Cursor.HAND);
    	     player.setOnMouseDragged(new EventHandler<MouseEvent>() {
    	            public void handle(MouseEvent me) {
    	                double dragX = me.getSceneX();
    	                double dragY = me.getSceneY();
    	                //calculate new position of the circle
    	                double newXPosition = initX + dragX;
                        if(newXPosition >10 && newXPosition <510)
    	                player.setLayoutX(newXPosition-300);
                        
                        for(int i=0;i<100;i++)
                        {
                            if(player.getBoundsInParent().intersects(balls.get(i).getBoundsInParent())){
                                
                                System.out.println("crashhh!!!");
                                player.addlen(balls.get(i).getnum());
                                balls.get(i).destroy();
                                
                                
                            }
                            if(player.getBoundsInParent().intersects(boxes.get(i).getBoundsInParent()))
                            {
                                
                                
                                {
                                    player.declen(boxes.get(i).getnum());
                                    score.setscore(boxes.get(i).getnum());
                                    boxes.get(i).destroy();
                                    
                                    System.out.println("boxed!");
                                }
                                
                            }
                            
                        }
                        
    	            }
    	               
    	        });
    	     
    	     this.setOnMousePressed(new EventHandler<MouseEvent>() {
    	            public void handle(MouseEvent me) {
    	                //when mouse is pressed, store initial position
    	                initX = player.getTranslateX();
                        player.setCursor(Cursor.CLOSED_HAND);
    	            }
    	        });
        
        return player;
    }

    gameplay()
    {   
        this.player=getplayer();
        this.score=new score();
        this.getChildren().addAll(player,score);
        
        
            
            ArrayList<TranslateTransition> boxan = new ArrayList<TranslateTransition>(); 
            ArrayList<TranslateTransition> ballan = new ArrayList<TranslateTransition>();
            ArrayList<TranslateTransition> wallan = new ArrayList<TranslateTransition>();
            Duration sec=Duration.millis(10000);
            Duration del=Duration.millis(16000);
            
            
            
            for(int i=0;i<100;i++)
            {   
                
                
                    boxes.add(new box(i));
                    balls.add(new ball(i));
                    walls.add(new wall(i));
                    this.getChildren().addAll(boxes.get(i),balls.get(i),walls.get(i));

                    boxan.add(new TranslateTransition(Duration.millis(10000+(-2)*boxes.get(i).gety()),boxes.get(i)));
                    boxan.get(i).setFromY(boxes.get(i).ry);
                    boxan.get(i).setToY(3000);
                    boxan.get(i).setCycleCount(1);
                    boxan.get(i).play();
                    //boxes.get(i).destroy();
                    
                    

                    ballan.add(new TranslateTransition(Duration.millis(10000+(-2)*balls.get(i).gety()),balls.get(i)));
                    ballan.get(i).setFromY(balls.get(i).ry);
                    ballan.get(i).setToY(3000);
                    ballan.get(i).setCycleCount(1);
                    ballan.get(i).play();
                    //balls.get(i).destroy();


                    wallan.add(new TranslateTransition(Duration.millis(10000+(-2)*walls.get(i).gety()),walls.get(i)));
                    wallan.get(i).setFromY(walls.get(i).ry);
                    wallan.get(i).setToY(3000);
                    wallan.get(i).setCycleCount(1);
                    wallan.get(i).play();
                    //walls.get(i).destroy();
                    
                }
           

            
            
            
            
        
    }
    
   
}
