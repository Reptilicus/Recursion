import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class rulerCreator extends Applet{

	private BufferedImage display;
	private Graphics drawingArea;
	
	public void init() {
		resize(600, 100);
		int height = getSize().height;
		int width = getSize().width;
		display = create
		drawingArea = display.getGraphics();
		createRuler(width/2, 10, width, height - 10);
	}
	
	public void createRuler(int x, int y, int w, int h) {
		drawingArea.drawLine(0, h, w, h);
		drawRuler(x, y, w, h);
	}
	
	public void paint(Graphics g) {
		g.drawImage(display, 0, 0, null);
	}
	
	public void drawRuler(int x, int y, int w, int h) {
		if (y < h - 2) {
			drawRuler(x + w/4, (y+h)/2, w/2, h);
			drawRuler(x - w/4, (y+h)/2, w/2, h);
		} 
			drawingArea.drawLine(x, y, x, h);
	}
	
}
