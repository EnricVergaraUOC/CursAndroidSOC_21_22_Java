package LogicGame;

public abstract class Piece {
	
	public final static boolean WHITE = true;
	public final static boolean BLACK = false;
	public final static Piece EMPTY = null;
	
	protected boolean colour;
	
	public Piece(boolean colour) {
		SetColour(colour);
	}
	
	public void SetColour(boolean colour) {
		this.colour = colour;
	}
	
	public boolean GetColour() {
		return this.colour;
	}
	
	
	
	
}


