package lab6;

import java.awt.*;
import javax.swing.*;

public class CharacterTile extends AbstractCharacterTile {
	private static final long serialVersionUID = 1L;
	private String chinese;
	private String wan = "\u842C";

	public CharacterTile(char symbol) {
		super(symbol);
		switch (super.symbol) {
		case '1':
			chinese = "\u4E00";
			break;

		case '2':
			chinese = "\u4E8C";
			break;

		case '3':
			chinese = "\u4E09";
			break;

		case '4':
			chinese = "\u56DB";
			break;

		case '5':
			chinese = "\u4E94";
			break;

		case '6':
			chinese = "\u516D";
			break;

		case '7':
			chinese = "\u4E03";
			break;

		case '8':
			chinese = "\u516B";
			break;

		case '9':
			chinese = "\u4E5D";
			break;

		default:
			chinese = "\u842C";
			break;
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Draw the Chinese character
		g.setFont(new Font("Roman", Font.PLAIN, 40));
		int charaLength = g.getFontMetrics().stringWidth(chinese);
		int charaHeight = g.getFontMetrics().getHeight() / 2;
		g.drawString(chinese, ((super.getWidth() - 10) / 2) - charaLength / 2, ((super.getHeight() - 10) / 4) + charaHeight - charaHeight / 2);
		
		//Draw the wan
		g.setColor(red);
		int wanLength = g.getFontMetrics().stringWidth(wan);
		int wanHeight = g.getFontMetrics().getHeight() / 2;
		g.drawString("\u842C", ((super.getWidth() - 10) / 2) - wanLength / 2, ((super.getHeight() - 10) * 3 / 4) + wanHeight - wanHeight / 2);
		
		//Add the character value and set the tool tip
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
		frame.setTitle("Character Tiles");
		frame.add(scroller);

		// Try something like this if your tiles don't fit on the screen.
		// Replace "tile width" and "tile height" with your values.
		// scroller.setPreferredSize(new Dimension(8 * tile width, 40 + tile
		// height));

		tiles.add(new CharacterTile('1'));
		tiles.add(new CharacterTile('2'));
		tiles.add(new CharacterTile('3'));
		tiles.add(new CharacterTile('4'));
		tiles.add(new CharacterTile('5'));
		tiles.add(new CharacterTile('6'));
		tiles.add(new CharacterTile('7'));
		tiles.add(new CharacterTile('8'));
		tiles.add(new CharacterTile('9'));

		frame.pack();
		frame.setVisible(true);
	}
}
