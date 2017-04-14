package lab7;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class MahJong extends JFrame {
	private static final long serialVersionUID = 1L;

	private static MahJong 			mahjong;
	private static MahJongBoard 	board;
	private static boolean 			audioOn = true;
	private static boolean			tournamentMode = false;

	private JPanel					controls = new JPanel();
	private GridBagLayout 			layout = new GridBagLayout();
	private GridBagConstraints 		constraints = new GridBagConstraints();
	private JPanel 					tilePanel = new JPanel(layout);
	JPanel 							timePanel;
	JLabel							timeLabel;
	static JLabel					scoreLabel = new JLabel("Your score is: 0");
	
	Action 							newGameAction;
	Action 							restartAction;
	Action 							numberedRestartAction;
	Action							tournamentAction;
	Action 							viewRemovedTilesAction;
	Action 							exitAction;
	Action 							undoAction;
	Action 							redoAction;
	Action 							toggleAudioAction;
	Action 							operationAction;
	Action 							gameRulesAction;
	
	static int						score = 0;
	long							timerTime = 0;
	Timer 							timer = new Timer();
	TimerTask						updateTimeAction = new TimerTask() {
		@Override
		public void run() {
			timerTime++;
			timeLabel.setText(String.format("Elapsed Time: %02d:%02d:%02d", TimeUnit.SECONDS.toHours(timerTime), TimeUnit.SECONDS.toMinutes(timerTime) - TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(timerTime)), TimeUnit.SECONDS.toSeconds(timerTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(timerTime))));
		}
		
	};

	public MahJong() {
		setTitle("MahJong");
		board = new MahJongBoard();

		makeMenu();
		JButton undoButton = ButtonFactory.makeImageButton("images/Undo24.gif", "Undo the last Move", undoAction, board, true);
		JButton redoButton = ButtonFactory.makeImageButton("images/Redo24.gif", "Redo the last Move", redoAction, board, true);
		add(board);
		controls.add(undoButton);
		controls.add(redoButton);
		controls.add(scoreLabel);
		add(controls, BorderLayout.SOUTH);

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});

		pack();
		setVisible(true);
	}

	public static class MahJongBoard extends JPanel implements MouseListener {
		private static final long serialVersionUID = 1L;

		private static final int 		width = 1060;
		private static final int 		height = 810;
		private final BoardBackground 	bg = new BoardBackground(width, height);
		private static int 				seed = (int) (System.currentTimeMillis() % 1000000);
		private static Random 			rand = new Random(seed);
		private MahJongStructure 		struct;
		private Stack<Tile> 			removed = new Stack<Tile>();
		private Stack<Tile> 			redo = new Stack<Tile>();

		private LinkedList<Tile> 		deck = new LinkedList<Tile>();
		private int[] 					removedCount = new int[42];
		private Fireworks 				fireworks = new Fireworks();

		private Tile 					first;
		private Tile 					second;

		public MahJongBoard() {
			setLayout(null);

			for (int i = 0; i < 4; i++) {
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

			for (int i = 1; i <= 12; i++) {
				struct.addTile(deck.removeLast(), i, 0, 0);
			}
			for (int i = 3; i <= 10; i++) {
				struct.addTile(deck.removeLast(), i, 1, 0);
			}
			for (int i = 2; i <= 11; i++) {
				struct.addTile(deck.removeLast(), i, 2, 0);
			}
			for (int i = 0; i <= 14; i++) {
				struct.addTile(deck.removeLast(), i, 3, 0);
			}
			for (int i = 1; i <= 12; i++) {
				struct.addTile(deck.removeLast(), i, 4, 0);
			}
			for (int i = 2; i <= 11; i++) {
				struct.addTile(deck.removeLast(), i, 5, 0);
			}
			for (int i = 3; i <= 10; i++) {
				struct.addTile(deck.removeLast(), i, 6, 0);
			}
			for (int i = 1; i <= 12; i++) {
				struct.addTile(deck.removeLast(), i, 7, 0);
			}

			for (int j = 1; j <= 6; j++) {
				for (int i = 4; i <= 9; i++) {
					struct.addTile(deck.removeLast(), i, j, 1);
				}
			}

			for (int j = 2; j <= 5; j++) {
				for (int i = 5; i <= 8; i++) {
					struct.addTile(deck.removeLast(), i, j, 2);
				}
			}

			for (int j = 3; j <= 4; j++) {
				for (int i = 6; i <= 7; i++) {
					struct.addTile(deck.removeLast(), i, j, 3);
				}
			}

			struct.addTile(deck.removeLast(), 7, 4, 4);

			for (int x = 14; x >= 0; x--) {
				for (int y = 7; y >= 0; y--) {
					for (int z = 4; z >= 0; z--) {
						if (struct.struct[x][y][z] != null) {
							if (z == 4) {
								struct.getTile(x, y, z).setLocation(
										x * Tile.face.width - z * Tile.edge - Tile.face.width / 2,
										y * Tile.face.height - z * Tile.edge - Tile.face.height / 2);
							} else if (x == 0 || x == 13 || x == 14) {
								struct.getTile(x, y, z).setLocation(x * Tile.face.width - z * Tile.edge,
										y * Tile.face.height - z * Tile.edge + Tile.face.height / 2);
							} else {
								struct.getTile(x, y, z).setLocation(x * Tile.face.width - z * Tile.edge,
										y * Tile.face.height - z * Tile.edge);
							}
							struct.getTile(x, y, z).addMouseListener(this);
							add(struct.getTile(x, y, z));
						}
					}
				}
			}

			add(bg);

			setPreferredSize(new Dimension(width, height));
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			Tile t = (Tile) e.getSource();

			if (struct.isTileRemovable(t)) {
				if (first == null) {
					first = t;
					first.setSelected(true);
					repaint();
					return;
				} else if (t == first) {
					first.setSelected(false);
					first = null;
					repaint();
					return;
				}

				second = t;

				second.setSelected(true);

				if (struct.isTileRemovable(second) && first.matches(second)) {
					removeTilesFromPlay(first, second);
					
					return;
				}

				first.setSelected(false);

				first = second;
				second = null;
				repaint();
			}
		}

		public void removeTilesFromPlay(Tile first, Tile second) {
			first.setZOrder(this.getComponentZOrder(first));
			removed.push(first);
			first.toggleInPlay();
			remove(first);

			second.setZOrder(this.getComponentZOrder(second));
			removed.push(second);
			second.toggleInPlay();
			remove(second);

			if (audioOn) {
				PlayClip clip = new PlayClip("audio/stone-scraping.wav");
				clip.play();
			}

			updateRemovedCount(first, 1);
			updateRemovedCount(second, 1);

			this.first = this.second = null;

			if (removed.size() == 144) {
				repaint();
				add(fireworks.getPanel());
				fireworks.fire();
				revalidate();
			}
			
			repaint();
		}
		
		private void updateScore(int amount) {
			score += amount;
			scoreLabel.setText("Your Score is: " + score);
		}

		private void updateRemovedCount(Tile t, int amount) {
			updateScore(amount * 5);
			switch (t.toString()) {
			case "Character 1":
				removedCount[0] += amount;
				break;
			case "Character 2":
				removedCount[1] += amount;
				break;
			case "Character 3":
				removedCount[2] += amount;
				break;
			case "Character 4":
				removedCount[3] += amount;
				break;
			case "Character 5":
				removedCount[4] += amount;
				break;
			case "Character 6":
				removedCount[5] += amount;
				break;
			case "Character 7":
				removedCount[6] += amount;
				break;
			case "Character 8":
				removedCount[7] += amount;
				break;
			case "Character 9":
				removedCount[8] += amount;
				break;
			case "Circle 1":
				removedCount[9] += amount;
				break;
			case "Circle 2":
				removedCount[10] += amount;
				break;
			case "Circle 3":
				removedCount[11] += amount;
				break;
			case "Circle 4":
				removedCount[12] += amount;
				break;
			case "Circle 5":
				removedCount[13] += amount;
				break;
			case "Circle 6":
				removedCount[14] += amount;
				break;
			case "Circle 7":
				removedCount[15] += amount;
				break;
			case "Circle 8":
				removedCount[16] += amount;
				break;
			case "Circle 9":
				removedCount[17] += amount;
				break;
			case "Bamboo 1":
				removedCount[18] += amount;
				break;
			case "Bamboo 2":
				removedCount[19] += amount;
				break;
			case "Bamboo 3":
				removedCount[20] += amount;
				break;
			case "Bamboo 4":
				removedCount[21] += amount;
				break;
			case "Bamboo 5":
				removedCount[22] += amount;
				break;
			case "Bamboo 6":
				removedCount[23] += amount;
				break;
			case "Bamboo 7":
				removedCount[24] += amount;
				break;
			case "Bamboo 8":
				removedCount[25] += amount;
				break;
			case "Bamboo 9":
				removedCount[26] += amount;
				break;
			case "North Wind":
				removedCount[27] += amount;
				break;
			case "East Wind":
				removedCount[28] += amount;
				break;
			case "South Wind":
				removedCount[29] += amount;
				break;
			case "West Wind":
				removedCount[30] += amount;
				break;
			case "Red Dragon":
				removedCount[31] += amount;
				break;
			case "Green Dragon":
				removedCount[32] += amount;
				break;
			case "White Dragon":
				removedCount[33] += amount;
				break;
			case "Chrysanthemum":
				removedCount[34] += amount;
				break;
			case "Orchid":
				removedCount[35] += amount;
				break;
			case "Plum":
				removedCount[36] += amount;
				break;
			case "Bamboo":
				removedCount[37] += amount;
				break;
			case "Spring":
				removedCount[38] += amount;
				break;
			case "Summer":
				removedCount[39] += amount;
				break;
			case "Fall":
				removedCount[40] += amount;
				break;
			case "Winter":
				removedCount[41] += amount;
				break;
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		public void undo() {
			if (removed.isEmpty()) {
				JOptionPane.showMessageDialog(null, "There are no more moves to undo!", "Warning",
						JOptionPane.WARNING_MESSAGE);
			} else {
				add(removed.peek());
				redo.push(removed.peek());
				updateRemovedCount(removed.peek(), -1); // remove the tiles from the removed count
				removed.peek().toggleInPlay();
				setComponentZOrder(removed.peek(), removed.pop().getZOrder());
				
				add(removed.peek());
				redo.push(removed.peek());
				updateRemovedCount(removed.peek(), -1); // remove the tiles from the removed count
				removed.peek().toggleInPlay();
				setComponentZOrder(removed.peek(), removed.pop().getZOrder());
				revalidate();
				repaint();
			}
		}
		
		public void redo() {
			if(redo.isEmpty()) {
				JOptionPane.showMessageDialog(null, "There are no more moves to redo!", "Warning",
						JOptionPane.WARNING_MESSAGE);
			} else {
				removeTilesFromPlay(redo.pop(), redo.pop());
			}
		}

		public static void setRand(int seed) {
			rand = new Random(seed);
		}

		public static void setRand() {
			rand = new Random(seed);
		}
	}

	private void makeMenu() {
		newGameAction = new AbstractAction("New Game") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		};
		restartAction = new AbstractAction("Restart") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				restartGame();
			}
		};
		numberedRestartAction = new AbstractAction("Numbered") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				newNumbered();
			}
		};
		tournamentAction = new AbstractAction("Tournament Mode") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				toggleTournamentMode();
			}
		};
		exitAction = new AbstractAction("Exit") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		};
		viewRemovedTilesAction = new AbstractAction("View Removed Tiles") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				viewRemovedTilesUI();
			}
		};
		undoAction = new AbstractAction("Undo") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				board.undo();
			}
		};
		redoAction = new AbstractAction("Redo") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				board.redo();
			}
		};
		toggleAudioAction = new AbstractAction("Audio On/Off") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				audioOn = !audioOn;
				board.fireworks.setSound(audioOn);
			}
		};
		operationAction = new AbstractAction("Operation") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				Help help = new Help("help/operation.html", "Operation");
				help.display();
			}
		};
		gameRulesAction = new AbstractAction("Game Rules") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				Help help = new Help("help/game rules.html", "Game Rules");
				help.display();
			}
		};

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu gameMenu = makeMenu("Game", 'G');
		menuBar.add(gameMenu);

		gameMenu.add(makeMenuItem("New Game", "Starts a new game", "ctrl N", 'N', newGameAction));
		gameMenu.add(makeMenuItem("Restart", "Restarts the current game", "ctrl R", 'R', restartAction));
		gameMenu.add(makeMenuItem("Numbered", "Starts a specifed game based on 6 digit number", null, 'M', numberedRestartAction));
		gameMenu.add(makeMenuItem("Tournament Mode", "Enters into tournament mode", "ctr T", 'T', tournamentAction));
		gameMenu.add(makeMenuItem("Removed Tiles", "Displays removed tiles", null, 'V', viewRemovedTilesAction));
		gameMenu.add(makeMenuItem("Exit", "Exits the program", null, 'E', exitAction));

		JMenu soundMenu = makeMenu("Sound", 'S');
		menuBar.add(soundMenu);

		soundMenu.add(makeMenuItem("On/Off", "Turns the sound on/off", "ctrl M", 'A', toggleAudioAction));

		JMenu moveMenu = makeMenu("Move", 'M');
		menuBar.add(moveMenu);

		moveMenu.add(makeMenuItem("Undo", "Undoes the last move", "ctrl Z", 'U', undoAction));
		moveMenu.add(makeMenuItem("Redo", "Redoes the last undone move", "ctrl shift Z", 'R', redoAction));

		JMenu helpMenu = makeMenu("Help", 'H');
		menuBar.add(helpMenu);

		helpMenu.add(makeMenuItem("Operation", null, null, 'O', operationAction));
		helpMenu.add(makeMenuItem("Game Rules", "Rules of the game", null, 'R', gameRulesAction));
	}

	private JMenuItem makeMenuItem(String label, String tip, String accelerator, char mnemonic, Action action) {
		JMenuItem menuItem = new JMenuItem(action);
		menuItem.setMnemonic(mnemonic);
		menuItem.setToolTipText(tip);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(accelerator));

		return menuItem;
	}

	private JMenu makeMenu(String label, char mnemonic) {
		JMenu menu = new JMenu(label);
		menu.setMnemonic(mnemonic);
		return menu;
	}

	private void viewRemovedTilesUI() {
		layout = new GridBagLayout();
		constraints = new GridBagConstraints();
		tilePanel = new JPanel(layout);
		JPanel tiles = new JPanel();

		tiles.add(new JScrollPane(tilePanel));

		if (board.removedCount[0] > 0) {
			addComponent(new CharacterTile('1'), 0, 0);
			addComponent(new JLabel("x " + board.removedCount[0]), 0, 1);
		}
		if (board.removedCount[1] > 0) {
			addComponent(new CharacterTile('2'), 0, 2);
			addComponent(new JLabel("x " + board.removedCount[1]), 0, 3);
		}
		if (board.removedCount[2] > 0) {
			addComponent(new CharacterTile('3'), 0, 4);
			addComponent(new JLabel("x " + board.removedCount[2]), 0, 5);
		}
		if (board.removedCount[3] > 0) {
			addComponent(new CharacterTile('4'), 0, 6);
			addComponent(new JLabel("x " + board.removedCount[3]), 0, 7);
		}
		if (board.removedCount[4] > 0) {
			addComponent(new CharacterTile('5'), 0, 8);
			addComponent(new JLabel("x " + board.removedCount[4]), 0, 9);
		}
		if (board.removedCount[5] > 0) {
			addComponent(new CharacterTile('6'), 0, 10);
			addComponent(new JLabel("x " + board.removedCount[5]), 0, 11);
		}
		if (board.removedCount[6] > 0) {
			addComponent(new CharacterTile('7'), 0, 12);
			addComponent(new JLabel("x " + board.removedCount[6]), 0, 13);
		}
		if (board.removedCount[7] > 0) {
			addComponent(new CharacterTile('8'), 0, 14);
			addComponent(new JLabel("x " + board.removedCount[7]), 0, 15);
		}
		if (board.removedCount[8] > 0) {
			addComponent(new CharacterTile('9'), 0, 16);
			addComponent(new JLabel("x " + board.removedCount[8]), 0, 17);
		}

		if (board.removedCount[9] > 0) {
			addComponent(new CircleTile(1), 1, 0);
			addComponent(new JLabel("x " + board.removedCount[9]), 1, 1);
		}
		if (board.removedCount[10] > 0) {
			addComponent(new CircleTile(2), 1, 2);
			addComponent(new JLabel("x " + board.removedCount[10]), 1, 3);
		}
		if (board.removedCount[11] > 0) {
			addComponent(new CircleTile(3), 1, 4);
			addComponent(new JLabel("x " + board.removedCount[11]), 1, 5);
		}
		if (board.removedCount[12] > 0) {
			addComponent(new CircleTile(4), 1, 6);
			addComponent(new JLabel("x " + board.removedCount[12]), 1, 7);
		}
		if (board.removedCount[13] > 0) {
			addComponent(new CircleTile(5), 1, 8);
			addComponent(new JLabel("x " + board.removedCount[13]), 1, 9);
		}
		if (board.removedCount[14] > 0) {
			addComponent(new CircleTile(6), 1, 10);
			addComponent(new JLabel("x " + board.removedCount[14]), 1, 11);
		}
		if (board.removedCount[15] > 0) {
			addComponent(new CircleTile(7), 1, 12);
			addComponent(new JLabel("x " + board.removedCount[15]), 1, 13);
		}
		if (board.removedCount[16] > 0) {
			addComponent(new CircleTile(8), 1, 14);
			addComponent(new JLabel("x " + board.removedCount[16]), 1, 15);
		}
		if (board.removedCount[17] > 0) {
			addComponent(new CircleTile(9), 1, 16);
			addComponent(new JLabel("x " + board.removedCount[17]), 1, 17);
		}

		if (board.removedCount[18] > 0) {
			addComponent(new Bamboo1Tile(), 2, 0);
			addComponent(new JLabel("x " + board.removedCount[18]), 2, 1);
		}
		if (board.removedCount[19] > 0) {
			addComponent(new BambooTile(2), 2, 2);
			addComponent(new JLabel("x " + board.removedCount[19]), 2, 3);
		}
		if (board.removedCount[20] > 0) {
			addComponent(new BambooTile(3), 2, 4);
			addComponent(new JLabel("x " + board.removedCount[20]), 2, 5);
		}
		if (board.removedCount[21] > 0) {
			addComponent(new BambooTile(4), 2, 6);
			addComponent(new JLabel("x " + board.removedCount[21]), 2, 7);
		}
		if (board.removedCount[22] > 0) {
			addComponent(new BambooTile(5), 2, 8);
			addComponent(new JLabel("x " + board.removedCount[22]), 2, 9);
		}
		if (board.removedCount[23] > 0) {
			addComponent(new BambooTile(6), 2, 10);
			addComponent(new JLabel("x " + board.removedCount[23]), 2, 11);
		}
		if (board.removedCount[24] > 0) {
			addComponent(new BambooTile(7), 2, 12);
			addComponent(new JLabel("x " + board.removedCount[24]), 2, 13);
		}
		if (board.removedCount[25] > 0) {
			addComponent(new BambooTile(8), 2, 14);
			addComponent(new JLabel("x " + board.removedCount[25]), 2, 15);
		}
		if (board.removedCount[26] > 0) {
			addComponent(new BambooTile(9), 2, 16);
			addComponent(new JLabel("x " + board.removedCount[26]), 2, 17);
		}

		if (board.removedCount[27] > 0) {
			addComponent(new WindAndDragonTile('N'), 3, 0);
			addComponent(new JLabel("x " + board.removedCount[27]), 3, 1);
		}
		if (board.removedCount[28] > 0) {
			addComponent(new WindAndDragonTile('E'), 3, 2);
			addComponent(new JLabel("x " + board.removedCount[28]), 3, 3);
		}
		if (board.removedCount[29] > 0) {
			addComponent(new WindAndDragonTile('W'), 3, 4);
			addComponent(new JLabel("x " + board.removedCount[29]), 3, 5);
		}
		if (board.removedCount[30] > 0) {
			addComponent(new WindAndDragonTile('S'), 3, 6);
			addComponent(new JLabel("x " + board.removedCount[30]), 3, 7);
		}

		if (board.removedCount[31] > 0) {
			addComponent(new WindAndDragonTile('C'), 4, 0);
			addComponent(new JLabel("x " + board.removedCount[31]), 4, 1);
		}
		if (board.removedCount[32] > 0) {
			addComponent(new WindAndDragonTile('F'), 4, 2);
			addComponent(new JLabel("x " + board.removedCount[32]), 4, 3);
		}
		if (board.removedCount[33] > 0) {
			addComponent(new WhiteDragonTile(), 4, 4);
			addComponent(new JLabel("x " + board.removedCount[33]), 4, 5);
		}

		if (board.removedCount[34] > 0) {
			addComponent(new FlowerTile("Chrysanthemum"), 5, 0);
			addComponent(new JLabel("x " + board.removedCount[34]), 5, 1);
		}
		if (board.removedCount[35] > 0) {
			addComponent(new FlowerTile("Orchid"), 5, 2);
			addComponent(new JLabel("x " + board.removedCount[35]), 5, 3);
		}
		if (board.removedCount[36] > 0) {
			addComponent(new FlowerTile("Plum"), 5, 4);
			addComponent(new JLabel("x " + board.removedCount[36]), 5, 5);
		}
		if (board.removedCount[37] > 0) {
			addComponent(new FlowerTile("Bamboo"), 5, 6);
			addComponent(new JLabel("x " + board.removedCount[37]), 5, 7);
		}

		if (board.removedCount[38] > 0) {
			addComponent(new SeasonTile("Spring"), 6, 0);
			addComponent(new JLabel("x " + board.removedCount[38]), 6, 1);
		}
		if (board.removedCount[39] > 0) {
			addComponent(new SeasonTile("Summer"), 6, 2);
			addComponent(new JLabel("x " + board.removedCount[39]), 6, 3);
		}
		if (board.removedCount[40] > 0) {
			addComponent(new SeasonTile("Fall"), 6, 4);
			addComponent(new JLabel("x " + board.removedCount[40]), 6, 5);
		}
		if (board.removedCount[41] > 0) {
			addComponent(new SeasonTile("Winter"), 6, 6);
			addComponent(new JLabel("x " + board.removedCount[41]), 6, 7);
		}

		JOptionPane.showMessageDialog(null, tiles);
	}

	private void addComponent(Component c, int row, int col) {
		constraints.gridx = col;
		constraints.gridy = row;
		layout.setConstraints(c, constraints);
		tilePanel.add(c);
	}

	private void newGame() {
		int option = JOptionPane.showConfirmDialog(this, "Do you want to start a new game?", "New Game",
				JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			MahJongBoard.seed = (int) (System.currentTimeMillis() % 1000000);
			MahJongBoard.setRand();
			mahjong.remove(board);
			board = new MahJongBoard();
			mahjong.add(board);
			scoreLabel.setText(String.valueOf(score = 0));

			setTitle("MahJong");

			revalidate();
			repaint();
		}
	}

	private void restartGame() {
		int option = JOptionPane.showConfirmDialog(this, "Do you want to restart the game?", "Restart",
				JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			MahJongBoard.setRand(MahJongBoard.seed);
			mahjong.remove(board);
			board = new MahJongBoard();
			mahjong.add(board);
			MahJongBoard.setRand();
			scoreLabel.setText(String.valueOf(score = 0));

			revalidate();
			repaint();
		}
	}

	private void newNumbered() {
		String seedString = JOptionPane
				.showInputDialog("Enter a six digit number of which game you would like to play:", 012345);
		if (seedString == null)
			return;
		int seed = Integer.parseInt(seedString);
		MahJongBoard.setRand(seed);
		mahjong.remove(board);
		board = new MahJongBoard();
		mahjong.add(board);
		MahJongBoard.setRand();
		scoreLabel.setText(String.valueOf(score = 0));

		setTitle("MahJong - " + seed);

		revalidate();
		repaint();
	}
	
	public void toggleTournamentMode() {
		newGameAction.setEnabled(tournamentMode);
		restartAction.setEnabled(tournamentMode);
		numberedRestartAction.setEnabled(tournamentMode);
		viewRemovedTilesAction.setEnabled(tournamentMode);
		undoAction.setEnabled(tournamentMode);
		redoAction.setEnabled(tournamentMode);
		
		if(!tournamentMode) {
		timePanel = new JPanel();
		timePanel.add(timeLabel = new JLabel(String.format("Elapsed Time: %02d:%02d:%02d", TimeUnit.SECONDS.toHours(timerTime), TimeUnit.SECONDS.toMinutes(timerTime), TimeUnit.SECONDS.toSeconds(timerTime))));
		mahjong.add(timePanel, BorderLayout.NORTH);
		} else {
			mahjong.remove(timePanel);
			timerTime = 0;
		}
		
		mahjong.pack();
		mahjong.revalidate();
		mahjong.repaint();

		MahJongBoard.seed = (int) (System.currentTimeMillis() % 1000000);
		MahJongBoard.setRand();
		mahjong.remove(board);
		board = new MahJongBoard();
		mahjong.add(board);
		scoreLabel.setText(String.valueOf(score = 0));

		setTitle("MahJong");

		revalidate();
		repaint();
		
		if(!tournamentMode) {
			timer = new Timer();
			updateTimeAction = new TimerTask(){
				@Override
				public void run() {
					timerTime++;
					timeLabel.setText(String.format("Elapsed Time: %02d:%02d:%02d", TimeUnit.SECONDS.toHours(timerTime), TimeUnit.SECONDS.toMinutes(timerTime) - TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(timerTime)), TimeUnit.SECONDS.toSeconds(timerTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(timerTime))));
				}
				
			};
			timer.scheduleAtFixedRate(updateTimeAction, 1000, 1000);
		} else {
			timer.cancel();
		}

		tournamentMode = !tournamentMode;
	}

	public void exit() {
		if (JOptionPane.showConfirmDialog(this, "Exit Program?", "Confirm Exit",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	public static void main(String[] args) {
		mahjong = new MahJong();
	}
}
