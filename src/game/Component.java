/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.util.Stack;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

/**
 *
 * @author dikshant
 */
public class Component extends StackPane implements Serializable
{
    protected double ry;
    protected double rx;
    
    protected double gety()
    {
        return this.ry;
    }
    protected double getx()
    {
        return this.rx;
    }
    
    protected void destroy()
    {
        
        this.setScaleX(0);
        this.setScaleY(0);
    }
    
    
}
