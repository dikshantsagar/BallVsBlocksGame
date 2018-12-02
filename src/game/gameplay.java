/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.animation.TranslateTransitionBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.RED;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
  *@author dikshant sagar, mukul kumar
 * @version Snake Vs Block Game AP Project
 * 
 * gameplay class
 * The main gameplay where all the activities occur.
 * The game will run on this class. This class embeds all the GUI components and the score and the pause exit menu.
 */
public class gameplay extends AnchorPane implements Serializable {
    
	/** arraylist of boxes
	 * arraylist of balls
	 * arraylist of wall
	 * arraylist of magnet
	 * arraylist of destroyblock
	 * arraylist of shield
	 * */
    
    private double initX;
    private Snake player;
    private score score;
    protected Color co;
    protected ArrayList<box> boxes=new ArrayList<box>();
    protected ArrayList<ball> balls=new ArrayList<ball>();
    protected ArrayList<wall> walls=new ArrayList<wall>();
    protected ArrayList<magnet> mags=new ArrayList<magnet>();
    protected ArrayList<destroyallblocks> bombs=new ArrayList<destroyallblocks>();
    protected ArrayList<shield> sh=new ArrayList<shield>();
    
    protected ArrayList<TranslateTransition> boxan = new ArrayList<TranslateTransition>(); 
    protected   ArrayList<TranslateTransition> ballan = new ArrayList<TranslateTransition>();
    protected   ArrayList<TranslateTransition> wallan = new ArrayList<TranslateTransition>();
    protected   ArrayList<TranslateTransition> mag = new ArrayList<TranslateTransition>();
    protected   ArrayList<TranslateTransition> bomb = new ArrayList<TranslateTransition>();
    protected   ArrayList<TranslateTransition> sha = new ArrayList<TranslateTransition>();
   
    
    
    /** Gameover function
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException*/
    protected void stopall() throws IOException, FileNotFoundException, ClassNotFoundException
    {
       
        gameover root=new gameover(this.score.getscore(),co);
        Scene scene=getScene();
        root.setId("fpane");
        scene.setRoot(root);
        scene.setFill(RED);
        
    }
/**  get the playyer's infomation*/
    
