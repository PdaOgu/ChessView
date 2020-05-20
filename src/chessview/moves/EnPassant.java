package chessview.moves;

import chessview.*;
import chessview.pieces.*;

/**
 * @author hung
 * 
 * 
 */
public class EnPassant extends TakeMove {
	
	public EnPassant (Move move) {
		super(move);
	}

	public boolean isValid(Board board) {
		int newRow = newPosition.row();
		int newCol = newPosition.column();
		int dir = this.isWhite() ? 1 : -1;
		this.isTaken = board.pieceAt(new Position(newRow - dir, newCol));
		return this.piece.isValidMove(oldPosition, newPosition, isTaken, board);
	}
	
	public void apply(Board board) {
	    this.incMoveCounter(board);
		board.move(oldPosition, newPosition);
		int newRow = newPosition.row();
		int newCol = newPosition.column();
		int dir = this.isWhite() ? 1 : -1;
		board.setPieceAt(new Position(newRow - dir, newCol), null);
	}
	
	public String toString() {
		return super.toString() + "ep" + this.toStringCheckmate();
	}
}
