package chessview.moves;

import chessview.*;
import chessview.pieces.*;

public class Castling implements MultiPieceMove {	
	private boolean kingSide;
	private boolean isWhite;
	
	public Castling(boolean isWhite, boolean kingSide) {
		this.isWhite = isWhite;
		this.kingSide = kingSide;
	}
	
	public boolean isWhite() {
		return false;
	}
	
	public void apply(Board board) {	
		Position kingPos = new Position(this.isWhite ? 1 : 8, 5);
		Position newKingPos = new Position(this.isWhite ? 1 : 8, this.kingSide ? 7 : 3);
		Position rookPos = new Position(this.isWhite ? 1 : 8, this.kingSide ? 8 : 1);
		Position newRookPos = new Position(this.isWhite ? 1 : 8, this.kingSide ? 6 : 4);
		board.move(kingPos, newKingPos);
		board.move(rookPos, newRookPos);
	}
	
	public boolean isValid(Board board) {
		Position kingPos = new Position(this.isWhite ? 1 : 8, 5);
		Position newKingPos = new Position(this.isWhite ? 1 : 8, this.kingSide ? 7 : 3);
		King king = (King) board.pieceAt(kingPos);
		
		return king.isValidMove(kingPos, newKingPos, null, board);
	}		
	
	public String toString() {
		if(kingSide) {
			return "O-O";
		} else {
			return "O-O-O";
		}
	}
}
