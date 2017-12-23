/**
 * Abstract class for an object that shoots.  Abstract methods include draw and shoot
 * 
 * @version 1.00 2016/2/7
 */
import java.awt.*;
import java.util.ArrayList;

public abstract class Car extends javax.swing.JPanel {
   
   
   private int cornerX, cornerY; //top left corner of shooter
   private int height, width; //width and height of shooter
   private Color color; //color of shooter
    
   
    public Car(int x, int y, int w, int h, Color c) {
    	cornerX = x;
    	cornerY = y;
    	height = h;
    	width = w;
    	color = c;
       	
    }
    
    public Color getColor(){
    	return color;
    }
    
    public void setColor(Color c){
    	color = c;
    }

   public int getHeight(){
   	  return height;
   }
   
   public void setHeight(int h)
   {
   	height = h;
   }
   
   public void setWidth(int w)
   {
   	width = w;
   }
   
   public int getWidth(){
   	  return width;
   }
   
   public int getX(){
   	  return cornerX;
   }
   
   public int getY(){
   	  return cornerY;
   }
   
   public void setX(int x){
   	  cornerX = x;
   }
   
   public void setY(int y){
	   	  cornerY = y;
	   }
  
 
   //Must be defined by child classes
    public abstract void draw(Graphics g);
    public abstract void setLocation(int x, int m);

}
 