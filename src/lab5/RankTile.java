package lab5;

abstract public class RankTile extends Tile {
	private static final long serialVersionUID = 1L;
	protected int rank;

	public RankTile(int rank) {
		this.rank = rank;
	}

	public boolean matches(Tile other) {
		return super.matches(other) && rank == ((RankTile) other).rank;
	}
}
