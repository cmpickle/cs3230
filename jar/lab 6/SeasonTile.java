import javax.swing.ImageIcon;

public class SeasonTile extends PictureTile {
	private static final long serialVersionUID = 1L;

	public SeasonTile(String name) {
		super(name);
	}
	
	public SeasonTile(int num) {
		super("");
		String name = "";
		
		switch(num) {
			case 0:
				name="Spring";
				break;
			case 1:
				name="Summer";
				break;
			case 2:
				name="Fall";
				break;
			case 3:
				name="Winter";
				break;
		}
		
		super.name = name;
		super.image = new ImageIcon("images/" + name + ".png");
	}
}
