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
 *@author dikshant sagar, mukul kumar
 * @version Snake Vs Block Game AP Project
 * 
 * Parent Component class for GUI components like Ball, Block, etc 
 * 
 */
public class Component extends StackPane implements Serializable
{
	
	/** ry and rx gives the coordinated of the component*/
	  
    protected double ry;
    protected double rx;
    
<<<<<<< HEAD
    /** Get the y component of componen
     * @return t*/
=======
    /** Get the y component of component*/
>>>>>>> ff52a881dadf2717db4578383938414fc9172487
    protected double gety()
    {
        return this.ry;
    }
    
<<<<<<< HEAD
    /** Get the y component of componen
     * @return t*/
=======
    /** Get the y component of component*/
>>>>>>> ff52a881dadf2717db4578383938414fc9172487
    protected double getx()
    {
        return this.rx;
    }
    
    /**Main destroy function for all GUI components
	 * 
	 */
    protected void destroy()
    {
    	
        
        this.setScaleX(0);
        this.setScaleY(0);
    }
    
    
}
