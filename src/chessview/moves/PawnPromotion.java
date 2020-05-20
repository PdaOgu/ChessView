package chessview.moves;

import chessview.Board;
import chessview.Position;
import chessview.pieces.Piece;

/**
 * @author hung
 *
 *
 */
public class PawnPromotion extends Move {

    private Piece isTaken;
	private Piece promotion;

	/**
	 * @param piece
	 * @param oldPosition
	 * @param newPosition
	 */
	public PawnPromotion (Move move, Piece promotion) {
		super(move);
		this.isTaken = null;
		if (move instanceof TakeMove)
		    this.isTaken = ((TakeMove) move).isTaken;
		this.promotion = promotion;
	}

	@Override
	public boolean isValid (Board board) {
	    boolean isValidPosition = ((this.isWhite() && this.newPosition.row() == 8)
	                                || (!this.isWhite() && this.newPosition.row() == 1));
	    return isValidPosition
                && this.piece.isValidMove(this.oldPosition, this.newPosition, this.isTaken, board);
	}

	@Override
	public void apply (Board board) {
	    this.incMoveCounter(board);
		board.move(this.oldPosition, this.newPosition);
		board.setPieceAt(this.newPosition, this.promotion);
	}

	@Override
	public String toString () {
		return pieceChar(this.piece) + this.oldPosition + (this.isTaken == null ? "-" : "x") +
	           pieceChar(this.isTaken) + this.newPosition+ "="
		        + SimpleMove.pieceChar(this.promotion) + this.toStringCheckmate();
	}

}
