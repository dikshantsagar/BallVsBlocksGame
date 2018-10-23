package application;
	
import java.util.ArrayList;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import java.util.Random;


public class Main extends Application {
	
	 private double initX;
     private double initY;
     private double startx=250;
     private double starty=300;
     private int ballscore=10;
     
     private Group createboxes(int len)
     {
    	 	Random rand=new Random();
    	 	
    	 	int passblocknum=rand.nextInt(len)+1;
    	 	int bl1=rand.nextInt(60)+1;
    	 	int bl2=rand.nextInt(40)+1;
    	 	int pass=rand.nextInt(4);
    	 	
    	 	StackPane stack1=new StackPane();
		StackPane stack2=new StackPane();
		StackPane stack3=new StackPane();
    	 	
    	 	Rectangle b1=new Rectangle(1,1,100,100);
    	 	Rectangle b2=new Rectangle(200,1,100,100);
		Rectangle b3=new Rectangle(350,1,100,100);
		
		b1.setFill(Color.LIME);
		b2.setFill(Color.LIME);
		b3.setFill(Color.LIME);
	     b1.setArcHeight(20);
		 b1.setArcWidth(20);
		 
		 b2.setArcHeight(20);
		 b2.setArcWidth(20);
		 
		 b3.setArcHeight(20);
		 b3.setArcWidth(20);
		 
		 Text t1=new Text(Integer.toString(passblocknum));
		 t1.setScaleX(3);
		 t1.setScaleY(3);
		 
		 Text t2=new Text(Integer.toString(bl1));
		 t2.setScaleX(3);
		 t2.setScaleY(3);
		 
		 Text t3=new Text(Integer.toString(bl2));
		 t3.setScaleX(3);
		 t3.setScaleY(3);
		 
		 
    	 	
    	 	if(pass==0)
    	 	{
    	 		stack1.getChildren().addAll(b1,t1);
    			stack2.getChildren().addAll(b2,t2);
    			stack3.getChildren().addAll(b3,t3);
    			
    			stack1.setLayoutX(150);
   			stack1.setLayoutY(30);
   			
   			stack2.setLayoutX(270);
   			stack2.setLayoutY(30);
   			
   			stack3.setLayoutX(390);
   			stack3.setLayoutY(30);
    			
    	 	}
    	 	else if(pass==1)
    	 	{
    	 		stack1.getChildren().addAll(b1,t2);
    			stack2.getChildren().addAll(b2,t3);
    			stack3.getChildren().addAll(b3,t1);
    			
    				stack1.setLayoutX(30);
       			stack1.setLayoutY(30);
       			
       			stack2.setLayoutX(270);
       			stack2.setLayoutY(30);
       			
       			stack3.setLayoutX(390);
       			stack3.setLayoutY(30);
    	 	}
    	 	else if(pass==2)
    	 	{
    	 		stack1.getChildren().addAll(b1,t3);
    			stack2.getChildren().addAll(b2,t1);
    			stack3.getChildren().addAll(b3,t2);
    			
    				stack1.setLayoutX(30);
       			stack1.setLayoutY(30);
       			
       			stack2.setLayoutX(150);
       			stack2.setLayoutY(30);
       			
       			stack3.setLayoutX(390);
       			stack3.setLayoutY(30);
    	 	}
    	 	else
    	 	{
    	 		stack1.getChildren().addAll(b1,t3);
    			stack2.getChildren().addAll(b2,t2);
    			stack3.getChildren().addAll(b3,t1);
    			
    				
    				stack1.setLayoutX(30);
       			stack1.setLayoutY(30);
       			
       			stack2.setLayoutX(150);
       			stack2.setLayoutY(30);
       			
       			stack3.setLayoutX(270);
       			stack3.setLayoutY(30);
    	 	}
    	 	
    	 	Group ret =new Group(stack1,stack2,stack3);
    	 	
    	 	return ret;
    	 	
    	 	
     }

