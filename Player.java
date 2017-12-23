import java.awt.*;
import java.util.ArrayList;

	public class Player extends Car{
	 
	   private static int panelWidth; //All enemies will share this information
	   private static int panelHeight;
	   private final boolean movesDown = true;
	   private final int speed = 20; //value determines how much x is increased by on a move call
	   
	   public Player(int x, int y, int w, int h, Color c) {
	    
	    	super(x, y, w, h, c);	   
	    	     
	    
	    }
	   
	   
	    
	    public static void setPanelWidth(int w)
	    {
	    	panelWidth = w;
	    }
	    
	    public static void setPanelHeight(int h)
	    {
	    	panelHeight = h;
	    }
	    
	  
	    
	    
	    //Basic Enemy looks like a rectangle
	    public void draw(Graphics g){
	      
	      g.setColor(getColor());
	      
	      g.fillRect(getX(), getY(), getWidth(), getHeight());
	       
	     
	   }
	   
	    
	  
	 /* The move method is called every time the timer goes off (currently every 50ms) -
	  * checkStats() is called at which point both enemies move method is called.  
	  * They appear to move at different speeds because of the way the xVal value is updated.
	  * It is increased/decreased by the speed value.  For the Circle Enemy, the speed was set
	  * to 3 in the constructor.  For the basic Enemy, the speed is 10 */

	    public void setLocation(int x, int m){//moves side to side
      		setX(x - (speed * m));
      
   		}
	    
	    
	   
	   
	}
	 
	

