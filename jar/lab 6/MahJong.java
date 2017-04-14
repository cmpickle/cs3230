import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.*;

public class MahJong extends JFrame{
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1920;
	public static final int HEIGHT = 1050;

	public MahJong() {
		setTitle("MahJong");
		setSize(WIDTH, HEIGHT);
		add(new MahJongBoard());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	public static class MahJongBoard extends JPanel implements MouseListener {
		private static final long serialVersionUID = 1L;

		private static final int width = 1060;
		private static final int height = 810;
		private static final BoardBackground bg = new BoardBackground(width, height);
		private static final Random rand = new Random();
		static MahJongStructure struct;
		private Stack<Tile> removed = new Stack<Tile>();
		
		private static LinkedList<Tile> deck = new LinkedList<Tile>();
		
		static {
			for(int i=0; i<4; i++) {
				deck.add(new CharacterTile('1'));
				deck.add(new CharacterTile('2'));
				deck.add(new CharacterTile('3'));
				deck.add(new CharacterTile('4'));
				deck.add(new CharacterTile('5'));
				deck.add(new CharacterTile('6'));
				deck.add(new CharacterTile('7'));
				deck.add(new CharacterTile('8'));
				deck.add(new CharacterTile('9'));
				deck.add(new WindAndDragonTile('N'));
				deck.add(new WindAndDragonTile('E'));
				deck.add(new WindAndDragonTile('S'));
				deck.add(new WindAndDragonTile('W'));
				deck.add(new WindAndDragonTile('C'));
				deck.add(new WindAndDragonTile('F'));
				deck.add(new CircleTile(1));
				deck.add(new CircleTile(2));
				deck.add(new CircleTile(3));
				deck.add(new CircleTile(4));
				deck.add(new CircleTile(5));
				deck.add(new CircleTile(6));
				deck.add(new CircleTile(7));
				deck.add(new CircleTile(8));
				deck.add(new CircleTile(9));
				deck.add(new BambooTile(2));
				deck.add(new BambooTile(3));
				deck.add(new BambooTile(4));
				deck.add(new BambooTile(5));
				deck.add(new BambooTile(6));
				deck.add(new BambooTile(7));
				deck.add(new BambooTile(8));
				deck.add(new BambooTile(9));
				deck.add(new WhiteDragonTile());
				deck.add(new Bamboo1Tile());
			}
			deck.add(new SeasonTile("Spring"));
			deck.add(new SeasonTile("Summer"));
			deck.add(new SeasonTile("Fall"));
			deck.add(new SeasonTile("Winter"));
			deck.add(new FlowerTile("Plum"));
			deck.add(new FlowerTile("Chrysanthemum"));
			deck.add(new FlowerTile("Orchid"));
			deck.add(new FlowerTile("Bamboo"));
			
			Collections.shuffle(deck, rand);
			
			struct = new MahJongStructure();
			
			for(int i=1; i<=12; i++) {
				struct.addTile(deck.removeLast(), i, 0, 0);	
//				struct.getTile(i, 0, 0).setStructLocation(i, 0, 0);
			}
			for(int i=3; i<=10; i++) {
				struct.addTile(deck.removeLast(), i, 1, 0);
//				struct.getTile(i, 1, 0).setStructLocation(i, 1, 0);
			}
			for(int i=2; i<=11; i++) {
				struct.addTile(deck.removeLast(), i, 2, 0);
//				struct.getTile(i, 2, 0).setStructLocation(i, 2, 0);
			}
			for(int i=0; i<=14; i++) {
				struct.addTile(deck.removeLast(), i, 3, 0);
//				struct.getTile(i, 3, 0).setStructLocation(i, 3, 0);
			}
			for(int i=1; i<=12; i++) {
				struct.addTile(deck.removeLast(), i, 4, 0);
//				struct.getTile(i, 4, 0).setStructLocation(i, 4, 0);
			}
			for(int i=2; i<=11; i++) {
				struct.addTile(deck.removeLast(), i, 5, 0);
//				struct.getTile(i, 5, 0).setStructLocation(i, 5, 0);
			}
			for(int i=3; i<=10; i++) {
				struct.addTile(deck.removeLast(), i, 6, 0);
//				struct.getTile(i, 6, 0).setStructLocation(i, 6, 0);
			}
			for(int i=1; i<=12; i++) {
				struct.addTile(deck.removeLast(), i, 7, 0);
//				struct.getTile(i, 7, 0).setStructLocation(i, 7, 0);
			}

			for(int j=1; j<=6; j++) {
				for(int i=4; i<=9; i++) {
					struct.addTile(deck.removeLast(), i, j, 1);
//					struct.getTile(i, j, 1).setStructLocation(i, j, 1);
				}
			}
			
			for(int j=2; j<=5; j++) {
				for(int i=5; i<=8; i++) {
					struct.addTile(deck.removeLast(), i, j, 2);
//					struct.getTile(i, j, 2).setStructLocation(i, j, 2);
				}
			}
			
			for(int j=3; j<=4; j++) {
				for(int i=6; i<=7; i++) {
					struct.addTile(deck.removeLast(), i, j, 3);
//					struct.getTile(i, j, 3).setStructLocation(i, j, 3);
				}
			}
			
			struct.addTile(deck.removeLast(), 7, 4, 4);
//			struct.getTile(7, 4, 4).setStructLocation(7, 4, 4);
		}
		
		public MahJongBoard() {
			setLayout(null);
			
			for(int x=14; x>=0; x--) {
				for(int y=7; y>=0; y--) {
					for(int z=4; z>=0; z--) {
						if(struct.struct[x][y][z]!=null) {
							if(z==4) {
								struct.getTile(x,y,z).setLocation(x*Tile.face.width - z * Tile.edge - Tile.face.width/2, y*Tile.face.height - z*Tile.edge - Tile.face.height/2);
							} else if(x==0||x==13||x==14) {
								struct.getTile(x,y,z).setLocation(x*Tile.face.width - z * Tile.edge, y*Tile.face.height - z*Tile.edge + Tile.face.height/2);
							} else {
								struct.getTile(x,y,z).setLocation(x*Tile.face.width - z * Tile.edge, y*Tile.face.height - z*Tile.edge);
							}
							struct.getTile(x, y, z).addMouseListener(this);
							add(struct.getTile(x, y, z));
						}
					}
				}
			}
			
			add(bg);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON3) {
				if(removed.isEmpty()) {
					JOptionPane.showMessageDialog(this, "There are no more moves to undo!", "Warning", JOptionPane.WARNING_MESSAGE);
				} else {
					add(removed.peek());
					setComponentZOrder(removed.peek(), removed.pop().getZOrder());
					revalidate();
					repaint();
				}
			} else {
			Tile t = (Tile)e.getSource();
			t.setZOrder(this.getComponentZOrder(t));
			removed.push(t);
//			t.toggleInPlay();
			remove(t);	
			repaint();
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}
	}
	
	public static void main(String[] args) {
		new MahJong();
	}
}
