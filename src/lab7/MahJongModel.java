package lab7;

import java.util.ArrayList;

public class MahJongModel {
	ArrayList<MahJongRow> board = new ArrayList<MahJongRow>();
	int row;
	
	public MahJongModel() {
		for(int i=0; i<12; i++) {
			board.add(new MahJongRow(i));
		}
	}
	
	public Tile getTile(int row, int column, int layer) {
		return board.get(row).get(column).get(layer);
	}
	
	public void setTile(Tile tile, int row, int column, int layer) {
		board.get(row).get(layer).add(column, tile);//.get(column).add(tile);
	}
}
