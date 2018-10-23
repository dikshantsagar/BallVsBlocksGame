package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class snake
{
	snake(int len,int x,int y)
	{
		int xi=x;
		int yi=y;
		Circle[] c=new Circle[len];
		
		for(int i=0;i<len;i++)
		{
			c[i]=new Circle(20);
			 c[i].setFill(Color.YELLOW);
			 c[i].setCenterX(xi);
			 c[i].setCenterY(yi);
			 xi+=20;
			 yi+=20;
			 
		}
	}
}
