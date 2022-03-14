package LogicGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.*;

/**
 * Model object for ChessPlayer.
 *
 * @author  Jordi Blasco Planesas<br>
 *          Capacitaci&oacute; digital. Web 2.0 i xarxes socials.<br>
 *          Universitat Oberta de Catalunya (UOC)
 * @version  2.0
 */
public class Checkers {

	private final String NL = System.getProperty("line.separator");

	private BufferedReader in = null;
	private ChessBoard chessBoard = null;
	private boolean startedGame = false;
	private boolean player;
	private boolean DEVELOPMENT_MODE = true;

   /**
    * Default constructor. It initializes BufferedReader.
    */
	public Checkers() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

   /**
    * Method which create the interface of the main menu.
    * @return String  graphical representation of main menu
    */
	private String getMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("------------------------").append(NL);
		if (!this.startedGame)
			sb.append("1. Initialize ChessBoard").append(NL);
		else
			sb.append("2. Move a piece").append(NL);
		sb.append("3. Exit").append(NL);
		if (this.DEVELOPMENT_MODE)
			sb.append("4. Debug Cell").append(NL);
		sb.append("------------------------").append(NL);
		sb.append("Select option : ");
		return sb.toString();
	}
	
   /**
    * Private method used to read the option selected
    * by keyboard.
    * @return String  the option selected by keyboard.
    */
	private int readOption() {

		int option;

		if (this.startedGame)
			System.out.println(chessBoard.toString());
		System.out.print(getMenu());

		try {
			option = Integer.parseInt(in.readLine());
		} catch (Exception e) {
			option = 0;
		}
		return option;
	}
	
   /**
    * Private method used to read a chess piece move by keyboard.
    * @return String  the chess move input by keyboard.
    */
	private String readMove() {
		String move;

		System.out.println("Example: a3 b4");
		System.out.print("Move : ");

		try {
			move = in.readLine();
		} catch (Exception e) {
			move = "";
		}
		return move;
	}

   /**
    * Private method used to create a ChessBoard object and
    * set startedGame to true
    * @exception CheckersException throws all ChessPlayerException generated
    *                                 by the methods used here.
    */
	private void initializeBoard() throws CheckersException {
		chessBoard = new ChessBoard();
		this.startedGame = true;
	}

   /**
    * Method used to manage the move option of main menu
    * @exception CheckersException throws all ChessPlayerException generated
    *                                 by the methods used here.
    */
	private void movePiece(String move) throws CheckersException {

		String initialPosition = "";
		String finalPosition = "";

		// Check if the move matches the regular expression for a move
		move = move.toLowerCase();
		String re = "([a-h][1-8]) ([a-h][1-8])";
		Pattern pat = Pattern.compile(re, Pattern.CASE_INSENSITIVE
				| Pattern.DOTALL);
		Matcher m = pat.matcher(move);
		if (m.find()) {
			initialPosition = m.group(1);
			finalPosition = m.group(2);
		}
		if (initialPosition.isEmpty() || finalPosition.isEmpty()) {
			throw new CheckersException(
					CheckersException.INCORRECT_MOVE_VALUE);
		}

		// Ask ChessBoard to move the piece
		chessBoard.movePiece(initialPosition, finalPosition, this.player);
		if (!chessBoard.isThereWinner()) {	
			this.player = this.player ? Piece.BLACK : Piece.WHITE;
			System.out.println(">> Done");
		}
		else {
			this.startedGame = false;
			System.out.println(">> Game ended, winner " + (chessBoard.getWinnerColour() ? "WHITE" : "BLACK"));
		}
	}

   /**
    * Method for debugging purposes 
    * Remove after implementation
    * @return String  the position read from keyboard
    */
	private String readCell() {
		String cell;

		System.out.println("Example: a2");
		System.out.print("Cell : ");

		try {
			cell = in.readLine();
		} catch (Exception e) {
			cell = "";
		}
		return cell;
	}

   /**
	* Method for debugging purposes 
	* Remove after implementation
	* @exception CheckersException throws all ChessPlayerException generated
    *                                 by the methods used here.
	*/
	private void debugCell(String cell) throws CheckersException {
		String position = "";

		// Check if the move matches the regular expression for a move
		cell = cell.toLowerCase();
		String re = "([a-h][1-8])";
		Pattern pat = Pattern.compile(re, Pattern.CASE_INSENSITIVE
				| Pattern.DOTALL);
		Matcher m = pat.matcher(cell);
		if (m.find()) {
			position = m.group(1);
		}
		if (position.isEmpty()) {
			throw new CheckersException(
					CheckersException.INCORRECT_CELL_SELECTION);
		}

		// Ask ChessBoard to move the piece
		System.out.println(chessBoard.getCell(position).toString());
	}

   /**
    * Method used to finish the game
    */
	private void exit() {
		System.out.println(">> Bye");
		System.exit(0);
	}

   /**
    * Method that shows main menu of the game and manage all input
	* data written by keyboard.
	*/
	public void play() {

		int option;
		String move;
		String cell;

		do {
			try {
				option = this.readOption();
				switch (option) {
				case 1:
					initializeBoard();
					this.player = Piece.WHITE;
					break;
				case 2:
					if (!this.startedGame) {
						throw new CheckersException(
								CheckersException.NO_STARTED_GAME);
					}
					move = this.readMove();
					movePiece(move);
					break;
				case 3:
					exit();
					break;
				case 4:
					if (!this.DEVELOPMENT_MODE)
						throw new CheckersException(
								CheckersException.INCORRECT_OPTION);
					if (!this.startedGame) {
						throw new CheckersException(
								CheckersException.NO_STARTED_GAME);
					}
					cell = readCell();
					debugCell(cell);
					break;
				default:
					throw new CheckersException(
							CheckersException.INCORRECT_OPTION);
				}
			} catch (CheckersException ce) {
				System.err.println(ce.toString());
				//ce.printStackTrace();
			}
		} while (true);
	}
	
   /**
    * Main method creates a ChessPlayer object which is used
    * to start the game using play() method.
    * @param args Unused.
    */
	public static void main(String args[]) {
			
		CheckersIO io = new CheckersIO();
		try {
			ArrayList<String> moves = new ArrayList<String>();
			moves.add("a1 b1");
			moves.add("a2 b2");
			moves.add("a3 b3");
			io.setOutput("moves1.txt");
			io.write(moves);
		}catch(IOException e) {
			System.err.println(e.toString());
		}
		
		System.out.println("test writing in file finished");
		
		
		//Checkers g = new Checkers();
		//g.play();
		
		//RunTests();
		
	}
	public static void RunTests() {
		System.out.println("Starting Test");
		ChessBoard board = new ChessBoard();
		System.out.println(board.toString());
		
		//Test 1:
		board.ResetBoard();
		board.setPiece(new Pawn(Piece.WHITE), "d2");
		try{
			board.movePiece("d2", "d3", Piece.WHITE);
			System.err.println("Error 1");
		}catch(CheckersException e) {
			//Nothing to do.
		}
		
		//Test 2:
		board.ResetBoard();
		board.setPiece(new Pawn(Piece.WHITE), "d2");
		try{
			board.movePiece("d2", "e3", Piece.WHITE);
			
		}catch(CheckersException e) {
			System.err.println("Error 2");
		}
		
		//Test 3:
		board.ResetBoard();
		board.setPiece(new Pawn(Piece.WHITE), "d2");
		try{
			board.movePiece("d2", "c3", Piece.WHITE);
			
		}catch(CheckersException e) {
			System.err.println("Error 3");
		}
		
		
		
		//Test 4:
		board.ResetBoard();
		board.setPiece(new Pawn(Piece.WHITE), "e3");
		board.setPiece(new Pawn(Piece.BLACK), "f4");
		try{
			board.movePiece("e3", "g5", Piece.WHITE);
			
		}catch(CheckersException e) {
			System.err.println("Error 4");
		}
		
		
		//Test 5:
		board.ResetBoard();
		
		board.setPiece(new Pawn(Piece.WHITE), "e3");
		board.setPiece(new Pawn(Piece.WHITE), "g3");
		board.setPiece(new Pawn(Piece.BLACK), "h6");
		try{
			board.movePiece("e3", "f4", Piece.WHITE);
			if (board.isThereWinner()) {
				System.err.println("Error 5");
			}
			board.movePiece("h6", "g5", Piece.BLACK);
			if (board.isThereWinner()) {
				System.err.println("Error 5");
			}
			board.movePiece("f4", "h6", Piece.WHITE);
			if (!board.isThereWinner()) {
				System.err.println("Error 5");
			}
			
		}catch(CheckersException e) {
			System.err.println("Error t");
		}
		
		System.out.println("Test Finished");
		
	}
	
		
		
	
	
}
