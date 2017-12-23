import java.awt.*;
import java.util.ArrayList;

public class EnemyCar extends Car {

	private final boolean movesDown = true;
	private int speed; // value determines how much x is increased by on a move
						// call

	public EnemyCar(int x, int y, int w, int h, Color c, int s) {

		super(x, y, w, h, c);

		speed = s;

	}
	
	public void setSpeed(int s)
	{
		speed = s;
	}

	// Basic Enemy looks like a rectangle
	public void draw(Graphics g) {

		g.setColor(getColor());

		g.fillRect(getX(), getY(), getWidth(), getHeight());

	}

	/*
	 * The move method is called every time the timer goes off (currently every
	 * 50ms) - checkStats() is called at which point both enemies move method is
	 * called. They appear to move at different speeds because of the way the
	 * xVal value is updated. It is increased/decreased by the speed value. For
	 * the Circle Enemy, the speed was set to 3 in the constructor. For the
	 * basic Enemy, the speed is 10
	 */

	public void setLocation(int x, int w) {
		int yVal = getY();

		if (movesDown)
			yVal += speed;
		else
			yVal -= speed;

		if (getY()>= 900) {
			this.setColor(Color.red);
		}

			setY(yVal); // Sets the yPosition of the enemy so that when enemy is
						// drawn this is the yPos of the left corner

	}

}
