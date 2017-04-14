package lab6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BoardBackground extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private ImageIcon bg = new ImageIcon("images/dragon_bg.png");
	private int width;
	private int height;
	
	public BoardBackground(int width, int height) {
		this.width = width;
		this.height = height;
		
		setSize(width, height);
		bg.setImage(bg.getImage().getScaledInstance((int)(width*.95), (int)(height*.95), Image.SCALE_SMOOTH));
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(new Color(230, 140, 50));
		g.fillRect(0, 0, width, height);
		g.drawImage(bg.getImage(), width/2 - bg.getIconWidth()/2, height/2 - bg.getIconHeight()/2, this);
	}
}
