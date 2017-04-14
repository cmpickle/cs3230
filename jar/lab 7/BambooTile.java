

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class BambooTile extends RankTile {
	private static final long serialVersionUID = 1L;
	private static int bambooHeight = (face.height-15)/3;
	private static int bambooWidth = face.width/5;

	public BambooTile(int rank) {
		super(rank);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		setToolTipText(toString());
		drawBamboos(g);
	}

	public String toString() {
		return "Bamboo " + rank;
	}
	
	private void drawBamboos(Graphics g) {
		
		switch(super.rank) {
		case 2:
			drawBamboo(g, face.width/2 - bambooWidth/2, face.height/4 - bambooHeight/3, bambooWidth, bambooHeight, blue);
			drawBamboo(g, face.width/2 - bambooWidth/2, face.height*3/4 - bambooHeight*2/3, bambooWidth, bambooHeight, green);
			break;
			
		case 3:
			drawBamboo(g, face.width/2 - bambooWidth/2, face.height/4 - bambooHeight/3, bambooWidth, bambooHeight, blue);
			drawBamboo(g, face.width/3 - bambooWidth/2, face.height*3/4 - bambooHeight*2/3, bambooWidth, bambooHeight, green);
			drawBamboo(g, face.width*2/3 - bambooWidth/2, face.height*3/4 - bambooHeight*2/3, bambooWidth, bambooHeight, green);
			break;
			
		case 4:
			drawBamboo(g, face.width/3 - bambooWidth/2, face.height/4 - bambooHeight/3, bambooWidth, bambooHeight, blue);
			drawBamboo(g, face.width*2/3 - bambooWidth/2, face.height/4 - bambooHeight/3, bambooWidth, bambooHeight, green);
			drawBamboo(g, face.width/3 - bambooWidth/2, face.height*3/4 - bambooHeight*2/3, bambooWidth, bambooHeight, green);
			drawBamboo(g, face.width*2/3 - bambooWidth/2, face.height*3/4 - bambooHeight*2/3, bambooWidth, bambooHeight, blue);
			break;
			
		case 5:
			drawBamboo(g, face.width/4 - bambooWidth/2, face.height/4 - bambooHeight/3, bambooWidth, bambooHeight, green);
			drawBamboo(g, face.width*3/4 - bambooWidth/2, face.height/4 - bambooHeight/3, bambooWidth, bambooHeight, blue);
			drawBamboo(g, face.width/2 - bambooWidth/2, face.height/2 - bambooHeight/3, bambooWidth, bambooHeight, red);
			drawBamboo(g, face.width/4 - bambooWidth/2, face.height*3/4 - bambooHeight*2/3, bambooWidth, bambooHeight, blue);
			drawBamboo(g, face.width*3/4 - bambooWidth/2, face.height*3/4 - bambooHeight*2/3, bambooWidth, bambooHeight, green);
			break;
			
		case 6:
			drawBamboo(g, face.width/4 - bambooWidth/2, face.height/4 - bambooHeight/3, bambooWidth, bambooHeight, green);
			drawBamboo(g, face.width*2/4 - bambooWidth/2, face.height/4 - bambooHeight/3, bambooWidth, bambooHeight, green);
			drawBamboo(g, face.width*3/4 - bambooWidth/2, face.height/4 - bambooHeight/3, bambooWidth, bambooHeight, green);
			drawBamboo(g, face.width/4 - bambooWidth/2, face.height*3/4 - bambooHeight*2/3, bambooWidth, bambooHeight, blue);
			drawBamboo(g, face.width*2/4 - bambooWidth/2, face.height*3/4 - bambooHeight*2/3, bambooWidth, bambooHeight, blue);
			drawBamboo(g, face.width*3/4 - bambooWidth/2, face.height*3/4 - bambooHeight*2/3, bambooWidth, bambooHeight, blue);
			break;
			
		case 7:
			drawBamboo(g, face.width/2 - bambooWidth/2, face.height/24, bambooWidth, bambooHeight, red);
			drawBamboo(g, face.width/4 - bambooWidth/2, face.height*9/24, bambooWidth, bambooHeight, green);
			drawBamboo(g, face.width*2/4 - bambooWidth/2, face.height*9/24, bambooWidth, bambooHeight, blue);
			drawBamboo(g, face.width*3/4 - bambooWidth/2, face.height*9/24, bambooWidth, bambooHeight, green);
			drawBamboo(g, face.width/4 - bambooWidth/2, face.height*21/24 - bambooHeight*2/3, bambooWidth, bambooHeight, green);
			drawBamboo(g, face.width*2/4 - bambooWidth/2, face.height*21/24 - bambooHeight*2/3, bambooWidth, bambooHeight, blue);
			drawBamboo(g, face.width*3/4 - bambooWidth/2, face.height*21/24 - bambooHeight*2/3, bambooWidth, bambooHeight, green);
			break;
			
		case 8:
			drawBamboo(g, face.width/12 - bambooWidth/2 + bambooWidth/3, face.height/4 - bambooHeight/3, bambooWidth, bambooHeight, green);
			drawBamboo(g, face.width*11/12 - bambooWidth/2 - bambooWidth/3, face.height/4 - bambooHeight/3, bambooWidth, bambooHeight, green);
			drawBamboo(g, face.width/12 - bambooWidth/2 + bambooWidth/3, face.height*3/4 - bambooHeight*2/3, bambooWidth, bambooHeight, blue);
			drawBamboo(g, face.width*11/12 - bambooWidth/2 - bambooWidth/3, face.height*3/4 - bambooHeight*2/3, bambooWidth, bambooHeight, blue);
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.rotate(Math.PI/4, face.width/2 + bambooWidth/3, face.height/2-bambooHeight);
			drawBamboo(g, face.width/2 - bambooWidth + bambooWidth/3, face.height/4, bambooWidth, bambooHeight, green);
			g2d.rotate(-Math.PI/4, face.width/2 + bambooWidth/3, face.height/2-bambooHeight);

			g2d.rotate(-Math.PI/4, face.width/2 - bambooWidth/3, face.height/2-bambooHeight);
			drawBamboo(g, face.width/2 - bambooWidth/3, face.height/4, bambooWidth, bambooHeight, green);
			g2d.rotate(Math.PI/4, face.width/2 - bambooWidth/3, face.height/2-bambooHeight);
			
			g2d.rotate(Math.PI*3/4, face.width/2 - bambooWidth*2/3, face.height/2 + bambooHeight);
			drawBamboo(g, face.width/2 - bambooWidth + bambooWidth/3 - bambooWidth*2/3, face.height*3/4 - bambooHeight/6, bambooWidth, bambooHeight, blue);
			g2d.rotate(-Math.PI*3/4, face.width/2 - bambooWidth*2/3, face.height/2 + bambooHeight);

			g2d.rotate(-Math.PI*3/4, face.width/2, face.height/2 + bambooHeight);
			drawBamboo(g, face.width/2 - bambooWidth + bambooWidth/3, face.height*3/4, bambooWidth, bambooHeight, blue);
			g2d.rotate(Math.PI/4, face.width/2, face.height/2 + bambooHeight);
			break;
			
		case 9:
			drawBamboo(g, face.width/4 - bambooWidth/2, face.height/24, bambooWidth, bambooHeight, red);
			drawBamboo(g, face.width/2 - bambooWidth/2, face.height/24, bambooWidth, bambooHeight, blue);
			drawBamboo(g, face.width*3/4 - bambooWidth/2, face.height/24, bambooWidth, bambooHeight, green);
			drawBamboo(g, face.width/4 - bambooWidth/2, face.height*9/24, bambooWidth, bambooHeight, red);
			drawBamboo(g, face.width*2/4 - bambooWidth/2, face.height*9/24, bambooWidth, bambooHeight, blue);
			drawBamboo(g, face.width*3/4 - bambooWidth/2, face.height*9/24, bambooWidth, bambooHeight, green);
			drawBamboo(g, face.width/4 - bambooWidth/2, face.height*21/24 - bambooHeight*2/3, bambooWidth, bambooHeight, red);
			drawBamboo(g, face.width*2/4 - bambooWidth/2, face.height*21/24 - bambooHeight*2/3, bambooWidth, bambooHeight, blue);
			drawBamboo(g, face.width*3/4 - bambooWidth/2, face.height*21/24 - bambooHeight*2/3, bambooWidth, bambooHeight, green);
			break;
			
		default:
			break;
		}
	}
	
	private void drawBamboo(Graphics g, int x, int y, int width, int height, Color color) {
		int arc = 5;
		g.setColor(color);
		g.fillRoundRect(x + width*3/8, y, width*5/12, height, arc, arc);
		g.fillRoundRect(x, y, width, height/5, arc, arc);
		g.fillRoundRect(x, y + height*20/24, width, height/5, arc, arc);
		
		g.setColor(white);
		g.fillRect(x + width*7/12, y + height/16, width/8, (int)(height*.9));
		
		g.setColor(color);
		g.fillRoundRect(x, y + height*11/24, width, height/5, arc, arc);
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

		tiles.add(new BambooTile(2));
		tiles.add(new BambooTile(3));
		tiles.add(new BambooTile(4));
		tiles.add(new BambooTile(5));
		tiles.add(new BambooTile(6));
		tiles.add(new BambooTile(7));
		tiles.add(new BambooTile(8));
		tiles.add(new BambooTile(9));

		frame.pack();
		frame.setVisible(true);
	}
}
