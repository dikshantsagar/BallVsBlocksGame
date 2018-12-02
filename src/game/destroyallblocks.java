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
public class destroyallblocks extends Component implements Serializable
{
    destroyallblocks(int i) throws FileNotFoundException
    {
         Random rand=new Random();
        this.rx=rand.nextInt(4)*120+35;
        this.ry=(rand.nextInt(2000)*(-1)*(i+1)*4);
        Image image = new Image(new FileInputStream("./src/game/bomb.png"));
        ImageView base = new ImageView(image);
        base.setScaleX(0.2);
        base.setScaleY(0.2);
        this.getChildren().add(base);
        this.setTranslateX(rx);
        if(ry<0)
        {
            this.setTranslateY(ry);
        }
        else
        {
            this.setTranslateY(-3000);
        }
    
    }
}
