import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class mainPanel extends JPanel{
	
	public boolean draw, erase, threeDShape;
	private final int SIZE_OF_DOTS = 20; // size of pen dots
	private ArrayList<mainPanel.colorTracker> track; //array for tracking motion 
	public Color pen = Color.red; //sets initial pen color to red 
	Point delete; //deletes points 
	
	public mainPanel() {
		setPreferredSize(new Dimension(300,200)); //drawing panel 300x200
		setBackground(Color.white); //background color of panel is white
		
		mainPanel.PaintListener listener = new mainPanel.PaintListener();
		addMouseListener(listener); 
		addMouseMotionListener(listener); //reads mouse movement 
	
		this.track = new ArrayList(); //track using array list
		this.delete = new Point(); //delete points
		this.erase = false; //boolean erase is false initially 
		this.draw = false; //boolean draw false initially 
	}
	public void paintComponent(Graphics panel) { //invokes paint component method
		super.paintComponent(panel);
		for (mainPanel.colorTracker p : this.track) //for loops repeats according to mouse movement 
	    {
	      panel.setColor(p.color); // color of user choice
	      panel.fillOval(p.point.x, p.point.y, SIZE_OF_DOTS, SIZE_OF_DOTS); //fill dots with set paramters 
	    }
		if(this.erase) { //erases pen 
			panel.drawOval(this.delete.x, this.delete.y, SIZE_OF_DOTS, SIZE_OF_DOTS);
			panel.setColor(Color.black);  //color of eraser circle
		}
		if(this.threeDShape) { //turns drawing to 3D rectangles 
			for (mainPanel.colorTracker p : this.track){
			panel.setColor(p.color); //sets colors to user defined
			panel.fill3DRect(p.point.x, p.point.y, SIZE_OF_DOTS, SIZE_OF_DOTS, true); //draws rectangles with set parameters 
			}
		}
	}
		public void clear() { //clears entire workspace 
			this.track = new ArrayList();
			repaint(); //repaint method empties panel 
		}
		private class PaintListener implements MouseListener, MouseMotionListener{ //invoke mouse listener 
			 private PaintListener() {}
			    
			    public void mousePressed(MouseEvent event) {}
			    
			    public void mouseClicked(MouseEvent event) { //draw if mouse clicked 
			      mainPanel.this.draw = (!mainPanel.this.draw);
			    }
			    
			    public void mouseReleased(MouseEvent event) {}
			    
			    public void mouseDragged(MouseEvent event) {}
			    
			    public void mouseEntered(MouseEvent event) {}
			    
			    public void mouseExited(MouseEvent event) {}
			    
			    public void mouseMoved(MouseEvent event) { //if mouse moved, draw points
			    	
			      if (mainPanel.this.draw) {
			        Point p = event.getPoint();
			        mainPanel.this.track.add(new mainPanel.colorTracker(mainPanel.this.pen, p));
			        mainPanel.this.repaint();
			      }
			      if(mainPanel.this.erase) {
			    	  mainPanel.this.delete = event.getPoint();
			      }
			 }
		}
			private class colorTracker { // color and point class used as input
				private Color color;
				private Point point;
				
				public colorTracker(Color color, Point point) {//color and point method
					this.color = color;
					this.point = point;
			}
		}
	}