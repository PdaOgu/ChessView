package chessview.moves;

import chessview.*;
import chessview.pieces.*;

/**
 * The Class EnPassant
 * which implement en passant move in chess
 * @author hung
 */
public class EnPassant extends TakeMove {
	
	/**
	 * Instantiates a new en passant.
	 *
	 * @param move 
	 */
	public EnPassant (Move move) {
		super(move);
	}

	/**
	 * Checks if is valid.
	 *
	 * @param board 
	 * @return true, if is valid
	 */
	public boolean isValid(Board board) {
		int newRow = newPosition.row();
		int newCol = newPosition.column();
		int dir = this.isWhite() ? 1 : -1;
		this.isTaken = board.pieceAt(new Position(newRow - dir, newCol));
		return this.piece.isValidMove(oldPosition, newPosition, isTaken, board);
	}
	
	/**
	 * Apply.
	 *
	 * @param board 
	 */
	public void apply(Board board) {
	    this.incMoveCounter(board);
		board.move(oldPosition, newPosition);
		int newRow = newPosition.row();
		int newCol = newPosition.column();
		int dir = this.isWhite() ? 1 : -1;
		board.setPieceAt(new Position(newRow - dir, newCol), null);
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return super.toString() + "ep" + this.toStringCheckmate();
	}
}