    private Snake getplayer(int l,Color co)
    {
        Snake player=new Snake(l,co);
        player.setCursor(Cursor.HAND);
    	     player.setOnMouseDragged(new EventHandler<MouseEvent>() {
                        @Override
    	            public void handle(MouseEvent me) {
    	                double dragX = me.getSceneX();
    	                double dragY = me.getSceneY();
    	                //calculate new position of the circle
    	                double newXPosition = initX + dragX;
                        if(newXPosition >10 && newXPosition <510)
    	                player.setLayoutX(newXPosition-300);
                        
                        for(int i=0;i<10;i++)
                        {
                            
                        
                            if(player.getBoundsInParent().intersects(mags.get(i).getBoundsInParent()))
                                {
                                    System.out.println("mag");
                                    mags.get(i).destroy();
                                }
                            if(player.getBoundsInParent().intersects(bombs.get(i).getBoundsInParent()))
                                {
                                    System.out.println("mag");
                                    bombs.get(i).destroy();
                                    Scene scene=getScene();
                                try { 
                                    AnchorPane newgame=new gameplay(score.getscore(),player.getlen(),co);
                                    newgame.setId("fpane");
                                    scene.setRoot(newgame);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(gameplay.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                }
                            if(player.getBoundsInParent().intersects(sh.get(i).getBoundsInParent()))
                                {
                                    System.out.println("shield");
                                    sh.get(i).destroy();
                                    new Thread(new Runnable()
                                    {
                                        @Override
                                        public void run()
                                        {
                                            player.setshield();

                                            try {
                                                Thread.sleep(5000);
                                            } catch (InterruptedException ex) {
                                                Logger.getLogger(gameplay.class.getName()).log(Level.SEVERE, null, ex);
                                            }

                                            player.removeshield();
                                        }
                                    }).start();
                                    player.setshield();
                                }
                            if(player.getBoundsInParent().intersects(bombs.get(i).getBoundsInParent()))
                                {
                                    System.out.println("bomb");
                                    bombs.get(i).destroy();
                                }
                        }
                        for(int i=0;i<100;i++)
                        {
                            
                            if(player.getBoundsInParent().intersects(balls.get(i).getBoundsInParent()))
                            {
                                
                                System.out.println("crashhh!!!");
                                player.addlen(balls.get(i).getnum());
                                balls.get(i).destroy();
                                
                                
                            }
                            if(player.getBoundsInParent().intersects(boxes.get(i).getBoundsInParent()))
                            {
                                
                                if(boxes.get(i).blocknum<player.getlen())
                                {
                                    player.declen(boxes.get(i).getnum());
                                    score.setscore(boxes.get(i).getnum());
                                    boxes.get(i).destroy();
                                    
                                    System.out.println("boxed!");
                                }
                                else if(player.shieldalive()==true)
                                {
                                    boxes.get(i).destroy();
                                }
                                else
                                {
                                    
                                    try {
                                        stopall();
                                        
                                    } catch (IOException ex) {
                                        Logger.getLogger(gameplay.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (ClassNotFoundException ex) {
                                        Logger.getLogger(gameplay.class.getName()).log(Level.SEVERE, null, ex);
                                    }
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

    /** Main gameplay function
     * @param sc   score of user
     * @param l   length of the snake at a given time*/
    gameplay(int sc,int l,Color co) throws FileNotFoundException
    {   
        this.co=co;
        this.player=getplayer(l,co);
        this.score=new score(sc);
        Button btn1=new Button("| |");
        btn1.setStyle("-fx-font: 30 arial; -fx-base: #ee2211;");
        btn1.setLayoutX(20);
        btn1.setLayoutY(20);
        this.getChildren().addAll(player,score,btn1);
         btn1.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
               
                try {
                    AnchorPane pause=new pausescreen(score.getscore(),player.getlen(),co);
                    Scene scene =getScene();
                    scene.setRoot(pause);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
               
            }
        });
        
        
            
            
            
            
            
            
            
            int c=0;
            for(int i=0;i<100;i++)
            {   
                    if(i%4==0)
                    {
                        c+=1;
                    }
                
                    boxes.add(new box(c));
                    balls.add(new ball(i));
                    walls.add(new wall(c));
                    
                    this.getChildren().addAll(boxes.get(i),balls.get(i),walls.get(i));
                    System.out.println(balls.get(i).gety()/2000);
                    boxan.add(new TranslateTransition(Duration.seconds((boxes.get(i).gety()/2000)*-15),boxes.get(i)));
                    
                    boxan.get(i).setFromY(boxes.get(i).ry);
                    boxan.get(i).setToY(boxes.get(i).gety()*-1+1000);
                    boxan.get(i).setCycleCount(1);
                    boxan.get(i).play();
                    //boxes.get(i).destroy();
                    
                    

                    ballan.add(new TranslateTransition(Duration.seconds((balls.get(i).gety()/2000)*-15),balls.get(i)));
                    ballan.get(i).setFromY(balls.get(i).ry);
                    ballan.get(i).setToY(balls.get(i).gety()*-1+1000);
                    ballan.get(i).setCycleCount(1);
                    ballan.get(i).play();
                    //balls.get(i).destroy();


                    wallan.add(new TranslateTransition(Duration.seconds((walls.get(i).gety()/2000)*-15),walls.get(i)));
                    wallan.get(i).setFromY(walls.get(i).ry);
                    wallan.get(i).setToY(walls.get(i).gety()*-1+1000);
                    wallan.get(i).setCycleCount(1);
                    wallan.get(i).play();
                    //walls.get(i).destroy();
                    
                    
                    
                    
                       
                    
                    
                }
           
                for(int i=0;i<10;i++)
                {
                    mags.add(new magnet(i));
                    this.getChildren().add(mags.get(i));
                    mag.add(new TranslateTransition(Duration.seconds((mags.get(i).gety()/2000)*-15),mags.get(i)));
                    mag.get(i).setFromY(mags.get(i).ry);
                    mag.get(i).setToY(mags.get(i).gety()*-1+1000);
                    mag.get(i).setCycleCount(1);
                    mag.get(i).play();
                    
                    
                    bombs.add(new destroyallblocks(i));
                    this.getChildren().add(bombs.get(i));
                    bomb.add(new TranslateTransition(Duration.seconds((bombs.get(i).gety()/2000)*-15),bombs.get(i)));
                    bomb.get(i).setFromY(bombs.get(i).ry);
                    bomb.get(i).setToY(bombs.get(i).gety()*-1+1000);
                    bomb.get(i).setCycleCount(1);
                    bomb.get(i).play();
                    
                    sh.add(new shield(i));
                    this.getChildren().add(sh.get(i));
                    sha.add(new TranslateTransition(Duration.seconds((sh.get(i).gety()/2000)*-15),sh.get(i)));
                    sha.get(i).setFromY(sh.get(i).ry);
                    sha.get(i).setToY(sh.get(i).gety()*-1+1000);
                    sha.get(i).setCycleCount(1);
                    sha.get(i).play();
                }
                
              
            
            
            
        
    }
    
   
}
