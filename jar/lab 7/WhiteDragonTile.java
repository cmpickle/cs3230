

import java.awt.*;
import java.awt.geom.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class WhiteDragonTile extends Tile {
	private static final long serialVersionUID = 1L;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		setToolTipText(toString());
		int outterWidth = (int)(face.width*.9);
		int outterHeight = (int)(face.height*.9);
		int innerWidth = (int)(face.width*.6);
		int innerHeight = (int)(face.height*.7);
		Area border = new Area(new Rectangle(face.width/2 - outterWidth/2, face.height/2 - outterHeight/2, outterWidth, outterHeight));
		Area innerBorder = new Area(new Rectangle(face.width/2 - innerWidth/2, face.height/2 - innerHeight/2, innerWidth, innerHeight));
		border.subtract(innerBorder);
		
		g.setColor(white);
		Graphics2D g2d = (Graphics2D) g;
		g2d.fill(border);
		
		g.setColor(black);
		g2d.draw(border);
		
		g.setColor(blue);
		Area s1 = new Area(new Rectangle(face.width/2 - outterWidth/2, face.height/2 - outterHeight/2 + outterHeight/9, outterWidth, outterHeight/9));
		Area s2 = new Area(new Rectangle(face.width/2 - outterWidth/2, face.height/2 - outterHeight/2 + outterHeight*3/9, outterWidth, outterHeight/9));
		Area s3 = new Area(new Rectangle(face.width/2 - outterWidth/2, face.height/2 - outterHeight/2 + outterHeight*5/9, outterWidth, outterHeight/9));
		Area s4 = new Area(new Rectangle(face.width/2 - outterWidth/2, face.height/2 - outterHeight/2 + outterHeight*7/9, outterWidth, outterHeight/9));
		
		Area s5 = new Area(new Rectangle(face.width/2 - outterWidth/2 + outterWidth/7, face.height/2 - outterHeight/2, outterWidth/7, outterHeight));
		Area s6 = new Area(new Rectangle(face.width/2 - outterWidth/2 + outterWidth*3/7, face.height/2 - outterHeight/2, outterWidth/7, outterHeight));
		Area s7 = new Area(new Rectangle(face.width/2 - outterWidth/2 + outterWidth*5/7, face.height/2 - outterHeight/2, outterWidth/7, outterHeight));
		border.subtract(s1);
		border.subtract(s2);
		border.subtract(s3);
		border.subtract(s4);
		border.subtract(s5);
		border.subtract(s6);
		border.subtract(s7);
		g2d.fill(border);
		
		ImageIcon image = new ImageIcon(WhiteDragonTile.class.getResource("images/Pickle.png"));
		g.drawImage(image.getImage(), face.width/2 - image.getIconWidth()/2, face.height/2 - image.getIconHeight()/2, image.getIconWidth(), image.getIconHeight(), this);
	}

	public String toString() {
		return "White Dragon";
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bamboo 1 Tile");

		frame.add(new WhiteDragonTile());

		frame.pack();
		frame.setVisible(true);
	}
}
