package chessview.moves;

import chessview.Board;
import chessview.Position;
import chessview.pieces.Piece;

/**
 * The Class TakeMove.
 * which implement the steps of moving in game
 * @author hung
 */
public class TakeMove extends Move {

	/** The is taken. */
	protected Piece isTaken;
	
	/**
	 * Instantiates a new take move.
	 *
	 * @param piece the piece
	 * @param isTaken the is taken
	 * @param oldPosition the old position
	 * @param newPosition the new position
	 */
	public TakeMove (Piece piece, Piece isTaken, Position oldPosition, Position newPosition) {
		super(piece, oldPosition, newPosition);
		this.isTaken = isTaken;
	}
	
	/**
	 * Instantiates a new take move.
	 *
	 * @param move 
	 * @param isTaken 
	 */
	public TakeMove (Move move, Piece isTaken) {
		super(move.piece, move.oldPosition, move.newPosition);
		this.isTaken = isTaken;
	}
	
	/**
	 * Instantiates a new take move.
	 *
	 * @param move 
	 */
	protected TakeMove (Move move) {
		super(move.piece, move.oldPosition, move.newPosition);
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
		return this.piece.isValidMove(this.oldPosition, this.newPosition, this.isTaken, board)
		        && (this.checkmateState(this, temp) == this.getIsCheckmate());
	}

	/**
	 * Apply.
	 *
	 * @param board the board
	 */
	@Override
	public void apply (Board board) {
		board.move(this.oldPosition, this.newPosition);
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString () {
		return pieceChar(this.piece) + this.oldPosition + "x" +
		      pieceChar(this.isTaken) + this.newPosition
		      + this.toStringCheckmate(); 
	}	
}
