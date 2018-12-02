/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

/**
 *
 * @author dikshant
 */
public class test extends StackPane
{
    test() throws FileNotFoundException
    {
        Canvas canvas = new Canvas(520,700);
        this.getChildren().add(canvas);
        GraphicsContext gc=canvas.getGraphicsContext2D();
        Image earth = new Image(new FileInputStream("./src/game/mag.png"));
        final long startNanoTime = System.nanoTime();
        new AnimationTimer()
    {
        public void handle(long currentNanoTime)
        {
            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
 
            double x = 232 + 128 * Math.cos(t);
            double y = 232 + 128 * Math.sin(t);
 

            gc.drawImage( earth, x, y );

        }
    }.start();
    }
}
