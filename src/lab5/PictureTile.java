package lab5;

import java.awt.*;
import javax.swing.*;

abstract public class PictureTile extends Tile {
	private static final long serialVersionUID = 1L;
	private String name;
	protected ImageIcon image;

	public PictureTile(String name) {
		this.name = name;
		image = new ImageIcon("images/" + name + ".png");
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		setToolTipText(toString());
		int imageSize = (int)(face.width*.9);
		g.drawImage(image.getImage(), face.width/2-imageSize/2, face.height/2-imageSize/2, imageSize, imageSize, this);
	}

	public String toString() {
		return name;
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Picture Tiles");

		frame.add(new Bamboo1Tile());

		frame.add(new FlowerTile("Chrysanthemum"));
		frame.add(new FlowerTile("Orchid"));
		frame.add(new FlowerTile("Plum"));
		frame.add(new FlowerTile("Bamboo"));

		frame.add(new SeasonTile("Spring"));
		frame.add(new SeasonTile("Summer"));
		frame.add(new SeasonTile("Fall"));
		frame.add(new SeasonTile("Winter"));

		frame.pack();
		frame.setVisible(true);
	}
}
