package chessview.pieces;

import chessview.*;

/**
 * The Class Piece.
 * implement action of pieces
 */
public abstract class Piece {
	
	/** The is white. */
	private boolean isWhite;
	
	/**
	 * Instantiates a new piece.
	 *
	 * @param isWhite 
	 */
	public Piece (boolean isWhite) {		
		this.isWhite = isWhite;
		this.moveCounter = 0;
	}

	/**
	 * Determine whether this piece is white or black.
	 *
	 * @return true, if is white
	 */
	public boolean isWhite () {
		return this.isWhite;
	}
	
	/**
	 * Check whether or not a given move on a given board is valid. For takes,
	 * the piece being taken must be supplied.
	 *
	 * @param oldPosition            --- position of this piece before move.
	 * @param newPosition            --- position of this piece after move.
	 * @param isTaken            --- piece being taken, or null if no piece taken.
	 * @param board            --- board on which the validity of this move is being checked.
	 * @return true, if is valid move
	 */
	public abstract boolean isValidMove (Position oldPosition, 
	                                    Position newPosition,
	                                    Piece isTaken,
	                                    Board board);
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public abstract String toString ();
	
	/** The move counter. */
	private int moveCounter;
	
	/**
	 * Gets the move counter.
	 *
	 * @return the move counter
	 */
	public int getMoveCounter () {
        return moveCounter;
    }

    /**
     * Sets the move counter.
     *
     * @param moveCounter the new move counter
     */
    public void setMoveCounter (int moveCounter) {
        this.moveCounter = moveCounter;
    }
    
    /**
     * Equals.
     *
     * @param o
     * @return true, if successful
     */
    public boolean equals (Object o) {
		if (o instanceof Piece) {
			Piece p = (Piece) o;
			return o.getClass() == this.getClass() && this.isWhite == p.isWhite();
		}
		return false;
	}		
}
