/**
 * 
 */
package chessview.moves;

import chessview.Board;

/**
 * The Interface ICheckable.
 *
 * @author hung
 * The move must point out the current check mate state by
 * property isCheck getter
 */
public interface ICheckable {
	
	/**
	 * Gets the checks if is checkmate.
	 *
	 * @return the checks if is checkmate
	 */
	public boolean getIsCheckmate ();
	
	/**
	 * Sets the checks if is checkmate.
	 *
	 * @param isCheckmate the new checks if is checkmate
	 */
	public void setIsCheckmate (boolean isCheckmate);
	
	/**
	 * To string checkmate.
	 *
	 * @return the string
	 */
	public String toStringCheckmate ();
	
	/**
	 * Checkmate state.
	 *
	 * @param move 
	 * @param board 
	 * @return true, if successful
	 */
	public boolean checkmateState (Move move, Board board);
}
