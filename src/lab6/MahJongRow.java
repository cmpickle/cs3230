package lab6;

import java.util.ArrayList;

public class MahJongRow extends ArrayList<ArrayList<Tile>> {
	private static final long serialVersionUID = 1L;
	
//	private int x;
//	private int y;
//	private int row;
	
//	private ArrayList<ArrayList<Tile>> stack = new ArrayList<ArrayList<Tile>>();
	
	public MahJongRow(int row) {
//		this.row = row;
		
		for(int i=0; i<8; i++) {
			this.add(new ArrayList<Tile>(15));
		}
		
//		switch(row) {
//		case 0:
//			this.add(new ArrayList<Tile>(12));
//			break;
//		case 1:
//			this.add(new ArrayList<Tile>(8));
//			this.add(new ArrayList<Tile>(6));
//			break;
//		case 2:
//			this.add(new ArrayList<Tile>(10));
//			this.add(new ArrayList<Tile>(6));
//			this.add(new ArrayList<Tile>(4));
//			break;
//		case 3:
//			this.add(new ArrayList<Tile>(14));
//			this.add(new ArrayList<Tile>(6));
//			this.add(new ArrayList<Tile>(4));
//			this.add(new ArrayList<Tile>(2));
//			break;
//		case 4:
//			this.add(new ArrayList<Tile>(13));
//			this.add(new ArrayList<Tile>(6));
//			this.add(new ArrayList<Tile>(4));
//			this.add(new ArrayList<Tile>(2));
//			this.add(new ArrayList<Tile>(1));
//			break;
//		case 5:
//			this.add(new ArrayList<Tile>(10));
//			this.add(new ArrayList<Tile>(6));
//			this.add(new ArrayList<Tile>(4));
//			break;
//		case 6:
//			this.add(new ArrayList<Tile>(8));
//			this.add(new ArrayList<Tile>(6));
//			break;
//		case 7:
//			this.add(new ArrayList<Tile>(12));
//			break;
//		}
	}
	
//	public ArrayList<Tile> getStack() {
//		return stack;
//	}
}
