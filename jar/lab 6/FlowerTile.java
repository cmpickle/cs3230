import javax.swing.ImageIcon;

public class FlowerTile extends PictureTile {
	private static final long serialVersionUID = 1L;

	public FlowerTile(String name) {
		super(name);
	}
	
	public FlowerTile(int num) {
		super("");
		String name = "";
		
		switch(num) {
			case 0:
				name="Chrysanthemum";
				break;
			case 1:
				name="Orchid";
				break;
			case 2:
				name="Plum";
				break;
			case 3:
				name="Bamboo";
				break;
		}
		
		super.name = name;
		super.image = new ImageIcon("images/" + name + ".png");
	}
}
