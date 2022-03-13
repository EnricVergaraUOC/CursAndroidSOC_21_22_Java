package LogicGame;

import java.util.ArrayList;

public abstract class Piece {
	
	public final static boolean WHITE = true;
	public final static boolean BLACK = false;
	public final static Piece EMPTY = null;
	
	public static int TOTAL_WHITE_PIECES = 0;
	public static int TOTAL_BLACK_PIECES = 0;
	
	
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
	
	public abstract ArrayList<String> GetValidMoves (ChessBoard board, String position);
	
	public static boolean IsInsideBoard(int col, int row) {
		if (col >= 0 && col < ChessBoard.COLS &&
				row >= 0 && row < ChessBoard.ROWS) {
			return true;
		}
		return false;
	}

	

	public static String convertPosToString(int col, int row) {
		String position = "";
		position += (char)('a' + col);
		position += (char)('1' + row);
		return position;
	}
	
	
}


