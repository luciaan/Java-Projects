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

public class UserPanel extends JPanel implements KeyListener, ActionListener, JavaArcade {

	private int[] locx = {40, 220, 400, 580, 760};
	private EnemyCar[] cars;
	private int numCars;
	public int score;
	private int speed;
	public static int highScore;
	public boolean gameIsRunning;
	
	private Player player;
	
	private javax.swing.Timer timer;
   	private javax.swing.Timer enemyTimer;

    public UserPanel(Color backColor) {
    	
    	player = new Player(400, 790, 100, 100, Color.black);
    	
    	timer = new javax.swing.Timer(5, this);
     	score = 0;
     	highScore = 0;
     	gameIsRunning = false;
     	speed = 3;
    
	    enemyTimer = new javax.swing.Timer(2000, new EnemyAnimationListener());
	     
	    addKeyListener(this);
	    addMouseMotionListener(new PanelMotionListener());
	      
	      
	    this.setFocusable(true);
	    this.setFocusTraversalKeysEnabled(false);      
	    this.setBackground(backColor);
    }
    
    public void actionPerformed (ActionEvent e){
    		for(int i = 0; i< numCars; i++)
    			cars[i].setLocation(0, 1);
    		
    		for(int i = 0; i<numCars; i++)
    		{
    			if(collision(cars[i])== true)
    				player.setColor(Color.red);
    		}
    		
    		score += 5;
    			
    		repaint(); 
   	  }
   	  
   	public boolean collision(EnemyCar e)
   	{
   		if(((((player.getY() <= (e.getY() + e.getHeight()-1)) && (player.getX() >= e.getX() && player.getX() <= e.getX()+e.getWidth()))) || ((player.getY() <= (e.getY() + e.getHeight()-1)) && (player.getX() + player.getWidth() >= e.getX() && player.getX()+player.getWidth() <= e.getX()+e.getWidth())))&& e.getColor()!=Color.red )
   			return true;
   		else
   			return false;	
   	}
   	
   	private class EnemyAnimationListener implements ActionListener{
   
   	  public void actionPerformed (ActionEvent e){
   	  	
   	  	numCars = (int)(Math.random()*4)+1;
   	  	cars = new EnemyCar[numCars];
   	  	
   	  	
   	  	int num = 5;
   	  	ArrayList<Integer> loc = new ArrayList<Integer>(5);
   	  	for (int a = 0; a < 5; a++)
   	  		loc.add(a);
   	  	
   	  	for(int i = 0; i < numCars; i++)
   	  	{
   	  		int randCar = ((int)(Math.random() * 3));
   	  		int ranLoc = (int)(Math.random() * num);
                 switch (randCar)
                 {
                     case 0: 
                     	cars[i] = new Truck(locx[loc.get(ranLoc)], speed); 
                     		break;
                     case 1: 
                     	cars[i] = new SportsCar(locx[loc.get(ranLoc)], speed); 
                     		break; 
                     case 2: 
                     	cars[i] = new RegularCar(locx[loc.get(ranLoc)], speed); 
                     		break;
                 }

   	  		loc.remove(ranLoc);
   	  		num--;
   	  	}
   	  	speed++;
   	  	
   	  	
   	  	

   	  }
   	}
   	private class PanelMotionListener extends MouseMotionAdapter{//mouse dragged action that controls where slider is

      public void mouseDragged(MouseEvent e){
				if(running()) //don't allow hero to move if not started            
         player.setLocation(e.getX(), 0);                

      }
   }
   	  
   	public void keyTyped(KeyEvent e) { }
  	public void keyReleased(KeyEvent e) 
  		{ 
  			if (e.getKeyCode()== KeyEvent.VK_SPACE)
  				startGame();
  		} 
  		 
  	public void keyPressed(KeyEvent e){
  		switch(e.getKeyCode())
	    {
	      case KeyEvent.VK_ENTER://actions performed if enter key is pressed
	      	startGame();
	      	break;
	      	
	      case KeyEvent.VK_A: //move left
	      	player.setLocation(player.getX(), 1);
	      	break;
	      	
	      case KeyEvent.VK_D: //move right
	      	player.setLocation(player.getX(), -1);
	      	break;
	      	
	      case KeyEvent.VK_SPACE://actions performed if enter key is pressed
	      	pauseGame();
	      	break;
	      	   
	      case KeyEvent.VK_ESCAPE://actions performed if escape key is pressed
	      	stopGame();
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
      
      int fontSize = 20;
	    g.setColor(Color.black);
	    g.setFont(new Font("Courier", Font.PLAIN, fontSize));
	  
      if(!running())
      {
      	g.drawString(getInstructions().substring(0, 37), 300, 400);
      	g.drawString(getInstructions().substring(38, 73), 300, 420);
      	g.drawString(getInstructions().substring(74, 110), 300, 440);
      	g.drawString(getInstructions().substring(111, 145), 300, 460);
      	g.drawString(getInstructions().substring(145, 183), 300, 480);
      	g.drawString(getInstructions().substring(184, 223), 300, 500);
      	g.drawString(getInstructions().substring(223), 300, 520);
      }
      
      if(player.getColor() == Color.red)
      {
      	g.drawString("You Lose ", 400, 450);
      	g.drawString(getCredits(), 250, 470);
      	stopGame();
      }
      
      g.drawString("points: " + getPoints(), 700, 50);
      
  	}
  	
  	public String getGameName() {
		return "Dodge Traffic";
	}

	public String getInstructions() {
		return "The Rules: You play as the lower car. There are other cars coming at you."
				+ " Move out of the way by dragging your car left and right on the screen."
				+ " If one of the cars hits you, you lose. Survive as long as you can. Good luck!"
				+ " Press Space to start and hold it to pause." ;
	}

	public String getCredits() {
		return "The Creators: Vibhav, Andrew, and Tushar";
	}

	public String getHighScore() {
		highScore = Math.max(score, highScore);
		return "High Score is " + highScore;
	}

	public int getPoints() {
		return score;
	}

	public void startGame() {
		this.gameIsRunning = true;
		timer.start();
		enemyTimer.start();
	}
	
	public void stopGame(){
		this.gameIsRunning = false;
		timer.stop();
		enemyTimer.stop();
	}
	
	public void pauseGame(){
		timer.stop();
		enemyTimer.stop();
	}

	public boolean running() {
		return gameIsRunning;
	}
  	
    
    
}