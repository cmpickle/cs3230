


public class MahJongStructure {
	public Tile[][][] struct = new Tile[15][8][5];
	
	public MahJongStructure() {
		
	}
	
	public void addTile(Tile t, int x, int y, int z) {
		struct[x][y][z] = t;
		this.getTile(x, y, z).setStructLocation(x, y, z);
	}

	public Tile getTile(int x, int y, int z) {
		return struct[x][y][z];
	}
	
	public boolean isTileRemovable(Tile t) {
		int[] location = t.getStructLocation();
		if(location[2] < 4) {
			if(struct[location[0]][location[1]][location[2]+1] != null && struct[location[0]][location[1]][location[2]+1].isInPlay()) 		//Check that there isn't a tile about this tile
				return false;
			if(location[0] != 0 && location[0] != 14 && 																					//Check that there isn't a tile on both sides of this tile
					struct[location[0]-1][location[1]][location[2]] != null && struct[location[0]-1][location[1]][location[2]].isInPlay() && 
					struct[location[0]+1][location[1]][location[2]] != null && struct[location[0]+1][location[1]][location[2]].isInPlay())
				return false;
			if(location[0] >= 6 && location[0] <= 7 && location[1] >=3 && location[1] <= 4 && location[2] == 3 && struct[7][4][4].isInPlay()) //If the top tile overlays any of the four below it don't remove them
				return false;
			if(location[1] == 4 && location[0] == 1 && struct[0][3][0].isInPlay())
				return false;
			if(location[1] == 4 && location[0] == 12 && struct[13][3][0].isInPlay())
				return false;
		}
		
		return true;
	}
}
