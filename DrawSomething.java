//Jose Mora
//CIS 255
//11-15-2015
//GUI color tracker 
//Project 6

import java.awt.*;
import javax.swing.*;

public class DrawSomething extends JFrame{ //main frame 
	public static void main(String[] args) {
		
	JFrame f = new JFrame("Start Drawing"); //top title 
	mainPanel mainPanel = new mainPanel();
	GUI GUI = new GUI(mainPanel);
	
	f.setVisible(true); //set visibility 
	f.getContentPane().setLayout(new BorderLayout()); //set to border layout
	f.setSize(700,700); //size of frame is 700x700
	f.getContentPane().add(GUI, "South"); //option panel on bottom
	f.getContentPane().add(mainPanel, "Center"); //drawing panel in the middle
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}
