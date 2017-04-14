import java.awt.*;
//import java.awt.geom.Area;

import javax.swing.*;

public abstract class Tile extends JPanel {
	private static final long serialVersionUID = 1L;
	protected static Color black = Color.BLACK;
	protected static Color white = Color.WHITE;
	protected static Color red = Color.RED;
	protected static Color blue = Color.BLUE;
	protected static Color green = Color.GREEN;
	private static Color oldLace = new Color(255, 250, 240);
	private static Color wheat1 = new Color(255, 231, 186);
	private static Color wheat2 = new Color(238, 216, 174);
	// private Color wheat3 = new Color(205, 186, 150);
	private static Color wheat4 = new Color(139, 90, 0);
	private static Color springgreen = new Color(0, 255, 127);
	private static Color springgreen1 = new Color(0, 238, 118);
	private static Color springgreen2 = new Color(0, 205, 102);
	private static Color springgreen3 = new Color(0, 139, 69);
	private static GradientPaint grad;
	
	protected static Rectangle face = new Rectangle(70, 100);
	protected static int edge = 10;
	private static Polygon topRight = new Polygon(new int[] { 70, 70, 75, 75 }, new int[] { 0, 100, 105, 5 }, 4);
	private static Polygon topLower = new Polygon(new int[] { 0, 5, 75, 70 }, new int[] { 100, 105, 105, 100 }, 4);
	private static Polygon bottomRight = new Polygon(new int[] { 75, 75, 80, 80 }, new int[] { 5, 105, 110, 10 }, 4);
	private static Polygon bottomLower = new Polygon(new int[] { 5, 10, 80, 75 }, new int[] { 105, 110, 110, 105 }, 4);
	
	private int zOrder;
//	private int[] location = new int[3];
//	private boolean inPlay = true;

	public Tile() {
		setPreferredSize(new Dimension(80, 110));
		setSize(new Dimension(80, 110));
		
		setOpaque(false);
	}

	public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
	
			// Draw the main rectangle
			g.setColor(white);
			grad = new GradientPaint(90, 0, oldLace, 0, 120, wheat1);
			g2d.setPaint(grad);
			g.fillRect(0, 0, face.width, face.height);
	
			// Draw the top right polygon
			grad = new GradientPaint(75, 0, wheat1, 70, 105, wheat2);
			g2d.setPaint(grad);
			g.fillPolygon(topRight);
	
			// Draw the top lower polygon
			grad = new GradientPaint(80, 30, wheat2, 0, 105, wheat4);
			g2d.setPaint(grad);
			g.fillPolygon(topLower);
	
			// Draw the bottom right polygon
			grad = new GradientPaint(80, 0, springgreen, 75, 105, springgreen1);
			g2d.setPaint(grad);
			g.fillPolygon(bottomRight);
	
			// Draw the bottom lower polygon
			g.setColor(black);
			g.drawPolygon(bottomLower);
			grad = new GradientPaint(80, 40, springgreen2, 0, 120, springgreen3);
			g2d.setPaint(grad);
			g.fillPolygon(bottomLower);
			
			g.setColor(black);
			g.drawRect(0, 0, face.width, face.height);
			g.drawPolygon(topRight);
			g.drawPolygon(topLower);
			g.drawPolygon(bottomRight);
			
//			Polygon shadowLeft = new Polygon(new int[] {0, 0, 10, 5, -10, -10}, new int[] {0, 100, 110, 115, 115, 0}, 6);
//			Polygon shadowBelow = new Polygon(new int[] {10, 70, 80, 75, 5}, new int[] {100, 100, 110, 115, 115}, 5);
//			Polygon shadow = new Polygon(new int[] {0, 0, 10, 70, 80, 75, -10, -10}, new int[] {0, 100, 100, 100, 110, 115, 115, 0}, 8);
//			
//			Composite cOld = g2d.getComposite();
//			Composite cNew = ((AlphaComposite)cOld).derive(0.25F);
//			g2d.setComposite(cNew);
//			g.setClip(shadow);
////			if()
//			g.fillPolygon(shadow);
//			g.setClip(null);
//			g2d.setComposite(cOld);
	}

	public boolean matches(Tile other) {
		if (this == other)
			return true;

		if (other == null)
			return false;

		return getClass() == other.getClass();
	}
	
	public void setZOrder(int zOrder) {
		this.zOrder = zOrder;
	}
	
	public int getZOrder() {
		return zOrder;
	}
//	
//	public void setStructLocation(int x, int y, int z) {
//		location[0] = x;
//		location[1] = y;
//		location[2] = z;
//	}
//	
//	public int[] getStructLocation() {
//		return location;
//	}
//	
//	public void toggleInPlay() {
//		inPlay = !inPlay;
//	}
//	
//	public boolean isInPlay() {
//		return inPlay;
//	}
//	
//	public boolean hasLeftNeighbor() {
//		int[] find = this.getStructLocation();
////		if()
//		return false;
//	}
}
