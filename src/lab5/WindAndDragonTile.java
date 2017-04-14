package lab5;

import java.awt.*;
import javax.swing.*;

public class WindAndDragonTile extends AbstractCharacterTile {
	private static final long serialVersionUID = 1L;
	private String chinese;
	private Color color;
	
	public WindAndDragonTile(char symbol) {
		super(symbol);
		switch(super.symbol) {
		case 'N':
			chinese = "\u5317";
			color = black;
			break;
		
		case 'E':
			chinese = "\u6771";
			color = black;
			break;
			
		case 'W':
			chinese = "\u897F";
			color = black;
			break;
			
		case 'S':
			chinese = "\u5357";
			color = black;
			break;
			
		case 'C':
			chinese = "\u4E2D";
			color = red;
			break;
			
		case 'F':
			chinese = "\u767C";
			color = green;
			break;
			
		default:
			chinese = "\u842C";
			break;
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Draw the Chinese character
		g.setColor(color);
		g.setFont(new Font("Roman", Font.PLAIN, 75));
		int charaLength = g.getFontMetrics().stringWidth(chinese);
		int charaHeight = (g.getFontMetrics().getHeight()+20) / 2;
		g.drawString(chinese, ((super.getWidth() - 10) / 2) - charaLength / 2, ((super.getHeight() - 10) / 2) + charaHeight - charaHeight / 2);
		
		//Add the character value and set the tool tip
		g.setColor(red);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		int symbolWidth = g.getFontMetrics().stringWidth(String.valueOf(super.symbol));
		g.drawString(String.valueOf(super.symbol), face.width - symbolWidth-5, face.height - 85);
		setToolTipText(super.toString());
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel tiles = new JPanel();
		JScrollPane scroller = new JScrollPane(tiles);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("DragonAndWind Tiles");
		frame.add(scroller);

		// Try something like this if your tiles don't fit on the screen.
		// Replace "tile width" and "tile height" with your values.
		// scroller.setPreferredSize(new Dimension(8 * tile width, 40 + tile
		// height));

		tiles.add(new WindAndDragonTile('N'));
		tiles.add(new WindAndDragonTile('E'));
		tiles.add(new WindAndDragonTile('S'));
		tiles.add(new WindAndDragonTile('W'));
		tiles.add(new WindAndDragonTile('C'));
		tiles.add(new WindAndDragonTile('F'));

		frame.pack();
		frame.setVisible(true);
	}
}
