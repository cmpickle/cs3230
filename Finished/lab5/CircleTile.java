import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class CircleTile extends RankTile {
	private static final long serialVersionUID = 1L;

	public CircleTile(int rank) {
		super(rank);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		drawCircles(g);
		setToolTipText(toString());
	}

	public String toString() {
		return "Circle " + rank;
	}
	
	private void drawCircles(Graphics g) {
		int circleSize;
		
		switch(super.rank) {
		case 1:
			circleSize = (int) (face.width*.6);
			int pancakeSize = (int)(face.width*.9);
			drawPancake(g, face.width/2 - pancakeSize/2, face.height/2 - pancakeSize/2, pancakeSize, black, green, white);
			drawCircle(g, face.width/2 - circleSize/2, face.height/2 - circleSize/2, circleSize, black, red, white);
			break;
			
		case 2:
			circleSize = (int)(face.width*.6);
			drawCircle(g, face.width/2 - circleSize/2, face.height*3/4 - circleSize/2, circleSize, black, blue, white);
			drawCircle(g, face.width/2 - circleSize/2, face.height/4 - circleSize/2, circleSize, black, green, white);
			break;
			
		case 3:
			circleSize = (int)(face.width*.35);
			drawCircle(g, face.width/4 - circleSize/2, face.height/4 - circleSize/2, circleSize, black, blue, white);
			drawCircle(g, face.width/2 - circleSize/2, face.height/2 - circleSize/2, circleSize, black, red, white);
			drawCircle(g, face.width*3/4 - circleSize/2, face.height*3/4 - circleSize/2, circleSize, black, green, white);
			break;
			
		case 4:
			circleSize = (int)(face.width*4/10);
			drawCircle(g, face.width/4 - circleSize/2, face.height/3 - circleSize/2, circleSize, black, blue, white);
			drawCircle(g, face.width/4 - circleSize/2, face.height*2/3 - circleSize/2, circleSize, black, green, white);
			drawCircle(g, face.width*3/4 - circleSize/2, face.height*2/3 - circleSize/2, circleSize, black, blue, white);
			drawCircle(g, face.width*3/4 - circleSize/2, face.height/3 - circleSize/2, circleSize, black, green, white);
			break;
			
		case 5:
			circleSize = (int)(face.width*7/20);
			drawCircle(g, face.width/4 - circleSize/2, face.height/4 - circleSize/2, circleSize, black, blue, white);
			drawCircle(g, face.width/4 - circleSize/2, face.height*3/4 - circleSize/2, circleSize, black, green, white);
			drawCircle(g, face.width/2 - circleSize/2, face.height/2 - circleSize/2, circleSize, black, red, white);
			drawCircle(g, face.width*3/4 - circleSize/2, face.height*3/4 - circleSize/2, circleSize, black, blue, white);
			drawCircle(g, face.width*3/4 - circleSize/2, face.height/4 - circleSize/2, circleSize, black, green, white);
			break;
			
		case 6:
			circleSize = (int)(face.width*4/10);
			drawCircle(g, face.width/4 - circleSize/2, face.height/6 - circleSize/2, circleSize, black, green, white);
			drawCircle(g, face.width/4 - circleSize/2, face.height/2 - circleSize/2, circleSize, black, red, white);
			drawCircle(g, face.width/4 - circleSize/2, face.height*5/6 - circleSize/2, circleSize, black, red, white);
			drawCircle(g, face.width*3/4 - circleSize/2, face.height/6 - circleSize/2, circleSize, black, green, white);
			drawCircle(g, face.width*3/4 - circleSize/2, face.height/2 - circleSize/2, circleSize, black, red, white);
			drawCircle(g, face.width*3/4 - circleSize/2, face.height*5/6 - circleSize/2, circleSize, black, red, white);
			break;
			
		case 7:
			circleSize = (int)(face.width*3/10);
			drawCircle(g, face.width*5/24 - circleSize/2, face.height/8 - circleSize/2, circleSize, black, green, white);
			drawCircle(g, face.width/2 - circleSize/2, face.height/4 - circleSize/2, circleSize, black, green, white);
			drawCircle(g, face.width*19/24 - circleSize/2, face.height*3/8 - circleSize/2, circleSize, black, green, white);
			
			drawCircle(g, face.width/3 - circleSize/2, face.height*15/24 - circleSize/2, circleSize, black, red, white);
			drawCircle(g, face.width/3 - circleSize/2, face.height*21/24 - circleSize/2, circleSize, black, red, white);
			drawCircle(g, face.width*2/3 - circleSize/2, face.height*21/24 - circleSize/2, circleSize, black, red, white);
			drawCircle(g, face.width*2/3 - circleSize/2, face.height*15/24 - circleSize/2, circleSize, black, red, white);
			break;
			
		case 8:
			circleSize = (int)(face.width*3/10);
			drawCircle(g, face.width/4 - circleSize/2, face.height/8 - circleSize/2, circleSize, black, blue, white);
			drawCircle(g, face.width/4 - circleSize/2, face.height*3/8 - circleSize/2, circleSize, black, blue, white);
			drawCircle(g, face.width/4 - circleSize/2, face.height*5/8 - circleSize/2, circleSize, black, blue, white);
			drawCircle(g, face.width/4 - circleSize/2, face.height*7/8 - circleSize/2, circleSize, black, blue, white);

			drawCircle(g, face.width*3/4 - circleSize/2, face.height/8 - circleSize/2, circleSize, black, blue, white);
			drawCircle(g, face.width*3/4 - circleSize/2, face.height*3/8 - circleSize/2, circleSize, black, blue, white);
			drawCircle(g, face.width*3/4 - circleSize/2, face.height*5/8 - circleSize/2, circleSize, black, blue, white);
			drawCircle(g, face.width*3/4 - circleSize/2, face.height*7/8 - circleSize/2, circleSize, black, blue, white);
			break;
			
		case 9:
			circleSize = (int)(face.width*3/10);
			drawCircle(g, face.width/6 - circleSize/2, face.height/5 - circleSize/2, circleSize, black, green, white);
			drawCircle(g, face.width/6 - circleSize/2, face.height/2 - circleSize/2, circleSize, black, red, white);
			drawCircle(g, face.width/6 - circleSize/2, face.height*4/5 - circleSize/2, circleSize, black, blue, white);
			
			drawCircle(g, face.width*3/6 - circleSize/2, face.height/5 - circleSize/2, circleSize, black, green, white);
			drawCircle(g, face.width*3/6 - circleSize/2, face.height/2 - circleSize/2, circleSize, black, red, white);
			drawCircle(g, face.width*3/6 - circleSize/2, face.height*4/5 - circleSize/2, circleSize, black, blue, white);
			
			drawCircle(g, face.width*5/6 - circleSize/2, face.height/5 - circleSize/2, circleSize, black, green, white);
			drawCircle(g, face.width*5/6 - circleSize/2, face.height/2 - circleSize/2, circleSize, black, red, white);
			drawCircle(g, face.width*5/6 - circleSize/2, face.height*4/5 - circleSize/2, circleSize, black, blue, white);
			break;
			
		default:
			break;
		}
	}
	
	private void drawCircle(Graphics g, int x, int y, int circleSize, Color outline, Color background, Color decoration) {
		g.setColor(outline);
		g.drawOval(x, y, circleSize, circleSize);
		g.setColor(background);
		g.fillOval(x, y, circleSize, circleSize);
		g.setColor(decoration);
		Graphics2D g2d = (Graphics2D) g;
		drawCircleDecoration(g2d, circleSize, x, y, circleSize, circleSize);
	}
	
	private void drawCircleDecoration(Graphics g, int radius, int x, int y, int width, int height) {
		Graphics2D g2d = (Graphics2D) g;
		Ellipse2D decoration = new Ellipse2D.Double(x+width/2 - width/8/2, y+height/2 - height/2, width/8, height/2);
		g2d.rotate(Math.PI/4, x+(width/2), y+(height/2));
		g2d.fill(decoration);
		g2d.rotate(Math.PI/2, (x+width/2), y+height/2);
		g2d.fill(decoration);
		g2d.rotate(Math.PI/2, (x+width/2), y+height/2);
		g2d.fill(decoration);
		g2d.rotate(Math.PI/2, (x+width/2), y+height/2);
		g2d.fill(decoration);
		g2d.rotate(Math.PI/4, x+width/2, y+height/2);
	}
	
	private void drawPancake(Graphics g, int x, int y, int circleSize, Color outline, Color background, Color decoration) {
		g.setColor(black);
		g.drawOval(x, y, circleSize, circleSize);
		g.setColor(background);
		g.fillOval(x, y, circleSize, circleSize);
		g.setColor(white);
		Graphics2D g2d = (Graphics2D) g;
		int decorationSize = (int)(circleSize*1/10);
		for(int i = 0; i<16; i++) {
			g2d.fill(new Ellipse2D.Double(x+circleSize/2 - decorationSize/2, y + decorationSize/4, decorationSize, decorationSize));
			g2d.rotate(Math.PI/8, (x+circleSize/2), y+circleSize/2);
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel tiles = new JPanel();
		JScrollPane scroller = new JScrollPane(tiles);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Circle Tiles");
		frame.add(scroller);

		// Try something like this if your tiles don't fit on the screen.
		// Replace "tile width" and "tile height" with your values.
		// scroller.setPreferredSize(new Dimension(8 * tile width, 40 + tile
		// height));

		tiles.add(new CircleTile(1));
		tiles.add(new CircleTile(2));
		tiles.add(new CircleTile(3));
		tiles.add(new CircleTile(4));
		tiles.add(new CircleTile(5));
		tiles.add(new CircleTile(6));
		tiles.add(new CircleTile(7));
		tiles.add(new CircleTile(8));
		tiles.add(new CircleTile(9));

		frame.pack();
		frame.setVisible(true);
	}
}
