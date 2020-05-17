package chessview.moves;

import chessview.Board;
import chessview.Position;
import chessview.pieces.Piece;

/**
 * @author hung
 *
 *
 */
public class Castling extends Move {

	private boolean kingSide;
	private boolean isWhite;
	
	
	/**
	 * @param isWhite
	 * @param kingSide
	 */
	public Castling (boolean isWhite, boolean kingSide) {
		super();
		this.isWhite = isWhite;
		this.kingSide = kingSide;
	}
	
	public boolean isWhite () {
		return this.isWhite;
	}
	
	@Override
	public boolean isValid (Board board) {
		Position kingPos = new Position(this.isWhite ? 1 : 8, 5);
		Position newKingPos = new Position(this.isWhite ? 1 : 8, this.kingSide ? 7 : 3);
		Piece king = board.pieceAt(kingPos);
		
		return king.isValidMove(kingPos, newKingPos, null, board);
	}

	@Override
	public void apply (Board board) {
		Position kingPos = new Position(this.isWhite ? 1 : 8, 5);
		Position newKingPos = new Position(this.isWhite ? 1 : 8, this.kingSide ? 7 : 3);
		Position rookPos = new Position(this.isWhite ? 1 : 8, this.kingSide ? 8 : 1);
		Position newRookPos = new Position(this.isWhite ? 1 : 8, this.kingSide ? 6 : 4);
		board.move(kingPos, newKingPos);
		board.move(rookPos, newRookPos);
	}

	@Override
	public String toString () {
		if(kingSide) {
			return "O-O";
		} else {
			return "O-O-O";
		}
	}

}
