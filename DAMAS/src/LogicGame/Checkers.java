package LogicGame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Model object for Checkers.
 *
 * @author  Jordi Blasco Planesas<br>
 *          Capacitaci&oacute; digital. Web 2.0 i xarxes socials.<br>
 *          Universitat Oberta de Catalunya (UOC)
 * @version  2.0
 */
public class Checkers {
	
	private BufferedReader in = null;
	private ChessBoard c=null;
	private boolean startedGame=false;
	private boolean whoMoves=Piece.WHITE;
	
   /**
    * Default constructor. It initializes BufferedReader.
    */
	public Checkers() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
   /**
    * Private method used to read the option selected
    * by keyboard.
    * @return String  the option selected by keyboard.
    */
	private String readOption() {

		String option;
		
		System.out.println("------------------------");
		System.out.println("1. Initialize ChessBoard");
		System.out.println("2. Move a piece");
		System.out.println("3. Exit");
		System.out.println("------------------------");
		System.out.print  ("Select option : ");
			
		try {	
			option = in.readLine();
		} catch (Exception e) {
			option ="";
		}
		return option;
	}	
	
   /**
    * Private method used to read a checkers piece move by keyboard.
    * @return String  the checkers move input by keyboard.
    */
	private String readMove() {
		String move;
		
		System.out.println("\nExample: a3 b4");
		System.out.print("Move : ");
			
		try {	
			move = in.readLine();
		} catch (Exception e) {
			move ="";
		}
		return move;
	}

   /**
    * Method that shows main menu of the game and manage all input
    * data written by keyboard.
    * @return Nothing.
    */
	public void play(){
		
		String option;
		String move;
		
		do {
			option=this.readOption();
			
			if (option.equals("1")) {
				
				c=new ChessBoard();
				this.startedGame=true;
				this.whoMoves = Piece.WHITE;
				System.out.println(c.toString());
				
			} else if (option.equals("2")) {
		
				if (!this.startedGame) {
					
					System.out.println(">> The game is not started");
					
				} else {
				
					move=this.readMove();
					
					String initialPosition=move.substring(0,2);
					String finalPosition=move.substring(3,5);
					
					Piece p=c.getCell(initialPosition).getPiece();
					
					if (p != Piece.EMPTY) {
						if (this.whoMoves == p.GetColour()) {
							c.movePiece(initialPosition, finalPosition);
							this.whoMoves = !this.whoMoves;
							System.out.println(">> Done");
							
						} else {
							
							String turn="Black";
							if (this.whoMoves) {
								turn="White";
							} 
							System.out.println(">> Error: "+turn+" moves!");
						}
						
					} else {
						System.out.println(">> There is no piece on "+initialPosition+" cell");
					}
					
					System.out.println(c.toString());
				}
				
			} else if (option.equals("3")) {
				System.out.println(">> Bye");
				System.exit(0);
			} 
			
		} while (true);
		
		
	}
		
   /**
    * Main method creates a Checkers object which is used
    * to start the game using play() method.
    * @param args Unused.
    * @return Nothing.
    */
	public static void main(String args[]) {
		
		Checkers g=new Checkers();
		g.play();
		
	}
}
