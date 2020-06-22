package chessview.moves;

import chessview.*;
import chessview.pieces.*;

/**
 * The Class Move
 * which implement moving of chess pieces
 * @author hung
 */
public abstract class Move implements ICheckable {
	
	/** The piece. */
	protected Piece piece;
	
	/** The old position. */
	protected Position oldPosition;
	
	/** The new position. */
	protected Position newPosition;
	
	/** The is checkmate. */
	private boolean isCheckmate;
	
	
	/**
	 * Instantiates a new move.
	 *
	 * @param piece the piece
	 * @param oldPosition the old position
	 * @param newPosition the new position
	 */
	public Move (Piece piece, Position oldPosition, Position newPosition) {
		this.piece = piece;
		this.oldPosition = oldPosition;
		this.newPosition = newPosition;
	}
	
	/**
	 * Instantiates a new move.
	 *
	 * @param move 
	 */
	public Move (Move move) {
		this.piece = move.piece;
		this.oldPosition = move.oldPosition;
		this.newPosition = move.newPosition;
	}
	
	/**
	 * Instantiates a new move.
	 */
	protected Move () { }
	
	/**
	 * Check whether this move is valid or not.
	 *
	 * @param board 
	 * @return true, if is valid
	 */
	public abstract boolean isValid (Board board);

	/**
	 * Update the board to reflect the board after the move is played.
	 *
	 * @param board 
	 */
	public abstract void apply (Board board);
	
	/**
	 * Is this move for white or black?.
	 *
	 * @return true, if is white
	 */
	public boolean isWhite () {
		return this.piece.isWhite();
	}
	
	
	/**
	 * Gets the checks if is checkmate.
	 *
	 * @return the checks if is checkmate
	 */
	public boolean getIsCheckmate () {
		return this.isCheckmate;
	}
	
	/**
	 * Sets the checks if is checkmate.
	 *
	 * @param isCheckmate the new checks if is checkmate
	 */
	public void setIsCheckmate (boolean isCheckmate) {
		this.isCheckmate = isCheckmate;
	}

	/**
	 * To string checkmate.
	 *
	 *Ra8xNg8 @return the string
	 */
	public String toStringCheckmate () {
		if (this.isCheckmate)
			return "+";
		else
			return "";
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	protected void incMoveCounter (Board board) {
        Piece p = board.pieceAt(oldPosition);
        p.setMoveCounter(p.getMoveCounter() + 1);
        if (p instanceof Pawn) {
            if (Math.abs(this.oldPosition.row() - this.newPosition.row()) == 1) {
                ((Pawn) p).setCanBeEnPassant(false);
            } else {
                ((Pawn) p).setCanBeEnPassant(true);
            }
        }
	}
	
	public abstract String toString ();
	
	/**
	 * Piece char.
	 *
	 * @param p 
	 * @return the string
	 */
	protected static String pieceChar(Piece p) {
		if(p instanceof Pawn) {
			return "";
		} else if(p instanceof Knight) {
			return "N";
		} else if(p instanceof Bishop) {
			return "B";
		} else if(p instanceof Rook) {
			return "R";
		} else if(p instanceof Queen) {
			return "Q";
		} else {
			return "K";
		}
	}
}
