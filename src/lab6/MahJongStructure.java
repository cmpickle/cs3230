package lab6;

public class MahJongStructure {
	public Tile[][][] struct = new Tile[15][8][5];
	
	public MahJongStructure() {
		
	}
	
	public void addTile(Tile t, int x, int y , int z) {
		struct[x][y][z] = t;
	}
	
	public Tile getTile(int x, int y, int z) {
		return struct[x][y][z];
	}
	
	public Tile removeTile(int[] location) {
		Tile t = struct[location[0]][location[1]][location[2]];
		struct[location[0]][location[1]][location[2]] = null;
		return t;
	}
}
