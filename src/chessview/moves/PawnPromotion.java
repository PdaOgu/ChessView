package chessview.moves;

import chessview.Board;
import chessview.Position;
import chessview.pieces.Piece;

/**
 * @author hung
 *
 *
 */
public class PawnPromotion extends SimpleMove {

	private Piece promotion;

	/**
	 * @param piece
	 * @param oldPosition
	 * @param newPosition
	 */
	public PawnPromotion (Move move, Piece promotion) {
		super(move);
		this.promotion = promotion;
	}

	@Override
	public boolean isValid (Board board) {
        return this.piece.isValidMove(this.oldPosition, this.newPosition, null, board);
	}

	@Override
	public void apply (Board board) {
		board.move(this.oldPosition, this.newPosition);
		board.setPieceAt(this.newPosition, this.promotion);
	}

	@Override
	public String toString () {
		return super.toString() + "=" + SimpleMove.pieceChar(this.promotion) + this.toStringCheckmate();
	}

}