	public void start(Stage primaryStage) 
	{
	     Group root = new Group();
	     Scene scene = new Scene(root,520,400);
	     Sphere snake=new Sphere(35);
	     PhongMaterial material = new PhongMaterial();
	     material.setDiffuseColor(Color.YELLOW);
	     snake.setMaterial(material);
		 snake.setTranslateX(startx);
		 snake.setTranslateY(starty);
		 Text t=new Text(Integer.toString(ballscore));
		 t.setX(startx-5);
		 t.setY(starty+5);
		 t.setScaleX(1.2);
		 t.setScaleY(1.2);
		 
		 
				 
		
    	     snake.setCursor(Cursor.HAND);
    	     snake.setOnMouseDragged(new EventHandler<MouseEvent>() {
    	            public void handle(MouseEvent me) {
    	                double dragX = me.getSceneX();
    	                double dragY = me.getSceneY();
    	                //calculate new position of the circle
    	                double newXPosition = initX + dragX;
    	                double newYPosition = initY + dragY;
    	                	snake.setTranslateX(newXPosition-250);
    	                snake.setTranslateY(newYPosition-250);
    	                t.setX(newXPosition-5);
    	                t.setY(newYPosition+5);
    	            }
    	               
    	        });
    	     
    	     snake.setOnMousePressed(new EventHandler<MouseEvent>() {
    	            public void handle(MouseEvent me) {
    	                //when mouse is pressed, store initial position
    	                initX = snake.getTranslateX();
    	                initY = snake.getTranslateY();
    	            }
    	        });
	     
	     
	
			 StackPane stack1=new StackPane();
			 StackPane stack2=new StackPane();
			 StackPane stack3=new StackPane();
			 StackPane stack4=new StackPane();
			 
			 Text t1=new Text("23");
			 t1.setScaleX(3);
			 t1.setScaleY(3);
			 
			 Text t2=new Text("3");
			 t2.setScaleX(3);
			 t2.setScaleY(3);
			 
			 Text t3=new Text("41");
			 t3.setScaleX(3);
			 t3.setScaleY(3);
			 
			 Text t4=new Text("77");
			 t4.setScaleX(3);
			 t4.setScaleY(3);
			 
			 Rectangle b1=new Rectangle(1,1,100,100);
			 Rectangle b2=new Rectangle(200,1,100,100);
			 Rectangle b3=new Rectangle(350,1,100,100);
			 Rectangle b4=new Rectangle(500,1,100,100);
			 
			 b1.setFill(Color.LIME);
			 b2.setFill(Color.LIME);
			 b3.setFill(Color.LIME);
			 b4.setFill(Color.LIME);
			 
			 b1.setArcHeight(20);
			 b1.setArcWidth(20);
			 
			 b2.setArcHeight(20);
			 b2.setArcWidth(20);
			 
			 b3.setArcHeight(20);
			 b3.setArcWidth(20);
			 
			 b4.setArcHeight(20);
			 b4.setArcWidth(20);
			 
			 stack1.getChildren().addAll(b1,t1);
			 stack1.setLayoutX(30);
			 stack1.setLayoutY(30);
			 
			 stack2.getChildren().addAll(b2,t2);
			 stack2.setLayoutX(150);
			 stack2.setLayoutY(30);
			 
			 stack3.getChildren().addAll(b3,t3);
			 stack3.setLayoutX(270);
			 stack3.setLayoutY(30);
			 
			 stack4.getChildren().addAll(b4,t4);
			 stack4.setLayoutX(390);
			 stack4.setLayoutY(30);
			 
			 

			
			 
			 Group boxes=createboxes(ballscore);
			 root.getChildren().addAll(boxes,snake,t);
			 
			  Duration sec=Duration.millis(3500);
			  
		      TranslateTransition tr1 = new TranslateTransition(sec,stack1); 
		      tr1.setFromY(-200);
		      tr1.setToY(400);
		      tr1.setCycleCount(3); 
		      tr1.setAutoReverse(false);
		      tr1.play();

		      TranslateTransition tr2 = new TranslateTransition(sec,stack2); 
		      tr2.setFromY(-200);
		      tr2.setToY(400);
		      tr2.setCycleCount(3); 
		      tr2.setAutoReverse(false);
		      tr2.play();
		      
		      TranslateTransition tr3 = new TranslateTransition(sec,stack3); 
		      tr3.setFromY(-200);
		      tr3.setToY(400);
		      tr3.setCycleCount(3); 
		      tr3.setAutoReverse(false);
		      tr3.play();
		      
		      TranslateTransition tr4 = new TranslateTransition(sec,stack4); 
		      tr4.setFromY(-200);
		      tr4.setToY(400);
		      tr4.setCycleCount(3); 
		      tr4.setAutoReverse(false);
		      tr4.play();


	
		      
			
			scene.setFill(Color.BLACK);
			primaryStage.setScene(scene);
			primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
