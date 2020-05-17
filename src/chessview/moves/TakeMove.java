package chessview.moves;

import chessview.Board;
import chessview.Position;
import chessview.pieces.Piece;

/**
 * @author hung
 *
 *
 */
public class TakeMove extends Move {

	protected Piece isTaken;
	/**
	 * @param piece
	 * @param isTaken
	 * @param oldPosition
	 * @param newPosition
	 */
	public TakeMove (Piece piece, Piece isTaken, Position oldPosition, Position newPosition) {
		super(piece, oldPosition, newPosition);
		this.isTaken = isTaken;
	}
	
	public TakeMove (Move move, Piece isTaken) {
		super(move.piece, move.oldPosition, move.newPosition);
		this.isTaken = isTaken;
	}
	
	protected TakeMove (Move move) {
		super(move.piece, move.oldPosition, move.newPosition);
	}

	@Override
	public boolean isValid (Board board) {
	    Board temp = new Board(board);
		return this.piece.isValidMove(this.oldPosition, this.newPosition, this.isTaken, board)
		        && (this.checkmateState(this, temp) == this.getIsCheckmate());
	}

	@Override
	public void apply (Board board) {
		board.move(this.oldPosition, this.newPosition);
	}
	
	@Override
	public String toString () {
		return pieceChar(this.piece) + this.oldPosition + "x" +
		      pieceChar(this.isTaken) + this.newPosition
		      + this.toStringCheckmate(); 
	}	
}
