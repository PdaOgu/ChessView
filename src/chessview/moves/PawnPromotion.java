package chessview.moves;

import chessview.Board;
import chessview.Position;
import chessview.pieces.Piece;

/**
 * The Class PawnPromotion
 * which implement pawn promotion move in chess
 * @author hung
 */
public class PawnPromotion extends Move {

    /** The is taken. */
    private Piece isTaken;
	
	/** The promotion. */
	private Piece promotion;

	/**
	 * Instantiates a new pawn promotion.
	 *
	 * @param move 
	 * @param promotion 
	 */
	public PawnPromotion (Move move, Piece promotion) {
		super(move);
		this.isTaken = null;
		if (move instanceof TakeMove)
		    this.isTaken = ((TakeMove) move).isTaken;
		this.promotion = promotion;
	}

	/**
	 * Checks if is valid.
	 *
	 * @param board 
	 * @return true, if is valid
	 */
	@Override
	public boolean isValid (Board board) {
	    Board temp = new Board(board);
	    boolean isValidPosition = ((this.isWhite() && this.newPosition.row() == 8)
	                                || (!this.isWhite() && this.newPosition.row() == 1));
	    return isValidPosition
                && this.piece.isValidMove(this.oldPosition, this.newPosition, this.isTaken, board)
                && (this.checkmateState(this, temp) == this.getIsCheckmate());
	}

	/**
	 * Apply.
	 *
	 * @param board 
	 */
	@Override
	public void apply (Board board) {
		board.move(this.oldPosition, this.newPosition);
		board.setPieceAt(this.newPosition, this.promotion);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString () {
		return pieceChar(this.piece) + this.oldPosition + (this.isTaken == null ? "-" : "x") +
	           pieceChar(this.isTaken) + this.newPosition+ "="
		        + SimpleMove.pieceChar(this.promotion) + this.toStringCheckmate();
	}

}
