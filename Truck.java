/*
 *Author: Andrew Lucia
 *largest enemy car
 */

import java.awt.Color;

public class Truck extends EnemyCar {

	public Truck (int x, int s) {
		super(x, 0, 100, 200, Color.gray, s-1);
	}
	
}
