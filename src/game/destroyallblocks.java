
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
 *@author dikshant sagar, mukul kumar
 * @version Snake Vs Block Game AP Project
 * destroyallblocks class. 
 * Destroys all the blocks present on the screen at a given time.
 */
public class destroyallblocks extends Component implements Serializable


/**
 *  Destroys all blocks
 *  @param  i       i is a dummy ineteger to decide the position and after how much time a destroyblock component will occur
 */
{
    destroyallblocks(int i) throws FileNotFoundException
    {
         Random rand=new Random();
        this.rx=rand.nextInt(4)*120+35;
        this.ry=(rand.nextInt(2000)*(-1)*(i+1)*4)-1000;
        //this.ry=rand.nextInt(3000);
        Image image = new Image(new FileInputStream("./src/game/bomb.png"));
        ImageView base = new ImageView(image);
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
