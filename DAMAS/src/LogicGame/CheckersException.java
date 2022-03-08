package LogicGame;

public class CheckersException extends Exception {
	
		/**
	 * 
	 */
		private static final long serialVersionUID = -8645784795982540240L;
	
		public final static String NO_STARTED_GAME = ">> The game is not started";
	
	  /**
	    * CheckersException's constructor, with no param
	    */  
		public CheckersException() {
			super();
		}

	   /**
	    * CheckersException's constructor. It set its message attribute.
	    * @param message  the message of the CheckersException 
	    */  
		public CheckersException(String message) {
			super(message);
		}

	   /**
	    * CheckersException's constructor. It set its message and info attributes.
	    * @param message  the message of the CheckersException 
	    * @param info  the info of the CheckersException 
	    */  
		public CheckersException(String message, String info) {
			super(message + info);
		}
		
}
