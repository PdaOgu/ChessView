package chessview;

import chessview.moves.Move;

/**
 * A round consists of a move by white, and will normally also have a move by
 * black. The latter may not happen in the case that White wins the game.
 * 
 * @author djp
 * 
 */
public class Round {
	
	/** The white. */
	private Move white;
	
	/** The black. */
	private Move black;
	
	/**
	 * Create a round from a white move, and an optional black move.
	 * 
	 * @param white - whites move; cannot be null;
	 * @param black - blacks move; may be null.
	 */
	public Round(Move white, Move black) {
		if(white == null) {
			throw new IllegalArgumentException("A round must always consist of a move by white");
		}
		this.white = white;
		this.black = black;
	}
	
	/**
	 * White.
	 *
	 * @return the move
	 */
	public Move white() {
		return white;
	}
	
	/**
	 * Black.
	 *
	 * @return the move
	 */
	public Move black() {
		return black;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		String r = white.toString();
		if(black != null) {
			r += " " + black.toString();
		}
		return r;
	}
}
