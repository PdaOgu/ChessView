package chessview.moves;

import chessview.Board;
import chessview.Position;
import chessview.pieces.Piece;

/**
 * The Class Castling.
 *
 * @author hung
 */
public class Castling extends Move {

	/** The king side. */
	private boolean kingSide;
	
	/** The is white. */
	private boolean isWhite;
	
	
	/**
	 * Instantiates a new castling.
	 *
	 * @param isWhite 
	 * @param kingSide 
	 */
	public Castling (boolean isWhite, boolean kingSide) {
		super();
		this.isWhite = isWhite;
		this.kingSide = kingSide;
	}
	
	/**
	 * Checks if is white.
	 *
	 * @return true, if is white
	 */
	public boolean isWhite () {
		return this.isWhite;
	}
	
	/**
	 * Checks if is valid.
	 *
	 * @param board 
	 * @return true, if is valid
	 */
	@Override
	public boolean isValid (Board board) {
		Position kingPos = new Position(this.isWhite ? 1 : 8, 5);
		Position newKingPos = new Position(this.isWhite ? 1 : 8, this.kingSide ? 7 : 3);
		Piece king = board.pieceAt(kingPos);
		
		return king.isValidMove(kingPos, newKingPos, null, board);
	}

	/**
	 * Apply.
	 *
	 * @param board the board
	 */
	@Override
	public void apply (Board board) {
		Position kingPos = new Position(this.isWhite ? 1 : 8, 5);
		Position newKingPos = new Position(this.isWhite ? 1 : 8, this.kingSide ? 7 : 3);
		Position rookPos = new Position(this.isWhite ? 1 : 8, this.kingSide ? 8 : 1);
		Position newRookPos = new Position(this.isWhite ? 1 : 8, this.kingSide ? 6 : 4);
		board.move(kingPos, newKingPos);
		board.move(rookPos, newRookPos);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString () {
		if(kingSide) {
			return "O-O";
		} else {
			return "O-O-O";
		}
	}

}
