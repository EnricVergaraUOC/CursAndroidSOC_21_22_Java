package LogicGame;

import java.util.ArrayList;

public class Pawn extends Piece {
	final String white_pawn = "\u25CB";
	final String black_pawn = "\u25CF";
	
	public Pawn(boolean colour) {
		super(colour);
	}
	
	public String toString() {
		return this.colour? white_pawn: black_pawn;
	}
	
	public ArrayList<String> GetValidMoves (ChessBoard board, String position) {
		ArrayList<String> moves = new ArrayList<String>();
		
		int VerticalDir = 1;
		if (this.colour == Piece.BLACK) {
			VerticalDir = -1;
		}
		String validPos;
		validPos = GetValidMovesAux(board, position, VerticalDir, 1);
		if (validPos != null) {
			moves.add(validPos);
		}
		
		validPos = GetValidMovesAux(board, position, VerticalDir, -1);
		if (validPos != null) {
			moves.add(validPos);
		}
		
		return moves;
	}
	
	public String GetValidMovesAux (ChessBoard board, String position,
		int hDir, int vDir) {
		String res = null;
		
		int col_original = board.getCol(position);
		int row_original = board.getRow(position);
		
		//Move just one diagonal position
		int col_move, row_move;
		col_move = col_original + vDir;
		row_move = row_original + hDir;
		if (!IsInsideBoard(col_move, row_move)){
			return null;
		}
		String newPos = convertPosToString(col_move, row_move);
		Cell c = board.getCell(newPos);
		if (!c.hasPiece()) {
			res = newPos;
		}else if(c.getPiece().GetColour() != this.colour){
			col_move += vDir;
			row_move += hDir;
			if (!IsInsideBoard(col_move, row_move)){
				return null;
			}else {
				newPos = convertPosToString(col_move, row_move);
				c = board.getCell(newPos);
				if (c.hasPiece()) {
					res = newPos;
				}
			}
		}
			
		return res;
	}
	
	private boolean IsInsideBoard(int col, int row) {
		if (col >= 0 && col <= ChessBoard.COLS &&
				row >= 0 && row<= ChessBoard.ROWS) {
			return true;
		}
		return false;
	}

	

	private String convertPosToString(int col, int row) {
		String position = "";
		position += (char)('a' + col);
		position += (char)('1' + row);
		return position;
	}
}
