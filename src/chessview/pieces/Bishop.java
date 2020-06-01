package chessview.pieces;

import chessview.*;
/**
 * The Class Bishop
 * check if a move is valid
 * @author hung
 */
public class Bishop extends Piece {
	public Bishop (boolean isWhite) {
		super(isWhite);
	}
	
	/**
	 * Checks if move is valid.
	 *
	 * @param oldPosition the old position
	 * @param newPosition the new position
	 * @param isTaken the is taken
	 * @param board the board
	 * @return true, if it is valid move
	 */
	public boolean isValidMove (Position oldPosition, Position newPosition,
			Piece isTaken, Board board) {

		if (!Position.isValid(oldPosition)
				|| !Position.isValid(newPosition))
			return false;

		Piece p = board.pieceAt(oldPosition);
		Piece t = board.pieceAt(newPosition);
				
		if (!this.equals(p)
                || (t == null && isTaken != null)            
                || (t != null && isTaken == null)              
                || (t != null && !t.equals(isTaken))            
                || (t != null && t.isWhite() == this.isWhite()))
            return false;
				
		return board.clearDiaganolExcept(oldPosition, newPosition, p, t);
	}
	
	public String toString () {
		if(this.isWhite()) {
			return "B";
		} else {
			return "b";
		}
	}
}
