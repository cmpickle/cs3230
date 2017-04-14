package lab6;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AbstractCharacterTile extends Tile {
	private static final long serialVersionUID = 1L;
	protected char symbol;

	public AbstractCharacterTile(char symbol) {
		this.symbol = symbol;
	}

	public boolean matches(Tile other) {
		return super.matches(other) && symbol == ((AbstractCharacterTile) other).symbol;
	}

	public String toString() {
		switch (symbol) {
		case 'C':
			return "Red Dragon";
		case 'F':
			return "Green Dragon";
		case 'N':
			return "North Wind";
		case 'E':
			return "East Wind";
		case 'W':
			return "West Wind";
		case 'S':
			return "South Wind";
		default:
			return "Character " + symbol;
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel tiles = new JPanel();
		JScrollPane scroller = new JScrollPane(tiles);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("AbstractCharacter Tiles");
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
