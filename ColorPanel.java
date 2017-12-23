/**
 * @(#)UserPanel.java
 *
 *
 * @author 
 * @version 1.00 2017/3/14
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ColorPanel extends JPanel implements KeyListener, ActionListener {

	private int[] locx = {40, 220, 400, 580, 760};
	private EnemyCar[] cars;
	private int numCars;
	
	private Player player;
	
	private javax.swing.Timer timer;
   	private javax.swing.Timer enemyTimer;

    public ColorPanel(Color backColor) {
    	
    	player = new Player(400, 790, 100, 100, Color.black);
    	
    	timer = new javax.swing.Timer(5, this);
     
    
	    enemyTimer = new javax.swing.Timer(10000, new EnemyAnimationListener());
	     
	    addKeyListener(this);
	      
	      
	    this.setFocusable(true);
	    this.setFocusTraversalKeysEnabled(false);      
	    this.setBackground(backColor);
    }
    
    public void actionPerformed (ActionEvent e){
    		for(int i = 0; i< numCars; i++)
    			cars[i].setLocation(0, 0);
    		
    		for(int i = 0; i<numCars; i++)
    		{
    			if(collision(cars[i])== true)
    				timer.stop();
    		}
    			
    		repaint(); 
   	  }
   	  
   	public boolean collision(EnemyCar e)
   	{
   		if(((player.getY() >= (e.getY() + e.getHeight()-1)) || (player.getX()+1 >= (e.getWidth() + e.getX()))) || ((player.getX() + player.getWidth()) <= e.getX()+1))
   			return true;
   		else
   			return false;
 			
   	}
   	
   	private class EnemyAnimationListener implements ActionListener{
   
   	  public void actionPerformed (ActionEvent e){
   	  	
   	  	numCars = (int)(Math.random()*5);
   	  	cars = new EnemyCar[numCars];
   	  	
   	  	
   	  	
   	  	ArrayList<Integer> loc = new ArrayList<Integer>(5);
   	  	for (int a = 0; a < 5; a++)
   	  		loc.add(a);
   	  	
   	  	for(int i = 0; i < numCars; i++)
   	  	{
   	  		int ranLoc = (int)(Math.random() *5);
   	  		cars[i] = new EnemyCar(locx[loc.get(ranLoc)], 0, 100, 100, Color.black, 3);
   	  		loc.remove(ranLoc);
   	  	}
   	  	
   	  	
   	  	

   	  }
   	}
   	  
   	public void keyTyped(KeyEvent e) { }
  	public void keyReleased(KeyEvent e) { } 
  		 
  	public void keyPressed(KeyEvent e){
  		switch(e.getKeyCode())
	    {
	      case KeyEvent.VK_ENTER://actions performed if enter key is pressed
	      	timer.start();
	      	enemyTimer.start();
	      	break;
	      	
	      case KeyEvent.VK_A: //move left
	      	player.setLocation(player.getX(), 1);
	      	break;
	      	
	      case KeyEvent.VK_D: //move right
	      	player.setLocation(player.getX(), -1);
	      	break;
	      	
	      case KeyEvent.VK_SPACE://actions performed if enter key is pressed
	      	timer.start();
	      	break;
	      	   
	      case KeyEvent.VK_ESCAPE://actions performed if escape key is pressed
	        System.exit(0);
	       	break;
	       	
	      default:
	      	
       }
  	}
  	
  	public void paintComponent(Graphics g){
  
      super.paintComponent(g);
      
      player.draw(g);
      for(int i = 0; i< numCars; i++)
      	cars[i].draw(g);
      
      
  	}
  	
    
    
}