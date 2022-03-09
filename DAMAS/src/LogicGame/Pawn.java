package LogicGame;

public class Pawn extends Piece {
	final String white_pawn = "\u25CB";
	final String black_pawn = "\u25CF";
	
	public Pawn(boolean colour) {
		super(colour);
	}
	
	public String toString() {
		return this.colour? white_pawn: black_pawn;
	}
	
	public  Cell GetValidMoves (ChessBoard board) {
		System.out.println("GetValidMoves from Pawn");
		return null;
	}
}
