package common;

import java.awt.event.ActionListener;
import	java.beans.*;
import javax.swing.*;

public class MakeMenuItem {
	// factory methods for building menu components

	@SuppressWarnings("unused")
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


	@SuppressWarnings("unused")
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


	@SuppressWarnings("unused")
	private JMenu makeMenu(String label, char mnemonic)
	{
		JMenu	menu = new JMenu(label);
		menu.setMnemonic(mnemonic);
		return menu;
	}
}
