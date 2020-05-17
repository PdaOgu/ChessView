package chessview.moves;

import chessview.Board;
import chessview.Position;
import chessview.pieces.Pawn;
import chessview.pieces.Piece;

/**
 * @author hung
 *
 *
 */
public class SimpleMove extends Move {

	public SimpleMove (Piece piece, Position oldPosition, Position newPosition) {
		super(piece, oldPosition, newPosition);
	}
	
	public SimpleMove (Move move) {
		super(move);
	}
	
	@Override
	public boolean isValid (Board board) {
	    Board temp = new Board(board);
		return this.piece.isValidMove(this.oldPosition, this.newPosition, null, board)
		        && (this.checkmateState(this, temp) == this.getIsCheckmate());
	}

	@Override
	public void apply (Board board) {
		board.move(this.oldPosition, this.newPosition);
	}

	@Override
	public String toString () {
		return pieceChar(this.piece) + this.oldPosition + "-" + this.newPosition + this.toStringCheckmate(); 
	}
}
