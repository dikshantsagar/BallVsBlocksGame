/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author dikshant
 */
public class shield extends Component implements Serializable
{
    
    shield(int i) throws FileNotFoundException
    {
         Random rand=new Random();
        this.rx=rand.nextInt(480)+20;
        this.ry=(rand.nextInt(2000)*(-1)*(i+1))-100;
        Image image = new Image(new FileInputStream("./src/game/shield.png"));
        ImageView base = new ImageView(image);
        //base.setScaleX(0.2);
        //base.setScaleY(0.2);
        this.getChildren().add(base);
        this.setTranslateX(rx);
        this.setTranslateY(ry);
    }
}
