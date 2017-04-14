public class CharacterTile extends Tile {
	protected char symbol;
	
	public CharacterTile(char symbol) {
		this.symbol = symbol;
	}
	
	public boolean matches(Tile other) {
		super.matches(other);
		CharacterTile otherCharacterTile = (CharacterTile) other;
		
		if(this.symbol == otherCharacterTile.symbol) return true;
		
		return false;
	}
	
	public String toString() {
		switch(symbol) {
			case 'N':
				return "North Wind";
			case 'E':
				return "East Wind";
			case 'W':
				return "West Wind";
			case 'S':
				return "South Wind";
			case 'C':
				return "Red Dragon";
			case 'F':
				return "Green Dragon";
			default:
				return "Character " + symbol;
		}
	}
}
