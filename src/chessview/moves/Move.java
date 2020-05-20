package chessview.moves;

import chessview.*;
import chessview.pieces.*;

/**
 * @author hung
 *
 * 
 */
public abstract class Move implements ICheckable {
	protected Piece piece;
	protected Position oldPosition;
	protected Position newPosition;
	private boolean isCheckmate;
	
	
	public Move (Piece piece, Position oldPosition, Position newPosition) {
		this.piece = piece;
		this.oldPosition = oldPosition;
		this.newPosition = newPosition;
	}
	
	public Move (Move move) {
		this.piece = move.piece;
		this.oldPosition = move.oldPosition;
		this.newPosition = move.newPosition;
	}
	
	protected Move () { }
	
	/**
	 * Check whether this move is valid or not.
	 * 
	 * @param board
	 * @return
	 */
	public abstract boolean isValid (Board board);

	/**
	 * Update the board to reflect the board after the move is played.
	 * 
	 * @param board
	 */
	public abstract void apply (Board board);
	
	/**
	 * Is this move for white or black?
	 * 
	 * @return
	 */
	public boolean isWhite () {
		return this.piece.isWhite();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public boolean getIsCheckmate () {
		return this.isCheckmate;
	}
	
	/**
	 * @param isCheckate
	 * @return
	 */
	public void setIsCheckmate (boolean isCheckmate) {
		this.isCheckmate = isCheckmate;
	}
	
//	public boolean checkmateState (Move move, Board board) {
//	    move.apply(board);
//	    return board.isInCheck(!this.isWhite());
//	}
	
	public String toStringCheckmate () {
		if (this.isCheckmate)
			return "+";
		else
			return "";
	}
	
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
