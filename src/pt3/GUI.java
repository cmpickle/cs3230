package pt3;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;

	Action northAction = new AbstractAction("North") {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			north();				
		}
	};
	
	Action southAction = new AbstractAction("South") {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			south();				
		}
	};
	
	Action eastAction = new AbstractAction("East") {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			east();				
		}
	};
	
	Action westAction = new AbstractAction("West") {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			west();				
		}
	};

	public GUI() {
		setTitle("GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,200);
		setLocationRelativeTo(null);
		
		makeMenu();
		
		JButton northButton = new JButton("North");
		JButton eastButton = new JButton("East");
		JButton southButton = new JButton("South");
		JButton westButton = new JButton("West");
		
		northButton.addActionListener(northAction);
		eastButton.addActionListener(eastAction);
		southButton.addActionListener(southAction);
		westButton.addActionListener(westAction);
		
		MyPanel northPanel = new MyPanel();
		MyPanel eastPanel = new MyPanel();
		MyPanel southPanel = new MyPanel();
		MyPanel westPanel = new MyPanel();
		
		northPanel.add(northButton);
		eastPanel.add(eastButton);
		southPanel.add(southButton);
		westPanel.add(westButton);
		
		add(northPanel, BorderLayout.NORTH);
		add(eastPanel, BorderLayout.EAST);
		add(southPanel, BorderLayout.SOUTH);
		add(westPanel, BorderLayout.WEST);
		
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		public MyPanel() {
			setLayout(new GridBagLayout());
		}
	}
	
	public void north() {
		JOptionPane.showMessageDialog(this, "North", "Direction", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void east() {
		JOptionPane.showMessageDialog(this, "East", "Direction", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void south() {
		JOptionPane.showMessageDialog(this, "South", "Direction", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void west() {
		JOptionPane.showMessageDialog(this, "West", "Direction", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void makeMenu()
	{
		JMenuBar	menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu directionsMenu = makeMenu("Directions", 'D');
		menuBar.add(directionsMenu);
		
		directionsMenu.add(makeMenuItem("North", "Displays North", "ctrl N", 'N', northAction));
		directionsMenu.add(makeMenuItem("South", "Displays South", "ctrl S", 'S', southAction));
		directionsMenu.add(makeMenuItem("East", "Displays East", "ctrl E", 'E', eastAction));
		directionsMenu.add(makeMenuItem("West", "Displays West", "ctrl W", 'W', westAction));
	}
	
	private JMenuItem makeMenuItem(String label, String tip, String accelerator, char mnemonic,
			Action action)
	{
		JMenuItem	menuItem = new JMenuItem(action);
		menuItem.setMnemonic(mnemonic);
		menuItem.setToolTipText(tip);				
		menuItem.setAccelerator(KeyStroke.getKeyStroke(accelerator));

		return menuItem;
	}


	private JMenu makeMenu(String label, char mnemonic)
	{
		JMenu	menu = new JMenu(label);
		menu.setMnemonic(mnemonic);
		return menu;
	}
	
	public static void main(String[] args) {
		new GUI();
	}
}
