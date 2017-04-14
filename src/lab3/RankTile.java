package lab3;

public abstract class RankTile extends Tile {
	protected int rank;
	
	public RankTile(int rank) {
		this.rank = rank;
	}
	
	public boolean matches(Tile other) {
		if(this == other) return true;
		
		if(other==null) return false;
		
		if(getClass() != other.getClass()) return false;
		
		RankTile otherRankTile = (RankTile) other;
		
		if(this.rank == otherRankTile.rank) return true;
		
		return false;
	}
}
