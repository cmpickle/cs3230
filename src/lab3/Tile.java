package lab3;

public abstract class Tile {
	public boolean matches(Tile other){
		if(this == other) return true;
		
		if(other==null) return false;
		
		if(getClass() == other.getClass()) return true;
		
		return false;
	}
}
