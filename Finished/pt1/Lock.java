public abstract class Lock {
	public boolean equals(Object other){
		if(this == other) return true;
		
		if(other==null) return false;
		
		if(getClass() == other.getClass()) return true;
		
		return false;
	}
}
