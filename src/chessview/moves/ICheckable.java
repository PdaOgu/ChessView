/**
 * 
 */
package chessview.moves;

import chessview.Board;

/**
 * @author hung
 * The move must point out the current check mate state by
 * property isCheck getter
 */
public interface ICheckable {
	public boolean getIsCheckmate ();
	public void setIsCheckmate (boolean isCheckmate);
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
