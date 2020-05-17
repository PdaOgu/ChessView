package chessview.pieces;

import chessview.*;


public abstract class Piece {
	private boolean isWhite;
	
	public Piece (boolean isWhite) {		
		this.isWhite = isWhite;
	}

	/**
	 * Determine whether this piece is white or black.
	 * @return
	 */
	public boolean isWhite () {
		return this.isWhite;
	}
	
	/**
	 * Check whether or not a given move on a given board is valid. For takes,
	 * the piece being taken must be supplied.
	 * 
	 * @param oldPosition
	 *            --- position of this piece before move.
	 * @param newPosition
	 *            --- position of this piece after move.
	 * @param isTaken
	 *            --- piece being taken, or null if no piece taken.
	 * @param board
	 *            --- board on which the validity of this move is being checked.
	 * @return
	 */
	public abstract boolean isValidMove (Position oldPosition, 
	                                    Position newPosition,
	                                    Piece isTaken,
	                                    Board board);
	
	public abstract String toString ();
	
	public boolean equals (Object o) {
		if (o instanceof Piece) {
			Piece p = (Piece) o;
			return o.getClass() == this.getClass() && this.isWhite == p.isWhite();
		}
		return false;
	}		
}
