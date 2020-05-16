package chessview.pieces;

import chessview.*;

public class Queen extends PieceImpl implements Piece {
	public Queen(boolean isWhite) {
		super(isWhite);
	}
	
	public boolean isValidMove(Position oldPosition, Position newPosition,
			Piece isTaken, Board board) {
		
		if (!Position.isValid(oldPosition)
				|| !Position.isValid(newPosition))
			return false;

		Piece p = board.pieceAt(oldPosition);
		Piece t = board.pieceAt(newPosition);
				
		if (!this.equals(p)
				|| (isTaken != null && (!isTaken.equals(t) || p.isWhite() == isTaken.isWhite())))
			return false;
		
		return board.clearColumnExcept(oldPosition, newPosition, p, t)
				|| board.clearRowExcept(oldPosition, newPosition, p, t)
				|| board.clearDiaganolExcept(oldPosition, newPosition, p, t);
	}
	
	public String toString() {
		if(isWhite) {
			return "Q";
		} else {
			return "q";
		}
	}
}
