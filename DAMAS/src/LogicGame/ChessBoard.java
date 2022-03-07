package LogicGame;

public class ChessBoard {

	public final static int COLS = 8;
	public final static int ROWS = 8;
	
	ChessBoard(){
		board = new Cell[ROWS][COLS];
		initializeBoard();
		//initializePieces();
		
	}
	
	private void initializeBoard() {
		for(int row = ROWS -1; row >= 0; row--) {
			for(int col = 0; col < COLS; col++) {
				if ((row+col)%2==0) {
					board[row][col] = new Cell(Cell.WHITE, Piece.EMPTY);
				}else {
					board[row][col] = new Cell(Cell.BLACK, Piece.EMPTY);
				}
			}
		}
	}
	
	private void  initializePieces() {
		
	}
	
	public String toString() {

		String horizontal = "\u2500";
		String vertical = "\u2502";
		String top = "\u252C";
		String bottom = "\u2534";
		String left = "\u251C";
		String right = "\u2524";
		String center = "\u253C";
		String top_left = "\u250C";
		String top_right = "\u2510";
		String bottom_left = "\u2514";
		String bottom_right = "\u2518";
		String NL = System.getProperty("line.separator");
		String space = " ";
		String white_cell = "\u2591";
		String black_cell = "\u2588";	
		
		String chessBoard = "";
		
		//-----Line Top------------------------------
		String lineTop = "   a  b  c  d  e  f  g  h"+NL;
		lineTop += "  " + top_left;
		for (int col = 0; col < COLS -1 ; col++) {
		 lineTop += horizontal + horizontal + top;
		}
		lineTop += horizontal + horizontal + top_right;
		
		 
		//-----Line Bottom------------------------------
		String lineBottom = " " + bottom_left;
		for (int col = 0; col < COLS -1; col++) {
		 lineBottom += horizontal + horizontal + bottom;
		}
		lineBottom += horizontal + horizontal + bottom_right;
		
		//-----Line Middle--------------------------------
		String lineMiddle= " " + left;
		for (int col = 0; col < COLS -1; col++) {
		lineMiddle += horizontal + horizontal + center;
		}
		lineMiddle += horizontal + horizontal + right;
		 
		//---- Print all the board
		chessBoard = lineTop + NL;
		for (int row = ROWS - 1; row >=0; row--) {
			String fila = "";
			for (int col = 0; col < COLS; col++) {
				fila+= board[row][col].toString() + vertical ;

				 
			}
			chessBoard += (row+1) + space +  vertical + fila + NL;
			if (row>0) {
				chessBoard += space + lineMiddle + NL;
			}else {
				chessBoard += space +  lineBottom + NL;
			 }
				 
			 
		 }
		
		return chessBoard;
	}
	
	
	private Cell[][] board;
}