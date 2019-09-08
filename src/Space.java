import javax.swing.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/*
 * @author Nikko Osaka
 * @date 9/7/2019
 */
public class Space {
	private JFrame frame;
	private Panel panel;

	Space(String title, int width, int length){
		this.frame = new JFrame(title);
		this.frame.setSize(width, length);
		this.panel = new Panel(this.frame);
		this.frame.add(this.panel);
		this.frame.repaint();
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
	}

	public void addShape(Shape shape){
		if(shape != null){
			this.panel.addShape(shape);
		}
		update();
	}

	public void addShape(int id, int locX, int locY, int width, int height){
		Shape s = new Shape(id, this.panel.getHeight(), this.panel.getWidth(), locX, locY, width, height);
		this.panel.addShape(s);
		update();
	}

	public void addShape(int id, int locX, int locY, int radius){
		Shape s = new Shape(id, this.panel.getHeight(), this.panel.getWidth(), locX, locY, radius);
		this.panel.addShape(s);
		update();
	}

	public boolean isShapeInSpace(Shape shape){
		if(shape == null) return false;

		for(Shape s : this.panel.getShapes()){
			if(s.equals(shape)){
				return true;
			}
		}
		return false;
	}

	public boolean isPointInSpace(int x, int y){
		for(Shape s : this.panel.getShapes()){
			if(s.isPointInShape(x,y)){
				return true;
			}
		}
		return false;
	}

	public boolean isPointInSpace(Shape point){
		if(point == null) return false;

		for(Shape s : this.panel.getShapes()){
			if(!s.equals(point) && s.isPointInShape(point.getLocX(), point.getLocY())){
				return true;
			}
		}
		return false;
	}

	public ArrayList<Shape> getShapes(){
		return this.panel.getShapes();
	}

	private void update() {
		this.frame.repaint();
	}

	public void exit() {
		this.frame.dispatchEvent(new WindowEvent(this.frame, WindowEvent.WINDOW_CLOSING));
	}

}
