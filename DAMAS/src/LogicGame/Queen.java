package LogicGame;

import java.util.ArrayList;

public class Queen extends Piece {
	final String white_queen = "\u25CE";
	final String black_queen = "\u25C9";
	
	public Queen(boolean colour) {
		super(colour);
	}
	
	public String toString() {
		return this.colour? white_queen: black_queen;
	}
	
	public  ArrayList<String> GetValidMoves (ChessBoard board, String position) {
		return null;
	}
}