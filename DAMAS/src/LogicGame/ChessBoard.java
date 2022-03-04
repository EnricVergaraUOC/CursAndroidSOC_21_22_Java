package LogicGame;

public class ChessBoard {

	public final static int COLS = 8;
	public final static int ROWS = 8;
	
	ChessBoard(){
		board = new Cell[ROWS][COLS];
		initializeBoard();
		initializePieces();
		
	}
	
	private void initializeBoard() {
		for(int row = 0; row < ROWS; row++) {
			for(int col = 0; col < COLS; col++) {
				
				board[row][col] = new Cell(Cell.WHITE, new Queen(Piece.BLACK));
			}
		}
	}
	
	private void  initializePieces() {
		
	}
	
	public String toString() {
		String res = "";
		for (int i = 0; i < ROWS; i++)
		{
			for (int j = 0; j < COLS; j++) {
				res += board[i][j].toString();
			}
		}
		return res;
	}
	private Cell[][] board;
}