import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

public class GUI extends JPanel { //class is a JPanel

	JRadioButton Red, Blue, Green, Eraser; //RBG and erase buttons
	JButton clear, Relax, threeDShape; //clear space and draw 3D
	mainPanel bottomPanel;
 
	public GUI(mainPanel panel) {
		
		this.bottomPanel = panel;

		GUI.ButtonListener listener = new GUI.ButtonListener();
		ButtonGroup buttons = new ButtonGroup(); //Groups buttons together
		
		Red = new JRadioButton ("Red"); //Red color choice
		buttons.add(Red);
		Red.addActionListener(listener);
		add(Red);
		
	    Blue = new JRadioButton ("Blue"); //Blue color choice
	    buttons.add(Blue);
	    Blue.addActionListener(listener);
	    add(Blue);
	    
	    Green = new JRadioButton ("Green"); //Green color choice
	    buttons.add(Green);
	    Green.addActionListener(listener);
	    add(Green);
	    
	    Eraser = new JRadioButton("Eraser"); //erase colors 
	    buttons.add(Eraser);
	    Eraser.addActionListener(listener);
	    add(Eraser);
	    
	    threeDShape = new JButton("Click to draw 3D"); //Draws colors in 3D
	    buttons.add(threeDShape);
	    threeDShape.addActionListener(listener);
	    add(threeDShape);
	    
	    clear = new JButton("Clear"); // redo work space
	    buttons.add(clear);
	    clear.addActionListener(listener);
	    add(clear);
	    
	    Relax = new JButton("Relax"); // Coders Gonna Code
	    buttons.add(Relax);
	    Relax.addActionListener(listener);
	    add(Relax);
	   
	    
	    setBackground(Color.CYAN); //set panel to cyan color
		setVisible(true); // show visibility 
	}

	 public class ButtonListener implements ActionListener {
		ButtonListener() {}
		public void actionPerformed(ActionEvent e) {
		Object choice = e.getSource();
		if (choice == GUI.this.clear)  { //clear if button pressed
			GUI.this.bottomPanel.clear();
		}
		else if (choice == GUI.this.Red) {// change pen to red if pressed
			GUI.this.bottomPanel.pen = Color.red;
			GUI.this.bottomPanel.erase = false;
			GUI.this.bottomPanel.threeDShape = false;
			}
		else if (choice == GUI.this.Blue) { //change pen to blue if pressed 
			GUI.this.bottomPanel.pen = Color.blue;
			GUI.this.bottomPanel.erase = false;
			GUI.this.bottomPanel.threeDShape = false;
		}
		else if (choice == GUI.this.Green) { //change pen to Green if pressed 
			GUI.this.bottomPanel.pen = Color.GREEN;
			GUI.this.bottomPanel.erase = false;
			GUI.this.bottomPanel.threeDShape = false;
		}
		else if (choice == GUI.this.threeDShape) { //Change to 3D
			GUI.this.bottomPanel.erase = false;
			GUI.this.bottomPanel.threeDShape = true;
			}
		else if (choice == GUI.this.Eraser) { //Erase pen 
			GUI.this.bottomPanel.erase = true;
			GUI.this.bottomPanel.pen = Color.white;
			GUI.this.bottomPanel.threeDShape = false;
			}
		else if (choice == GUI.this.Relax) { //opens link
			try {
		        Desktop desktop=Desktop.getDesktop();
		       try {
				desktop.browse(new URI("http://40.media.tumblr.com/c5ce0bc865375c96ae6c77c38c109f8d/tumblr_ndwldyT6Uy1tbhzhno1_1280.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
				} finally {
					GUI.this.bottomPanel.erase = false;
					}
			} 
	 }
}
}