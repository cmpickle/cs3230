package common;

import	java.awt.*;
import	java.awt.event.*;
import	javax.swing.*;
import	java.beans.*;


public class MenuDemo extends JFrame
{
	private static final long serialVersionUID = 1L;
	private	JPanel	color = new JPanel();
	private JLabel	label = new JLabel("Hello");


	public MenuDemo()
	{
		setTitle("Menu Demo");
		setSize(600, 400);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter()
				{ public void windowClosing(WindowEvent e)
					{ exit(); }
				});

		add(color);
		color.setBackground(Color.YELLOW);
		color.add(label);

		makeMenu();

		setVisible(true);
	}


	public void exit()
	{
		if (JOptionPane.showConfirmDialog(this,
					"Do you want to end this program?", "End Program",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
			System.exit(0);
	}


	public void red()
	{
		color.setBackground(Color.RED);
	}


	public void blue()
	{
		color.setBackground(Color.BLUE);
	}
	
	public void hello()
	{
		label.setText("Hello");
	}
	
	
	public void goodbye()
	{
		label.setText("Goodbye");
	}


	private void makeMenu()
	{
		JMenuBar	menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu colorMenu = makeMenu("Color", 'C');
		//JMenu	colorMenu = new JMenu("Color");
		//colorMenu.setMnemonic('C');		// alt-C
		menuBar.add(colorMenu);
		
		colorMenu.add(makeMenuItem("Red", "Change the color to red", "ctrl R", 'R', "red", this));
//
//		red.setToolTipText("Change the color to red");
//		red.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
//		//red.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
//		//red.setAccelerator(KeyStroke.getKeyStroke('R'));	// case sensitive
//		colorMenu.add(red);
//
//		red.addActionListener(new ActionListener()
//				{ public void actionPerformed(ActionEvent e)
//					{ red(); }
//				});

		colorMenu.add(makeMenuItem("Blue", "Change the color to blue", "ctrl B", 'B', "blue", this));
		
//		JMenuItem	blue = new JMenuItem("Blue", 'B');
//		blue.setToolTipText("Change the color to blue");
//		blue.setAccelerator(KeyStroke.getKeyStroke("ctrl B"));
//		colorMenu.add(blue);
//		blue.addActionListener(new ActionListener()
//				{ public void actionPerformed(ActionEvent e)
//					{ blue(); }
//				});

		colorMenu.addSeparator();
		
		colorMenu.add(makeMenuItem("Exit", "Exit the program", "ctrl E", 'E', "exit", this));

//		JMenuItem	exit = new JMenuItem("Exit", 'E');
//		exit.setToolTipText("Exit the program");
//		exit.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
//		colorMenu.add(exit);
//		exit.addActionListener(new ActionListener()
//				{ public void actionPerformed(ActionEvent e)
//					{ exit(); }
//				});


		ButtonGroup	group = new ButtonGroup();

		JMenu messageMenu = makeMenu("Message", 'M');
//		JMenu		messageMenu = new JMenu("Message");
//		messageMenu.setMnemonic('M');
		menuBar.add(messageMenu);
		
		messageMenu.add(makeRadioMenuItem("Hello", "Say Hello", true, group, "hello", this));

//		JRadioButtonMenuItem	helloItem = new JRadioButtonMenuItem("Hello", true);
//		group.add(helloItem);
//		messageMenu.add(helloItem);
//		helloItem.setToolTipText("Say Hello");
//		helloItem.setAccelerator(KeyStroke.getKeyStroke("ctrl H"));
//		helloItem.setMnemonic('H');
//		helloItem.addActionListener(new ActionListener()
//				{ public void actionPerformed(ActionEvent e)
//					{ label.setText("Hello"); }
//				});
		
		messageMenu.add(makeRadioMenuItem("Goodbye", "Say Goodbye", true, group, "goodbye", this));

//		JRadioButtonMenuItem	goodbyeItem = new JRadioButtonMenuItem("Goodbye");
//		group.add(goodbyeItem);
//		messageMenu.add(goodbyeItem);
//		goodbyeItem.setToolTipText("Say Goodbye");
//		goodbyeItem.setAccelerator(KeyStroke.getKeyStroke("ctrl G"));
//		goodbyeItem.setMnemonic('G');
//		goodbyeItem.addActionListener(new ActionListener()
//				{ public void actionPerformed(ActionEvent e)
//					{ label.setText("Goodbye"); }
//				});
	}
	
	private JMenuItem makeMenuItem(String label, String tip, String accelerator, char mnemonic,
			String method, Object target)
	{
		JMenuItem	menuItem = new JMenuItem(label, mnemonic);
		menuItem.setToolTipText(tip);				// adds tool tip text
		menuItem.setAccelerator(KeyStroke.getKeyStroke(accelerator));

		// sets up event handling: "method" is called when "menuItem" is selected
		menuItem.addActionListener((ActionListener)EventHandler.create(ActionListener.class,
					target, method));

		return menuItem;
	}


	private JMenuItem makeRadioMenuItem(String label, String tip, boolean selected, ButtonGroup group,
			String method, Object target)
	{
		JRadioButtonMenuItem	radioItem = new JRadioButtonMenuItem(label, selected);
		radioItem.setToolTipText(tip);				// adds tool tip text
		group.add(radioItem);

		// sets up event handling: "method" is called when "menuItem" is selected
		radioItem.addActionListener((ActionListener)EventHandler.create(ActionListener.class,
					target, method));

		return radioItem;
	}


	private JMenu makeMenu(String label, char mnemonic)
	{
		JMenu	menu = new JMenu(label);
		menu.setMnemonic(mnemonic);
		return menu;
	}



	public static void main(String[] args)
	{
		new MenuDemo();
	}
}
