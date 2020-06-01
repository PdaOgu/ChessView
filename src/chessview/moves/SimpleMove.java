package chessview.moves;

import chessview.Board;
import chessview.Position;
import chessview.pieces.Pawn;
import chessview.pieces.Piece;

/**
 * The Class SimpleMove
 * which implement simple moves in chess
 * @author hung
 */
public class SimpleMove extends Move {

	/**
	 * Instantiates a new simple move.
	 *
	 * @param piece the piece
	 * @param oldPosition the old position
	 * @param newPosition the new position
	 */
	public SimpleMove (Piece piece, Position oldPosition, Position newPosition) {
		super(piece, oldPosition, newPosition);
	}
	
	/**
	 * Instantiates a new simple move.
	 *
	 * @param move 
	 */
	public SimpleMove (Move move) {
		super(move);
	}
	
	/**
	 * Checks if is valid.
	 *
	 * @param board 
	 * @return true, if is valid
	 */
	@Override
	public boolean isValid (Board board) {
		return this.piece.isValidMove(this.oldPosition, this.newPosition, null, board);
	}

	/**
	 * Apply.
	 *
	 * @param board 
	 */
	@Override
	public void apply (Board board) {
	    this.incMoveCounter(board);
	    board.move(this.oldPosition, this.newPosition);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString () {
		return pieceChar(this.piece) + this.oldPosition + "-" + this.newPosition + this.toStringCheckmate(); 
	}
}
