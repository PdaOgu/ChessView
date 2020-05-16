package chessview.pieces;

import chessview.*;

public class Bishop extends PieceImpl implements Piece {
	public Bishop(boolean isWhite) {
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
				|| (isTaken != null && (!isTaken.equals(t) || p.isWhite() == t.isWhite())))
			return false;
				
		return board.clearDiaganolExcept(oldPosition, newPosition, p, t);
		
//		return this.equals(p)
//				&& (t == isTaken || (isTaken != null && isTaken.equals(t)))
//				&& (board.clearDiaganolExcept(oldPosition, newPosition, p, t)
//						|| board.clearColumnExcept(oldPosition, newPosition, p,
//								t) || board.clearRowExcept(oldPosition,
//						newPosition, p, t));				
	}
	
	public String toString() {
		if(isWhite) {
			return "B";
		} else {
			return "b";
		}
	}
}
