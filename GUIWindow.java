// displays all of the things happening in the colorpanel
//@author A Lucia

import javax.swing.*;
import java.awt.*;

public class GUIWindow {


	public static void main(String[] args) {
	
						JFrame theGUI = new JFrame();
						theGUI.setTitle("GUI Program");
						theGUI.setSize(900, 900);
						theGUI.setResizable(false);
						theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						UserPanel panel = new UserPanel(Color.white);
						Container pane = theGUI.getContentPane();
						pane.setLayout(new GridLayout(1, 1));
						pane.add(panel);
						theGUI.setVisible(true);
						panel.requestFocus();
					
			}
		}
